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
 *    All the SPARQL queries and Model modification are handled here 
 *    
 *   
 */


package provscontrol;

 
 

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.logging.Logger;
import obf.Obfuscator;
import utils.NS;
import utils.PatternBuilder;
import utils.TimeHelper;
import com.google.gson.internal.LinkedTreeMap;

import org.apache.jena.graph.TripleBoundary;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelExtract;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.StatementTripleBoundary;

 

public class RDFSQuery {
	protected Obfuscator obtor;
	protected RDFConnect rdc;
	private PatternBuilder prov;
	private static Logger log;
	private TimeHelper timeh;


	public RDFSQuery(String provsize) {
		rdc=new RDFConnect(provsize);
		obtor=new Obfuscator(rdc,provsize);
		 log = Logger.getLogger(getClass().getName());
	     prov = new PatternBuilder();
	     timeh=new TimeHelper();
	}

	
public boolean existsNode(String nodeID) {
	 return rdc.existsNode(nodeID);
	}








public Model readModelfromString(String provst){
	Model model=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
	InputStream input = new ByteArrayInputStream(provst.getBytes());
	model.read(input, null,"JSON-LD");
	model.setNsPrefix("foaf", NS.FOAF);
	model.setNsPrefix("cisp", NS.CISP);
	model.setNsPrefix("prov", NS.PROV);
	model.setNsPrefix("rdf", NS.RDF);
	return model;
}

public void addNodeModel(Model modnd, String nodeid) {
	rdc.UpdateNamedModel(modnd, nodeid);
}


public Model createNewProvNode(String nodeid, String info, String stream, String dtg, String source) {
	String[] ij=new String[]{nodeid,info};//String[0:id,1:text,2:cispid]  
    String timex=timeh.getDateCIS(dtg);
    String timey=timeh.now();
    String newid=UUID.randomUUID().toString();
	prov.makeGenerationPattern(ij, source+"_Report", "Aquiring"+newid, stream, timey);
	prov.makeGenerationPattern(source+"_Report",stream+"_Notif_"+nodeid,   "Reporting"+newid, source, timex);
	prov.makePrimarySource(source+"_Report");
	return prov.getModel();
}


public Model loadModel(String nodeID) {
	Model model=rdc.doQueryNamedModel(nodeID);
	return model;
}

public String getOnSaveResults(String user, ArrayList<String> nodes) {
	 Model modret=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
	 modret.setNsPrefix("foaf", NS.FOAF);
	 modret.setNsPrefix("cisp", NS.CISP);
	 modret.setNsPrefix("prov", NS.PROV);
	 modret.setNsPrefix("rdf", NS.RDF);
		
	 for(String nodeID:nodes){
		// System.out.println(nodeID);
		 Model model=loadModel(nodeID);
		 modret.add(model); 
	 }
	String json=convertModelToJSon(modret);
	return json;
}


private String convertModelToJSon(Model model) {
	StringWriter out = new StringWriter();
	model.write(out, "JSON-LD");
	String result = out.toString();
	try {
			out.close();
	} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}
	return result;
}

public Model createNewCISpacesNode(String nodeID, String source, String info, String time) {
	//get required info
	//now provenance!!
	//System.out.println(info);
	String[] ij=new String[]{nodeID,info};//String[0:id,1:text,2:cispid]  
	String pid=UUID.randomUUID().toString();
    
    //Workaround some buggy cis files that were exported before https://redmine.rsgsoton.net/issues/202 was fixed
    if(time.endsWith(".0")) time = time.substring(0, time.length()-2);                        
    
	prov.makeSimpleGenerationPattern(ij, "CreateNode"+pid, source, timeh.getDateCIS(time));
	Model me=prov.getModel();
	StringWriter out = new StringWriter();
	me.write(out, "JSON-LD");
	return prov.getModel();
	
}
private Model extractModel(String topID, Model model) {
	
	StatementTripleBoundary sb = new StatementTripleBoundary(TripleBoundary.stopNowhere);
	ModelExtract md=new ModelExtract(sb);
	Resource r=model.getResource(topID);
	Model me=md.extract(r, model);   
	me.setNsPrefix("foaf", NS.FOAF);
	me.setNsPrefix("cisp", NS.CISP);
	me.setNsPrefix("prov", NS.PROV);
	me.setNsPrefix("rdf", NS.RDF);
	return me;
}
public ArrayList<String> onLoadFile(ArrayList nodes, String provstring) {
	//also get a list of all the new nodes!
	//read the new model... then adjust the default nodes
	Model model=readModelfromString(provstring);
	//before I upload it select all the nodes!
	String query=NS.PREFIXES+  
			 " SELECT DISTINCT ?node WHERE { "
			  + "?node a prov:Entity."
			  + "?node prov:type cisp:Node."
			 + "}";
	ArrayList array=rdc.executeQLSingle(query,model);
	ArrayList nodelist=(ArrayList) array.clone();
	//System.out.println("THIS IS THE NODE "+nodelist);
   
	//now crossreference nodeid with id of nodes
	ArrayList<String> fails=new ArrayList<String>();
	Iterator iter=nodes.iterator();
	while(iter.hasNext()){
		LinkedTreeMap nd=(LinkedTreeMap)iter.next();
		String nodeID=(String) nd.get("nodeID");
		String type=(String) nd.get("type");
		if(type.equals("I")){
		if(nodelist.contains(NS.URICISP+"Node"+nodeID)){
			//ok add the new model
			Model ndmod=extractModel(NS.URICISP+"Node"+nodeID, model);
			rdc.UpdateNamedModel(ndmod, nodeID);
		}else{
			fails.add(nodeID);
		}
		}
	}
 
	   return fails;

}


public void copyNode(String fromID, String toID) {
	
	Model mod=loadModel(fromID);
	
	String from=convertModelToJSon(mod);
	//System.out.println(from);
	//System.out.println(fromID+":"+toID);
	String to=from.replaceAll(fromID, toID);
	mod=readModelfromString(to);
	rdc.UpdateNamedModel(mod, toID);
}


public String loadProvModel(String nodeID, String user,boolean obf) {
	Model modto=loadModel(nodeID);
	 if(obf){ 
			 modto=obtor.getModelNodes(modto, user);
	 
	}
	 String json=convertModelToJSon(modto);
	 return json;
}


public void saveAndUpload() {
			rdc.closeAndUpload();
}







 
 
}