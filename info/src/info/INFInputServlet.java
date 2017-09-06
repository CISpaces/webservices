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
 * It handles posts for new information
 * 
 * 
 * @author      Alice Toniolo  
 * @version     1.0  
 * @since 		June 2015           
 *   
 *    
 */



package info;
 

 


import infocontrol.InfoInput;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.internal.LinkedTreeMap;

import utils.JsonHelper;

 
 

@Path("/PostInfo")
public class INFInputServlet {
	private boolean PRINT=true;
 
	private static Logger log;
	private JsonHelper jsh;

 
 
   public INFInputServlet() {
	   log=Logger.getLogger(getClass().getName());
	    jsh=new JsonHelper();
	   org.apache.log4j.BasicConfigurator.configure();
	   org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
	   Logger.getLogger("com.hp.hpl.jena.query").setLevel(Level.OFF);
	   Logger.getLogger("com.hp.hpl.jena").setLevel(Level.OFF);
	  
	}
   
 
   
// This method is called if APPLICATION_JSON is called: input required a JSON String
//Output another JSON STRING
   @Context ServletConfig context;

   
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  
  public String sayJSONtextEvaluate(String input) {
	  String output="";
	  log.log(Level.INFO,"*** INFO INPUT SERVICE - New Post ***");
	  PRINT=Boolean.parseBoolean(context.getInitParameter("print"));  
 
	  	//first read CISpaces settings
	  
		
	 
	  if(PRINT){
			 log.log(Level.INFO,input);
		 }
	//  System.out.println(input);
	  
	  HashMap map=jsh.convertInputMap(input);
	  
	  InfoInput infol=new InfoInput();
	 
	  
	  output=infol.postInfo(map);
	  
	  log.log(Level.INFO,"*** INFO SERVICE - Request Handled ***");
	  if(PRINT){
			 log.log(Level.INFO,output);
		 }
	  
	  //here stop database
	  infol.closeDataBase();

	  return output;
	 
  }
  

   
   
//This method is called if HTML is request This is just to see whether the service is working
 @GET
 @Produces(MediaType.TEXT_HTML)
 public String sayHtmlHello() {
   return "<html> " + "<title>" + "Hello INFO INPUT" + "</title>"
       + "<body><h1>" + "Hello INFO INPUT available!!!" + "</body></h1>" + "</html> ";
 }
 
 
 
 
 

}
