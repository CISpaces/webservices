package prov;
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


public class NS {

	public static final String FOAF = "http://xmlns.com/foaf/0.1/";
	public static final String URICISP = "http://www.itacispaces.org/";
	public static final String CISP = "http://www.itacispaces.org/ns#";
	public static final String RDF = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
	public static final String PROV = "http://www.w3.org/ns/prov#";
	public static final String XSD="http://www.w3.org/2001/XMLSchema#";
	public static final String PREFIXES = "PREFIX prov:  <"+PROV+">"
			+ " PREFIX cisp: <"+CISP+">"
			+ " PREFIX rdf: <"+RDF+">"
			+ " PREFIX xsd: <"+XSD+">"
			+ " PREFIX foaf: <"+FOAF+">";

}
