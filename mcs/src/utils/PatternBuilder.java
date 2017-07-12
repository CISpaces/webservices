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


package utils;
 
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import prov.ProvenanceBundle;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;


public class PatternBuilder extends ProvenanceBundle{

	public PatternBuilder() {
		super();
		prov.setNsPrefix("foaf", NS.FOAF);
		prov.setNsPrefix("cisp", NS.CISP);
		prov.setNsPrefix("prov", NS.PROV);
		prov.setNsPrefix("rdf", RDF_NS);
	}
	

	public void setModel(Model mod){
		prov.add(mod);
	}
	
	
public void makeGenerationPattern(Object a1,Object a2,String p1,Object ag1,String time){
	    Resource aa1,aa2,agg1,pp1;
	   //this already checks for existing ones!Brilliant!!!
		//make different entities/actors
		aa1=getCISEntity(a1);
		aa2=getCISEntity(a2);
		agg1=getCISAgent(ag1);
		
		createActivity(p1);
		pp1=getResource(NS.URICISP+p1);
		//need to add 4 relationships 
		addWasDerivedFrom(aa1, aa2);
		addUsed(pp1,aa2);
		addWasGeneratedBy(aa1, pp1,time);
		addWasAssociatedWith(pp1, agg1);
		 
	}
	



public void makeAnalysisGenerationPattern(String location,String anname,String ayid,String prevname,ArrayList users,String p1,String time, ArrayList ids){

    Resource an1,agg1,pp1,an2;
    an1=makeAnalysis(anname,ayid,location);//main entity
    createEntity(prevname);
    an2=getResource(NS.URICISP+prevname);
    addWasDerivedFrom(an1,an2);
    Object ag1;
    createActivity(p1);//activity
	pp1=getResource(NS.URICISP+p1);
	//System.out.println(pp1.toString());
	addWasGeneratedBy(an1, pp1,time);
    Iterator iter=users.iterator();
    while(iter.hasNext()){
    	ag1=iter.next();
    	agg1=getCISAgent(ag1);//agent
    	addWasAssociatedWith(pp1, agg1);
    }
	//now used
	Resource node;
	iter=ids.iterator();
	String nd;
	while(iter.hasNext()){
		nd=(String) iter.next();
		nd="Node"+nd;
		node=getCISEntity(nd);
		addUsed(pp1,node);
	}
	addUsed(pp1,an2);
	//need to add 4 relationships
}

public void addUsersToGeneration(String activity, ArrayList users) {
	// TODO Auto-generated method stub
	 ///activity no uri
	//users have 2 strings user+aff
	createActivity(activity);
	Resource pp1 = getResource(NS.URICISP+activity);
	Resource agent;
	Iterator iter=users.iterator();
	String nd;
	while(iter.hasNext()){
		agent=getCISAgent(iter.next());
		addWasAssociatedWith(pp1,agent);
	}
	
}
public void addNodeWasDerivedFromAnalysis(String location,String nodename, String analyname,String analy) {
	 createEntity(nodename);
	 Resource en=getResource(NS.URICISP+nodename);
	 makeAnalysis(analyname,analy,location);
	 Resource wp=getResource(NS.URICISP+analyname);
	 addWasDerivedFrom(wp,en);
	
}
public void addLocationToAnalysis(String anID,String analyname, String location) {
	makeAnalysis(analyname, anID, location);
	
}


public void makeAnalywasDerived(String en1, String en2) {
	Resource aa1,aa2,pp1;
	   //this already checks for existing ones!Brilliant!!!
		//make different entities/actors
		aa1=getCISEntity(en1);
		aa2=getCISEntity(en2);
	 
	 
		//need to add 4 relationships 
		addWasDerivedFrom(aa1, aa2);
		 
	}


public void makeSimpleAnalysisGenerationPattern(String location,String analy,String ayid,ArrayList users,String p1,String time, ArrayList ids){
	
    Resource an1,agg1,pp1;
    an1=makeAnalysis(analy,ayid,location);//main entity
    Object ag1;
    createActivity(p1);//activity
	pp1=getResource(NS.URICISP+p1);
	//System.out.println(pp1.toString());
	addWasGeneratedBy(an1, pp1,time);
    Iterator iter=users.iterator();
    while(iter.hasNext()){
    	ag1=iter.next();
    	agg1=getCISAgent(ag1);//agent
    	addWasAssociatedWith(pp1, agg1);
    }
	//now used
	Resource node;
	iter=ids.iterator();
	while(iter.hasNext()){
		node=getCISEntity(iter.next());
		addUsed(pp1,node);
	}
	//need to add 4 relationships
}

public void makeSimpleGenerationPattern(Object a1,String p1,Object ag1,String time){
    Resource aa1,aa2,agg1,pp1;
   //this already checks for existing ones!Brilliant!!!
	//make different entities/actors
	aa1=getCISEntity(a1);
	agg1=getCISAgent(ag1);
	createActivity(p1);
	pp1=getResource(NS.URICISP+p1);
	//need to add 4 relationships 
	addWasGeneratedBy(aa1, pp1,time);
	addWasAssociatedWith(pp1, agg1);
}

public void makeCSRequPattern(Object a1,Object a2,Object a3,String p1,String p2,String t_a1p1,String t_a2p2,Object ag1,Object ag2){
	  Resource aa1,aa2,aa3,pp1,pp2,agg1,agg2;
	  aa1=getCISEntity(a1);
	  aa2=getCISEntity(a2);
	  aa3=getCISEntity(a3);
	  agg1=getCISAgent(ag1);
	  agg2=getCISAgent(ag2);
	  createActivity(p1);
	  createActivity(p2);
	  pp1=getResource(NS.URICISP+p1);
	  pp2=getResource(NS.URICISP+p2);
	 
	  //need to add 8 relationships 
	  
	  addWasInformedBy(pp1,pp2);
	  addWasAssociatedWith(pp1, agg1);
	  addWasAssociatedWith(pp2, agg2);
	  addWasGeneratedBy(aa1, pp1,t_a1p1);
	  addWasGeneratedBy(aa2, pp2,t_a2p2);
	  addUsed(pp1,aa2);
	  addUsed(pp1,aa3);
	  addUsed(pp2,aa3);
	  addWasDerivedFrom(aa1,aa2);
	}


