
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
 * @since 		March 2015           
 *   
 */


package csnodes;

 
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

import utils.TimeHelper;

import com.google.gson.internal.LinkedTreeMap;

 

public class ERSCSBuilder {
	private ArrayList nodes;
	private ArrayList ndprov;
	private ArrayList edges;

	private String formID = null;
	private TimeHelper time;
	private ArrayList locations;
	private String crowdloc;
 
	private String user;
	
	private ArrayList ques = null;
	private long nQues = 0;
	private ArrayList queStat = null; 
	
	private String title = null;
	private String des = null;
	private String createTime = null;
	private String lastTime = null;
	
	
	private String nodeID=null;
	private String timestamp;//now
 
	private String root;
	private boolean support;
	
	//{formAnalysis={lastTime=2015-04-14 16:00:37.037, des=Given that A Toxic Bacteria contaminated the local water system in Kish, is the claim supported by evidence?, nodeID=, title=A Toxic Bacteria contaminated the local water system in Kish, supp=true, timestamp=2015-04-20 12:48:12.4812, crowdloc=UK/US, userID=83603dc6-44cd-43e1-8bc9-7a9d2b345742, locations=[UK/US], nQues=2.0, ques=[{queID=1, queType=MultiChoice, srcUrl=http%3A%2F%2Flocalhost%3A8080%2Fhdcpictures%2Ftap_water.png, ansOptions=[White, Yellow, Brown, Clear ], que=What is the color of your tap water?, ansValues=[Con, Pro, Pro, Con]}, {queID=0, queType=Numerical, Pro=[20.0, 1.0E308], srcUrl=http%3A%2F%2Flocalhost%3A8080%2Fhdcpictures%2Ftap_water.png, que=What is the temperature of your cold water?, Con=[1.0E-308, 19.0]}], queStat=[{queType=Numerical, count={std=2.6012817353502227, mean=21.1, right=25.0, left=17.0}, ratio={}, queID=0, maxAnsLen=2.0}, {queType=MultiChoice, count={Brown=0.125, Clear=0.5416666666666666, White=0.125, Yellow=0.20833333333333334}, ratio={}, queID=1, maxAnsLen=6.0}], formID=myFormCont, createTime=201504051123}, user=Joe}

	
	public ERSCSBuilder(HashMap maptot)  {
		//System.out.println(maptot);
		LinkedTreeMap map=(LinkedTreeMap) maptot.get("formAnalysis");
		time=new TimeHelper();
		user=(String) maptot.get("user");
		formID = (String) map.get("formID");
		queStat = (ArrayList) map.get("queStat");
		locations = (ArrayList) map.get("locs");
		support =(boolean) map.get("supp");
		ques=(ArrayList) map.get("ques");
		double val=(double) map.get("nQues");
		nQues= Math.round(val);
		title=(String) map.get("title");
		des=(String) map.get("des");
		createTime=(String) map.get("createTime");
		lastTime=(String) map.get("lastTime");
		nodeID=(String) map.get("nodeId");
		timestamp=(String) map.get("timestamp");
		nodeID=(String) map.get("nodeID");
		crowdloc=(String) map.get("crowdloc");
		nodes=new ArrayList();
		ndprov=new ArrayList();
		edges=new ArrayList();
		root=null;
	}

