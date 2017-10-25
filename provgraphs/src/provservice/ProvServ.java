
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
 * @since 		October 2014           
 *   
 */


package provservice;

 



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;









import java.util.UUID;

import com.google.gson.internal.LinkedTreeMap;

import plots.ProvServiceHelper;
 
import visual.SGraph;

public class ProvServ {

	private  ProvQuery pvq;
	private String path;
	private JsonHelper jsh;
	private ProvServiceHelper psh;

 

	public ProvServ(String pt,String port, String host) {
		 
		 pvq=new ProvQuery();
		 path=pt;
		 jsh=new JsonHelper();
		 psh=new ProvServiceHelper(port,host);
	
	}
	
	 
	public String printProvNode(String user,String nodeID, Boolean obf) {
		//call the service settle the provenance information in
		
		HashMap map=new HashMap();
		map.put("user", user);
		map.put("obf", obf);
		map.put("nodeID", nodeID);
		//first settle the user/wboxid problem:
		//for updates I need username (individual) and wboxid (chatname if connected)
		//user remains user
	 
		map.put("action","getnode");
		String json=jsh.convertInputJson(map);
		String output=psh.ConnectToEvaluate(json);	
		//System.out.println(output);
		HashMap result=jsh.convertInputMap(output);
		if(result.containsKey("response")){
			String resp=(String) result.get("response");
			if(resp.equals("fail")){
				return "fail";
			}
		}
		LinkedTreeMap provtree=(LinkedTreeMap) result.get("prov");
		String provstring= jsh.convertInputJson(provtree);
		pvq.getAndSetModel(provstring);
		//pvq.print();
		//then Print it!!!!
		return printGraphProvNode(nodeID);//wbox is always the one I need!!!!
	}
	
	 

	 


	public String printGraphProvNode(String nodeID) {
		
			SGraph sgv = new SGraph("Provenance of node "+nodeID,path); //A graph is needed
			ArrayList nodes=new ArrayList();
			
			if(pvq.existsNode(nodeID)){
		
		/* FROM HERE GRAPH!!!!!!!! */
			//in this case I query all the nodes that are in the prov chain and then display them!!!
			ArrayList provchNds=pvq.getProvChainNodes(nodeID); //LIST OF URIS
	 	System.out.println(provchNds.toString());
			//now I get an array of arrays that have Resources/type
			ArrayList res;
			String tlabel,label,type;
			Iterator iter=provchNds.iterator();
			 
			//create all nodes
			while(iter.hasNext()){
				res=(ArrayList) iter.next();
				tlabel=(String) res.get(0);
				label=tlabel.replace(NS.URICISP,"");
				type=(String)res.get(1);
				type=type.replace(NS.PROV,"");
			//	System.out.println(label+":"+type);
				if(type.equals("Entity")){
					if(label.startsWith("Node")){
						sgv.addNode(label);
						nodes.add(label);
						 //get and set node labels
						String info=pvq.getNodeLab(label);
						if(info!=null){
							sgv.addNodeLab(label,info); 
						}
					}
					else{
						sgv.addEntity(label);
						nodes.add(label);
					}
					 //get and set primary sources
					
					if(pvq.getPrimarySources(label)){
						 sgv.addPrimS(label); 
					 }
					
					//get and set goals
					
					if(pvq.getGoals(label)){
						 sgv.addGoals(label);
					 }
					
				}else if(type.equals("Agent")){
						sgv.addActor(label);
						nodes.add(label);
				}else if(type.equals("Activity")){
						sgv.addActivity(label);
						nodes.add(label);
					}
			 
				}
			//create all edges
			iter=nodes.iterator();
			String nd1,nd2;
		 
			Iterator itt;
			ArrayList edges;
		 	while(iter.hasNext()){
				nd1=(String) iter.next();
				//now I need to find each relationship for each node
				edges=pvq.getRelations(NS.URICISP+nd1);
				itt=edges.iterator();
				while(itt.hasNext()){
					nd2=(String) itt.next();
					nd2=nd2.replace(NS.URICISP,"");
					switch(sgv.getType(nd1)){
					/*
					 * 0:none
					 * 2:actors
					 * 3:activities
					 * 1:entities
					 */
					
					
					 case 1:
						   switch(sgv.getType(nd2)){
						   		case 1:
						   			sgv.addEdge(nd1, nd2, "wasDerivedFrom");
						   			   break;
						   		case 2:
						   			sgv.addEdge(nd1, nd2, "wasAttributedTo");
						   			   break;
						   		case 3:
						   			sgv.addEdge(nd1, nd2, "wasGeneratedBy");
						   			String time=pvq.getTimeLab(nd1,nd2);
									if(time!=null){
										sgv.addTimeAttEdge(nd1, nd2, time);
									}
						   			   break;
						   }     
						   break;
					 case 2:
						   switch(sgv.getType(nd2)){
						   		case 1:
						   			   break;
						   		case 2:
						   			sgv.addEdge(nd1, nd2, "actedOnBehalf");
						   			   break;
						   		case 3:
						   			   break;
						   } 
						   break;
					 case 3:
						   switch(sgv.getType(nd2)){
						   		case 1:
						   			sgv.addEdge(nd1, nd2, "used");
						   			   break;
						   		case 2:
						   			sgv.addEdge(nd1, nd2, "wasAssociatedWith");
						   			   break;
						   		case 3:
						   			sgv.addEdge(nd1, nd2, "wasInformedBy");
						   			   break;
						   } 
						   break;
					
					 }
				 
				 
				}
				
				
			}	
		 
	 sgv.setLayout("Node"+nodeID);
	 
			}
	 String pid=UUID.randomUUID().toString();
	 sgv.printImage(true,pid);
		
	 return pid;
	}
	
	
	

	 




	

}
