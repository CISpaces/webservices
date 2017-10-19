package provncontrol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.joda.time.DateTime;

import com.google.gson.internal.LinkedTreeMap;

import database.DBNQuery;
import provncontrol.pdatastr.LabelConstructor;
import provncontrol.pdatastr.Ppath;
import provscontrol.RDFSQuery;
import utils.NS;
import utils.TimeHelper;


public class RDFNQuery extends RDFSQuery{

	private DBNQuery dbn;

	public RDFNQuery(String ps){
		super(ps);
		  dbn = new DBNQuery(ps);
	}

	public ArrayList getProvPaths(Boolean obf, String nodeID, String user) {
			//System.out.println("got here");
			Model model=loadModel(nodeID);
			//obfuscate if needed
			
			 if(obf){ 
				 model=obtor.getModelNodes(model, user);
		 
		}
			//now build a number of paths over that pattern
			// model.write(System.out,"N-TRIPLES");
			ArrayList array=dbn.getPaths(nodeID,user);
			if(array.isEmpty()){
				JDBPaths path=new JDBPaths(rdc);
				path.setRoot(nodeID,model);
				HashMap paths=path.queryPaths(model);
			//	System.out.println("PATHS"+paths);
				//now insert paths
				Iterator itt=paths.keySet().iterator();
				String key;
				Ppath pgg;
				while(itt.hasNext()){
					key=(String) itt.next();
					pgg=(Ppath) paths.get(key);
					pgg.setForExport();
					dbn.insertPaths(user, nodeID, pgg.getId(), pgg.getTitle(), pgg.getHint(), pgg.getPrem1(), pgg.getPrem2(),   pgg.getArg());
				}
			} 
			
			ArrayList result=dbn.getInfoPathUnused(user, nodeID);
		//	System.out.println(result);
			return result;
	}

	public HashMap getProvNodePath(String user,String nodeID, String pathID) {
			String[] str=dbn.getppc(user, nodeID, pathID);
			NodeBuilder ndbuild=new NodeBuilder(this);
			HashMap results=new HashMap();
			//System.out.println(str);
			if(str!=null){
			  results=ndbuild.buildNodesPaths(str,nodeID);
			ArrayList nodeIN=(ArrayList) results.get("nodes");
			addprovPaths(nodeIN,user);
			}else{
				results.put("response", "fail");
			}
			return results;
	}
	
	public void addprovPaths(ArrayList nodesIN,   String user ) {
		//	System.out.println("here"+nodesIN+nodesSH);
			  Iterator itt=nodesIN.iterator();
				 
			 while(itt.hasNext()){
				 HashMap map=(HashMap) itt.next();
				 String text=(String) map.get("text");
				 String txt=text.replaceAll("\n", "");
				 if(txt.startsWith("Info - ")){
					 dbn.addPExists(text,user);
				 }
			 }
		 
			
		}


	public Object[] getTimeDistance(String node, String user) {
		//time 
		//check all the generation activities and find the most recent (skip CISP access)
		TimeHelper th=new TimeHelper();
		Model model=loadModel(user);
		 
	//	System.out.println("NoDE"+node);
	//	model.write(System.out,"N-TRIPLES");
		
		String query=NS.PREFIXES+  
				 " SELECT DISTINCT ?act ?time WHERE { "
				  + "?act a prov:Activity."
				  + "?nd prov:wasGeneratedBy ?act." 
				  + "?nd prov:qualifiedGeneration ?x." 
				  + "?x prov:atTime ?time."  
				 + "}";
		ArrayList list=rdc.executeQLMany(query,model);
		
		Iterator iter=list.iterator();
		DateTime rec=th.parseDateCIS("1900-01-06T07:15:44Z");
		while(iter.hasNext()){
			ArrayList litem=(ArrayList) iter.next();
		//	System.out.println(litem);
			String time=((String) litem.get(1));
			String act=((String) litem.get(0)).replaceAll(NS.URICISP,"");
			if(!act.startsWith("CISpAccess")){
				DateTime it=th.parseDateCIS(time);
				if(it.isAfter(rec)){
					rec=it;
				}
			}
		}
		//System.out.println(rec.toString());
		//ok!!!!
		//distance

		String qpath="prov:wasDerivedFrom*|(prov:wasGeneratedBy/prov:used)*";
		query=NS.PREFIXES+  
				 " SELECT DISTINCT ?ps WHERE { "
				  + "?x cisp:nodeID \""+node+"\"^^xsd:string."
				  + "?x "+qpath+" ?ps."
				  + "?ps prov:type prov:PrimarySource."
				 		+ "}";
		ArrayList array1=rdc.executeQLSingle(query, model);
		if(array1.size()==0){
			//then need to find the furthest away entities
			query=NS.PREFIXES+  
					 " SELECT DISTINCT ?ps WHERE { "
					  + "?x cisp:nodeID \""+node+"\"^^xsd:string."
					  + "?x "+qpath+" ?ps."
					  + "?ps a prov:Entity."
					 		+ "}";
			array1=rdc.executeQLSingle(query, model);
		}
	//	System.out.println(array1);
		int dist=constructGraph(model,array1,node);
		//System.out.println(dist);
		return new Object[]{rec,dist};
	}

	public Model getAllNodesAnalysis(boolean obf,ArrayList nodes,String user) {
		 Model modret=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		 modret.setNsPrefix("foaf", NS.FOAF);
		 modret.setNsPrefix("cisp", NS.CISP);
		 modret.setNsPrefix("prov", NS.PROV);
		 modret.setNsPrefix("rdf", NS.RDF);
		Iterator iter=nodes.iterator();
		while(iter.hasNext()){
			LinkedTreeMap map=(LinkedTreeMap)iter.next();
			String nodeID=(String) map.get("nodeID");
			Model model=loadModel(nodeID);
			 if(obf){ 
				 model=obtor.getModelNodes(model, user);
			 }
			 modret.add(model); 
		 }
		return modret;
	}

