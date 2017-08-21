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

package obf;



import utils.NS;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Statement;

import database.DBQuery;
import provscontrol.RDFConnect;

public class Obfuscator {
	private RDFConnect obfq;
	private DBQuery dbq;
	public Obfuscator(RDFConnect dbc,String ps){
		obfq=new RDFConnect(ps);
		dbq=new DBQuery(ps);
	}

	 

	 public Model getModelNodes(Model model, String user) {
		if(dbq.isBlackListed(user)){
			//find all primary sources 
			ArrayList array=getPrimarySourceResources(model);
		//	System.out.println(array.toString());
			//now get all statements with these resources
			array=getResources(array,model);
		//	System.out.println(array.toString());
			model.remove(array);
			return model;

		}else{
			return model;
		}
		 
	}
	 
	 
		
private ArrayList getPrimarySourceResources(Model model){
		
		String query=NS.PREFIXES+  
				 " SELECT ?t WHERE { "
				// <http://www.itacispaces.org/BorderObservations> <http://www.w3.org/ns/prov#type> <http://www.w3.org/ns/prov#PrimarySource> .
				  + "?t prov:type <http://www.w3.org/ns/prov#PrimarySource> ."
				 + "}";
	//	StringWriter out = new StringWriter();
	//	model.write(out, "N-TRIPLES");
		//System.out.println(out);
	//	System.out.println(query);
		ArrayList array=obfq.executeQLSingle(query,model); 
//		System.out.println(query);
//		 System.out.println(array.toString());
		 
		return array;
}

private ArrayList getResources(ArrayList array, Model model) {
	 
	Iterator iter=array.iterator();
	String res;
	ArrayList statements=new ArrayList();
	Statement st;
	String subject,predicate,object;
	while(iter.hasNext()){
		res=(String)iter.next();
		String query=NS.PREFIXES+  
				 " SELECT ?p ?o WHERE { "
				// <http://www.itacispaces.org/BorderObservations> <http://www.w3.org/ns/prov#type> <http://www.w3.org/ns/prov#PrimarySource> .
				  + "<"+res+"> ?p ?o ."
				 + "}";
		ArrayList answ=obfq.executeQLMany(query,model);
		Iterator itt=answ.iterator();
		while(itt.hasNext()){
			ArrayList rst=(ArrayList) itt.next();
			subject=res;
			predicate=(String) rst.get(0);
			object=(String) rst.get(1);
			Statement stmt = model.createStatement(model.createResource(subject), model.createProperty(predicate), model.createResource(object));
			statements.add(stmt);
		}
			
	}
	
	return statements;
}
}
