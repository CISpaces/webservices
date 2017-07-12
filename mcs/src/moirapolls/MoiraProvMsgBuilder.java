package moirapolls;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

import com.hp.hpl.jena.graph.TripleBoundary;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelExtract;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StatementTripleBoundary;

import data.Card;
import gaian.MDBQuery;
import gaian.JDBConnect;
import utils.NS;
import utils.PatternExtender;
import utils.TimeExtender;

public class MoiraProvMsgBuilder {
	
	private TimeExtender time;
	private JDBConnect conn;
	private Model model;


	public MoiraProvMsgBuilder(MDBQuery dbq){
		time=new TimeExtender();
		conn=new JDBConnect(dbq);
		model=conn.doQueryDefaultModel();
	}
	
	
	
	
	
	
	



	public void createRespondPattern(ArrayList from, ArrayList to, ArrayList reply_to,String id,String timestamp) {
		//pattern with receive/reply/receive
		//first reply /receive from/to as simple pattern
		PatternExtender prov=formMsgPatternFromTo("Reply_"+id, from, to, id, timestamp);
		
		//now the respond to
		Iterator iter=reply_to.iterator();
		String reply;
		while(iter.hasNext()){
			reply=(String) iter.next();
			prov.makeSimpleInformedPattern(reply,"Reply_"+id, "Receive_"+reply);
		}
		conn.SDBUpdate(prov.getModel());
		
	}

	



public void createInitPattern(ArrayList from, ArrayList to, String id, String timestamp) {
	//pattern with send/receive
	PatternExtender prov=formMsgPatternFromTo("Send_"+id, from, to, id, timestamp);
	 
	conn.SDBUpdate(prov.getModel());
}




public void createQueryPattern(ArrayList from, ArrayList to, String id, String timestamp) {
	PatternExtender prov=formMsgPatternFromTo("Query_"+id, from, to, id, timestamp);
	conn.SDBUpdate(prov.getModel());
	
}


public String[] getProvofQueryCard(Card card, String nodeid, String text) {
	getProvofInfoCard(card, nodeid, text, "Reply_Forward_");
	//here need to add used
	PatternExtender prov = new PatternExtender();
	
	String f_first=((String) card.property_values.is_from.get(0)).replaceAll(" ", "_");
	String timey=time.getDateFromMoira(""+card._created);
	  //  String newid=UUID.randomUUID().toString();
	prov.makeSimpleGenerationPattern(card._id, "Reply_Forward_"+card._id, f_first, timey);
	if(card.property_values.is_from.size()>1)
			prov.addUsersToGenerationExt("Reply_Forward_"+card._id, card.property_values.is_from);
 
	if(!card.property_values.is_in_reply_to.isEmpty()){
		Iterator iter=card.property_values.is_in_reply_to.iterator();
		String to;
 
		while(iter.hasNext()){
			to=(String) iter.next();
			prov.addUsedExt("Reply_Forward_"+card._id, to);
		}
		
	}
	conn.SDBUpdate(prov.getModel());
	//now query dtg and source as per info service and add the top query
	return retrieveProvInfo(nodeid,NS.URICISP+"Node"+nodeid,card._created);
}


public String getProvofInfoCard(Card card, String id, String text) {
	// TODO Auto-generated method stub
	return getProvofInfoCard(card,id,text,"Decide_Forward_");
}



private String getProvofInfoCard(Card card,String nodeid, String text, String activity) {
	//this is not in reply to but it could be forwarded from 
	PatternExtender prov = new PatternExtender();
	String timep=time.getDateFromMoira(card.property_values.timestamp);
	String f_first=((String) card.property_values.is_from.get(0)).replaceAll(" ", "_");
	
	boolean forward=false,sources=false;
	
	if(card.property_values.cispdata.sources!=null && !card.property_values.cispdata.sources.isEmpty()){
		sources=true;
	}
	if(card.property_values.cispdata.forwarded_from!=null){
		forward=true;
	}
	if(sources || forward){
		ArrayList forward_users=new ArrayList();
		
		forward_users.addAll(card.property_values.is_from);
		if(sources){
			
			forward_users.addAll(card.property_values.cispdata.sources);
		}
		String k_user=(String) forward_users.get(0);
		//users sorted!!!
		//now head of generation pattern or not
		k_user=k_user.replaceAll(" ", "_");
		if(forward){
			//head!!
			prov.makeGenerationPattern(card._id, (String)card.property_values.cispdata.forwarded_from, activity+card._id, k_user, timep);
			
	
		}else{
			//no head!!!
			   prov.makeSimpleGenerationPattern(card._id, activity+card._id, k_user, timep);
		}
		
		if(forward_users.size()>1)
			prov.addUsersToGenerationExt(activity+card._id, forward_users);
	
		//System.out.println("DO I COME HERE?");
		
	
	
	}
	
	
	
	
	
	String[] ij=new String[]{nodeid,text};//String[0:id,1:text,2:cispid]  
	String timey=time.getDateFromMoira(""+card._created);
  //  String newid=UUID.randomUUID().toString();
    prov.makeGenerationPattern(ij, card._id, "Process_Send_"+card._id, f_first, timey);
    if(card.property_values.is_from.size()>1)
		prov.addUsersToGenerationExt("Process_Send_"+card._id, card.property_values.is_from);
	conn.SDBUpdate(prov.getModel());
	
	//now extract model!
 
	return getStringProvModel(NS.URICISP+"Node"+nodeid);
}


public String getStringProvModel(String top){
 
	return convertModelToJSon(getProvModel(top));
}

public Model getProvModel(String top){
	//System.out.println("FIRST");
	//model.write(System.out, "N-TRIPLES");
	//System.out.println("SECOND");
	//conn.extractModel(top).write(System.out, "N-TRIPLES");
	return conn.extractModel(top);
}


private String convertModelToJSon(Model model) {
	StringWriter out = new StringWriter();
	model.write(out, "RDF/JSON");
	String result = out.toString();
	try {
			out.close();
	} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}
	return result;
}



