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
 * @since 		September 2014           
 *   
 */


package infocontrol;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

import utils.NS;
import utils.PatternBuilder;
import utils.TimeHelper;

import com.hp.hpl.jena.graph.TripleBoundary;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelExtract;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StatementTripleBoundary;

import gaian.DBConnect;
import gaian.DBQuery;
import gaian.JDBConnect;


 


public class InfoProvBuild {
	//only named model

	private PatternBuilder prov;
	private TimeHelper time;
	private JDBConnect conn;

	private Model model;

	public InfoProvBuild(DBQuery dbcn) {
		time=new TimeHelper();
		conn=new JDBConnect(dbcn);
	}
	


public void createRandomProv(String nodeid,String info, String username){
	prov = new PatternBuilder();
	String[] ij=new String[]{nodeid,info};//String[0:id,1:text,2:cispid]  
	String timep=time.now();
	prov.makeGenerationPattern(ij, "RandomDataColl", "RandomGeneration", "InfoStream", timep);
	prov.makePrimarySource("RandomDataColl");
	conn.SDBUpdateInfoBox(prov.getModel(), username);
	 
	/* ///jsut testing methods
	OntModel model=prov.getModel();
	
	System.out.println("THIS IS THE NEW PROV\n\n");
	prov.write(System.out);
	System.out.println("THIS IS THE OLD PROV\n\n");
	Model mod=conn.doQuery();
	mod.write(System.out,"N-TRIPLES"); 
	System.out.println("THIS IS THE OTHER PROV\n\n");
	 
	mod.write(System.out); 
	 */
}


public void createNewProvNode(String nodeid, String info, String stream, String dtg, String source, String username) {
	// TODO Auto-generated method stub
	prov = new PatternBuilder();
	String[] ij=new String[]{nodeid,info};//String[0:id,1:text,2:cispid]  
    String timex=time.getDateCIS(dtg);
    String timey=time.now();
    String newid=UUID.randomUUID().toString();
	prov.makeGenerationPattern(ij, source+"_Report", "Aquiring"+newid, stream, timey);
	prov.makeGenerationPattern(source+"_Report",stream+"_Notif_"+nodeid,   "Reporting"+newid, source, timex);
	prov.makePrimarySource(source+"_Report");
	conn.SDBUpdateInfoBox(prov.getModel(), username);
	
}




public String createAccessProv(String nodeid,String info,String username,String aff){
	//check if it was accessed before 
	//if so send the same id of the access
	//TODO
	String newid = null;
	 String query=NS.PREFIXES+  
			 " SELECT ?s WHERE{"+
					 "?s a prov:Activity  ."+ 
				   "?s prov:wasAssociatedWith <"+NS.URICISP+username+"> ."+
				   "?s prov:used <"+NS.URICISP+"Node"+nodeid+"> ."+
				 "}";
	// System.out.println(query);
	 
	 ArrayList array=conn.executeQLSingle(query,model);
	// System.out.println(array.toString());
	 if(array.size()==0){
	
	
	//else create new id 
	//add first access 
	  newid=UUID.randomUUID().toString();
	prov = new PatternBuilder();
	
	String[] ij=new String[]{nodeid,info};//String[0:id,1:text,2:cispid]  
	String[] dervij=new String[]{newid,info,newid};//String[0:id,1:text,2:cispid]  
	 
	String timep=time.now();
	String pid=UUID.randomUUID().toString();
	prov.makeGenerationPattern(dervij, ij, "CISpAccess"+pid, username, timep);
	prov.addExtraPropProperty(NS.URICISP+"Node"+nodeid, NS.CISP+"record", NS.CISP+"InitialInfo");
	
	//copy exactly the same to the default model!!!
	
 

	conn.SDBUpdateInfoBox(prov.getModel(), username);

	
	/*//Just testing methods
	 Model test=conn.doQueryDefaultModel();
	System.out.println("THIS IS THE DEFAULT PROV\n\n");
	test.write(System.out,"N-TRIPLES");
	test=conn.doQueryNamedModel(username);
	System.out.println("THIS IS THE INIDV PROV\n\n");
	test.write(System.out,"N-TRIPLES");
	 
	*/
	
	 }else{
	  query=NS.PREFIXES+  
				 " SELECT ?id WHERE{"+
						 "?s a prov:Entity ."+ 
					   "?s prov:wasDerivedFrom  <"+NS.URICISP+"Node"+nodeid+"> ."+
					   "?s prov:wasGeneratedBy <"+array.get(0)+"> ."+
					   "?s cisp:nodeID ?id ."+ 
					 "}";
		// System.out.println(query);
		 
		  array=conn.executeQLSingle(query,model); 
		 //System.out.println(array.toString());
		 newid=(String) array.get(0);
		 
	 }
	return newid;
}

public String[] retrieveProvInfo(String newid) {
	String[] provinfo=new String[2];
	String qpath="prov:wasDerivedFrom*|prov:wasAssociatedWith*|prov:wasGeneratedBy*|prov:used*|prov:wasInformedBy*|prov:actedOnBehalfOf*|prov:wasAttributedTo*";
	String  qpath1="prov:wasDerivedFrom*|prov:wasGeneratedBy*|prov:wasAttributedTo*";
	String qpath2="prov:wasDerivedFrom*";
	//here we do only go back one step!!
	String query;
	ArrayList array;
	//1st attempt direct derivation!!!
	query=NS.PREFIXES+  
			 " SELECT DISTINCT ?q WHERE{"+
			 "?q a prov:Entity ."+ 
			 "<"+NS.URICISP+"Node"+newid+"> prov:wasDerivedFrom ?p ."+
			 "?p prov:wasDerivedFrom ?q." +
		 "}";
	
	array=conn.executeQLSingle(query,model);
//	System.out.println(array.toString());
	
	if(array.size()>0){

		HashSet subsub=new HashSet();
		Iterator iter=array.iterator();
		String ps="",candidate;
		while(iter.hasNext()){
			candidate=(String) iter.next();
			
			candidate=candidate.replace(NS.URICISP,"");
			if(candidate.contains("msg_")){
			 
				//System.out.println("DO I COME HERE INSTEAD>?");
				//add the option that if the derivation is from moira messages extract the sources!!!
				String subquery=NS.PREFIXES+  
						 " SELECT DISTINCT ?q WHERE{"+
						 "?q a prov:Agent ."+ 
						 "<"+NS.URICISP+candidate+"> prov:wasGeneratedBy ?p1 ."+
						 "?p1 prov:wasAssociatedWith ?q." +
					 "}";
				
				ArrayList subarray=conn.executeQLSingle(subquery,model);
			    subsub.addAll(subarray);
			    
			  //get also the user in the generation 
				subquery=NS.PREFIXES+  
						 " SELECT DISTINCT ?q WHERE{"+
						 "?q a prov:Agent ."+ 
						 "<"+NS.URICISP+"Node"+newid+"> prov:wasDerivedFrom ?e1 ."+
						 "?e1 prov:wasDerivedFrom <"+NS.URICISP+candidate+"> ."+
						 "?e1 prov:wasGeneratedBy ?p ."+
						 "?p prov:used <"+NS.URICISP+candidate+"> ."+
						 "?p prov:wasAssociatedWith ?q." +
					 "}";
		 
				
				
				//System.out.println(subquery);
			//	model.write(System.out,"N-TRIPLES");
				subarray=conn.executeQLSingle(subquery,model);
			    subsub.addAll(subarray);
			    
			}
			ps+=candidate+",";
		}
		ps=ps.substring(0,ps.length()-1);
		
		
	
			if(subsub.size()>0){
			  String subsources="";
			  Iterator subit=subsub.iterator();
			  while(subit.hasNext()){
				  subsources+=","+((String)subit.next()).replace(NS.URICISP,"");
			  }
			  subsources=subsources.substring(1);
			  ps=subsources+":"+ps;
	
		}
		
		provinfo[0]=ps;

		
	}else{
		//2nd attempt  generated+used!!!
		
		query=NS.PREFIXES+  
				 " SELECT DISTINCT ?q WHERE{"+
				 "?q a prov:Entity ."+ 
				 "<"+NS.URICISP+"Node"+newid+"> prov:wasDerivedFrom ?p ."+
				 "?p prov:wasGeneratedBy/prov:used ?q." +
			 "}";
		array=conn.executeQLSingle(query,model);
		//System.out.println(array.toString());
		if(array.size()>0){
			Iterator iter=array.iterator();
			String ps="",candidate;
			while(iter.hasNext()){
				candidate=(String) iter.next();
				candidate=candidate.replace(NS.URICISP,"");
				ps+=candidate+",";
			}
			ps=ps.substring(0,ps.length()-1);
			provinfo[0]=ps;
		}else{
		 //4th attempt ...could not find it look for primary sources 
			 query=NS.PREFIXES+  
					 " SELECT DISTINCT ?y WHERE { "
					  + "?x cisp:nodeID \""+newid+"\"^^xsd:string."
					  + "?x "+qpath1+" ?t."
					  + "?t ("+qpath+")* ?y."
						  + "?y prov:type <"+NS.PROV+"PrimarySource>.}";
			array=conn.executeQLSingle(query,model); 
			if(array.size()>0){
			//	System.out.println("THESE ARE THE PRIM SOURCES:\n"+array.toString());
				Iterator iter=array.iterator();
				String ps="",candidate;
				while(iter.hasNext()){
					candidate=(String) iter.next();
					candidate=candidate.replace(NS.URICISP,"");
					ps+=candidate+",";
				}
				ps=ps.substring(0,ps.length()-1);
				provinfo[0]=ps;
				//System.out.println("I SENT THIS OUT THE FOLLOWING:\n"+ps);
			}else{
				//5th attempt unknown!!!
				provinfo[0]="unknown";
			}
		}
	
	}
	  query=NS.PREFIXES+  
			 " SELECT ?time WHERE{"+
			 "?s a prov:Entity ."+ 
		   "<"+NS.URICISP+"Node"+newid+"> prov:wasDerivedFrom ?s ."+
		   "?s prov:qualifiedGeneration ?p ."+
		   "?p prov:atTime ?time." +
		 "}";
// System.out.println(query);

array=conn.executeQLSingle(query,model); 
//model.write(System.out,"N-TRIPLES");
//This time should always be there but sometimes it is not"
String timex = null;
if(array.size()>0){
	timex=(String) array.get(0);
}
//System.out.println("TIME?"+timex);

if(timex==null){
	timex=time.nowCIS();
}else{
	timex=time.parseCIS(timex);
}
provinfo[1]=timex;
 return provinfo;
}





public boolean loadInfoModel(String name) {
	 model= conn.doQueryInfoBoxModel(name);
	 return true;
}





private Model extractModel(String nodeID, Model defModel) {
	StatementTripleBoundary sb = new StatementTripleBoundary(TripleBoundary.stopNowhere);
	ModelExtract md=new ModelExtract(sb);
	Resource r=defModel.getResource(nodeID);
	Model me=md.extract(r, defModel);                
	return me;

}

public boolean existsNode(String nodeID,Model mod) {
	
	
	String query=NS.PREFIXES+  
			 " SELECT DISTINCT ?x WHERE{"+
			 "?x a prov:Entity ."+ 
			 "?x cisp:nodeID \""+nodeID+"\"^^xsd:string."+
		 "}";
	//System.out.println(query);
	//model.write(System.out,"N-TRIPLES"); 
	
	ArrayList array=conn.executeQLSingle(query, mod);
	if(array.size()>0){
		return true;
	}else{
	
	return false;
	}
}



	
 



private boolean existsAnalysis(String user, String analysis) {
	String query=NS.PREFIXES+  
			 " SELECT DISTINCT ?x WHERE{"+
			 "?x a prov:Entity ."+ 
			 "?x cisp:analysisID \""+analysis+"\"^^xsd:string."+
		 "}";
	//System.out.println(query);
	//model.write(System.out,"N-TRIPLES"); 
	
	ArrayList array=conn.executeQLSingle(query, model);
	if(array.size()>0){
		return true;
	}else{
	
	return false;
	}
}



public void closeOff() {
	conn.closeAndUpload();
	
}



public void addNewProvNodeMoira(String provst, String username) {
	//everything is already included in provst
		 //this is passed as a json string
		PatternBuilder build=new PatternBuilder();
		Model model=build.getModel();
		InputStream input = new ByteArrayInputStream(provst.getBytes());
		model.read(input, null,"RDF/JSON");
		model.setNsPrefix("foaf", NS.FOAF);
		model.setNsPrefix("cisp", NS.CISP);
		model.setNsPrefix("prov", NS.PROV);
		model.setNsPrefix("rdf", NS.RDF);
		//model.write(System.out,"N-TRIPLES");
		conn.SDBUpdateInfoBox(model, username);
	
}



public void createNewProvNodeTrans(String nodeid, String info, String stream, String dtg, String source, String surr,
		String user) {
	prov = new PatternBuilder();
	String[] ij=new String[]{nodeid,info};//String[0:id,1:text,2:cispid]  
    String timex=time.getDateCIS(dtg);
    String timey=time.now();
    String newid=UUID.randomUUID().toString();
    String newid2=UUID.randomUUID().toString();
	prov.makeGenerationPattern(ij, source, "Aquiring"+newid, user, timey);
	prov.makeSimpleGenerationPattern(source, "Reporting"+newid2, surr, timex);
	prov.makePrimarySource(source);
	prov.createEntity(stream);
	prov.addWasDerivedFrom(source, stream);
	//Model model=prov.getModel();
//	model.write(System.out,"N-TRIPLES");
	conn.SDBUpdateInfoBox(prov.getModel(), user);
}





}




	


