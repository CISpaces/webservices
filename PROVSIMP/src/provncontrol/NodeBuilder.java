
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
 * @version     2.0  
 * @since 		July 2017          
 *   
 */


package provncontrol;

 
 
import java.util.ArrayList;
import java.util.HashMap;
 
import java.util.Iterator;
import java.util.UUID;

import utils.PatternBuilder;
import utils.TimeHelper;

 
 

public class NodeBuilder {
	private ArrayList nodes;
	private ArrayList ndprov;
	private ArrayList edges;

 
	private TimeHelper time;
 
 
	private String root;
	private RDFNQuery conn;
	private String curanaly;
 
	
	
	
	public NodeBuilder(RDFNQuery rdf)  {
		 
		time=new TimeHelper();
		conn=rdf;
		nodes=new ArrayList();
		ndprov=new ArrayList();
		edges=new ArrayList();
		root=null;
	}



	public HashMap buildNodesPaths(String[] str,String nodeID) {
		root=nodeID;
		String p1ID=UUID.randomUUID().toString();
		String p2ID=UUID.randomUUID().toString();
		 
		String source="Prov_Analysis_Node_"+nodeID;//remember
		String timex=time.nowCIS();
		String idArgScheme=UUID.randomUUID().toString();
		//NODE 1
		HashMap node=new HashMap();
		    node.put("text", str[0]);
		    node.put("uncert","Confirmed");// for now we leave it like that!
		    node.put("eval","N/A");
		    node.put("input", "CLAIM");
		    //source and dtg with provenance
		    node.put("commit","N/A");
		    node.put("type", "I");
		    node.put("dtg", timex);
		    node.put("source", source);
		    node.put("nodeID", p1ID);
		    HashMap ann=new HashMap();
		    ann.put("conc", new HashMap());
		    HashMap scheme=new HashMap();
		    HashMap charact=new HashMap();
		    ArrayList prems=new ArrayList();
		    prems.add("PPV1");
		    charact.put("prem", prems);
		    charact.put("cqs", new ArrayList());
		    charact.put("id", "LPV");
		    charact.put("assump", new ArrayList());
		    scheme.put(idArgScheme, charact);
		    ann.put("prem_assump", scheme);
		    node.put("annot", ann);
		    nodes.add(node);
		    ndprov.add(node);
		  
		    //"annot":{"conc":{},"prem_assump":{"bf72a519-73b3-4b46-b2b2-44e2ecadc3ba":{"prem":["PCS2"],"cqs":[],"id":"LCS","assump":[]}}}},
		    
		    node=new HashMap();
		    node.put("text", str[1]);
		    node.put("uncert","Confirmed");// for now we leave it like that!
		    node.put("eval","N/A");
		    node.put("input", "CLAIM");
		    //source and dtg with provenance
		    node.put("commit","N/A");
		    node.put("type", "I");
		    node.put("dtg", timex);
		    node.put("source", source);
		    node.put("nodeID", p2ID);
		     ann=new HashMap();
		    ann.put("conc", new HashMap());
		      scheme=new HashMap();
		     charact=new HashMap();
		      prems=new ArrayList();
		    prems.add("PPV2");
		    charact.put("prem", prems);
		    charact.put("cqs", new ArrayList());
		    charact.put("id", "LPV");
		    charact.put("assump", new ArrayList());
		    scheme.put(idArgScheme, charact);
		    ann.put("prem_assump", scheme);
		    node.put("annot", ann);
		    nodes.add(node);
		    ndprov.add(node);
		    
		    
		    
		    node=new HashMap();
		    node.put("text", "LPV");
		    node.put("dtg", timex);
		    node.put("nodeID", idArgScheme);
		    node.put("type", "RA");
		    node.put("source", source);
		    ann=new HashMap();
		    ann.put("id", "LPV");
		    node.put("annot", ann);
		    nodes.add(node);

		 //3 edges!
		    //{"toID":"bf72a519-73b3-4b46-b2b2-44e2ecadc3ba","fromID":"f8e089f3-8d58-49c0-ac35-597f47ed06b1","formEdgeID":null,"edgeID":"f6db6d08-84cd-4536-a0d5-b94358d8f948"}
			HashMap edge=new HashMap();
			edge.put("toID", idArgScheme);
			edge.put("fromID", p1ID);
			edge.put("formEdgeID",null);
		    String idx=UUID.randomUUID().toString();
			edge.put("edgeID", idx);
			edges.add(edge);
			
			edge=new HashMap();
			edge.put("toID", idArgScheme);
			edge.put("fromID", p2ID);
			edge.put("formEdgeID",null);
		    idx=UUID.randomUUID().toString();
			edge.put("edgeID", idx);
			edges.add(edge);
			
			edge=new HashMap();
			edge.put("toID", nodeID);
			edge.put("fromID", idArgScheme);
			edge.put("formEdgeID",null);
		    idx=UUID.randomUUID().toString();
			edge.put("edgeID", idx);
			edges.add(edge);
			
	
			HashMap results=new HashMap();
			results.put("nodes", nodes);
			results.put("edges", edges);
			results.put("root",root);
			String provs="CISpaces_Prov_Service";
			addNodes(timex,source,provs);
			
			
			return results;
	}
	
  
 
	
	
	 
	 private void addNodes(String timex,String source,String provs) {
		
		timex=time.getDateCIS(timex); 
		//for each node 
		//create prov node 
		//and add the node to the analysis!!!!
		PatternBuilder prov = new PatternBuilder();
		HashMap node;
		ArrayList nodes=new ArrayList();
		Iterator iter=ndprov.iterator();
		while(iter.hasNext()){
			node=(HashMap) iter.next();
			String[] nodeID=new String[2];
			nodeID[0]=(String) node.get("nodeID");
			nodeID[1]=(String) node.get("text");
			nodes.add(nodeID[1]);
			prov.makeGenerationPattern(nodeID, source , "Analyse_Prov_Chain_"+UUID.randomUUID().toString(), provs, timex);
			conn.addNodeModel(prov.getModel(), nodeID[0]);
		}
		
	}
	 
 
 
	 
}
