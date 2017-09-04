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
 * 
 * @author      Alice Toniolo  
 * @version     1.0  
 * @since 		September 2014           
 *   
 */


package infocontrol;

 
import gaian.DBConnect;
import gaian.DBQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import utils.JsonHelper;


public class InfoControl {
	private long INTERVAL;//3 mins
	private HashMap in;
	private JsonHelper jsh;
	private DBQuery dbc;
	private User user;
	private ArrayList infolist;
	private boolean hasUser;
	private InfoProvBuild ipb;
	
	private DBConnect dbcn;
	private boolean rand_gen;
 
 
	public InfoControl(HashMap map, int ite, boolean rgen) {
		rand_gen=rgen;
		jsh=new JsonHelper();
		in=map;
		/*
		 *String dbURL = "jdbc:derby://localhost:6414/gaiandb";
		String dbDriver = "org.apache.derby.jdbc.ClientDriver";
		String dbUname ="gaiandb";
		String dbPass = "passw0rd";
		 */

		dbcn=new DBConnect();
		dbc=new DBQuery(dbcn);
		user=new User();
		infolist=new ArrayList();
		hasUser=false;
		INTERVAL=ite*60000;
		ipb=new InfoProvBuild(dbc);
		
		//System.out.println( UUID.randomUUID().toString());
	//	System.out.println( UUID.randomUUID().toString());
	}



	public String getInfo() {
		//{"text":"Some equipment was stolen from biology lab, Professor Patino reported","annot":{"conc":{},"prem_assump":{}},"nodeID":"81d9489b-7869-46e5-bdca-f5ca0cede9af","eval":"N/A","commit":"N/A","input":"INFO","type":"I"}
		checkTables();
		String usss=(String) in.get("user");
		//now lock 
		boolean lock=ipb.loadInfoModel(usss);
		HashMap output;
		if(lock){
			
		while(!locktables(true)){
		//	System.out.println("waiting");
		}
		user.setUser(usss);
		user.setAff((String)in.get("aff"));
		retrieveLastSession();
		//this sets user info
		checkifUserInfo();
	//	System.out.println(newinfo);
		//System.out.println(newinfo);
		checkifEnoughInfoSet();
	
		//this sets infolist
		//now if it is the initial I send all the information to the user else, I send the new ones only when there is > 3 mins before the previous request
		boolean init=(Boolean) in.get("status");
	
	
		if(init || (!init&&!hasUser)){
			//System.out.println(init +" "+ hasUser);
			output=getInitInfo();
		}else{
			//System.out.println("fsdjbag"+init +" "+ hasUser);
			output=getNewInfo();
		}
		//here make sure that the provenance use of db is released
		ipb.closeOff();
		//and unlock
		locktables(false);
		}else{
			output=new HashMap();
			output.put("response","fail");
		}
		String outreturn=jsh.convertInputJson(output);
	 //   ipb.printAll(user.getUser());
		return outreturn;
	}

	



	private synchronized boolean locktables(boolean lock) {
		if(lock){
			return dbc.setRWLock();
		}else{
			dbc.unsetRWLock();
		}
		return false;
	}

	private boolean checkifUserInfo() {
		ArrayList infoset=dbc.checkUserInfo(user.getUser());
		if(infoset!=null){
		// System.out.println("enough");
			infolist.addAll(infoset);
			return true;
		} else{
			return false;
		}
	}

	private void checkifEnoughInfoSet() {
		int setToRead=user.getLastset()+1;
		ArrayList infoset=dbc.checkSet(setToRead,user.getAff());
		if(infoset!=null){
		// 	System.out.println("enough");
			infolist.addAll(infoset);
		}else{
		 	//System.out.println(" not enough");
			if(rand_gen){
			infoset=dbc.createNewSet(setToRead,user.getAff(),ipb,user.getUser());
			infolist.addAll(infoset);
			}
		}
	}

	private HashMap getNewInfo() {
		long now=System.currentTimeMillis();
		HashMap output=new HashMap();
		long before=user.getTime();
		if(now-before>=INTERVAL){
			ArrayList array=getProvInfo(infolist);
			output.put("info",array);
			dbc.changeEntry(now,user);
		}
		else{
			output.put("info",new ArrayList());
		}
		return output;
	}

