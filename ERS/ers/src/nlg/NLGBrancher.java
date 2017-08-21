package nlg;

 

import com.google.gson.internal.LinkedTreeMap;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class NLGBrancher {
	
	public NLGBrancher() {
		
	}
	
	
 	public HashMap branchNLGgraph(LinkedTreeMap mgraph, HashMap resp, DefaultDirectedGraph<String, DefaultEdge> graph) {
	/*here structure	 
	 * "chunks": {
	    "chunk-1": {‘nodes’:…, ‘edges’:…}
	    "chunk-2": {‘nodes’:…, ‘edges’:…}
	  },
	*/
		//dummy call
 		System.out.println(resp);
 		if(resp.containsKey("colors")){
 			HashMap colors=(HashMap) resp.get("colors");
 			HashSet<String> setin=new HashSet<String>();
 			HashSet<String> setout=new HashSet<String>();
 			HashSet<String> setund=new HashSet<String>();
 			if(colors.containsKey("Skeptical Opt-0")){
 				HashMap skep=(HashMap)colors.get("Skeptical Opt-0");
 				Iterator itt=skep.keySet().iterator();
 				while(itt.hasNext()){
 					String key=(String) itt.next();
 					String value=(String) skep.get(key);
 					if(value.equals("X")){
 						setout.add(key);
 					}else if(value.equals("V")){
 						setin.add(key);
 					}else{
 						setund.add(key);
 					}
 				}
 				
 				HashMap map=new HashMap();
 				map.put("chunck-1",getGraph(setout,mgraph,graph));
 				map.put("chunck-2",getGraph(setin,mgraph,graph));
 				map.put("chunck-3",getGraph(setund,mgraph,graph));
 				return map;
 				
 				
 				
 				
 				
 				
 			}
 			
 		} 
 		
 		
 		
 		
 		
 		
 		
		HashMap map=new HashMap();
		map.put("chunck-1",mgraph);
		return map;
	}


	private HashMap getGraph(HashSet<String> set, LinkedTreeMap mgraph,DefaultDirectedGraph<String, DefaultEdge> graph) {
		ArrayList nodes=new ArrayList();
		ArrayList edges=new ArrayList();
		ArrayList totnodes=(ArrayList) mgraph.get("nodes");
		ArrayList totedges=(ArrayList) mgraph.get("edges");
		HashMap<String,LinkedTreeMap> tnodes=new HashMap<String,LinkedTreeMap>();
		HashMap<String,HashSet<LinkedTreeMap>> tedges=new HashMap<String,HashSet<LinkedTreeMap>>();
		//transform into map
		Iterator itn=totnodes.iterator();
		while(itn.hasNext()){
			LinkedTreeMap map=(LinkedTreeMap) itn.next();
			tnodes.put((String)map.get("nodeID"), map);
		}
		itn=totedges.iterator();
		while(itn.hasNext()){
			LinkedTreeMap map=(LinkedTreeMap) itn.next();
			HashSet<LinkedTreeMap> setx=new HashSet<LinkedTreeMap>();
			if(tedges.containsKey(map.get("target"))){
				setx= tedges.get(map.get("target"));
			}
			setx.add(map);
			tedges.put((String)map.get("target"), setx);
		}
		
		System.out.println(graph.vertexSet());
	
		for(String node:set){
			System.out.println(node);
			Set<DefaultEdge> edgs=graph.incomingEdgesOf(node);
			nodes.add(tnodes.get(node));
			for(DefaultEdge edge:edgs){
				String prond=graph.getEdgeSource(edge);
				Set<DefaultEdge> peds=graph.incomingEdgesOf(prond);
				HashSet<String> prems=new HashSet<String>();
				for(DefaultEdge premed:peds){
					String prem=graph.getEdgeSource(premed);
					prems.add(prem);
				}
				if(set.containsAll(prems)){
					//then to be added!!!!//but they will be added anyway so avoid 
					nodes.add(tnodes.get(prond));
					//now edges
					
					//from pro node
					HashSet<LinkedTreeMap> tree=tedges.get(node);
					for(LinkedTreeMap mtree:tree){
						if(((String)mtree.get("source")).equals(prond)){
						 edges.add(mtree);
						}
					}
					//to pro node
					tree=tedges.get(prond);
					for(LinkedTreeMap mtree:tree){
						if(prems.contains((String)mtree.get("source"))){
							edges.add(mtree);
						}
					}
					
					
					
					
				}
				
			}
			
			
			 
		}
		
		
		
		
		
		
		
		
		
		HashMap mx=new HashMap();
		mx.put("nodes", nodes);
		mx.put("edges", edges);
		return mx;
	}
}
