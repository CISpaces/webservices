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
 * @since 		November 2014           
 *   
 */



package askpapipref;
 
import java.util.HashSet;

import java.util.Set;


import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;



import java.util.ArrayList;

 
public class AFRAengine implements AFengine{
 
private  ArrayList<String> args;
private  ArrayList<String[]> atks;
private  ArrayList<String> AFargs;
private  ArrayList<String[]> AFatks;
private DefaultDirectedGraph<String, DefaultEdge> graph;
private  ArrayList<String[]> attonatt;
private ArrayList<String> extra;
private int count;
private DAFengine dunaf;

	public AFRAengine(ArrayList<String> ags, ArrayList<String[]> aks, ArrayList<String[]> atoat) {
		count=0;
		AFargs=new ArrayList<String>();
		AFatks=new ArrayList<String[]>();
		args=ags;
		atks=aks;
		attonatt=atoat;
		graph=new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		extra=new ArrayList<String>();
		//args is a list of arguments 
		// and two-element String-arrays ([attacker, attacked]) or ([attacker, attacker,attacked])
		
	}
   
	
	public HashSet<HashSet<String>> evaluatePreferred(){
		AFargs.addAll(args);
		//now build attacks on the attacks!
		HashSet<String> aton=buildAttackOnAttacks();
		//now build graph
		buildGraph(aton);
		 //then convert with no attacks on the attacks
		convertSimple();
		AFargs.addAll(extra);
		//then prepare attacks
		addAttacks();
		//then evaluate
	/*	for(String[] co:AFatks){
			System.out.println(co[0]+"->"+co[1]);
		}
		System.out.println(AFatks.size());*/
		//then remove all extra arguments
		HashSet<HashSet<String>> exts=evaluateAFRAPreferred();
		
		return prepareExts(exts);
	}


private HashSet<HashSet<String>> prepareExts(HashSet<HashSet<String>> exts) {
		HashSet<HashSet<String>> newexts=new HashSet<HashSet<String>>();
		for(HashSet<String> ext:exts){
			ext.removeAll(extra);
			newexts.add(ext);
		}
		return newexts;
	}


private void addAttacks() {
		Set<DefaultEdge> edges=graph.edgeSet();
		String attacker,attacked;
		String[] atk;
		for(DefaultEdge edge:edges){
			attacker=graph.getEdgeSource(edge);
			attacked=graph.getEdgeTarget(edge);
			atk=new String[]{attacker,attacked};
			AFatks.add(atk);
		}
	}


private HashSet<String> buildAttackOnAttacks() {
	HashSet<String> aton=new HashSet<String>();
	String id1,id2;
	 for(String[] atk:attonatt){
		 //triple!
		 graph.addVertex(atk[0]);
		 graph.addVertex(atk[1]);
		 graph.addVertex(atk[2]);
		 id1="g"+count++;
		 graph.addVertex(id1);
		 id2="g"+count++;
		 graph.addVertex(id2);
		 graph.addEdge(atk[1], id1);
		 graph.addEdge(id1, atk[2]);
		 graph.addEdge(id2, id1);
		 graph.addEdge(atk[0], id2);
		 aton.add(atk[1]+atk[2]);
		 extra.add(id1);
		 extra.add(id2);
	 }
	//  System.out.println(extra);
		return aton;
	}





private void convertSimple() {
		//here the edges are already named
		 Set<DefaultEdge> removals=new HashSet<DefaultEdge>();
		 Set<String> additions=new HashSet<String>();
		 Set<DefaultEdge> in,inin;
		 String arg,source;
		 for(String node:extra){
			 in=graph.incomingEdgesOf(node);
			 if(!in.isEmpty()){
				for(DefaultEdge edge:in){
					if(!removals.contains(edge)){
						arg=graph.getEdgeSource(edge);
						if(!extra.contains(arg)){
						//then it is an argument
						//remove the link
							removals.add(edge);
							inin=graph.incomingEdgesOf(arg);
							for(DefaultEdge atk:inin){
								source=graph.getEdgeSource(atk);
								additions.add(source+":"+node);
						}
						}
					}
					}
				
				 
			 }
			 
		 }
		 graph.removeAllEdges(removals);
		 String[] couple;
		 for(String add:additions){
			 couple=add.split(":");
			 graph.addEdge(couple[0], couple[1]);
		 }
		 
		 
		
	}


private void buildGraph(HashSet<String> aton) {
		String id;
		 
		for(String[] tuple:atks){
			if(!aton.contains(tuple[0]+tuple[1])){
				graph.addVertex(tuple[0]);
				id="g"+count++;
				graph.addVertex(tuple[1]);
				graph.addVertex(id);
				graph.addEdge(tuple[0], id);
				graph.addEdge(id,tuple[1]);
				extra.add(id);
			}
		}
	//	System.out.println(extra);
	}





private HashSet<HashSet<String>> evaluateAFRAPreferred() {
		long startTime = System.currentTimeMillis();
		dunaf=new DAFengine(AFargs,AFatks);
		HashSet<HashSet<String>> pippo=dunaf.evaluatePreferred();
		/*	Iterator iter=pippo.iterator();
		System.out.println("\n\n*** Your preferred extensions are:");
		Iterator it;
		while(iter.hasNext()){
			it=((HashSet<String>) iter.next()).iterator();
			while(it.hasNext())
			System.out.print(" "+it.next());
			System.out.println(" and ");
		}*/
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
	//	System.out.println(totalTime);
		return pippo;
	}
	
 
}