  public void makeRequirementPattern(Object a1,Object a2,String g1,String p1,String p2,String t_a1p1,String t_a2p2){
	  Resource aa1,aa2,gg1,pp1,pp2;
	  aa1=getCISEntity(a1);
	  aa2=getCISEntity(a2);
	  //g1 is a GOAL NODE not in the analysis so cannot be a node
	  gg1=makeGoal(g1);
	 
	  //need to add 5 relationships 
	  createActivity(p1);
	  createActivity(p2);
	 
	  pp1=getResource(NS.URICISP+p1);
	  pp2=getResource(NS.URICISP+p2);
	  addWasInformedBy(pp1,pp2);
	  addWasGeneratedBy(aa1, pp1,t_a1p1);
	  addWasGeneratedBy(aa2, pp2,t_a2p2);
	  addUsed(pp1,aa2);
	  addUsed(pp2,gg1);
	}
  public void addNodesToGeneration(String activity, ArrayList nodes) {
		 ///activity no uri
	  createActivity(activity);
		Resource pp1 = getResource(NS.URICISP+activity);
		Resource node;
		Iterator iter=nodes.iterator();
		String nd;
		while(iter.hasNext()){
			nd=(String) iter.next();
			nd="Node"+nd;
			node=getCISEntity(nd);
			addUsed(pp1,node);
		}
	}



