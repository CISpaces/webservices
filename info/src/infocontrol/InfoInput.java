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

import com.google.gson.internal.LinkedTreeMap;

import utils.JsonHelper;


public class InfoInput {
	private JsonHelper jsh;
	private DBQuery dbc;
	private ArrayList infolist;
	private InfoProvBuild ipb;
	private String dest;
 
 
	public InfoInput() {

		jsh=new JsonHelper();

		DBConnect dbcn=new DBConnect();
		dbc=new DBQuery(dbcn);
		infolist=new ArrayList();
		ipb=new InfoProvBuild(dbc);
	}


	public String postInfo(HashMap map) {
        System.out.println("***************************CHECKING IF TABLES EXIST*****************************************");
        checkTables();
		/* I assume for now that the format of the string is the following:  
		 {
  			"info": [
    			{
      			"nodeID": "df222a6d-ec6c-4f0c-a424-3cd8bb683e02",
      			"text": "Info 14f9940d 6e1e 4ffc 9c3c 07e92d3c236c",
      			"source": "DataStream",
      			"dtg": "2014/08/28 02:14:50"
    			},....]
    		"dest":....
    		"stream": "Moira"
		 }
		 if user is there the info should only go to them,if the affiliation is there then it should go to any of the people with the same affiliation
		 */
 
		//
		
		HashMap res=new HashMap();
		
		infolist=(ArrayList) map.get("info");
		dest=(String) map.get("dest");
		boolean lock=ipb.loadInfoModel(dest);
		
		if(lock){
		while(!locktables(true)){
		}
		
		
		
		if(map.containsKey("stream")){
			//this is from outside if we want
		String stream=(String) map.get("stream");
		int setToAdd;
			ipb.loadInfoModel(dest);
		 
			setToAdd=dbc.getNextSet(dest);
			addinfoset(setToAdd,dest,stream);
		
		
		}else{
			//this is from moira
			int setToAdd;
			ipb.loadInfoModel(dest);
				setToAdd=dbc.getNextSet(dest);
				addinfosetmoira(setToAdd,dest);
				
			
			
			
		}
		
		}
		locktables(false);
		ipb.closeOff();

		res.put("response", "success");
		
		return jsh.convertInputJson(res);
	}

	




  



	private void addinfosetmoira(int setToAdd, String user) {
		String info,nodeid,source,dtg,prov;
		LinkedTreeMap map;
		Iterator iter=infolist.iterator();
		String newid=UUID.randomUUID().toString();
		while(iter.hasNext()){
			map=(LinkedTreeMap)iter.next();
			/* {
		    			{
		      			"nodeID": "df222a6d-ec6c-4f0c-a424-3cd8bb683e02",
		      			"text": "Info 14f9940d 6e1e 4ffc 9c3c 07e92d3c236c",
		      			"source": "DataStream",
		      			"dtg": "2014/08/28 02:14:50"
		      			"prov" : string
		    			},....]
		     
				 */
			 nodeid=(String) map.get("nodeID");
			 info=(String) map.get("text");
			 source=(String) map.get("source");
			 dtg=(String) map.get("dtg");
			 prov=(String) map.get("prov");
			//create prov 
			 //(String nodeid, String info, String stream, String dtg, String source, String newid) {
			
			 // *  |id|affiliation|setid|text|
			 if(dbc.insertNewNode(nodeid,user,info,setToAdd,null)){
				// System.out.println("INSERT PROV");
				 ipb.addNewProvNodeMoira(prov,user);
			 }
		}
		
	}


	public void addinfoset(int setToAdd, String user, String stream) {
		String info,nodeid,source,dtg;
		LinkedTreeMap map;
		Iterator iter=infolist.iterator();
		String newid=UUID.randomUUID().toString();
		while(iter.hasNext()){
			map=(LinkedTreeMap)iter.next();
			/* {
		    			{
		      			"nodeID": "df222a6d-ec6c-4f0c-a424-3cd8bb683e02",
		      			"text": "Info 14f9940d 6e1e 4ffc 9c3c 07e92d3c236c",
		      			"source": "DataStream",
		      			"dtg": "2014/08/28 02:14:50"
		    			},....]
		     
				 */
			 nodeid=(String) map.get("nodeID");
			 info=(String) map.get("text");
			 source=(String) map.get("source");
			 source=source.replaceAll(" ", "_");
			 stream=stream.replaceAll(" ", "_");
			 dtg=(String) map.get("dtg");
			//create prov 
			 //(String nodeid, String info, String stream, String dtg, String source, String newid) {
			boolean test=dbc.insertNewNode(nodeid,user,info,setToAdd,null);
			 // *  |id|affiliation|setid|text|
			//System.out.println(test);
			 if(test){
				 ipb.createNewProvNode(nodeid, info, stream, dtg, source,user);
			 }
		}
	}
	
