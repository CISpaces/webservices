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

package moiranodes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import com.google.gson.Gson;
import com.hp.hpl.jena.rdf.model.Model;

import data.Rationale;
import data.Stats;
import gaian.DBConnect;

import gaian.MDBQuery;
import moirapolls.MoiraPollClient;
import moirapolls.MoiraProvMsgBuilder;
import utils.JsonHelper;
import utils.TimeComparator;
import utils.TimeExtender;
 


public class MoiraPostControl {
	 private MDBQuery dbc;
	 private String m_host;
	 private int m_port; 
	 private String m_tell;
	 private boolean PRINT=false;
	private String m_ask;
	private String moira_name;

	public MoiraPostControl(String m_h, int m_port2,String tl,String ask, boolean pt,String moi) {
  
		  m_host=m_h; 
		  m_port=m_port2;
		  m_tell=tl;
		  m_ask=ask;
		  PRINT=pt;
		  moira_name=moi;
		  DBConnect dbcn=new DBConnect();
		  dbc=new MDBQuery(dbcn);
		  
		 
	}

	public HashMap post(HashMap input){
		if(!checkConnections()){
			return noSuccess();
		}
		checkTable();
		if(input.containsKey("action")){
			String action=(String) input.get("action");
			switch(action){
				case "openquery":
					if(openQuery(input))
						return success();
					else
						return noSuccess();
				case "closequery":
					closeQuery(input);
					return success();
				case "getall":
					return getAllQueries(input);
				case "getupdates":
					HashMap map=getAllUpdates(input);
					if(map!=null)
						return map;
					else
						return noSuccess();	
				default:
					return noSuccess();
			}
		}else{
			return noSuccess();
		}
	}
	

	private HashMap getAllUpdates(HashMap input) {
		String queryID=(String) input.get("queryID");
		HashMap updates=new HashMap();
		
		//I require one queryhistory 
		
		/* 
		 * I need to populate the node text
		 * The id
		 * if it is shared or not
		 * the history
		 * the updates
		 * the import 
		 */
		String[] query_data=dbc.getAllQueryData(queryID);
		//shared|textnode|query
		if(query_data[0]!=null){
		
		int val=Integer.parseInt(query_data[0]);
		if(val==0){
			updates.put("shared", false);
		}else{
			updates.put("shared", true);
		}
		updates.put("text", query_data[1]);
		//dtg From 
		String querynode=query_data[5];
		updates.put("nodeID", querynode);
		String user=query_data[3];
		ArrayList<String> hystory=new ArrayList<String>();
				
		hystory.add(query_data[4]+"-"+user+" to "+moira_name+":"+query_data[2]);
		
		//now add all the previous history 
		ArrayList<String[]> list=dbc.getAllHistory(queryID);
		TimeComparator comp=new TimeComparator();
		Collections.sort(list,comp);
		for(String[] hdata:list){
			String fromto="";
			if(hdata[1].equals("XXXX")){
				fromto=user+" to "+moira_name;
			}else{
				fromto=moira_name+" to "+user;
			}
			String newmsg=hdata[2]+"-"+fromto+":"+hdata[0];
			
			if(hdata[3]!=null && !hdata[3].equals("null")){
				Gson gson=new Gson();
				Rationale[] rar=gson.fromJson(hdata[3], Rationale[].class);
				newmsg+="\n"+getRationaleText(rar);	
				
			}
			hystory.add(newmsg);
		}
		updates.put("history", hystory);
		//history done!
		
		//now updates
		
		//now what do I do with them 
		//for this user we have only two options 
		MoiraProvMsgBuilder mprb=new MoiraProvMsgBuilder(dbc);
		MoiraNodeBuilder mnb=new MoiraNodeBuilder(moira_name);
		mnb.setProvAnalysis(user);
		//now these messages could only be from Moira because otherwise we would have seen them already
		//if I sent something I need to be in the page 
		HashMap node=new HashMap();
		//now query for updates then build new messages
		ArrayList<String[]> opts=dbc.getAllUpdates(queryID);
		ArrayList<String> msg=new ArrayList<String>();
		for(String[] keys:opts){
				String text=keys[0];
				String dtg=keys[2];
				String newmsg=dtg+"-"+moira_name+" to "+user+":"+text;
				
				String source=keys[4];
				String nodeid=keys[3];
				String ration=keys[5];
				String top_prov=keys[1];
				if(ration==null){
					mnb.createNode("INFO",text,source,dtg,nodeid);
				}else{
					mnb.createNode("CLAIM",text,source,dtg,nodeid);
				}
				String pid=mnb.createPro(moira_name,null);
				mnb.createEdges(querynode,pid,nodeid);
				//now if this node contains rationale add rationale
				
				Model model=mprb.getProvModel(top_prov);
				//now extract model prov and give it to model
				mnb.setProvenance(nodeid,model);
				//System.out.println(ration);
				if(ration!=null && !ration.equals("null")){
				//	System.out.println(ration);
				//there is some rationale to be parsed 
				 //	System.out.println("SOME RATIONALE"+ration);
					Gson gson=new Gson();
					Rationale[] rar=gson.fromJson(ration, Rationale[].class);
					newmsg+="\n"+getRationaleText(rar);
					//System.out.println(newmsg);
					mnb.addRationale(rar,text,top_prov,source,dtg);
					 
				}
				msg.add(newmsg);
				
		}
		if(!opts.isEmpty()){
			HashMap cisp=mnb.getCispData();
			updates.put("cis_data", cisp);
		} 
		updates.put("updates", msg);
				//System.out.println(node+""+ups);
		mprb.closeOff();
		return updates;
		
		}else{
			return null;
		}
		
		
		
	}