	public void makePrimarySourcePattern(ArrayList ps,String p1,Object ag1,Object a1,String t_a1p1){
		 createActivity(p1);
		 Resource aa1=getCISEntity(a1);
		 Resource pp1=getResource(NS.URICISP+p1);
		 addWasGeneratedBy(aa1,pp1,t_a1p1);
		 Resource agg1=getCISAgent(ag1);
		 addWasAssociatedWith(pp1,agg1);
		 Iterator iter=ps.iterator();
		 Resource pas;
		 while(iter.hasNext()){
			 pas=getCISEntity(iter.next());
			 pas=makePrimarySource(pas);
			 addUsed(pp1,pas);
		 }
	}
	/****************************************************************************************
	 * Expand Analyst+Node+Goal methods for CISPACES
	 * @return 
	 * 
	 */
	protected Resource getCISAgent(Object ag) {
		if(ag instanceof String){
			String art=(String)ag;
			art=art.replaceAll(" ", "_");
			createAgent(art); //the entity derived
			return getResource(NS.URICISP+art);
		}else{//entity is a node String[0:person,1:affiliation]  
			String[] ee=(String[])ag;
			return makeAnalyst(ee[0],ee[1]);
		}
	}

	
	public Resource getCISEntity(Object a){
		if(a instanceof String){
			String art=(String)a;
			art=art.replaceAll(" ", "_");
			createEntity(art); //the entity derived
			return getResource(NS.URICISP+art);
		}else{//entity is a node String[0:id,1:text]  
			String[] ee=(String[])a;
			 
			return makeNode(ee[0],ee[1]);
			 
		}
	}

	 
	/****************************************************************************************
	 * Further resource methods for CISPACES
	 * @return 
	 * 
	 */
	
	
	public void addExtraPropLiteral(String resource,String proptype,String literal){
	 	Resource node=getResource(resource);
	 	if(!hasProperty(node,proptype)){
   			node.addProperty(prov.createProperty(proptype),prov.createTypedLiteral(literal)); 
	 	} 	 
}	
	public void addExtraPropProperty(String resource,String proptype,String property){
	 	Resource node=getResource(resource);
	 	if(!hasProperty(node,proptype)){
   			node.addProperty(prov.createProperty(proptype),prov.createProperty(property)); 
	 	} 	 
}
	
	
	 private Resource makeNode(String cispid,String text){
		 	String nodeid="Node"+cispid;
		 	createEntity(nodeid);
		 	Resource node=getResource(NS.URICISP+nodeid);
		 	if(!hasProperty(node,NS.CISP+"infText")){
	   			node.addProperty(prov.createProperty(NS.CISP+"infText"),prov.createTypedLiteral(text)); 
		 	}
		 	if(!hasProperty(node,NS.CISP+"nodeID")){
	   			node.addProperty(prov.createProperty(NS.CISP+"nodeID"),prov.createTypedLiteral(cispid)); 
		 	}
		 	if(!hasProperty(node,NS.PROV+"type")){
	   			node.addProperty(prov.createProperty(NS.PROV+"type"),prov.createProperty(NS.CISP + "Node"));
		 	}
		 	 
	   		return node;
	}
	 
	 private Resource makePrimarySource(Resource ent){
		 if(checkType(ent, "Entity")){
		 	if(!hasProperty(ent,NS.PROV + "type")){
		 		ent.addProperty(prov.createProperty(NS.PROV + "type"),prov.createProperty(NS.PROV + "PrimarySource"));
		 	}
		 	
		 }
		 return ent;
	 }
	 public void makePrimarySource(String string) {
			createEntity(string);
			Resource s=getResource(NS.URICISP+string);
			makePrimarySource(s);
		}
	
   private Resource makeAnalyst(String person,String affiliation){
	   	  	person=person.replaceAll(" ", "_");
	   		createAgent(person);
	   		createAgent(affiliation); 
	   		addActedOnBehalfOf(person,affiliation);
	   		Resource analyst=getResource(NS.URICISP+person);
	   		if(!hasProperty(analyst,NS.FOAF + "name")){
	   			analyst.addProperty(prov.createProperty(NS.FOAF + "name"),prov.createTypedLiteral(person));
	   		}
	   		if(!hasProperty(analyst,NS.FOAF + "name")){
	   			analyst.addProperty(prov.createProperty(NS.CISP+"role"),prov.createProperty(NS.CISP+"Analyst"));
	   		}
	   		return analyst;
	}
   
	

