/******************************************************************************
 * This research was sponsored by the U.S. Army Research Laboratory and the
 * U.K. Ministry of Defence under the Biennial Program Plane 2013 (BPP13),
 * Project 6, Task 3: Collaborative Intelligence Analysis.
 * The U.S. and U.K. Governments are authorized to reproduce and distribute
 * reprints for Government purposes notwithstanding any copyright notation
 * hereon.
 * **************************************************************************
 * 
 * 
 * @author      Alice Toniolo  
 * @version     1.0  
 * @since 		August 2015           
 *   
 *    
 */

package moirapolls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import data.Card;
import data.Stats;
import gaian.DBConnect;
import gaian.MDBQuery;
import utils.JsonHelper;
 
 


public class MoiraPollControl {
	 private MDBQuery dbc;
	   
	 private String i_host;
	 private String i_port; 
	 private String m_host;
	 private int m_port; 
	 private String m_ask;
	 private boolean PRINT=false;
	 private MoiraProvMsgBuilder mprb;
	 private HashMap<String,HashMap> to_send;
	 private ArrayList<Card> to_process;
	 private boolean test;

	private static Logger log;

	public MoiraPollControl( String i_h, String i_p, String m_h, int m_port2,String ak, boolean pt) {
		   log=Logger.getLogger(getClass().getName());
		try{  i_host=i_h; 
		  i_port=i_p; 
		  m_host=m_h; 
		  m_port=m_port2;
		  m_ask=ak;
		  PRINT=pt;
		  DBConnect dbcn=new DBConnect();
		  dbc=new MDBQuery(dbcn);
		  to_send=new HashMap<String,HashMap>();
		  to_process=new ArrayList<Card>();
		  checkConnectionAndTable();
		  
		}catch(Exception e){
			e.printStackTrace();
		}
		  
	}

	 

	public void check() {
		  log.log(Level.INFO,"*** MCS SERVICE - TIME TICKER ***");
		if(test){
			try{
		//Pool every card from Moira
		//System.out.println("hello");
		MoiraPollClient mpc=new MoiraPollClient(PRINT);
		//System.out.println(m_host);
		
		long prevtime=dbc.getLastTime();
		if(prevtime!=-1){
			m_ask+="&since="+prevtime;
		}
	 	String result=mpc.ConnectToEvaluate(m_port, m_host,m_ask);
	 	//result=getResult();
	 	result=rebuild(result);
    //	 System.out.println(result);
    	result=result.replaceAll("\'", "\u0027");
    	result=result.replaceAll("'", "\u0027");
    	Stats res = null;
        Gson gson = new Gson();
   
    	if(result!=null){
    		res = gson.fromJson(result, Stats.class);
    	}
    	dbc.insertNewTime(res.getServerTime());
    	//first I build provenance of those cards that I don't need
    	for(Card card:res.structured_response){
    		//System.out.println(card.toString());
    		handleCardFirst(card);
    	}
    	//then I process the cards so provenance should all be ready
    	for(Card card:to_process){
    		handleCardSecond(card);
    	}
    	    
    	mprb.closeOff();
    	sendAllInfoService();
			}catch(Exception e){
				e.printStackTrace();
			}
		} 
	}


	private String rebuild(String result) {
		result=result.replaceAll("\"is to\"", "\"is_to\"");
		result=result.replaceAll("\"is in reply to\"", "\"is_in_reply_to\"");
		result=result.replaceAll("\"is from\"", "\"is_from\"");
		result=result.replaceAll("\"secondary content\"", "\"secondary_content\"");
		return result;
	}



	private void handleCardSecond(Card card) {
		//this is for CISpaces
		//deal with provenance
		card.property_values.getCispacesData();
		String reply=card.property_values.cispdata.nodeID;
		if(reply!=null && !reply.equals("")){
			//this is a reply 
			//System.out.println("TO BE PROCESSED AS ANSWER ->"+card.toString());
			processQueryCard(card);
		 
		}else{
			//this is an info
			//System.out.println("TO BE PROCESSED AS INFO ->"+card.toString());
			processInfoCard(card);
			//for the provenance need to get the message id of that particular string 
		}
		
	}



	private void sendAllInfoService() {
		// TODO Auto-generated method stub
		//serialise tosend and send it!!
		InfoServiceHelper ish=new InfoServiceHelper(i_port,i_host);
		JsonHelper jsh=new JsonHelper();
		Iterator<String> iter=to_send.keySet().iterator();
		while(iter.hasNext()){
			String key=iter.next();
			String gsonmap=jsh.convertInputJson(to_send.get(key));
			String result=ish.ConnectToEvaluate(gsonmap);
		}
		
		//System.out.println(to_send);
	}

	private void handleCardFirst(Card card) {
	 
	    card.property_values.getCispacesData();
	//    System.out.println(card);
		if(card.property_values.cispdata.to_cispaces){
			to_process.add(card);
		}else{
			//deal with provenance
			buildPlainProv(card);
		}
		 
	}

	

	