	private HashMap getAllQueries(HashMap input) {
		String user=(String) input.get("user");
		//we need text, queryid
		ArrayList<HashMap> list=dbc.getAllQueries(user);
		HashMap map=new HashMap();
		map.put("queries", list);
		return map;
	}
	
	
	public String getRationaleText(Rationale[] rar) {
		String msg="";
		for(Rationale rule:rar){
			Iterator iter=rule.conclusions.iterator();
			String conc;
			String msg_conc="";
			while(iter.hasNext()){
				conc=(String) iter.next();
				msg_conc+=conc+" AND ";
			}
			msg_conc=msg_conc.substring(0,msg_conc.length()-5);
			String msg_prems="";
			iter=rule.premises.iterator();
			while(iter.hasNext()){
				msg_prems+=iter.next()+" AND ";
			}
			msg_prems=msg_prems.substring(0,msg_prems.length()-5);
			msg+=msg_conc+" BECAUSE "+msg_prems;
		} 
		return msg;
	}
	
	private void closeQuery(HashMap input) {
		String queryID=(String) input.get("queryID");
		//do I have to remove the query from Moira? 
		dbc.deleteQuery(queryID);
 
	}

	private boolean openQuery(HashMap input) {
		//this is called for both existing and not existing queries 
		String user=(String) input.get("user");
		String query=(String) input.get("msg");
		String queryID=(String) input.get("queryID");
		String nodeID=(String) input.get("nodeID");
		String text=(String) input.get("text");
		
		
		if(queryID!=null){
			//then this exists already 
			addUserUpdate(queryID,query,user);
			return true;
		}else{
			boolean shared=(Boolean) input.get("shared");
			return addNewQuery(shared, user, nodeID, text, query);
		}
		
	}

	private boolean addNewQuery(boolean shared,String user,String nodeID,String text,String query) {
		int num=0;
		if(shared){
			num=1;
		}
	//	String allID=num+user+nodeID;
		String allID=UUID.randomUUID().toString();
	
	//	System.out.println(query);
	   String query_card=query.replaceAll("'", "\\'" );
	 
		String card="there is a NL card named 'msg_{uid}' that"
				+ "\n has the timestamp '{now}' as timestamp and"
				+ "\n is from the individual '"+user+"' and"
				+ "\n is to the agent '"+moira_name+"' and"
				+ "\n has '"+query_card+"' as content and"
				+ "\n has '{"
				+ "\n \"to_cispaces\": false,"
				+ "\n \"nodeID\": \""+allID+"\""
				+ "\n }' as secondary content.";
 
		//first save it!!
		//then post it!!
	//	System.out.println(card);
		String query_db=query.replaceAll("'", "''" );
		TimeExtender time=new TimeExtender();
		String dtg=time.nowUnix();
		//I should be posting a query twice but I check just in case
		if(dbc.insertNewQuery(user,query_db,num,nodeID,allID,text,dtg)){
			MoiraPostClient mpc=new MoiraPostClient(PRINT);
			String result=mpc.ConnectToEvaluate(m_port, m_host,m_tell,card);
			
			return true;
		}
		return false;
	}

	

	private void addUserUpdate(String queryID, String query, String user) {
	   String last_msg=dbc.getLastMsg(queryID);
	   String query_card=query.replaceAll("'", "\\'" );
	   String extra="";
	 if(last_msg!=null){
		 extra="\n is in reply to the NL card '"+last_msg+"' and";
	 }
		String card="there is a NL card named 'msg_{uid}' that"
				+ "\n has the timestamp '{now}' as timestamp and"
				+ extra 
				+ "\n is from the individual '"+user+"' and"
				+ "\n is to the agent '"+moira_name+"' and"
				+ "\n has '"+query_card+"' as content and"
				+ "\n has '{"
				+ "\n \"to_cispaces\": false,"
				+ "\n \"nodeID\": \""+queryID+"\""
				+ "\n }' as secondary content.";
 
		//first save it!!
		//then post it!!
	//	System.out.println(card);
		String query_db=query.replaceAll("'", "''" );
		TimeExtender time=new TimeExtender();
		String dtg=time.nowUnix();
		dbc.insertNewMsg(user,query_db,queryID,dtg);
		MoiraPostClient mpc=new MoiraPostClient(PRINT);

		String result=mpc.ConnectToEvaluate(m_port, m_host,m_tell,card);
	}

	private HashMap success() {
		HashMap map=new HashMap();
		map.put("result", "success");
		return map;
	}

	private HashMap noSuccess() {
		HashMap map=new HashMap();
		map.put("result", "fail");
		return map;
	}

	 

	private void checkTable() {
	 	if(!dbc.existTable("CISPACES_MOIRAQS")){
			  
			 dbc.createTableMoiraQueries();
		 }
	 	if(!dbc.existTable("CISPACES_MOIRAUPDS")){
			  
			 dbc.createMoiraUpdates();
		 }
		if(!dbc.existTable("CISPACES_MOIRAPROV")){
			  
			 dbc.createMoiraProv();
		 }
		
		
	}
	
	

	private boolean checkConnections() {
		boolean test=dbc.queryTest();
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
		return test;
	}


}

/*{ \"to_cispaces\": true, \"sources\": [\"Fran\"],  \"forwarded_from\": \"msg_015\",  \"nodeID\": \"0Milesdf282a6d-ec6c-4f0c-a424-3cd8bb683e02\",  \"rationale\":  [{\"premises\":[ \"c saw b in locA\", \"a was in locA\" ],\"conclusions\": [ \"the person \'TheIEDMaker\' is the same as the person \'John\'.\" ]}]} 
 *   {\"premises\":[ \"c was in locA\" ], \"conclusions\":[ \" c saw b in locA\" ]}]}
 */ 
