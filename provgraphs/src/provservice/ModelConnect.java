
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


import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;




import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateAction;

public class ModelConnect {

 
	private Model model;

	public ModelConnect() {
		model=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
	}
	
	 
	
 
 
	public ArrayList executeQLSingle(String query){
		// System.out.println(query);
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
 
	 

	public Model doQueryNamedModel(String name) {
 
	 
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
		model.read(input, null,"JSON-LD");
		model.setNsPrefix("foaf", NS.FOAF);
		model.setNsPrefix("cisp", NS.CISP);
		model.setNsPrefix("prov", NS.PROV);
		model.setNsPrefix("rdf", NS.RDF);
		//System.out.println("out"+output);
		//model.write(System.out);
      // print();
	}





	public void print() {
		model.write(System.out,"N-TRIPLES");
	/*	 try {
				BufferedWriter out = new BufferedWriter(new FileWriter("/Library/apache-tomcat-7.0.56/bin/hgisadfbvufosaseo.txt"));
				model.write(out,"N-TRIPLES");
				out.close();
			} catch (IOException e) {
				 System.out.println("WHAT?"+e);
			}
		 
		*/
	} 
	 
	 
}