private PatternExtender formMsgPatternFromTo(String activity,ArrayList from, ArrayList to, String id, String timestamp) {
	
	PatternExtender prov = new PatternExtender();
	String timep=time.getDateFromMoira(timestamp);
	//first from
	String f_first=((String) from.get(0)).replaceAll(" ", "_");
	prov.makeSimpleGenerationPattern(id, activity, f_first, timep);
	if(from.size()>1)
		prov.addUsersToGenerationExt(activity, from);
	prov.makePrimarySource(id);
	//now to
	String t_first=((String) to.get(0)).replaceAll(" ", "_");
	prov.makeSimpleUsedPattern(id, "Receive_"+id, t_first);
	if(to.size()>1)
		prov.addUsersToGenerationExt("Receive_"+id, to);
	
	prov.addWasInformedPattern("Receive_"+id,activity);
	return prov;
	
}

public String[] retrieveProvInfo(String newid, String top, long timestamp) {
	model=conn.doQueryDefaultModel();
	String[] provinfo=new String[3];
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
				//model.write(System.out,"N-TRIPLES");
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
	  TimeExtender timex=new TimeExtender();
	  
provinfo[1]=timex.getDateFromMoiraCISpace(timestamp);
provinfo[2]=top;
 return provinfo;
}

public void closeOff() {
	conn.closeAndUpload();
	
}









































