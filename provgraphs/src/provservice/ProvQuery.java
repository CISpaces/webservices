    
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










import java.util.Iterator;



public class ProvQuery {
	private ModelConnect conn;

	public ProvQuery() {
		conn=new ModelConnect();
	}

	public boolean existsNode(String nodeID) {
		
		
		String query=NS.PREFIXES+  
				 " SELECT DISTINCT ?x WHERE{"+
				 "?x a prov:Entity ."+ 
				 "?x cisp:nodeID \""+nodeID+"\"^^xsd:string."+
			 "}";
		//System.out.println(query);
		//model.write(System.out,"N-TRIPLES"); 
		
		ArrayList array=conn.executeQLSingle(query);
		if(array.size()>0){
			return true;
		}else{
		//System.out.println("out");
		return false;
		}
	}
	
public boolean existsAnalysis(String anID) {
		
		
		String query=NS.PREFIXES+  
				 " SELECT DISTINCT ?x WHERE{"+
				 "?x a prov:Entity ."+ 
				 "?x cisp:analysisID \""+anID+"\"^^xsd:string."+
			 "}";
		// System.out.println("EXISTS ANALYOS+"+query);
		// model.write(System.out,"N-TRIPLES"); 
		
		ArrayList array=conn.executeQLSingle(query);
		if(array.size()>0){
			return true;
		}else{
		
		return false;
		}
	}

	public ArrayList getProvChainNodes(String nodeID) {
		 
		String qpath="prov:wasDerivedFrom*|prov:wasAssociatedWith*|prov:wasGeneratedBy*|prov:used*|prov:wasInformedBy*|prov:actedOnBehalfOf*|prov:wasAttributedTo*";
		String  qpath1="prov:wasDerivedFrom*|prov:wasGeneratedBy*|prov:wasAttributedTo*";
		String query=NS.PREFIXES+  
				 " SELECT DISTINCT ?y ?q WHERE { "
				// + "?x a prov:Entity."
				  + "?x cisp:nodeID \""+nodeID+"\"^^xsd:string."
				  + "?x "+qpath1+" ?t."// + "?x cisp:nodeID \'\'."
				 + "?t ("+qpath+")* ?y."
				 + "?y rdf:type ?q."
				//  + "?t "+qpath+" ?y."
				 		+ "}";
		 ArrayList array=conn.executeQLMany(query); 
		 
		return array;
	}

	

	public ArrayList getRelations(String key) {
		String qpath="prov:wasDerivedFrom|prov:wasAssociatedWith|prov:wasGeneratedBy|prov:used|prov:wasInformedBy|prov:actedOnBehalfOf|prov:wasAttributedTo";
		
		String query=NS.PREFIXES+  
				 " SELECT DISTINCT ?y WHERE { "
				// + "?x a prov:Entity."
				  + "<"+key+"> "+qpath+" ?y."
				 		+ "}";
	//	System.out.println(query);
		 ArrayList array=conn.executeQLSingle(query); 
		 
		return array;
	}

	 
	

	
	
	
	public String getNodeLab(String label) {
		String query=NS.PREFIXES+  
				 " SELECT ?t WHERE { "
				// <http://www.itacispaces.org/Node34ef2e99-a70d-4f19-a325-3ad2c55a6c8c> <http://www.itacispaces.org/ns#infText> "The gang G is heading south"^^<http://www.w3.org/2001/XMLSchema#string> .
				  + "<"+NS.URICISP+label+"> cisp:infText ?t."
				 + "}";
		ArrayList array=conn.executeQLSingle(query); 
	//	System.out.println(array.toString());
		if(!array.isEmpty()){
			return (String) array.get(0);
		}
		return null;
	}

