package provncontrol;

 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import org.apache.jena.rdf.model.Model;

import provncontrol.pdatastr.Pgen;
import provncontrol.pdatastr.Pgoal;
import provncontrol.pdatastr.Pps;
import provscontrol.RDFConnect;
import utils.NS;

 

public class JDBPaths {
	private RDFConnect conn;
	private String root;
	private int tid;
	public JDBPaths(RDFConnect c) {
		conn=c;
	}
	public void setRoot(String id, Model model){
		root=checkNodes(NS.URICISP+"Node"+id, model);
		tid=1;
	}
	
	public HashMap queryPaths(Model model) {
		HashMap ptot=new HashMap();
		//first extract generation patterns
		//model.write(System.out,"N-TRIPLES");
		ptot=getPGenPatterns(model);
		HashMap pPSs=new HashMap();
		pPSs=getPrimSourcePatterns(model);
		ptot.putAll(pPSs);
		HashMap pGoals=new HashMap();
		pGoals=getGoalPatterns(model);
		ptot.putAll(pGoals);
		
		
		return ptot;
		
		//System.out.println(pGens.size()+""+pPSs.size()+""+pGoals.size());
		
		
	}



	private HashMap getGoalPatterns(Model model) {
		// TODO Auto-generated method stub
		HashMap pGls=new HashMap();
		String query=NS.PREFIXES+  
				 " SELECT DISTINCT ?p1 ?p2 ?a ?g WHERE { "
				  + "?p1 a prov:Activity."
				  + "?p2 a prov:Activity."
				  + "?a a prov:Entity."
				  + "?g a prov:Entity."
				  + "?p1 prov:wasInformedBy ?p2."
				  + "?p1 prov:used ?a."
				  + "?p2 prov:used ?g."
			  	  + "?a prov:wasGeneratedBy ?p2."
			  	  +  "?g prov:type cisp:Goal."
			  	  + "}";
		
		ArrayList array=conn.executeQLMany(query,model);
		// System.out.println(array);
		//?p1 ?p2 ?a ?g
		ArrayList res;
		Iterator iter=array.iterator();
		Pgoal pg;
		String x1,x2,x3,x4,x5;
		while(iter.hasNext()){
			res=(ArrayList) iter.next();
			//?p1 ?p2 ?a ?g
			x1=(String)res.get(0);
			x1=x1.replaceAll(NS.URICISP, "");
			x2=(String)res.get(1);
			x2=x2.replaceAll(NS.URICISP, "");
			x5=(String)res.get(2);
			x3=x5.replaceAll(NS.URICISP, "");
			x4=(String)res.get(3);
			x4=x4.replaceAll(NS.URICISP, "");
			if(pGls.containsKey(x1+x2)){
				pg=(Pgoal) pGls.get(x1+x2);
				 
			}else{
				String pid=UUID.randomUUID().toString();
				pg=new Pgoal(pid,x1,x2,x3,x4,root,tid);
				tid++;
				
			}	//seek for time
				query=NS.PREFIXES+  
						 " SELECT DISTINCT ?t WHERE { "
						 + "<"+x5+"> prov:qualifiedGeneration ?x."
						  + "?x prov:atTime ?t."
						  + "}";
				ArrayList out=conn.executeQLSingle(query, model);
				if(out.size()>0){
					pg.setTime((String) out.get(0));
				}
			
			
				pGls.put(x1+x2, pg);
			 
		}
	
		
 
		
		return pGls;
	}



