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
 * @author      Alice Toniolo  
 * @version     1.0  
 * @since 		August 2015           
 *   
 *    
 */

package moiranodes;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;






import utils.NS;
import utils.PatternBuilder;

import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.update.UpdateAction;

public class ModelConnect {

 
	private Model model;

	public ModelConnect() {
		model=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
	}
	
	 
	
 
 
	public ArrayList executeQLSingle(String query){
		 
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
	
	public ArrayList executeQLMany(String query){
		 
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
	
	
	public void removeQuery(String query){
		 
		UpdateAction.parseExecute( query, model );
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
 
	 

	private Model doQueryNamedModel(String name) {
 
	 
		model.setNsPrefix("prov", NS.PROV);
		model.setNsPrefix("cisp", NS.CISP);
		
		//System.out.println("SEPARATE\n\n");
 
	    return model;
	}
	
 	public Model doQueryDefaultModel() {
 
	 
		model.setNsPrefix("prov", NS.PROV);
		model.setNsPrefix("cisp", NS.CISP);
		// model.write(System.out,"N-TRIPLES"); 
		//System.out.println("SEPARATE\n\n");
 
	    return model;
	}





	public void getAndSetModel(String output) {
		 //this is passed as a json string
		
		InputStream input = new ByteArrayInputStream(output.getBytes());
		model.read(input, null,"RDF/JSON");
		model.setNsPrefix("foaf", NS.FOAF);
		model.setNsPrefix("cisp", NS.CISP);
		model.setNsPrefix("prov", NS.PROV);
		model.setNsPrefix("rdf", NS.RDF);
		//System.out.println("out"+output);
		//model.write(System.out);

	}





	public void UpdateModel(PatternBuilder prov) {
		 Model toAdd=prov.getModel();
		 model.add(toAdd);
		
	}
	
	public void UpdateModel(Model md) {
		 model.add(md);
	}

   public String writeToJson(){
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


	public Model getModel() {
		// TODO Auto-generated method stub
		return model;
	} 
	 
	 
}
