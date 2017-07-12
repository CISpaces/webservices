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



package mcs;
 
  
 

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

import moiranodes.MoiraPostControl;
import utils.JsonHelper;

 
 

@Path("/AskMoira")
public class MCSServlet {
	private boolean PRINT=false;
 
	private static Logger log;
	private JsonHelper jsh;
	 
	private String ci_path;
	 private String m_host;
	 private int m_port; 
	 private String m_tell;
 
 
   public MCSServlet() {
	   log=Logger.getLogger(getClass().getName());
	    jsh=new JsonHelper();
	}
   
 
   
// This method is called if APPLICATION_JSON is called: input required a JSON String
//Output another JSON STRING
   @Context ServletConfig context;

private String m_ask;

private String moira_name;

   
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  
  public String sayJSONtextEvaluate(String input) {
	  String output="";
	//  System.out.println(input);
	  log.log(Level.INFO,"*** MCS SERVICE - New Request ***");
	  PRINT=Boolean.parseBoolean(context.getInitParameter("print"));  
	  ci_path=System.getenv("CISPACES");
	  	//first read CISpaces settings
		try {
			
		  String content = new String(Files.readAllBytes(Paths.get(ci_path+"/code/config/cis_settings.txt")));
		  //System.out.println(content);
		  HashMap settings=jsh.convertInputMap(content);
		  LinkedTreeMap servers=(LinkedTreeMap) settings.get("Servers");
		  LinkedTreeMap gaian=(LinkedTreeMap) servers.get("GaianDB");
		  
		 	  
		  LinkedTreeMap mcs=(LinkedTreeMap) servers.get("MCS");
 		  m_host=(String) mcs.get("moira_host_name"); 
 		  m_port=(int)Math.round((Double) mcs.get("moira_port")); 
  		  m_tell=(String) mcs.get("moira_posts");
  		  m_ask=(String) mcs.get("moira_cards");
  		  moira_name=(String) mcs.get("moira_name");
		} catch (Exception e) {
		
		} 	 
		
	  if(!test()){
		  //else read web.xml
	   try { 
		  // System.out.println("hello2");
	   
		  m_host=context.getInitParameter("moira_host_name"); 
		  m_port=Integer.parseInt(context.getInitParameter("moira_port")); 
		  m_tell=context.getInitParameter("moira_posts");
		  m_ask=context.getInitParameter("moira_cards");
		  moira_name=context.getInitParameter("moira_name");
	   } catch (Exception e) {
			
		} 
	  }
	  if(!test()){
		 // System.out.println("hello3");
		  //else set default
		 
		   m_host="localhost";
		   m_port=8080;
		   m_tell="/CeStoreWeb/sentences";
		   m_ask="/CeStoreWeb/concepts/card/instances?showStats=true";
		   moira_name="Moira2";
	  }
	  if(PRINT){
			 log.log(Level.INFO,input);
		 }
	  //System.out.println(interval);
	  
	  HashMap map=jsh.convertInputMap(input);
 
	  MoiraPostControl mcontr=new MoiraPostControl( m_host,m_port,m_tell,m_ask,PRINT,moira_name);
	  HashMap result= mcontr.post(map);
	  
	  output=jsh.convertInputJson(result);
	  
	  log.log(Level.INFO,"*** MCS SERVICE - Request Handled ***");
	  if(PRINT){
			 log.log(Level.INFO,output);
		 }

	  return output;
	 
  }
  
  private boolean test(){
	  if(  m_tell==null || m_ask==null || m_host==null || moira_name==null) 
		  return false;
	  return true;
  }
   
   
//This method is called if HTML is request This is just to see whether the service is working
 @GET
 @Produces(MediaType.TEXT_HTML)
 public String sayHtmlHello() {
   return "<html> " + "<title>" + "Hello INFO" + "</title>"
       + "<body><h1>" + "Hello MCS available!!!" + "</body></h1>" + "</html> ";
 }
 
 
 

}