	private void buildPlainProv(Card card) {
		if(!card.property_values.isEmpty()){
		ArrayList reply=card.property_values.is_in_reply_to;
		if(reply!=null && !reply.isEmpty()){
			//this is a reply 
			mprb.createRespondPattern(card.property_values.is_from,card.property_values.is_to,card.property_values.is_in_reply_to, card._id,card.property_values.timestamp);
		}else{
			//this is an info
			card.property_values.getCispacesData();
			if(card.property_values.cispdata.nodeID!=null){
				//then this is a request from CISpaces
				mprb.createQueryPattern(card.property_values.is_from,card.property_values.is_to,card._id,card.property_values.timestamp);
				
			}else{
				
				mprb.createInitPattern(card.property_values.is_from,card.property_values.is_to,card._id,card.property_values.timestamp);
			}
		}
		}
		
	}
	
	
	private void processQueryCard(Card card) {
		//here I need to create the provenance of the card as info 
		//then put the card in the updates table
		card.property_values.getCispacesData();
		if(card.property_values.cispdata.nodeID!=null){
			
		String nodeid=UUID.randomUUID().toString();
		String text="";
		Iterator itx=card.property_values.content.iterator();
		while(itx.hasNext()){
			text+="_"+itx.next();
		}
		text=text.substring(1);
		String[] prov_data=mprb.getProvofQueryCard(card,nodeid,text);
		
		String id=card.property_values.cispdata.nodeID;
		
		
		
		//ok now create the update in the table 
		
		 String text_db=text.replaceAll("'", "''");
		//id (IDaLL) | Text | nodeid (cispacesid) |source | dtg | top_prov (to extract model) || int used (0no 1yes) | 
		 Gson gson=new Gson();
		 String ratio_string=gson.toJson(card.property_values.cispdata.rationale);
		if(!dbc.insertNewUpdate(id,text_db,nodeid,prov_data[0],prov_data[1],prov_data[2],card._id,ratio_string, card.property_values.is_to)){
			 log.log(Level.INFO,"CARD "+card._id+" NOT INSERTED AS REQUEST DOES NOT EXISTS");
		}
		}
		
		
	}
	
	
	
	private void processInfoCard(Card card) {
		//build provenance
		//build node 
		/*	 {
			"info": [
			{
  			"nodeID": "df222a6d-ec6c-4f0c-a424-3cd8bb683e02",
  			"text": "Info 14f9940d 6e1e 4ffc 9c3c 07e92d3c236c",
  			"dtg": "2014/08/28 02:14:50"
  			"prov": "fjsadd"
			},....]
		"dest":....
	 }
*/
	 
		Iterator iter=card.property_values.is_to.iterator();
		while(iter.hasNext()){
			String dest=(String) iter.next();
			HashMap map;
			HashMap node;
			ArrayList nodes;
			if(dest.equals("CISusers")){
				dest="UK/US";
			}
			if(to_send.containsKey(dest)){
				map=to_send.get(dest);
				nodes=(ArrayList) map.get("info");
			}else{
				map=new HashMap();
				nodes=new ArrayList();
				map.put("info", nodes);
				map.put("dest",dest);
			}
			to_send.put(dest, map);
			node=new HashMap();
			String id=UUID.randomUUID().toString();
			node.put("nodeID", id);
			String text="";
			Iterator itx=card.property_values.content.iterator();
			while(itx.hasNext()){
				text+="_"+itx.next();
			}
			text=text.substring(1);
			node.put("text", text);
			String prov=mprb.getProvofInfoCard(card,id,text);
			node.put("prov", prov);
			nodes.add(node);
		}
		 
	}
	
	private void checkConnectionAndTable() {
		//first test db connection
		test=dbc.queryTest();
		if(test){
			try{
			MoiraPollClient mpc=new MoiraPollClient(PRINT);
			String result=mpc.ConnectToEvaluate(m_port, m_host,m_ask);
			if(result==null){
				test=false;
			}
			else{
				
				Gson gson = new Gson();
					if(result!=null){
						Stats res = gson.fromJson(result, Stats.class);
			}
			}
			}catch(Exception e){
				test=false;
			}
		}
		if(test){
		
		if(!dbc.existTable("CISPACES_MOIRASET")){
			  
			 dbc.createTableMoiraCards();
		 }
		
		if(!dbc.existTable("CISPACES_MOIRAPROV")){
			  
			 dbc.createMoiraProv();
		 }
		if(!dbc.existTable("CISPACES_MOIRAUPDS")){
			  
			 dbc.createMoiraUpdates();
		 }
		if(!dbc.existTable("CISPACES_MOIRAQS")){
			  
			 dbc.createTableMoiraQueries();
		 }
		mprb=new MoiraProvMsgBuilder(dbc);
		}
		
	}
	


}
