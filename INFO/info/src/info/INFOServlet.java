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
 * @version     1.0  
 * @since 		June 2014           
 *   
 *    
 */



package info;
 
  
import infocontrol.InfoControl;

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

 
 

@Path("/GetInfo")
public class INFOServlet {
	private boolean PRINT=true;
	private int interval=0;
	private static Logger log;
	private JsonHelper jsh;
	private String ci_path;
	private boolean rand_gen=false;
 
   public INFOServlet() {
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
	  log.log(Level.INFO,"*** INFO SERVICE - New Request ***");
	  PRINT=Boolean.parseBoolean(context.getInitParameter("print"));  
	  ci_path=System.getenv("CISPACES");
	  	//first read CISpaces settings
		try {
			
		  String content = new String(Files.readAllBytes(Paths.get(ci_path+"/code/config/cis_settings.txt")));
		  //System.out.println(content);
		  HashMap settings=jsh.convertInputMap(content);
		  LinkedTreeMap servers=(LinkedTreeMap) settings.get("Servers");
		  
		   
		  LinkedTreeMap iss=(LinkedTreeMap) servers.get("ISS");
		  double time=(Double) iss.get("interval"); 
		  interval=(int) Math.round(time);
		   
		  rand_gen=(Boolean) iss.get("randgen"); 
		 
		} catch (Exception e) {
			 try { 
				  // System.out.println("hello2");
			   interval=Integer.parseInt(context.getInitParameter("interval")); 
			   rand_gen=Boolean.parseBoolean(context.getInitParameter("randgen")); 
			   } catch (Exception ex) {
				   interval=5; 
				   rand_gen=true; 
				}
		} 	 
	 
	  if(PRINT){
			 log.log(Level.INFO,input);
		 }
	  //System.out.println(interval);
	  
	  HashMap map=jsh.convertInputMap(input);
	  log.log(Level.INFO,"RANDOM GENERATOR:"+rand_gen);
	  InfoControl infol=new InfoControl(map,interval,rand_gen);
	 
	  
	  output=infol.getInfo();
	  
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
   return "<html> " + "<title>" + "Hello INFO" + "</title>"
       + "<body><h1>" + "Hello INFO available!!!" + "</body></h1>" + "</html> ";
 }
 
 
 

}