	public boolean getPrimarySources(String label) {
		String query=NS.PREFIXES+  
				 " SELECT ?t WHERE { "
				// <http://www.itacispaces.org/BorderObservations> <http://www.w3.org/ns/prov#type> <http://www.w3.org/ns/prov#PrimarySource> .
				  + "<"+NS.URICISP+label+"> prov:type ?t."
				 + "}";
		ArrayList array=conn.executeQLSingle(query); 
		//System.out.println(array.toString());
		if(!array.isEmpty()){
			if(array.contains("http://www.w3.org/ns/prov#PrimarySource")){
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean getGoals(String label) {
		String query=NS.PREFIXES+  
				 " SELECT ?t WHERE { "
				// <http://www.itacispaces.org/BorderSituationAwareness> <http://www.w3.org/ns/prov#type> <http://www.itacispaces.org/ns#Goal> .
				  + "<"+NS.URICISP+label+"> prov:type ?t."
				 + "}";
		ArrayList array=conn.executeQLSingle(query); 
		//System.out.println(array.toString());
		if(!array.isEmpty()){
			if(array.contains("http://www.itacispaces.org/ns#Goal")){
				return true;
			}
			return false;
		}
		return false;
	}

	public String getTimeLab(String nd1, String nd2) {
		String query=NS.PREFIXES+  
				 " SELECT ?t WHERE { "
				// _:BX2D424a7e65X3A147c9f794cfX3AX2D7ffa <http://www.w3.org/ns/prov#atTime> "2014-08-10T23:25:52Z"^^<http://www.w3.org/2001/XMLSchema#dateTime> .
				//<http://www.itacispaces.org/MessageReceived> <http://www.w3.org/ns/prov#qualifiedGeneration> _:BX2D424a7e65X3A147c9f794cfX3AX2D7ffa .
				// <http://www.itacispaces.org/MessageReceived> <http://www.w3.org/ns/prov#wasGeneratedBy> <http://www.itacispaces.org/Deliver> .
				  + "?p prov:atTime ?t."
				  + "<"+NS.URICISP+nd1+"> prov:qualifiedGeneration ?p."
				  + "<"+NS.URICISP+nd1+"> prov:wasGeneratedBy <"+NS.URICISP+nd2+">."
				 + "}";
	//	System.out.println(query);
		ArrayList array=conn.executeQLSingle(query); 
	//	System.out.println(array.toString());
		if(!array.isEmpty()){
			return (String) array.get(0);
		}
		return null;
	}
	public ArrayList getProvChainAnalysis(String ayd) {
		//select only type node or analysis
		 //<http://www.itacispaces.org/CurrentAnalysis297f6909-1e20-46eb-885f-b64ce50bf97a> <http://www.itacispaces.org/ns#analysisID> "f0e9fe51-e1e2-49a1-81ab-d0d1f35bba17"^^<http://www.w3.org/2001/XMLSchema#string> .
		//<http://www.itacispaces.org/Node3d1a134e-5e21-4294-b5cf-d37f6f87a7b2> <http://www.w3.org/ns/prov#type> <http://www.itacispaces.org/ns#Node> .
		//System.out.println(ayd);
 
		String qpath="prov:wasDerivedFrom*|prov:wasAssociatedWith*|prov:wasGeneratedBy*|prov:used*|prov:wasInformedBy*|prov:actedOnBehalfOf*|prov:wasAttributedTo*";
		String  qpath1="prov:wasDerivedFrom*|prov:wasGeneratedBy*|prov:wasAttributedTo*";
		String qpath2="cisp:analysisID|cisp:nodeID";
		String query=NS.PREFIXES+  
				 " SELECT DISTINCT ?y ?q ?r WHERE { "
				// + "?x a prov:Entity."
				  + "?x cisp:analysisID \""+ayd+"\"^^xsd:string."
				  + "?x "+qpath1+" ?t."// + "?x cisp:nodeID \'\'."
				 + "?t ("+qpath+")* ?y."
				 + "?y rdf:type ?q."
				 + "?y "+qpath2+" ?g."
				  + "?y prov:type ?r."
				//  + "?t "+qpath+" ?y."
				 + " FILTER NOT EXISTS { ?y cisp:record <http://www.itacispaces.org/ns#InitialInfo>. }"
				// NS.URICISP+"Node"+nodeid, NS.CISP+"ofType", NS.CISP+"InitialInfo"
				 		+ "}";
		 ArrayList array=conn.executeQLMany(query); 
		 
		 //now query the generation of all the analysis found in array
		 // System.out.println(array.toString());
		// model.write(System.out,"N-TRIPLES");
		return array;
		 
	}
	 
 

public String getAnalsysID(String label) {
	String query=NS.PREFIXES+  
			 " SELECT ?t WHERE { "
			   + "<"+label+"> cisp:analysisID ?t."
			 + "}";
	ArrayList array=conn.executeQLSingle(query); 
//	System.out.println(array.toString());
	if(!array.isEmpty()){
		return (String) array.get(0);
	}
	return null;
}

public ArrayList getGenerationAnalyis(String analysis) {
	
	String qpath="prov:wasAssociatedWith*|prov:wasGeneratedBy*";
	String query=NS.PREFIXES+  
			 " SELECT DISTINCT ?y ?q WHERE { "
			// + "?x a prov:Entity."
			+ "<"+analysis+"> prov:wasGeneratedBy ?t."
			 + "?t ("+qpath+")* ?y."
			 + "?y rdf:type ?q."
			//  + "?t "+qpath+" ?y."
			 		+ "}";
	 
	 ArrayList array=conn.executeQLMany(query); 
	// System.out.println("SILLY"+array.toString());
	return array;
}

public String getAnalysName(String anID) {
	String query=NS.PREFIXES+  
			 " SELECT DISTINCT ?x WHERE{"+
			 "?x cisp:analysisID \""+anID+"\"^^xsd:string."+
		 "}";
	ArrayList array=conn.executeQLSingle(query); 
//	System.out.println(array.toString());
	if(!array.isEmpty()){
		String name=(String) array.get(0);
		name=name.replace(NS.URICISP, "");
		return name;
	}
	return null;
}

public String getLocation(String label) {
	String query=NS.PREFIXES+  
			 " SELECT ?p WHERE { "
			// _:BX2D424a7e65X3A147c9f794cfX3AX2D7ffa <http://www.w3.org/ns/prov#atTime> "2014-08-10T23:25:52Z"^^<http://www.w3.org/2001/XMLSchema#dateTime> .
			//<http://www.itacispaces.org/MessageReceived> <http://www.w3.org/ns/prov#qualifiedGeneration> _:BX2D424a7e65X3A147c9f794cfX3AX2D7ffa .
			// <http://www.itacispaces.org/MessageReceived> <http://www.w3.org/ns/prov#wasGeneratedBy> <http://www.itacispaces.org/Deliver> .
			  + "<"+label+"> cisp:location ?p."
			  
			 + "}";
//	System.out.println(query);
	ArrayList array=conn.executeQLSingle(query); 
//	System.out.println(array.toString());
	if(!array.isEmpty()){
		String result="";
		Iterator iter=array.iterator();
		while(iter.hasNext()){
			result=result+":"+iter.next();
		}
		return result;
	}
	return null;
}

public void getAndSetModel(String output) {
	
	conn.getAndSetModel(output); 
	
	
	
	
}

public void print() {
	conn.print();
	
}


 
	
	
	
	 



}
