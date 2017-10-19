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
 *  This handled the conversion between Strings from DB to Models of RDF data
 * 
 */

package provscontrol;

 
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import utils.NS;

import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateAction;

import database.DBQuery;



public class RDFConnect {

	private DBQuery dbq;
	private HashMap modlist; //modlist keeps a copy of the model in case I need to work with it many times
 

	public RDFConnect(String provsize) {
		 dbq=new DBQuery(provsize);
		 modlist=new HashMap();
	}
	

	public boolean existsNode(String nodeID) {
		if(modlist.containsKey(nodeID)){
			return true;
		}
		return dbq.existNode(nodeID);
	}
 
	 
	
	public void UpdateNamedModel(Model model,String name){
		Model tot=doQueryNamedModel(name);
		tot.add(model);
		modlist.put(name,tot);
	}
	 


	public ArrayList executeQLSingle(String query,Model model){
		 
		QueryExecution queryExecution = QueryExecutionFactory.create(query,model);
		ResultSet results = queryExecution.execSelect();
		List<String> resultVars = results.getResultVars();
		String variable = resultVars.get(0);
		ArrayList resultsStrs = new ArrayList();
	   
		while (results.hasNext()){
			QuerySolution qs = results.next();
			resultsStrs.add(getNodeStrValue(qs.get(variable)));
		}
	 
		return resultsStrs;
		  
	}
	
	public ArrayList executeQLMany(String query,Model model){
		 
		QueryExecution queryExecution = QueryExecutionFactory.create(query,model);
		ResultSet results = queryExecution.execSelect();
		List<String> resultVars = results.getResultVars();
		String variable;
		int vars=resultVars.size();
		ArrayList resultsStrs = new ArrayList();
		ArrayList resultRow;
		while (results.hasNext()){
			resultRow=new ArrayList();
			QuerySolution qs = results.next();
			for(int i=0;i<vars;i++){
				variable = resultVars.get(i);
				resultRow.add(getNodeStrValue(qs.get(variable)));
			}
			resultsStrs.add(resultRow);
		}
	 
		return resultsStrs;
		  
	}
	 
	private String getNodeStrValue(RDFNode rdfNode) {
		if (rdfNode.isURIResource()){
			return rdfNode.asResource().getURI();
		} else if (rdfNode.isResource()){
			return rdfNode.asResource().getURI();
		} else if (rdfNode.isLiteral()){
			return rdfNode.asLiteral().getValue().toString();
		} else if (rdfNode.isAnon()){
			return rdfNode.toString();
		}
		
		return null;
	}
 

	
	public void removeQuery(String query,Model model){
		 
		UpdateAction.parseExecute( query, model );
	}
	
	
	public void removeNamedModel(String name) {
		modlist.remove(name,null);
	}
	
	
	 public Model doQueryNamedModel(String name) {
		Model model = null;
		if(modlist.containsKey(name)){
			return (Model)modlist.get(name);
		}
		model=getThisModel(name,null); //return model
		modlist.put(name, model);
	    return model;
	}
	
	private   Model getThisModel(String name, Model model) {
		 
			 //get lock
			 //db check lock
			
			 Model modret=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
				 String text=dbq.getModel(name);
				
				//System.out.println("TEXT"+text+"TEXT!!!");
				 if(text==null){
					 modret.setNsPrefix("foaf", NS.FOAF);
						modret.setNsPrefix("cisp", NS.CISP);
						modret.setNsPrefix("prov", NS.PROV);
						modret.setNsPrefix("rdf", NS.RDF);
					return modret;
				 }
				 else{
					 //read model 
					 InputStream input = new ByteArrayInputStream(text.getBytes());
	 
					 modret.read(input, null,"JSON-LD");
					 modret.setNsPrefix("foaf", NS.FOAF);
						modret.setNsPrefix("cisp", NS.CISP);
						modret.setNsPrefix("prov", NS.PROV);
						modret.setNsPrefix("rdf", NS.RDF);
				 }
				 return modret;
	 
		 }
	

	public void closeAndUpload() {
		//System.out.println("do I get here?"+modlist.keySet());
		 Iterator iter=modlist.keySet().iterator();
		 String key;
		 while(iter.hasNext()){
			 
			 key=(String) iter.next();
			 Model model=(Model) modlist.get(key);
			 insertModel(key, model); 
		 }
		// System.out.println("END THIS?");
		 modlist.clear();
	}
	
	private void insertModel(String name,Model model){ 
		  	 
			 StringWriter out = new StringWriter();
			 String mod;
			 if(model!=null){
				model.write(out,"JSON-LD");
				mod = out.toString();
				mod=mod.replaceAll("\n", "");
				//mod=mod.replaceAll(" ", "");
				try {
						out.close();
				} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}
				//System.out.println("How many times");
				dbq.insertModel(mod,name);
			 }
	}

	
	


	 
}