	private ArrayList getProvInfo(ArrayList infolist) {
		
		//this is the last set of information that goes out to the user
		ArrayList totlist=new ArrayList();
	 if(infolist!=null){
		Iterator iter=infolist.iterator();
		String id,newid,text;
		HashMap map,newinfo;
		
		String[] provinfo;
		while(iter.hasNext()){
			 map=(HashMap) iter.next();
			 id=(String) map.get("nodeID");//this is the id that is at the top of the model 
			 //query default model and copy all the data into 
			 
			 text=(String) map.get("text");
			 newid=ipb.createAccessProv(id,text,user.getUser(),user.getAff());
			 newinfo=new HashMap();
			 newinfo.put("nodeID", newid);
			 newinfo.put("text",text);
		
			 //dtg and source filling 
			 provinfo=ipb.retrieveProvInfo(newid);
			 newinfo.put("dtg",provinfo[1]);
			 newinfo.put("source", provinfo[0]);
			 totlist.add(newinfo);
		 
		}
	 }
		return totlist;
	}

	private HashMap getInitInfo() {
		ArrayList list=dbc.getAllInfo(user.getLastset(),user.getAff(),user.getUser());
		HashMap output=new HashMap();
		ArrayList array=new ArrayList();
		array=getProvInfo(list);
		output.put("info",array);
		return output;
	}

	private void retrieveLastSession() {
		//check if user exists
		User tryuname=dbc.existUser(user);
		if(tryuname!=null){
			//exists
			hasUser=true;
			user=tryuname;
			
			//System.out.println("exists");
		}else{
			//otherwise create new one
			user=dbc.createUser(user,ipb,rand_gen);
			hasUser=false;
			//System.out.println("not exists");
		}
	
	//	System.out.println(user.toString());
		 //at the end of this method I have my 
		
	}
 

	private synchronized void checkTables() {
		//only one at a time should do this :) 
		
		// DBQuery dbc=new DBQuery();
		//try to connect to database
				//make sure that tables are there
				/*
				 *  Table CISPACES_INFOTMP
				 *  |id|username|affiliation|lasttime|lastset|
				 *  Table CISPACES_INFOND
				 *  |id|setid|text|affiliation|
				 * 
				 */
				//if not create them  
		 if(!dbc.existTable("CISPACES_INFOTMP")){
			 String[] st=new String[]{
				"username","lasttime","affiliation"
			 };
			 dbc.createTableSets("CISPACES_INFOTMP",st,"lastset");
		 }
		 //this will be used as lock!
		 dbc.setUserDefault();
		 
		 if(!dbc.existTable("CISPACES_CURANALY")){
			 String[] st=new String[]{
				"curindivid","curshared","wboxid","affiliation"
			 };
			 dbc.createTableCurAnaly("CISPACES_CURANALY",st,"username");
		 }
		 if(!dbc.existTable("CISPACES_INFOND")){
			 String[] st=new String[]{
				"affiliation","text"
			 };
			 dbc.createTableInfo("CISPACES_INFOND", st,"setid","nodeID");
		 }
		
		 if(!dbc.existTable("CISPACES_INFOPROV")){
			 
			 dbc.createTableProv("CISPACES_INFOPROV");
		 }
		
	}



	public void closeDataBase() {
		dbc.closeDataBase();
		
	}

	
	
}
//curl -X POST -H "Content-Type: application/json" -d '{"user":"uhx","aff":"US","status":true}' http://localhost:8080/info/rest/GetInfo
////curl -X POST -H "Content-Type: application/json" -d '{"user":"ux","aff":"UK","status":false}' http://localhost:8080/info/rest/GetInfo
//curl -X POST -H "Content-Type: application/json" -d '{"user":"ux","aff":"uk","status":true}' http://localhost:8080/info/rest/GetInfo
//curl -X POST -H "Content-Type: application/json" -d '{"user":"uhx","aff":"uk","status":true}' http://localhost:8080/info/rest/GetInfo
//curl -X POST -H "Content-Type: application/json" -d '{"user":"uhx","aff":"uk","status":false}' http://localhost:8080/info/rest/GetInfo