	public HashSet<String> getAllActors(Model model, String user) {
		//	 model.write(System.out,"N-TRIPLES");
			String query=NS.PREFIXES+  
					 " SELECT DISTINCT ?actor WHERE { "
					  + "?actor a prov:Agent."
					  + "?act prov:wasAssociatedWith ?actor."
					 + "}";
			ArrayList nsacts=rdc.executeQLSingle(query,model);
			//System.out.println(nsacts);
			query=NS.PREFIXES+  
					 " SELECT DISTINCT ?act WHERE { "
					  + "?act a prov:Activity."
					  + "<"+NS.URICISP+user+"> a prov:Agent."
					  +"?act prov:wasAssociatedWith <"+NS.URICISP+user+">."
					   + " FILTER NOT EXISTS {   " 
						 + "?an cisp:analysisID ?anid." 
						 + "?an prov:wasGeneratedBy ?act."// + "?x cisp:nodeID \'\'."
						 + " }"
					 + "}";
			ArrayList nsprocs=rdc.executeQLSingle(query,model);
			boolean test=false;
				Iterator itt=nsprocs.iterator();
				while(itt.hasNext()){
					String proc=(String) itt.next();
					if(!proc.startsWith(NS.URICISP+"CISpAccess")){
						test=true;
					}
				}
			if(!test){
				nsacts.remove(NS.URICISP+user);
			}
			itt=nsacts.iterator();
			HashSet<String> set=new HashSet<String>();
			while(itt.hasNext()){
				String act=(String) itt.next();
				act=act.replaceAll(NS.URICISP, "");
				if(!act.equals("CISpaces_Prov_Service") && !act.equals("CISpaces_Pref_Service"))
				set.add(act);
			}
			
			return set;
		}



		public HashSet<String> getAllProcesses(Model model) {
		//	model.write(System.out,"N-TRIPLES");
			String query=NS.PREFIXES+  
					 " SELECT DISTINCT ?process WHERE { "
					  + "?process a prov:Activity."
					  + " FILTER NOT EXISTS {   " 
						 + "?an cisp:analysisID ?anid." 
						 + "?an prov:wasGeneratedBy ?process."// + "?x cisp:nodeID \'\'."
						 + " }"
					 + "}";
			ArrayList procs=new ArrayList();
			ArrayList nsprocs=rdc.executeQLSingle(query,model);
	//	 System.out.println(nsprocs);
				Iterator itt=nsprocs.iterator();
				while(itt.hasNext()){
					String proc=(String) itt.next();
					if(proc.startsWith(NS.URICISP+"CISpAccess")){
						procs.add(proc);
					}
				}
				
		   
			nsprocs.removeAll(procs);
			itt=nsprocs.iterator();
			HashSet<String> set=new HashSet<String>();
			while(itt.hasNext()){
				String act=(String) itt.next();
				act=act.replaceAll(NS.URICISP, "");
				act=LabelConstructor.getLabActivityRules(act);
				if(!act.contains("Analyse_Prov_Chain") && !act.contains("Analyse_Pref_Chain"))
				set.add(act);
			}
			
			// System.out.println(set);
			 return set;
		}

		private int constructGraph(Model model, ArrayList ent,String node) {
			DefaultDirectedGraph<String, DefaultEdge> graph=new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
			String nodex=NS.URICISP+"Node"+node;
			graph.addVertex(nodex);
			ent.add(nodex);
			//nodes
			String query=NS.PREFIXES+  
					 " SELECT DISTINCT ?ent WHERE { "
					  + "?ent a prov:Entity."
					 		+ "}";
			ArrayList array=rdc.executeQLSingle(query, model);
		//	model.write(System.out,"N-TRIPLES");
		//	System.out.println(array);
			Iterator iter=array.iterator();
			while(iter.hasNext()){
				String item=iter.next().toString();
				graph.addVertex(item);
			}
			query=NS.PREFIXES+  
					 " SELECT DISTINCT ?ent WHERE { "
					  + "?ent a prov:Activity."
					 		+ "}";
			array=rdc.executeQLSingle(query, model);
		//	System.out.println(array);
			iter=array.iterator();
			while(iter.hasNext()){
				String item=iter.next().toString();
				graph.addVertex(item);
			}
			//System.out.println("GRAPH"+graph.vertexSet());
			//edges
			query=NS.PREFIXES+  
					 " SELECT DISTINCT ?from ?to WHERE { "
					  + "?from prov:wasDerivedFrom|prov:wasGeneratedBy|prov:used ?to."
					 		+ "}";
			array=rdc.executeQLMany(query, model);
			iter=array.iterator();
			while(iter.hasNext()){
				ArrayList ati=(ArrayList) iter.next();
				String from=(String) ati.get(0);
				String to=(String) ati.get(1);
				graph.addEdge(from, to);
			}
			
			 
			 
			
		
			//now I have a graph!
			//find the longest among the shortest paths to primary sources
			double max=0;
			iter=ent.iterator();
			while(iter.hasNext()){
				String item=iter.next().toString();
				DijkstraShortestPath path =  new DijkstraShortestPath(graph, nodex, item);
				path.findPathBetween(graph, nodex, item);
				double out=path.getPathLength();
				if(out>max){
					max=out;
				}
			}
			int dis=(int) Math.round(max);
			return dis;
		}

	
}