	private HashMap getPrimSourcePatterns(Model model) {
		//<http://www.itacispaces.org/WaterSampleData> <http://www.w3.org/ns/prov#type> <http://www.w3.org/ns/prov#PrimarySource> .
		HashMap pSs=new HashMap();
		String query=NS.PREFIXES+  
				 " SELECT DISTINCT ?p WHERE { "
				  + "?a a prov:Entity."
				  + "?p a prov:Activity."
				  + "?a prov:type prov:PrimarySource."
				  + "?p prov:used ?a."
			  	  + "}";
		ArrayList array=conn.executeQLSingle(query,model);
		//System.out.println(array);
	 
		Iterator iter=array.iterator();
	
		String x1,x2,x3,x4,x5;
		Pps pg;
		while(iter.hasNext()){
			  
			x1=(String)iter.next();
			x2=x1.replaceAll(NS.URICISP, "");
			 
			if(pSs.containsKey(x2)){
				pg=(Pps) pSs.get(x2);
			
			}else{
				String pid=UUID.randomUUID().toString();
				pg=new Pps(x2,pid,root,tid);
				tid++;
				pSs.put(x2,pg);
			}
			 query=NS.PREFIXES+  
					 " SELECT DISTINCT ?ag WHERE { "
					 + "<"+x1+"> prov:wasAssociatedWith ?ag."
				  	  + "}";
			 ArrayList res=conn.executeQLSingle(query,model);
			 Iterator itt=res.iterator();
			 
			 while(itt.hasNext()){
				 x3=(String) itt.next();
				 x3=x3.replaceAll(NS.URICISP, "");
				 pg.addAgent(x3);
			 }
			 
			 query=NS.PREFIXES+  
					 " SELECT DISTINCT ?a WHERE { "
					 + "<"+x1+"> prov:used ?a."
					  + "?a prov:type prov:PrimarySource."
				  	  + "}";
			 res=conn.executeQLSingle(query,model);
			 itt=res.iterator();
			 
			 while(itt.hasNext()){
				 x3=(String) itt.next();
				 x3=x3.replaceAll(NS.URICISP, "");
				 pg.addEntity(x3);
			 }
 
			
		}
		
 
		
		return pSs;
	}


