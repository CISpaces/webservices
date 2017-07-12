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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.gson.internal.LinkedTreeMap;
import com.hp.hpl.jena.rdf.model.Model;

import data.Rationale;
import utils.TimeExtender;

public class MoiraNodeBuilder {

	
	
	
	
	
	private ArrayList nodes;
	private ArrayList edges;
	private String prov;
	private HashMap mapnodes;
	private MoiraProvBuild mprov;
	private String moira_name;
	private ArrayList<String> ndprov;
	private DefaultDirectedGraph<String, DefaultEdge> graph;
	private HashMap<String, String> nodeids;
	
	public MoiraNodeBuilder(String moira) {
		nodes=new ArrayList();
		edges=new ArrayList();
		moira_name=moira;
		mapnodes=new HashMap();
	    mprov=new MoiraProvBuild(moira);
	    graph=new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
	    nodeids=new HashMap<String,String>();
	    ndprov=new ArrayList<String>();
	}

	public void createNode(String note,String text,String source, String dtg, String nodeid){
		HashMap node=new HashMap();
	    node.put("text", text);
	    node.put("uncert","Confirmed");// for now we leave it like that!
	    node.put("eval","N/A");
	    node.put("input", note);
	    node.put("source", source);
	    node.put("dtg", dtg);
	    node.put("commit","N/A");
	    node.put("type", "I");
	    node.put("nodeID", nodeid);
	    HashMap ann=new HashMap();
	    ann.put("conc", new HashMap());
	    ann.put("prem_assump", new HashMap());
	    node.put("annot", ann);
	    nodes.add(node);
	    nodeids.put(text.replaceAll(" ", "").toLowerCase(), nodeid);
	    mapnodes.put(nodeid, node);
	    graph.addVertex(nodeid);
	}
	
	public String createPro(String source, String rule_name){
		String text="Pro";
		if(rule_name!=null){
			text+=" "+rule_name;
		}
		TimeExtender time=new TimeExtender();
		String timex=time.nowCIS();
		HashMap node=new HashMap();
	    node.put("text", text);
	    node.put("dtg", timex);
	    String idprox=UUID.randomUUID().toString();
	    node.put("nodeID", idprox);
	    node.put("type", "RA");
	    node.put("source", source);
	    HashMap ann=new HashMap();
	    ann.put("id", "N/A");
	    node.put("annot", ann);
	    nodes.add(node);
	   
	    return idprox;
	}

	public void createEdges(String query, String pid, String node) {
		 //from node to pid
		addEdge(node,pid);
		//from pid to query
		addEdge(pid,query);
	}
	
	private void addEdge(String fromid, String toid) {
		HashMap edge=new HashMap();
		edge.put("toID", toid);
		edge.put("fromID", fromid);
		edge.put("formEdgeID",null);
	    String idx=UUID.randomUUID().toString();
		edge.put("edgeID", idx);
		edges.add(edge);	
	}

	public HashMap getCispData() {
		HashMap results=new HashMap();
		HashMap prov=mprov.getSerialisedMProv();
		results.put("prov",prov);
		results.put("nodes", nodes);
		results.put("edges",edges);
		return results;
	}

	public void setProvenance(String node, Model model) {
		mprov.addNodesToAnalysis(node);
		mprov.setModelProv(model);
	}
	
	
	
	public void setProvAnalysis(String user){
		ArrayList uss=new ArrayList();
		uss.add(user);
		uss.add(moira_name);
		mprov.addNewAnalysis(uss);
	}
	private void createProvenance(String top_prov) {
		 mprov.repeatPattern(top_prov,ndprov,mapnodes);
		
	}
	public void addRationale(Rationale[] rar, String text, String top_prov, String source, String dtg) {
		for(Rationale rule:rar){
			Iterator iter=rule.conclusions.iterator();
			String conc;
			while(iter.hasNext()){
				conc=(String) iter.next();
				createNewRule(rule.rule_name,rule.premises,conc, source, dtg);
				
			}
		} 
		String rootID=searchRootandLeaves();
		createProvenance(top_prov);
 
	}
	
	

	private String searchRootandLeaves() {
		 //look for root and leaves 
		 //set leaves as infonodes
		 //root id for new link
		ArrayList<String> roots=new ArrayList<String>();
		Set<String> set=graph.vertexSet();
		Set in,out;
		for(String node:set){
			in=graph.incomingEdgesOf(node);
			out=graph.outgoingEdgesOf(node);
			if(in.isEmpty()){
				//leaf
			//	System.out.println(node);
				HashMap nd=(HashMap) mapnodes.get(node);
				 nd.put("input", "INFO");
			}
			if(out.isEmpty()){
				//root
				roots.add(node);
			}
		}
		return roots.get(0);
	}
	
	private void createNewRule(String rule_name, ArrayList prems, String conc, String source, String dtg) {
		//	System.out.println("how many");
			String proid=createPro(moira_name,rule_name);
			 graph.addVertex(proid);
			String nodeid;
			String search=conc;
		//	System.out.println(":"+search+":"+nodeids);
			if(nodeids.containsKey(search.replaceAll(" ","").toLowerCase())){
				nodeid=nodeids.get(search.replaceAll(" ","").toLowerCase());
			}else{
				nodeid=UUID.randomUUID().toString();
				createNode("CLAIM",conc,source,dtg,nodeid);
				
				ndprov.add(nodeid);
			}
		//	System.out.println("DEC"+nodeid);
			addEdge(proid,nodeid);
			graph.addEdge(proid,nodeid);
			
		//	String nodeid=UUID.randomUUID().toString();
			Iterator itp=prems.iterator();
			while(itp.hasNext()){
				String prem=(String) itp.next();
				//System.out.println("looking for "+prem);
				search=prem;
				//System.out.println(":"+search+":"+nodeids);
				if(nodeids.containsKey(search.replaceAll(" ","").toLowerCase())){
					//System.out.println("it is there");
					nodeid=nodeids.get(search.replaceAll(" ","").toLowerCase());
				}else{
					//System.out.println("it is not there");
					nodeid=UUID.randomUUID().toString();
					createNode("CLAIM",search,source,dtg,nodeid);
				 
					ndprov.add(nodeid);
				}
			//	System.out.println("DEC"+nodeid);
				//System.out.println(map);
				 addEdge(nodeid,proid);
				 graph.addEdge(nodeid,proid);
			}
			
		}


 
		
	
}
