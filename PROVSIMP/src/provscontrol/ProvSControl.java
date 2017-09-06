/******************************************************************************
 * This research was sponsored by the U.S. Army Research Laboratory and the
 * U.K. Ministry of Defence under the Biennial Program Plane 2013 (BPP13),
 * Project 6, Task 3: Collaborative Intelligence Analysis.
 * The U.S. and U.K. Governments are authorized to reproduce and distribute
 * reprints for Government purposes notwithstanding any copyright notation
 * hereon.
 * **************************************************************************
 * 
 * Deals with simple provenance inserts
 * 
 * @author      Alice Toniolo  
 * @version     2.0 
 * @since 		July 2017       
 *   
 */


package provscontrol;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.jena.rdf.model.Model;
import utils.JsonHelper;
import com.google.gson.internal.LinkedTreeMap;

import database.DBQuery;



public class ProvSControl {
	
private RDFSQuery pcore;
private JsonHelper jsh;
protected String provsize;


public ProvSControl(String ps) {
	provsize=ps;
	pcore=new RDFSQuery(provsize);
	jsh=new JsonHelper();
	checkTables();
	provsize=ps;
	}



private void checkTables() {
	DBQuery dbq = new DBQuery(provsize);
	 if(!dbq.existTable("CISPACES_INFOPROV")){
		 dbq.createTableProv();
	 }
}



public HashMap onAddNodes(HashMap map) {
		
	    String user=(String)map.get("user");
	    LinkedTreeMap nodelist=(LinkedTreeMap) map.get("nodes");
	    Iterator iter=(Iterator) nodelist.keySet().iterator();
	    String nodeid;
	    ArrayList fails=new ArrayList();
	    while(iter.hasNext()){
	    	nodeid=(String) iter.next();

	    		LinkedTreeMap ndprov=(LinkedTreeMap) nodelist.get(nodeid);
	    		if(!pcore.existsNode(nodeid)){
	    			if(!addNode(nodeid, ndprov,user)){
	    				fails.add(nodeid);
	    			}
	    		}
	    }
	    pcore.saveAndUpload();
	    map=new HashMap();
	    if(fails.isEmpty()){
			map.put("response","success");
	    }else{
	    	map.put("response","fail");	
	    	map.put("nodes", fails);
	    }
		return map;
	}

private boolean addNode(String nodeid, LinkedTreeMap ndprov,String user) {
	/* 3 types of individual nodes (not to be used for loading a file) 
	 1 prov attached per node 
	 2 metadata per node
	 3 cispaces claim ind node
	 */
	if(ndprov.containsKey("prov")){
		//type 1 	
		LinkedTreeMap prov=(LinkedTreeMap) ndprov.get("prov");
		String stprov=jsh.convertInputJson(prov);
		addNodeFromProv(nodeid,stprov);
		return true;
	}else if(ndprov.containsKey("meta")){
		//type 2
		LinkedTreeMap metaprov=(LinkedTreeMap) ndprov.get("meta");
		addNodeFromMeta(nodeid,metaprov);
		return true;
	}else if(ndprov.containsKey("cisp")){
		//type 3
		LinkedTreeMap cispprov=(LinkedTreeMap) ndprov.get("cisp");
		addNodeFromCisp(nodeid,cispprov);
		return true;
	}else{
	   return false;
	}
}

 

private void addNodeFromCisp(String nodeid, LinkedTreeMap map) {
	 //in this case I create a new standard node model
	/*
	 *  I assume for now that the format of the string is the ERS format
	 * "cisp":  {"text": "Claim2", "annot": "N/A",  "eval": "N/A", "input": "CLAIM", "nodeID": "Q1","type":"I", "dtg": "2014/10/07 13:45:33", "source": "user1"}, 
	 *  
	 * of which I need the following fields (I don't care about the rest)
	 * 		{
  			"text": "Claim2",
  			"source": "user1",
  			"dtg": "2014/10/07 13:45:33"
			}
	 * although data source is similar to the one below, the names of actions in prov are different
	 */
	
	String source=(String) map.get("source");
	String time=(String)map.get("dtg");
	String info=(String)map.get("text");
	Model modnd=pcore.createNewCISpacesNode(nodeid, source, info, time);
	pcore.addNodeModel(modnd, nodeid);
}

private void addNodeFromMeta(String nodeid, LinkedTreeMap map) {
	 //in this case I use the info structure for a new node model
	/* I assume for now that the format of the string is the following:  
	 * The idea here is that this could be called for info that gets sent to CISpaces 
			"meta": 
			{
  			"text": "Info 14f9940d 6e1e 4ffc 9c3c 07e92d3c236c",
  			"source": "DataStream",
  			"dtg": "2014/08/28 02:14:50"
  			"stream": "Moira"
			}
	 if user is there the info should only go to them,if the affiliation is there then it should go to any of the people with the same affiliation
	 */
	//
	String stream=null;
	stream=(String) map.get("stream");
	String info,source,dtg;
	info=(String) map.get("text");
	source=(String) map.get("source");
	source=source.replaceAll(" ", "_");
	stream=stream.replaceAll(" ", "_");
	dtg=(String) map.get("dtg");
	//create prov 
	Model modnd=pcore.createNewProvNode(nodeid, info, stream, dtg, source);
	pcore.addNodeModel(modnd,nodeid);
}

private void addNodeFromProv(String nodeid, String stprov) {
	 //in this case I load the prov model into the database 
	/* I assume for now that the format of the string is the following: 
	 * 
	 * "prov":{
	 * 			"prov":"stringprov"
	 * 			}
	 * 
	 * 
	 */
	//read the model and update node list
	Model modnd=pcore.readModelfromString(stprov);
	pcore.addNodeModel(modnd,nodeid);
}

public HashMap onSave(HashMap map) {
	//need to return a model with all the provenance of all the nodes (this is the input to OnLoad too)
	//this also does a check on nodes that may have not been added so far
	String user=(String)map.get("user");
	ArrayList update=(ArrayList)map.get("nodes");
	//first check that all nodes exists
	ArrayList<String> nodes=new ArrayList<String>();
	Iterator iter=update.iterator();
	while(iter.hasNext()){
		LinkedTreeMap nd=(LinkedTreeMap)  iter.next();
		String nodeID=(String) nd.get("nodeID");
		if(!pcore.existsNode(nodeID)){
			String type=(String) nd.get("type");

			//System.out.println(nodeID+":"+type);
				if(type.equals("I")){
					//System.out.println(nodeID+":"+type);
					addNodeFromCisp(nodeID, nd);
					nodes.add(nodeID);
				}
		}else{
				pcore.loadModel(nodeID);
				nodes.add(nodeID);
			}
		
	}
	//now create a prov model for all the nodes
	String result=pcore.getOnSaveResults(user,nodes);
	if(result!=null & !result.equals("")){
		HashMap newjson=jsh.convertInputMap(result);
		pcore.saveAndUpload();
		map=new HashMap();
		map.put("prov",newjson);
	}else{
		map=new HashMap();
		map.put("response","fail");	
	}
	return map;
}

public HashMap onLoad(HashMap map) {
	/* save all the nodes into the database
	 */
 
	LinkedTreeMap prov=(LinkedTreeMap) map.get("prov");
		ArrayList nodes=(ArrayList)map.get("nodes");
		ArrayList fails=pcore.onLoadFile(nodes,jsh.convertInputJson(prov));
		 pcore.saveAndUpload();
		    map=new HashMap();
		    if(fails.isEmpty()){
				map.put("response","success");
		    }else{
		    	map.put("response","fail");	
		    	map.put("nodes", fails);
		    }
			return map;
}



public HashMap onCopyNode(HashMap map) {
	String fromID=(String) map.get("from");
	String toID=(String) map.get("to");
	map=new HashMap();
	if(pcore.existsNode(fromID)){
		pcore.copyNode(fromID, toID);
		map.put("response","success");
	}else{
		map.put("response","fail");	
	}
	pcore.saveAndUpload();
	return map;
}


public HashMap onGetProvNode(HashMap map) {
	//need to return a model with  the provenance of one of the nodes 
	String user=(String)map.get("user");
	String nodeID=(String) map.get("nodeID");
	Boolean obf=(Boolean)map.get("obf");
	map=new HashMap();
	if(!pcore.existsNode(nodeID)){
		map.put("response","fail");	
	}else{
		//now create a prov model for all the nodes
		String result=pcore.loadProvModel(nodeID,user,obf);
		if(result!=null & !result.equals("")){
			HashMap newjson=jsh.convertInputMap(result);
			map.put("prov",newjson);
		}else{
			map.put("response","fail");	
		}
	}
	pcore.saveAndUpload();
	return map;
}


	
	



}