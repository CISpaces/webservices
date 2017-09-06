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

package gaian;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import utils.NS;

import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.update.UpdateAction;



public class JDBConnect {

	private DBQuery dbs;
	private HashMap modlist;
 

	public JDBConnect(DBQuery d) {
		 dbs=d;
		// defModel=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		// namModel=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		 modlist=new HashMap();// I put them here when I acquire their locks
		 
	}
	
	//the idea is that we remove the default model which acts as a bottleneck!!!!
	//and replace with individual default models
	public void SDBUpdateInfoBox(Model prevprov, String name){
		Model tot=doQueryNamedModel(name+"infobox");
		tot.add(prevprov);
		modlist.put(name+"infobox",tot);
	} 
	
	
	
	 private Model doQueryNamedModel(String name) {
			Model model = null;
			if(modlist.containsKey(name)){
				return (Model)modlist.get(name);
			}
			while(model==null){
				model=getThisModel(name,null);
			}
			modlist.put(name, model);
			// model.write(System.out,"N-TRIPLES"); 
			//System.out.println("SEPARATE\n\n");
			
		    return model;
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
	
	
	
	
	

 	public Model doQueryInfoBoxModel(String name) {
 		int count=0;
		Model model = null;
		if(modlist.containsKey(name+"infobox")){
			return (Model)modlist.get(name+"infobox");
		}
		while(model==null){
			
			model=getThisModel(name+"infobox",null);
			count++;
			if(count>100){
				return null;
			}
		}
		modlist.put(name+"infobox", model);
		// model.write(System.out,"N-TRIPLES"); 
		//System.out.println("SEPARATE\n\n");
		
	    return model;
	} 
	 
	 
	
	
	
	
	
	private   Model getThisModel(String name, Model model) {
		 
			 //get lock
			 //db check lock
			
			 Model modret=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
				 String text=dbs.getModel(name);
				
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
	 
					 modret.read(input, null,"RDF/JSON");
					 modret.setNsPrefix("foaf", NS.FOAF);
						modret.setNsPrefix("cisp", NS.CISP);
						modret.setNsPrefix("prov", NS.PROV);
						modret.setNsPrefix("rdf", NS.RDF);
				 }
				 return modret;
	 
		 }
	
	private synchronized boolean getLockModel(String name,Model model){ 
		 //getlock!!!!
		//System.out.println("and here?");
			boolean lock=dbs.checkLock(name);
			 if(!lock){ //ok I can take it now!
				 dbs.setLock(name,1);
			 //get new string json model
			 StringWriter out = new StringWriter();
			 String mod;
			 if(model==null){
				 dbs.insertNullModel(name);
			 }else{
				 
				model.write(out,"RDF/JSON");
				mod = out.toString();
				try {
						out.close();
				} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}
			//System.out.println("LEGNTH:"+mod.length());
			 //then insert in database
				dbs.insertModel(mod,name);
			 }
			 //System.out.println("GET OUT??:");
			 dbs.setLock(name,0);
			 return false;
			 }else{
			
		
				 return true;
			 }
	}

	
	


  


	


	public void closeAndUpload() {
	//	System.out.println("do I get here?"+modlist.keySet());
		 Iterator iter=modlist.keySet().iterator();
		 String key;
		 ArrayList keyset=new ArrayList(); //necessaary as it needs to be removed at the same time as releasing a lock
		 while(iter.hasNext()){
			 keyset.add(iter.next());
		 }
		 
		 iter=keyset.iterator();
		 Model model;
		 while(iter.hasNext()){
			 key=(String) iter.next();
			 model=(Model) modlist.get(key);
			 boolean answer=true;
			 while(answer){
			//	 System.out.println("HEY");
				 try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
			//	 System.out.println(key);
				 
					 answer=getLockModel(key, model);
				 
			  }
			 
			 
		 }
		// System.out.println("END THIS?");
		 modlist.clear();
	}

	public void wipe(String wboxid) {
	//	System.out.println(wboxid);
		Model  model=(Model) modlist.get(wboxid);
		model.removeAll();
		
		 boolean answer=true;
		 while(answer){
			 try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
		
			 answer=getLockModel(wboxid, model);
		  }
		 
		
	}


	 
	 
	 
}
