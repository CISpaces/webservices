package provsimp;
/******************************************************************************
 * This research was sponsored by the U.S. Army Research Laboratory and the
 * U.K. Ministry of Defence under the Biennial Program Plane 2013 (BPP13),
 * Project 6, Task 3: Collaborative Intelligence Analysis.
 * The U.S. and U.K. Governments are authorized to reproduce and distribute
 * reprints for Government purposes notwithstanding any copyright notation
 * hereon.
 * **************************************************************************
 * 
 * This is the interface of the service, GET/POST request handler
 * 
 * 
 * @author      Alice Toniolo  
 * @version     2.0  
 * @since 		July 2017          
 *   
 */

 
 

import javax.servlet.ServletConfig;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


import utils.JsonHelper;


import java.util.logging.Level;
import java.util.logging.Logger;


 

@Path("/ProcProv")
public class ProvSimpServlet {
	private boolean PRINT;
 
	private JsonHelper jsh;
 

	private String prov_size;
	private static Logger log;
	//permit logging PRINT=true verbose this comes form the xml file
	
   public ProvSimpServlet() {
	   log=Logger.getLogger(getClass().getName());
	   org.apache.log4j.BasicConfigurator.configure();
	   org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
	   Logger.getLogger("com.hp.hpl.jena.query").setLevel(Level.OFF);
	   Logger.getLogger("com.hp.hpl.jena").setLevel(Level.OFF);
	   jsh=new JsonHelper();
	}
   
 
// This method is called if APPLICATION_JSON is called: input required a JSON String
//Output another JSON STRING
  @Context
   ServletConfig context;
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String sayJSONtextEvaluate(String input) {

	  log.log(Level.INFO,"*** PROVDATA SERVICE - New Request ***");

	  PRINT=Boolean.parseBoolean(context.getInitParameter("print"));  
	  //set it here because we need to control this!
	  prov_size= context.getInitParameter("provsize");  

	  
	  
	  ProvForkControl provWork=new ProvForkControl(PRINT,prov_size);
	//   System.out.println(input);
	  String output= provWork.evaluateJsonString(input);
	  // System.out.println(output);

	  log.log(Level.INFO,"***  PROVDATA SERVICE - Request Handled ***");
	 
 
 
	  
	  return output;
	 
  }
  
  
  
 
   
  
//This method is called if HTML is request This is just to see whether the service is working
 @GET
 @Produces(MediaType.TEXT_HTML)
 public String sayHtmlHello() {
   return "<html> " + "<title>" + "Hello Service" + "</title>"
       + "<body><h1>" + "Hello ProvData Service available!!!" + "</body></h1>" + "</html> ";
 }

}