	public Resource makeGoal(String g1) {
			 
			createEntity(g1);
			Resource goal=getResource(NS.URICISP+g1);
		
			if(!hasProperty(goal, NS.PROV + "type")){
				goal.addProperty(prov.createProperty(NS.PROV + "type"),prov.createProperty(NS.CISP+"Goal"));
			}
	   		return goal;
	}
	

	private boolean hasProperty(Resource res, String name) {
		// value of a property unique!!
		Property pro=prov.createProperty(name);
		return res.hasProperty(pro);
	}

	
	private Resource makeAnalysis(String analyid,String ayid, String location){
	 	createEntity(analyid);
	 	Resource node=getResource(NS.URICISP+analyid);
	 	if(!hasProperty(node,NS.CISP+"analysisID")){
   			node.addProperty(prov.createProperty(NS.CISP+"analysisID"),prov.createTypedLiteral(ayid)); 
	 	}
	 	if(!hasProperty(node,NS.PROV+"type")){
   			node.addProperty(prov.createProperty(NS.PROV+"type"),prov.createProperty(NS.CISP + "Analysis"));
	 	}
	 	if(location!=null){//location can be many!!!
   			node.addProperty(prov.createProperty(NS.CISP+"location"),prov.createTypedLiteral(location));
	 	}
   		return node;
}

	/****************************************************************************************
	 * Further general methods not implemented in Provenance Bundle
	 * 
	 */
	//Was generated by with TIME qualified Generation
	public void addWasGeneratedBy(Resource a1, Resource p1,String time) {
		 addWasGeneratedBy(a1,p1);//creates already the property was generatedby
		 if(checkType(a1, "Entity"))
		 	{   
			 
			 if(!hasProperty(a1,NS.PROV + "qualifiedGeneration")){
				 a1.addProperty(prov.createProperty(NS.PROV + "qualifiedGeneration"),
					 	 prov.createResource()
                        .addProperty(prov.createProperty(NS.PROV + "atTime"), prov.createTypedLiteral(getCal(time))) 
                        .addProperty(prov.createProperty(NS.PROV + "Activity"), p1));
			 }
			 }
		 
	}
	

	private GregorianCalendar getCal(String date){
		DateTimeFormatter formatter =
		DateTimeFormat.forPattern("dd-MM-yyyy hh:mm:ss").withOffsetParsed().withZoneUTC();
		DateTime dateTime = formatter.parseDateTime(date);
		GregorianCalendar cal = dateTime.toGregorianCalendar();
		return cal;
		
		
	}
	
	/*************************************************************
	 * Reformat modules to add NS.CISP
	 * 
	 */
	
	
	public boolean addActedOnBehalfOf(String agent1, String agent2){
		return super.addActedOnBehalfOf(NS.URICISP+agent1, NS.URICISP+agent2);
	}
	public boolean addUsed(String activity, String entity){
		return super.addUsed(NS.URICISP+activity, NS.URICISP+entity);
	}
	public boolean addWasAssociatedWith(String activity, String agent){
		return super.addWasAssociatedWith(NS.URICISP+activity, NS.URICISP+agent);
	}
	public boolean addWasAttributedTo(String entity, String agent){
		return super.addWasAttributedTo(NS.URICISP+entity, NS.URICISP+agent);
	}
	public boolean addWasDerivedFrom(String entity1, String entity2){
		return super.addWasDerivedFrom(NS.URICISP+entity1, NS.URICISP+entity2);
	}
	public boolean addWasGeneratedBy(String entity, String activity){
		return super.addWasGeneratedBy(NS.URICISP+entity, NS.URICISP+activity);
	}
	public boolean addWasInformedBy(String activity1, String activity2){
		return super.addWasInformedBy(NS.URICISP+activity1, NS.URICISP+activity2);
	}
	
	public String createAgent(String agent){
		return super.createAgent(NS.URICISP+agent);
	}
	
	public String createActivity(String activity){
		return super.createActivity(NS.URICISP+activity);
	}
	public String createEntity(String entity){
		return super.createEntity(NS.URICISP+entity);
	}







	







	


	
	
	
	
	
	
}