	private HashMap getPGenPatterns(Model model) {
		HashMap pGens=new HashMap();
		String query=NS.PREFIXES+  
				 " SELECT DISTINCT ?a1 ?a2 ?p WHERE { "
				  + "?a1 a prov:Entity."
				  + "?a2 a prov:Entity."
				  + "?p a prov:Activity."
			  	  + "?a1 prov:wasGeneratedBy ?p."
			 	  + "?a1 prov:wasDerivedFrom ?a2." 
			 	  + "?p prov:used ?a2."
			 	/*  + " FILTER NOT EXISTS {   " 
			 
			      +  "?p prov:wasInformedBy ?p1."
			      +  "?p1 prov:used ?x."
			      +	 "?x prov:type <http://www.itacispaces.org/ns#Goal>."
			 	 + "}"*/
				 + "}";
		ArrayList array=conn.executeQLMany(query,model);
	//  System.out.println(array.size());
		ArrayList res;
		Iterator iter=array.iterator();
		Pgen pg;
		String x0,x1,x2,x3,x4,x5;
		while(iter.hasNext()){
			res=(ArrayList) iter.next();
			//?a1 ?a2 ?p ?ag 
			x0=(String)res.get(0);//a1
			x1=checkNodes(x0,model);
			x1=x1.replaceAll(NS.URICISP, "");
			
			x2=(String)res.get(1);//a2
			x2=checkNodes(x2,model);
			x2=x2.replaceAll(NS.URICISP, "");
			x4=(String)res.get(2);//p
			x3=x4.replaceAll(NS.URICISP, "");
			if(!x3.contains("CISpAccess") && !x3.contains("Analyse_Prov_Chain") && !x3.contains("Analyse_Pref_Chain")){
				//then I do not want that!!!
				
			 
			if(pGens.containsKey(x1+x3)){
				pg=(Pgen) pGens.get(x1+x3);
				 
			}else{
				String pid=UUID.randomUUID().toString();
				pg=new Pgen(x1,x2,x3,root,pid,tid);
				tid++;
				
			}	//seek for time
				query=NS.PREFIXES+  
						 " SELECT DISTINCT ?t WHERE { "
						  + "<"+x0+"> prov:qualifiedGeneration ?x."
						  + "?x prov:atTime ?t."
						  + "}";
				ArrayList out=conn.executeQLSingle(query, model);
				if(out.size()>0){
					pg.setTime((String) out.get(0));
				}
				//seek for agents
				query=NS.PREFIXES+  
						 " SELECT DISTINCT ?ag WHERE { "
						 + "<"+x4+"> prov:wasAssociatedWith ?ag."
							  + "?ag a prov:Agent."
						  + "}";
				out=conn.executeQLSingle(query, model);
				if(out.size()>0){
					Iterator itt=out.iterator();
					while(itt.hasNext()){
						x5=(String)itt.next();
						x5=x5.replaceAll(NS.URICISP, "");
						pg.addAgent(x5);
					}
					
					
				}
				
				//seek for entities
				query=NS.PREFIXES+  
						 " SELECT DISTINCT ?a WHERE { "
						 + "<"+x4+"> prov:used ?a."
							  + "?a a prov:Entity."
						  + "}";
				out=conn.executeQLSingle(query, model);
				if(out.size()>0){
					Iterator itt=out.iterator();
					while(itt.hasNext()){
						x5=(String)itt.next();
						x5=checkNodes(x5,model);
						x5=x5.replaceAll(NS.URICISP, "");
						pg.addEntity(x5);
					}
					
					
				}
			//	System.out.println(x1+":"+x3);
				pGens.put(x1+x3,pg);
			}
		 
		}
		 	
		query=NS.PREFIXES+  
				 " SELECT DISTINCT ?a1 ?p WHERE { "
				  + "?a1 a prov:Entity."
				  + "?p a prov:Activity."
			  	  + "?a1 prov:wasGeneratedBy ?p."
			 	  + " FILTER NOT EXISTS {   " 
			 	  + "?a2 a prov:Entity. "
			 	  + "?a1 prov:wasDerivedFrom ?a2."
			  	  + "?p prov:used ?a2."
			  	 + "}"
 
			 
			       + " FILTER NOT EXISTS {   " 
			     +  "?p1 prov:wasInformedBy ?p."
			        +  "?p prov:used ?x."
			        +	 "?x prov:type <http://www.itacispaces.org/ns#Goal>."
			  	  + "}"
				  + "}";
		
		array=conn.executeQLMany(query,model);
		 //	System.out.println(array.size());
		
		iter=array.iterator();
		while(iter.hasNext()){
			res=(ArrayList) iter.next();
			//?a1  ?p ?ag 
			x0=(String)res.get(0);//a1
			x1=checkNodes(x0,model);
			x1=x1.replaceAll(NS.URICISP, "");
		 
			x4=(String)res.get(1);//p
			x3=x4.replaceAll(NS.URICISP, "");
			if(pGens.containsKey(x1+x3)){
				pg=(Pgen) pGens.get(x1+x3);
				 
			}else{
				String pid=UUID.randomUUID().toString();
				pg=new Pgen(x1,x3,root,pid,tid);
				tid++;
				
			}	//seek for time
				query=NS.PREFIXES+  
						 " SELECT DISTINCT ?t WHERE { "
						 + "<"+x0+"> prov:qualifiedGeneration ?x."
						  + "?x prov:atTime ?t."
						  + "}";
				ArrayList out=conn.executeQLSingle(query, model);
				if(out.size()>0){
					pg.setTime((String) out.get(0));
				}
				//seek for agents
				query=NS.PREFIXES+  
						 " SELECT DISTINCT ?ag WHERE { "
						 + "<"+x4+"> prov:wasAssociatedWith ?ag."
							  + "?ag a prov:Agent."
						  + "}";
				out=conn.executeQLSingle(query, model);
				if(out.size()>0){
					Iterator itt=out.iterator();
					while(itt.hasNext()){
						x5=(String)itt.next();
						x5=x5.replaceAll(NS.URICISP, "");
						pg.addAgent(x5);
					}
					
					
				}
				//seek for entities
				query=NS.PREFIXES+  
						 " SELECT DISTINCT ?a WHERE { "
						 + "<"+x4+"> prov:used ?a."
							  + "?a a prov:Entity."
						  + "}";
				out=conn.executeQLSingle(query, model);
				if(out.size()>0){
					Iterator itt=out.iterator();
					while(itt.hasNext()){
						x5=(String)itt.next();
						x5=checkNodes(x5,model);
						x5=x5.replaceAll(NS.URICISP, "");
						pg.addEntity(x5);
					}
					
					
				}
		//		System.out.println(x1+":"+x3);
				pGens.put(x1+x3,pg);
		 
		}
		
				return pGens;
	}

	
	
	public String checkNodes(String node, Model model){
		if(node.contains("Node")){
			
			String query=NS.PREFIXES+  
					 " SELECT ?t WHERE { "
					// <http://www.itacispaces.org/Node34ef2e99-a70d-4f19-a325-3ad2c55a6c8c> <http://www.itacispaces.org/ns#infText> "The gang G is heading south"^^<http://www.w3.org/2001/XMLSchema#string> .
					  + "<"+node+"> cisp:infText ?t."
					 + "}";
		
		//System.out.println(query);
		ArrayList out=conn.executeQLSingle(query, model);
		if(out.size()>0){
			return "*"+(String)out.get(0)+"*";
		}
		}
		return node;
	}
}
