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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import utils.NS;

import com.hp.hpl.jena.graph.TripleBoundary;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelExtract;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StatementTripleBoundary;
import com.hp.hpl.jena.update.UpdateAction;



public class JDBConnect {

	private MDBQuery dbs;
	private HashMap modlist;
	private HashMap rolist;

	public JDBConnect(MDBQuery d) {
		 dbs=d;
		// defModel=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		// namModel=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		 modlist=new HashMap();// I put them here when I acquire their locks
		 rolist=new HashMap(); //I don't have a lock for them but I do not want to query them all the times
	}
	
	public void SDBUpdate(Model prevprov){
		Model tot=doQueryDefaultModel();
		tot.add(prevprov);
		modlist.put("defmodel",tot);
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
		modlist.put(name,null);
	}
	
	

	

	public Model doQueryDefaultModel() {
		Model model = null;
		if(modlist.containsKey("defmodel")){
			return (Model)modlist.get("defmodel");
		}
		while(model==null){
			model=getLockModel(true,null);
		}
		modlist.put("defmodel", model);
		// model.write(System.out,"N-TRIPLES"); 
		//System.out.println("SEPARATE\n\n");
	    return model;
	}
	 
	 
	
	

	 
	
	
	private synchronized Model getLockModel(boolean get,  Model model) {
		 if(get){
			 //get lock
			 //db check lock

			 Model modret=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		 
				 String text=dbs.getModel();
		 
				
				modret.setNsPrefix("foaf", NS.FOAF);
				modret.setNsPrefix("cisp", NS.CISP);
				modret.setNsPrefix("prov", NS.PROV);
				modret.setNsPrefix("rdf", NS.RDF);
				//System.out.println("TEXT"+text+"TEXT!!!");
				 if(text==null){
					return modret;
				 }
				 else{
					 //read model 
					 InputStream input = new ByteArrayInputStream(text.getBytes());
	 
					 modret.read(input, null,"RDF/JSON");
				 }
				 return modret;
		 
			 
			 
		 }else{
			 
			 //get new string json model
			 StringWriter out = new StringWriter();
			 String mod;
			 if(model==null){
				 dbs.insertNullModel();
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
			 dbs.insertModel(mod);
			 }
			//release lock
			 
		 }
		return null;
	}

	
	


  


	


	public void closeAndUpload() {
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
			 getLockModel(false,  model);
			 modlist.remove(key);
		 }
		 modlist.clear();
	}

 
		public Model extractModel(String topID) {
			
			Model model=(Model) modlist.get("defmodel");
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

	 


	 
	 
	 
}