	private synchronized boolean locktables(boolean lock) {
		if(lock){
			return dbc.setRWLock();
		}else{
			dbc.unsetRWLock();
		}
		return false;
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
		 
		 if(!dbc.existTable("CISPACES_CURANALY")){
			 String[] st=new String[]{
				"curindivid","curshared","wboxid","affiliation"
			 };
			 dbc.createTableCurAnaly("CISPACES_CURANALY",st,"username");
		 }
		 if(!dbc.existTable("CISPACES_INFOND")){
			 String[] st=new String[]{
				"affiliation","text", "lprov"
			 };
			 dbc.createTableInfo("CISPACES_INFOND", st,"setid","nodeID");
		 }
		
		 if(!dbc.existTable("CISPACES_INFOPROV")){
			 
			 dbc.createTableProv("CISPACES_INFOPROV");
		 }

		 if(!dbc.existTable("CISPACES_EDGE")){

		     dbc.createTableEdge("CISPACES_EDGE");
         }
		
	}


	public void closeDataBase() {
		dbc.closeDataBase();
		
	}


	public void postInfoTrans(HashMap map) {
		checkTables();
		/* I assume for now that the format of the string is the following:  
		 {
  			"info": [
    			{
      			"nodeID": "df222a6d-ec6c-4f0c-a424-3cd8bb683e02",
      			"text": "Info 14f9940d 6e1e 4ffc 9c3c 07e92d3c236c",
      			"source": "DataStream",
      			"dtg": "2014/08/28 02:14:50"
    			},....]
    		"dest":....
    		"stream": "Moira"
		 }
		 if user is there the info should only go to them,if the affiliation is there then it should go to any of the people with the same affiliation
		 */
 
		//
		
		HashMap res=new HashMap();
		
		
		
		infolist=(ArrayList) map.get("info");
		dest=(String) map.get("dest");
		boolean lock=ipb.loadInfoModel(dest);
		if(lock){
			while(!locktables(true)){
		}
		
		
		
		 
			//this is from outside if we want
		String stream=(String) map.get("stream");
		String surr=(String) map.get("surr");
		int setToAdd;
 
			 ipb.loadInfoModel(dest);
			setToAdd=dbc.getNextSet(dest);
			addinfosetTrans(setToAdd,dest,stream,surr);
		 
		
		locktables(false);
		ipb.closeOff();
		}
		
	}

	 


 	private void addinfosetTrans(int setToAdd, String user, String stream, String surr) {
		String info,nodeid,source,dtg;
		HashMap lprov=null;
		HashMap map;
		Iterator iter=infolist.iterator();
		String newid=UUID.randomUUID().toString();
		while(iter.hasNext()){
			map=(HashMap)iter.next();
			/* {
		    			{
		      			"nodeID": "df222a6d-ec6c-4f0c-a424-3cd8bb683e02",
		      			"text": "Info 14f9940d 6e1e 4ffc 9c3c 07e92d3c236c",
		      			"source": "DataStream",
		      			"dtg": "2014/08/28 02:14:50"
		    			},....]
		     
				 */
			 nodeid=(String) map.get("nodeID");
			 info=(String) map.get("text");
			 source=(String) map.get("source");
			 source=source.replaceAll(" ", "_");
			 stream=stream.replaceAll(" ", "_");
			 dtg=(String) map.get("dtg");
			 if(map.containsKey("lprov")){
				 lprov=(HashMap) map.get("lprov");
			 }
			//create prov 
			 //(String nodeid, String info, String stream, String dtg, String source, String newid) {
			 String lp=jsh.convertInputJson(lprov);
			boolean test=dbc.insertNewNode(nodeid,user,info,setToAdd,lp);
			 // *  |id|affiliation|setid|text|
		 //	System.out.println(test);
			 if(test){
				 ipb.createNewProvNodeTrans(nodeid, info, stream, dtg, source,surr, user);
			 }
		}
		
	}
	
	
}
//curl -X POST -H "Content-Type: application/json" -d '{"user":"uhx","aff":"US","status":true}' http://localhost:8080/info/rest/GetInfo 