//{"nodes":[{"input":"INFO","eval":"N/A","dtg":"2015/08/24 08:45:41","commit":"N/A","text":"Message from Forensic reasoner: The blue group is a suspect","source":"Moira2,Forensic_reasoner:msg_11","type":"I","annot":{"conc":{},"prem_assump":{}},"nodeID":"2e9f7274-c0e6-46fe-b321-7c5e8a793556","uncert":"Confirmed"},{"dtg":"2015/08/26 23:39:58","text":"Pro","source":"Moira2","type":"RA","annot":{"id":"N/A"},"nodeID":"0a704ebe-dc70-40ff-bee3-32e54445ca72"}],"edges":[{"toID":"0a704ebe-dc70-40ff-bee3-32e54445ca72","formEdgeID":null,"edgeID":"7363d7bd-b94d-4045-a5e2-58e70f833fc2","fromID":"2e9f7274-c0e6-46fe-b321-7c5e8a793556"},{"toID":"df222a6d-ec6c-4f0c-a424-3cd8bb683e02","formEdgeID":null,"edgeID":"2fededde-9d07-4865-944d-93a3ff1cc661","fromID":"0a704ebe-dc70-40ff-bee3-32e54445ca72"}],"prov":{"_:05cd951c938570bdb82590c9d36ed938":{"http://www.w3.org/ns/prov#atTime":[{"type":"literal","value":"2015-08-24T07:28:21Z","datatype":"http://www.w3.org/2001/XMLSchema#dateTime"}],"http://www.w3.org/ns/prov#Activity":[{"type":"uri","value":"http://www.itacispaces.org/Send_msg_01"}]},"_:21a425a2:14f6c1aba1b:-7f14":{"http://www.w3.org/ns/prov#atTime":[{"type":"literal","value":"2015-08-26T11:39:58Z","datatype":"http://www.w3.org/2001/XMLSchema#dateTime"}],"http://www.w3.org/ns/prov#Activity":[{"type":"uri","value":"http://www.itacispaces.org/MakeAnalysisd49e82e9-829e-459b-aa00-52a6ebf06510"}]},"http://www.itacispaces.org/Node2e9f7274-c0e6-46fe-b321-7c5e8a793556":{"http://www.w3.org/ns/prov#qualifiedGeneration":[{"type":"bnode","value":"_:6aa2dfaab53887dc9e6b5f659b932819"}],"http://www.w3.org/ns/prov#wasGeneratedBy":[{"type":"uri","value":"http://www.itacispaces.org/Process_Send_msg_12"}],"http://www.itacispaces.org/ns#nodeID":[{"type":"literal","value":"2e9f7274-c0e6-46fe-b321-7c5e8a793556","datatype":"http://www.w3.org/2001/XMLSchema#string"}],"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Entity"}],"http://www.itacispaces.org/ns#infText":[{"type":"literal","value":"Message from Forensic reasoner: The blue group is a suspect","datatype":"http://www.w3.org/2001/XMLSchema#string"}],"http://www.w3.org/ns/prov#type":[{"type":"uri","value":"http://www.itacispaces.org/ns#Node"}],"http://www.w3.org/ns/prov#wasDerivedFrom":[{"type":"uri","value":"http://www.itacispaces.org/msg_12"}]},"_:6aa2dfaab53887dc9e6b5f659b932819":{"http://www.w3.org/ns/prov#atTime":[{"type":"literal","value":"2015-08-27T00:38:49Z","datatype":"http://www.w3.org/2001/XMLSchema#dateTime"}],"http://www.w3.org/ns/prov#Activity":[{"type":"uri","value":"http://www.itacispaces.org/Process_Send_msg_12"}]},"http://www.itacispaces.org/Send_msg_01":{"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Activity"}],"http://www.w3.org/ns/prov#wasAssociatedWith":[{"type":"uri","value":"http://www.itacispaces.org/Patrol_1"}]},"_:be77dab0aa46b1895bf97e068f6548db":{"http://www.w3.org/ns/prov#atTime":[{"type":"literal","value":"2015-08-24T07:45:41Z","datatype":"http://www.w3.org/2001/XMLSchema#dateTime"}],"http://www.w3.org/ns/prov#Activity":[{"type":"uri","value":"http://www.itacispaces.org/Reply_Forward_msg_12"}]},"_:b28bd3cfeba28c04fc5bb95ca8c63309":{"http://www.w3.org/ns/prov#atTime":[{"type":"literal","value":"2015-08-24T07:45:41Z","datatype":"http://www.w3.org/2001/XMLSchema#dateTime"}],"http://www.w3.org/ns/prov#Activity":[{"type":"uri","value":"http://www.itacispaces.org/Reply_msg_11"}]},"http://www.itacispaces.org/msg_11":{"http://www.w3.org/ns/prov#qualifiedGeneration":[{"type":"bnode","value":"_:b28bd3cfeba28c04fc5bb95ca8c63309"}],"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Entity"}],"http://www.w3.org/ns/prov#wasGeneratedBy":[{"type":"uri","value":"http://www.itacispaces.org/Reply_msg_11"}],"http://www.w3.org/ns/prov#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#PrimarySource"}]},"http://www.itacispaces.org/msg_10":{"http://www.w3.org/ns/prov#qualifiedGeneration":[{"type":"bnode","value":"_:6aafbbee3fbc4252da9ef7f3a6da3634"}],"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Entity"}],"http://www.w3.org/ns/prov#wasGeneratedBy":[{"type":"uri","value":"http://www.itacispaces.org/Send_msg_10"}],"http://www.w3.org/ns/prov#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#PrimarySource"}]},"http://www.itacispaces.org/Joe":{"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Agent"}]},"http://www.itacispaces.org/Reply_Forward_msg_12":{"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Activity"}],"http://www.w3.org/ns/prov#used":[{"type":"uri","value":"http://www.itacispaces.org/msg_11"},{"type":"uri","value":"http://www.itacispaces.org/msg_01"}],"http://www.w3.org/ns/prov#wasAssociatedWith":[{"type":"uri","value":"http://www.itacispaces.org/Moira2"},{"type":"uri","value":"http://www.itacispaces.org/Forensic_reasoner"}]},"http://www.itacispaces.org/Forensic_reasoner":{"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Agent"}]},"http://www.itacispaces.org/Patrol 2":{"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Agent"}]},"http://www.itacispaces.org/Patrol 1":{"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Agent"}]},"http://www.itacispaces.org/msg_12":{"http://www.w3.org/ns/prov#qualifiedGeneration":[{"type":"bnode","value":"_:be77dab0aa46b1895bf97e068f6548db"}],"http://www.w3.org/ns/prov#wasGeneratedBy":[{"type":"uri","value":"http://www.itacispaces.org/Reply_Forward_msg_12"}],"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Entity"}],"http://www.w3.org/ns/prov#wasDerivedFrom":[{"type":"uri","value":"http://www.itacispaces.org/msg_11"}]},"http://www.itacispaces.org/Moira2":{"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Agent"}]},"http://www.itacispaces.org/Receive_msg_10":{"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Activity"}],"http://www.w3.org/ns/prov#wasInformedBy":[{"type":"uri","value":"http://www.itacispaces.org/Send_msg_10"}],"http://www.w3.org/ns/prov#used":[{"type":"uri","value":"http://www.itacispaces.org/msg_10"}],"http://www.w3.org/ns/prov#wasAssociatedWith":[{"type":"uri","value":"http://www.itacispaces.org/Patrol 1"},{"type":"uri","value":"http://www.itacispaces.org/Patrol 2"},{"type":"uri","value":"http://www.itacispaces.org/Forensic_reasoner"},{"type":"uri","value":"http://www.itacispaces.org/Forensic reasoner"}]},"http://www.itacispaces.org/Moira2Analysisd49e82e9-829e-459b-aa00-52a6ebf06510":{"http://www.itacispaces.org/ns#analysisID":[{"type":"literal","value":"d49e82e9-829e-459b-aa00-52a6ebf06510","datatype":"http://www.w3.org/2001/XMLSchema#string"}],"http://www.w3.org/ns/prov#qualifiedGeneration":[{"type":"bnode","value":"_:21a425a2:14f6c1aba1b:-7f14"}],"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Entity"}],"http://www.w3.org/ns/prov#wasGeneratedBy":[{"type":"uri","value":"http://www.itacispaces.org/MakeAnalysisd49e82e9-829e-459b-aa00-52a6ebf06510"}],"http://www.itacispaces.org/ns#location":[{"type":"literal","value":"Moira2_analysis","datatype":"http://www.w3.org/2001/XMLSchema#string"}],"http://www.itacispaces.org/ns#marker":[{"type":"uri","value":"http://www.itacispaces.org/ns#Last"}],"http://www.w3.org/ns/prov#type":[{"type":"uri","value":"http://www.itacispaces.org/ns#Analysis"}]},"_:6aafbbee3fbc4252da9ef7f3a6da3634":{"http://www.w3.org/ns/prov#atTime":[{"type":"literal","value":"2015-08-24T07:44:01Z","datatype":"http://www.w3.org/2001/XMLSchema#dateTime"}],"http://www.w3.org/ns/prov#Activity":[{"type":"uri","value":"http://www.itacispaces.org/Send_msg_10"}]},"http://www.itacispaces.org/Send_msg_10":{"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Activity"}],"http://www.w3.org/ns/prov#wasAssociatedWith":[{"type":"uri","value":"http://www.itacispaces.org/Moira2"}]},"http://www.itacispaces.org/Forensic reasoner":{"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Agent"}]},"http://www.itacispaces.org/MakeAnalysisd49e82e9-829e-459b-aa00-52a6ebf06510":{"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Activity"}],"http://www.w3.org/ns/prov#used":[{"type":"uri","value":"http://www.itacispaces.org/Node2e9f7274-c0e6-46fe-b321-7c5e8a793556"}],"http://www.w3.org/ns/prov#wasAssociatedWith":[{"type":"uri","value":"http://www.itacispaces.org/Moira2"},{"type":"uri","value":"http://www.itacispaces.org/Joe"}]},"http://www.itacispaces.org/Reply_msg_11":{"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Activity"}],"http://www.w3.org/ns/prov#wasInformedBy":[{"type":"uri","value":"http://www.itacispaces.org/Receive_msg_10"}],"http://www.w3.org/ns/prov#used":[{"type":"uri","value":"http://www.itacispaces.org/msg_10"}],"http://www.w3.org/ns/prov#wasAssociatedWith":[{"type":"uri","value":"http://www.itacispaces.org/Forensic_reasoner"}]},"http://www.itacispaces.org/Patrol_1":{"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Agent"}]},"http://www.itacispaces.org/Process_Send_msg_12":{"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Activity"}],"http://www.w3.org/ns/prov#used":[{"type":"uri","value":"http://www.itacispaces.org/msg_12"}],"http://www.w3.org/ns/prov#wasAssociatedWith":[{"type":"uri","value":"http://www.itacispaces.org/Moira2"}]},"http://www.itacispaces.org/msg_01":{"http://www.w3.org/ns/prov#qualifiedGeneration":[{"type":"bnode","value":"_:05cd951c938570bdb82590c9d36ed938"}],"http://www.w3.org/ns/prov#wasGeneratedBy":[{"type":"uri","value":"http://www.itacispaces.org/Send_msg_01"}],"http://www.w3.org/1999/02/22-rdf-syntax-ns#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#Entity"}],"http://www.w3.org/ns/prov#type":[{"type":"uri","value":"http://www.w3.org/ns/prov#PrimarySource"}]}}}



	
}