/* 
 * this part of the code is to retrieve source as the primary source in the path
 * 
 * 
 * String query=NS.PREFIXES+  
			 " SELECT DISTINCT ?y WHERE { "
			  + "?x cisp:nodeID \""+newid+"\"^^xsd:string."
			  + "?x "+qpath1+" ?t."
			  + "?t ("+qpath+")* ?y."
			  //<http://www.itacispaces.org/RegionsOfInterest> <http://www.w3.org/ns/prov#type> <http://www.w3.org/ns/prov#PrimarySource>
			  + "?y prov:type <"+NS.PROV+"PrimarySource>.}";
		ArrayList array=conn.executeQL(query,model); 
	if(array.size()>0){
		System.out.println("THESE ARE THE PRIM SOURCES:\n"+array.toString());
		Iterator iter=array.iterator();
		String ps="",candidate;
		while(iter.hasNext()){
			candidate=(String) iter.next();
			candidate=candidate.replace(NS.URICISP,"");
			ps+=candidate+",";
		}
		ps=ps.substring(0,ps.length()-1);
		provinfo[0]=ps;
		System.out.println("I SENT THIS OUT THE FOLLOWING:\n"+ps);
	}else{
		 query=NS.PREFIXES+  
				 " SELECT DISTINCT ?y WHERE { "
				  + "?x cisp:nodeID \""+newid+"\"^^xsd:string."
				  + "?x "+qpath2+" ?t."
				  + "?t "+qpath2+" ?y."
				  //<http://www.itacispaces.org/RegionsOfInterest> <http://www.w3.org/ns/prov#type> <http://www.w3.org/ns/prov#PrimarySource>
				  + "}";
		 array=conn.executeQL(query,model); 
		 String thisnode=NS.URICISP+"Node"+newid;
		 array.remove(thisnode);
		 System.out.println("THERE ARE NO PRIMARY SOURCES:\n"+array.toString());
		 Iterator iter=array.iterator();
		 String candidate="";
		 ArrayList list,prims=new ArrayList();
			while(iter.hasNext()){
				candidate=(String) iter.next();
				//this is not a node now
				 query=NS.PREFIXES+  
						 " SELECT DISTINCT ?y WHERE { "
						  + "<"+candidate+"> a prov:Entity."
						  + "<"+candidate+"> "+qpath2+" ?t."
						  + "?t "+qpath2+" ?y."
						  //<http://www.itacispaces.org/RegionsOfInterest> <http://www.w3.org/ns/prov#type> <http://www.w3.org/ns/prov#PrimarySource>
						  + "}";
				 list=conn.executeQL(query,model); 
				 list.remove(candidate);
				 System.out.println(candidate+" HAS THE FOLLOWING DERIVATIONS:\n"+list.toString());
				 if(list.size()==0){
					 prims.add(candidate.replace(NS.URICISP,""));
				 }
			}
			if(prims.size()>0){
			iter=prims.iterator();
			
			String ps="";
			while(iter.hasNext()){
				ps+=iter.next()+",";
			}
			ps=ps.substring(0,ps.length()-1);
			provinfo[0]=ps;
			System.out.println("I SENT THIS OUT THE FOLLOWING:\n"+ps);
			}else{
				provinfo[0]="Unknown";
			}
	}
	//With this I sort the sources but not the time!!!! 
	query=NS.PREFIXES+  
			 " SELECT ?time WHERE{"+
			 "?s a prov:Entity ."+ 
		   "<"+NS.URICISP+"Node"+newid+"> prov:wasDerivedFrom ?s ."+
		   "?s prov:qualifiedGeneration ?p ."+
		   "?p prov:atTime ?time." +
		 "}";
// System.out.println(query);

array=conn.executeQL(query,model); 
String timex=(String) array.get(0);
System.out.println("TIME?"+timex);

if(timex.isEmpty()){
	timex=time.nowCIS();
}else{
	timex=time.parseCIS(timex);
}
provinfo[1]=timex;
 return provinfo;
	
	
	*/