	public HashMap prepareCS() {
	 
	 
		//first of all create the top node!!!
		String source="CS_Results_"+formID;//remember
		String timex=time.nowCIS();
		String proID=UUID.randomUUID().toString();
		String conID=UUID.randomUUID().toString();
		if(support){
		if(nodeID==null || nodeID.equals("") ){
			//in this case there is no initial root node! //create one!
			HashMap node=new HashMap();
			String text="It is the case that "+title;
		    node.put("text", text);
		    node.put("uncert","Confirmed");// for now we leave it like that!
		    node.put("eval","N/A");
		    node.put("input", "CLAIM");
		    node.put("source", source);
		    node.put("dtg", timex);
		    node.put("commit","N/A");
		    node.put("type", "I");
		    String nodeid=UUID.randomUUID().toString();
		    node.put("nodeID", nodeid);
		    HashMap ann=new HashMap();
		    ann.put("conc", new HashMap());
		    ann.put("prem_assump", new HashMap());
		    node.put("annot", ann);
		    root=nodeid;
		    nodes.add(node);
		    ndprov.add(node);
		}else{
			root=nodeID;
		}
		}
		//ok node the top node is done!!
		//for each question,
		//get the most likely answer, 
		//get the result 
		//build 3 nodes (2 prem, 1 conc)
		//build the pro/con link with the root 
		LinkedTreeMap question=new LinkedTreeMap();
		LinkedTreeMap answer=new LinkedTreeMap();
		LinkedTreeMap count;
		HashSet sPro=new HashSet();
		HashSet sCon=new HashSet();
		String queID,ansID;
		String queType,text1,text2 = "",text3="";
		for(int i=0;i<nQues;i++){
			
			question=(LinkedTreeMap) ques.get(i);
			//now get the id
			queID=(String) question.get("queID");
			//find it in answers
			for(int j=0;j<nQues;j++){
				answer=(LinkedTreeMap) queStat.get(j);
				ansID=(String) answer.get("queID");
				if(ansID.equals(queID)){
					break;
				}
			}
			//System.out.println(answer.toString());
			//System.out.println(question.toString());
			//ok now I have answers and questions!
			//get the most likely answer (check type) 
			queType=(String)question.get("queType");
			String idp3=UUID.randomUUID().toString();
			text1="Given that the group was asked "+question.get("que");
			if(support && queType.equals("Numerical")){
				//numerical 
				//get answer!
				
				count=(LinkedTreeMap) answer.get("count");
				double mean=(double) count.get("mean");
				double result= Math.round( mean * 100.0 ) / 100.0;
				text2="Answer "+result+" is generally accepted as true";
				text3="Answer "+result+" may be plausibly be true";
				//now is it pro or con?
				//get limits!!!
				//"Con":[1.0E-308,19.0],"Pro":[20.0,1.0E308],
				ArrayList pros=(ArrayList) question.get("Pro");
				double low=(double) pros.get(0);
				double high=(double) pros.get(1);
				if(low<=mean && mean<=high){
					sPro.add(idp3);
				}else{
					sCon.add(idp3);
				}
	
			}else if(support && queType.equals("MultiChoice")){
				//categorical 
				//find answer!
				count=(LinkedTreeMap) answer.get("count");
				double max=Double.MIN_VALUE,value;
				String result="",potent;
				Iterator iter=count.keySet().iterator();
				while(iter.hasNext()){
					potent=(String) iter.next();
					value=(double)count.get(potent);
					if(value>max){
						max=value;
						result=potent;
					}
				}
				text2="Answer "+result+" is generally accepted as true";
				text3="Answer "+result+" may plausibly be true";
				//"ansOptions":["White","Yellow","Brown","Clear "]
				//"ansValues":["Con","Pro","Pro","Con"]
				ArrayList opts=(ArrayList) question.get("ansOptions");
				
				int index=opts.indexOf(result);
				ArrayList vals=(ArrayList) question.get("ansValues");
				//System.out.println(opts+"\n"+vals+index);
				String eval=(String) vals.get(index);
				if(eval.equals("Pro")){
					sPro.add(idp3);
				}else{
					sCon.add(idp3);
				}
				
				
			}else{//for all the other types of questions!!!
				count=(LinkedTreeMap) answer.get("count");
				double max=Double.MIN_VALUE,value;
				String result="",potent;
				Iterator iter=count.keySet().iterator();
				while(iter.hasNext()){
					potent=(String) iter.next();
					value=(double)count.get(potent);
					if(value>max){
						max=value;
						result=potent;
					}
				}
				text2="Answer "+result+" is generally accepted as true";
				text3="Answer "+result+" may plausibly be true";
				//"ansOptions":["White","Yellow","Brown","Clear "]
				//"ansValues":["Con","Pro","Pro","Con"]
				
			}
			
			//this happens anyway regardless the type of question or the type of support
			
		 
			
			String idArgScheme=UUID.randomUUID().toString();
			//careful because we need an argumentation scheme first!!!!
			//ok now build the nodes!!!
			HashMap node=new HashMap();
		    node.put("text", text1);
		    node.put("uncert","Confirmed");// for now we leave it like that!
		    node.put("eval","N/A");
		    node.put("input", "CLAIM");
		    node.put("source", source);
		    node.put("commit","N/A");
		    node.put("type", "I");
		    String idp1=UUID.randomUUID().toString();
		    node.put("nodeID", idp1);
		    node.put("dtg", timex);
		    HashMap ann=new HashMap();
		    ann.put("conc", new HashMap());
		    HashMap scheme=new HashMap();
		    HashMap charact=new HashMap();
		    ArrayList prems=new ArrayList();
		    prems.add("PCS1");
		    charact.put("prem", prems);
		    charact.put("cqs", new ArrayList());
		    charact.put("id", "LCS");
		    charact.put("assump", new ArrayList());
		    scheme.put(idArgScheme, charact);
		    ann.put("prem_assump", scheme);
		    node.put("annot", ann);
		    nodes.add(node);
		    ndprov.add(node);
		    
		   // "annot":{"conc":{},"prem_assump":{"bf72a519-73b3-4b46-b2b2-44e2ecadc3ba":{"prem":["PCS1"],"cqs":[],"id":"LCS","assump":[]}}}}
		    
		    node=new HashMap();
		    node.put("text", text2);
		    node.put("uncert","Confirmed");// for now we leave it like that!
		    node.put("eval","N/A");
		    node.put("input", "CLAIM");
		    //source and dtg with provenance
		    node.put("commit","N/A");
		    node.put("type", "I");
		    node.put("dtg", timex);
		    node.put("source", source);
		    String idp2=UUID.randomUUID().toString();
		    node.put("nodeID", idp2);
		     ann=new HashMap();
		    ann.put("conc", new HashMap());
		    scheme=new HashMap();
		     charact=new HashMap();
		     prems=new ArrayList();
		    prems.add("PCS2");
		    charact.put("prem", prems);
		    charact.put("cqs", new ArrayList());
		    charact.put("id", "LCS");
		    charact.put("assump", new ArrayList());
		    scheme.put(idArgScheme, charact);
		    ann.put("prem_assump", scheme);
		    node.put("annot", ann);
		    nodes.add(node);
		    ndprov.add(node);
		  
		    //"annot":{"conc":{},"prem_assump":{"bf72a519-73b3-4b46-b2b2-44e2ecadc3ba":{"prem":["PCS2"],"cqs":[],"id":"LCS","assump":[]}}}},
		    
		    node=new HashMap();
		    node.put("text", text3);
		    node.put("uncert","Confirmed");// for now we leave it like that!
		    node.put("eval","N/A");
		    node.put("input", "CLAIM");
 
		    node.put("commit","N/A");
		    node.put("type", "I");
		    node.put("dtg", timex);
		    node.put("source", source);
		    
		    node.put("nodeID", idp3);
		     ann=new HashMap();
		    ann.put("prem_assump", new HashMap());
		    scheme=new HashMap();
		     charact=new HashMap();
		    ArrayList concs=new ArrayList();
		    concs.add("CCS1");
		    charact.put("conc", concs);
		    charact.put("cqs", new ArrayList());
		    charact.put("id", "LCS");
		    scheme.put(idArgScheme, charact);
		    ann.put("conc", scheme);
		    node.put("annot", ann);
		    nodes.add(node);
		    ndprov.add(node);
		    
		    //,"annot":{"conc":{"bf72a519-73b3-4b46-b2b2-44e2ecadc3ba":{"cqs":[],"conc":["CCS1"],"id":"LCS"}},"prem_assump":{}}},
		    
		    //{"text":"LCS","dtg":"2015/03/02 15:36:59","annot":{"id":"LCS"},"nodeID":"bf72a519-73b3-4b46-b2b2-44e2ecadc3ba","source":"Joe","type":"RA"},
		    
		    //NOW ONE NODE FOR LINK!! THEN EDGES!
		    node=new HashMap();
		    node.put("text", "LCS");
		    node.put("dtg", timex);
		    node.put("nodeID", idArgScheme);
		    node.put("type", "RA");
		    node.put("source", source);
		    ann=new HashMap();
		    ann.put("id", "LCS");
		    node.put("annot", ann);
		    nodes.add(node);

		 //3 edges!
		    //{"toID":"bf72a519-73b3-4b46-b2b2-44e2ecadc3ba","fromID":"f8e089f3-8d58-49c0-ac35-597f47ed06b1","formEdgeID":null,"edgeID":"f6db6d08-84cd-4536-a0d5-b94358d8f948"}
			HashMap edge=new HashMap();
			edge.put("toID", idArgScheme);
			edge.put("fromID", idp1);
			edge.put("formEdgeID",null);
		    String idx=UUID.randomUUID().toString();
			edge.put("edgeID", idx);
			edges.add(edge);
			
			edge=new HashMap();
			edge.put("toID", idArgScheme);
			edge.put("fromID", idp2);
			edge.put("formEdgeID",null);
		    idx=UUID.randomUUID().toString();
			edge.put("edgeID", idx);
			edges.add(edge);
			
			edge=new HashMap();
			edge.put("toID", idp3);
			edge.put("fromID", idArgScheme);
			edge.put("formEdgeID",null);
		    idx=UUID.randomUUID().toString();
			edge.put("edgeID", idx);
			edges.add(edge);
			
			
			
			
			
			
			
			 
			
		}
		
		if(support){
		
		/*
		 * "edges":[,{"toID":"227340f2-c962-499e-9f8d-0219f7e3397b","fromID":"bf72a519-73b3-4b46-b2b2-44e2ecadc3ba","formEdgeID":null,"edgeID":"c4416beb-d74e-4bd9-b439-a2d4245212ff"},{"toID":"964ea8ec-c748-400c-9de5-21fbc0570724","fromID":"156f712b-4a88-4f31-9164-2b1bee005b4f","formEdgeID":null,"edgeID":"9762918f-7ebc-45cd-96d8-04c37a46b771"},{"toID":"227340f2-c962-499e-9f8d-0219f7e3397b","fromID":"964ea8ec-c748-400c-9de5-21fbc0570724","formEdgeID":null,"edgeID":"656cb216-5aa6-4bc2-a233-1ff6d2c848f1"},{"toID":"290d5acc-1221-4603-9642-af43c993b433","fromID":"e8850ce4-7579-40d3-b476-34f0af49ce9e","formEdgeID":null,"edgeID":"3bdd5883-36a0-4c9c-b261-19d5dfb2fb90"},{"toID":"227340f2-c962-499e-9f8d-0219f7e3397b","fromID":"290d5acc-1221-4603-9642-af43c993b433","formEdgeID":null,"edgeID":"792cc1e7-1874-462b-84b6-f105ef844b26"},{"toID":"bf72a519-73b3-4b46-b2b2-44e2ecadc3ba","fromID":"0a89fecf-0afd-4c1e-b88f-3afd7f16d50e","formEdgeID":null,"edgeID":"57dc94e0-af50-4fe8-baab-a4512f7c0be5"}],"node_pos":{"scale":1.6686209533520184,"f8e089f3-8d58-49c0-ac35-597f47ed06b1":[560.6220494519503,532.9846800917664],"227340f2-c962-499e-9f8d-0219f7e3397b":[702.4548304868723,214.27807800152965],"964ea8ec-c748-400c-9de5-21fbc0570724":[839.2817486617384,366.12258475656387],"e8850ce4-7579-40d3-b476-34f0af49ce9e":[428.80099413714044,197.5918684680094],"156f712b-4a88-4f31-9164-2b1bee005b4f":[939.3990058628598,553.0081315319904],"bf72a519-73b3-4b46-b2b2-44e2ecadc3ba":
		 */
		//now we create a node for each 
		
		//first create the con link to the root!
		  HashMap node=new HashMap();
		  node=new HashMap();
		  node.put("text", "Con CS");
		  node.put("dtg", timex);
		  String conTop=UUID.randomUUID().toString();
		  node.put("nodeID", conTop);
		  node.put("type", "CA");
		  node.put("source", source);
		  HashMap ann=new HashMap();
		  ann.put("cq_ans_node_id", null);
		  ann.put("cq_id", null);
		  node.put("annot", ann);
		  nodes.add(node);
		  
		  //create two nodes with support/ not support
		  //PRO TOP
		  	node=new HashMap();
		  	String text="Group provides evidence FOR "+title;
		  	node.put("text", text);
		    node.put("uncert","Confirmed");// for now we leave it like that!
		    node.put("eval","N/A");
		    node.put("input", "CLAIM");
		    node.put("source", source);
		    node.put("dtg", timex);
		    node.put("commit","N/A");
		    node.put("type", "I");
		    node.put("nodeID", proID);
		    ann=new HashMap();
		    ann.put("conc", new HashMap());
		    ann.put("prem_assump", new HashMap());
		    node.put("annot", ann);
		    nodes.add(node);
		    ndprov.add(node);
		  //CON TOP
		    node=new HashMap();
			text="Group provides evidence AGAINST "+title;
			node.put("text", text);
			node.put("uncert","Confirmed");// for now we leave it like that!
			node.put("eval","N/A");
			node.put("input", "CLAIM");
			node.put("source", source);
			node.put("dtg", timex);
			node.put("commit","N/A");
			node.put("type", "I");
			node.put("nodeID", conID);
			ann=new HashMap();
			ann.put("conc", new HashMap());
			ann.put("prem_assump", new HashMap());
			node.put("annot", ann);
			nodes.add(node);
			ndprov.add(node);
			//edge  from conlink to root  
			HashMap edge=new HashMap();
			edge.put("toID", root);
			edge.put("fromID", conTop);
			edge.put("formEdgeID",null);
		    String idx=UUID.randomUUID().toString();
			edge.put("edgeID", idx);
			edges.add(edge);
			//edge  from conId to conlink  
			edge=new HashMap();
			edge.put("toID", conTop);
			edge.put("fromID", conID);
			edge.put("formEdgeID",null);
		    idx=UUID.randomUUID().toString();
			edge.put("edgeID", idx);
			edges.add(edge);
			
			
		 
	  if(!sPro.isEmpty()){
			//then build a con link against the not t  
			
		  node=new HashMap();
		  node=new HashMap();
		  node.put("text", "Con");
		  node.put("dtg", timex);
		  String cid=UUID.randomUUID().toString();
		  node.put("nodeID", cid);
		  node.put("type", "CA");
		  node.put("source", source);
		  ann=new HashMap();
		  ann.put("cq_ans_node_id", null);
		  ann.put("cq_id", null);
		  node.put("annot", ann);
		  nodes.add(node);
			  
		  edge=new HashMap();
		  edge.put("toID", cid);
		  edge.put("fromID", proID);
		  edge.put("formEdgeID",null);
		  idx=UUID.randomUUID().toString();
		  edge.put("edgeID", idx);
		  edges.add(edge);
		  edge=new HashMap();
		  edge.put("toID", conID);
		  edge.put("fromID", cid);
		  edge.put("formEdgeID",null);
		  idx=UUID.randomUUID().toString();
		  edge.put("edgeID", idx);
		  edges.add(edge);
		  
				
		Iterator itt=sPro.iterator();
		String tid;
		while(itt.hasNext()){
			tid=(String) itt.next();
			
			//now first part of the pro link!!
			//{"text":"Pro","dtg":"2015/03/02 15:37:22","annot":{"id":"N/A"},"nodeID":"290d5acc-1221-4603-9642-af43c993b433","source":"Joe","type":"RA"}
			node=new HashMap();
		    node.put("text", "Pro");
		    node.put("dtg", timex);
		    String idprox=UUID.randomUUID().toString();
		    node.put("nodeID", idprox);
		    node.put("type", "RA");
		    node.put("source", source);
		    ann=new HashMap();
		    ann.put("id", "N/A");
		    node.put("annot", ann);
		    nodes.add(node);
			
		    //2 edges
			edge=new HashMap();
			edge.put("toID", idprox);
			edge.put("fromID", tid);
			edge.put("formEdgeID",null);
		    idx=UUID.randomUUID().toString();
			edge.put("edgeID", idx);
			edges.add(edge);
			edge=new HashMap();
			edge.put("toID", proID);
			edge.put("fromID",idprox);
			edge.put("formEdgeID",null);
		    idx=UUID.randomUUID().toString();
			edge.put("edgeID", idx);
			edges.add(edge);
		}
		}
		
		if(!sCon.isEmpty()){
			//build the other con link!!! 
			//{"text":"Con","dtg":"2015/03/02 15:37:14","annot":{"cq_ans_node_id":null,"cq_id":null},"nodeID":"964ea8ec-c748-400c-9de5-21fbc0570724","source":"Joe","type":"CA"}
			  node=new HashMap();
			  node=new HashMap();
			  node.put("text", "Con");
			  node.put("dtg", timex);
			  String cid=UUID.randomUUID().toString();
			  node.put("nodeID", cid);
			  node.put("type", "CA");
			  node.put("source", source);
			  ann=new HashMap();
			  ann.put("cq_ans_node_id", null);
			  ann.put("cq_id", null);
			  node.put("annot", ann);
			  nodes.add(node);
				  
			  edge=new HashMap();
			  edge.put("toID", cid);
			  edge.put("fromID", conID);
			  edge.put("formEdgeID",null);
			  idx=UUID.randomUUID().toString();
			  edge.put("edgeID", idx);
			  edges.add(edge);
			  edge=new HashMap();
			  edge.put("toID", proID);
			  edge.put("fromID", cid);
			  edge.put("formEdgeID",null);
			  idx=UUID.randomUUID().toString();
			  edge.put("edgeID", idx);
			  edges.add(edge);
				
		Iterator itt=sCon.iterator();
		String tid;
		while(itt.hasNext()){
			tid=(String) itt.next();
			//now first part of the pro link!!
			//{"text":"Pro","dtg":"2015/03/02 15:37:22","annot":{"id":"N/A"},"nodeID":"290d5acc-1221-4603-9642-af43c993b433","source":"Joe","type":"RA"}
			node=new HashMap();
		    node.put("text", "Pro");
		    node.put("dtg", timex);
		    String idprox=UUID.randomUUID().toString();
		    node.put("nodeID", idprox);
		    node.put("type", "RA");
		    node.put("source", source);
		    ann=new HashMap();
		    ann.put("id", "N/A");
		    node.put("annot", ann);
		    nodes.add(node);
			
		    //2 edges
			edge=new HashMap();
			edge.put("toID", idprox);
			edge.put("fromID", tid);
			edge.put("formEdgeID",null);
		    idx=UUID.randomUUID().toString();
			edge.put("edgeID", idx);
			edges.add(edge);
			edge=new HashMap();
			edge.put("toID", conID);
			edge.put("fromID",idprox);
			edge.put("formEdgeID",null);
		    idx=UUID.randomUUID().toString();
			edge.put("edgeID", idx);
			edges.add(edge);
		}
		}
		
		}
		
		
		HashMap results=new HashMap();
		results.put("nodes", nodes);
		results.put("edges", edges);
		results.put("root",root);
		results.put("prov", addProvenance(timex));
		
		
		return results;
	}
	
	


	private HashMap addProvenance(String timex) {
		 //create a default model up to the results!
		String ers="CISpaces_ERS_Service";
		String hdc="CISpaces_HDC_Service";
		String cus="CISpaces_of_"+user;
		CSProvBuild csprov=new CSProvBuild(ers,hdc,cus);
	
		csprov.addNewAnalysis();
		csprov.createCSProvDefault(nodeID,user,title,formID,des,crowdloc,locations,createTime,lastTime,timestamp);
		csprov.addNodes(ndprov,timex,user,formID);
		HashMap provmap=csprov.getSerialisedCSProv();
		return provmap;
		
		
		
	}
}
