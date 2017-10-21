package ers; /******************************************************************************
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
 * @since 		April 2014           
 *   
 */




import com.google.gson.internal.LinkedTreeMap;
import csnodes.ERSCSBuilder;
import nlg.TemplateLanguage;
import org.json.JSONException;
import org.json.JSONObject;
import utils.JsonHelper;

import javax.servlet.ServletConfig;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * POST request for Entity Reasoning and NLG
 * @param graph JSON String and action:eval/nlg. Eval action evaluates the graph and NLG generates the Report
 * @return a response giving information about the hypothesis, colours and chunks of subgroups in the graph. If it fails, it returns the error.
 * URL: http://localhost:8080/ERS/rest/writeRules
 */

@Path("/WriteRules")
public class ERSServlet {
	private boolean PRINT;
	private final String PRB1="Sorry, the input was corrupted, please try again.";
	private final String PRB2="Sorry, there is no action in your input, please try again.";
	private final String PRB3="Sorry, action not recognised, please try again.";
	private static Logger log;
	private String ci_path;

	private JsonHelper jsh;
	
   public ERSServlet() {
	   log=Logger.getLogger(getClass().getName());

	}
 
// This method is called if APPLICATION_JSON is called: input required a JSON String
//Output another JSON STRING
  @Context
   ServletConfig servletConfig;


  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String sayJSONtextEvaluate(String input) {
	  System.out.println(input);
	// System.out.println("*** ERS SERVICE - New Request ***"+input);
	  log.log(Level.INFO,"*** ERS SERVICE - New Request ***");
	  
	  PRINT=Boolean.parseBoolean(servletConfig.getInitParameter("print"));  

	  ci_path=System.getenv("CISPACES");
	  if(PRINT){
			 log.log(Level.INFO,input);
		 }
	  
	  //changes for NLG now we have action field
	  jsh=new JsonHelper();
	  String output = null;
	  HashMap map=jsh.convertInputMap(input);
		if(map.isEmpty()){
			output=setSomethingWrongResponse(PRB1);
		}else{
			if(map.containsKey("action")){
				String action=(String) map.get("action");
				if(action.equals("eval")){
					 ERSControl ersWork=new ERSControl(PRINT,ci_path);
					 LinkedTreeMap mgraph=(LinkedTreeMap) map.get("graph");
					log.log(Level.INFO,"*** ERS SERVICE - EVALUATING JSON OF GRAPH***");
					 output= ersWork.evaluateJsonString(mgraph);
					log.log(Level.INFO,"*** ERS SERVICE - IF I COME HERE THEN IT'S WORKING***");
				}else if(action.equals("csanaly")){
						ERSCSBuilder build=new ERSCSBuilder(map);
						HashMap res=build.prepareCS();
						output=jsh.convertInputJson(res);
				}else if(action.equals("nlg")){
					ERSControl ersWork=new ERSControl(PRINT,ci_path);
					 LinkedTreeMap mgraphtoeval=(LinkedTreeMap) map.get("graph");
					String evaluated = ersWork.evaluateJsonString(mgraphtoeval);
					log.log(Level.INFO,evaluated);
					String mgraph=map.get("graph").toString();
					try {
						log.log(Level.INFO, "nlg service accessed");
						JSONObject jsonObject = new JSONObject(input);
						String jsonIn = jsonObject.get("graph").toString();
						TemplateLanguage templateLanguage = new TemplateLanguage();
						output = templateLanguage.createMinimalInfereanceTemplate(jsonIn);
					} catch (JSONException e) {
						e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }else{
					output=setSomethingWrongResponse(PRB3);
				}
				
			}else{
				output=setSomethingWrongResponse(PRB2);
			}
			
			
		
		}
	  
	//  System.out.println("*** ERS SERVICE - Request Handled ***");
	  log.log(Level.INFO,"*** ERS SERVICE - Request Handled ***");
	  if(PRINT){
			 log.log(Level.INFO,output);
		 }
	  System.out.println(output);
	  return output;
	 
  }
  
private String setSomethingWrongResponse(String string) {
	 
		HashMap map=new HashMap();
		map.put("fail",true);
		map.put("cause",string);
		String ersResponse=jsh.convertInputJson(map);
		return ersResponse;
}

//This method is called if HTML is request This is just to see whether the service is working
 @GET
 @Produces(MediaType.TEXT_HTML)
 public String sayHtmlHello() {
   return "<html> " + "<title>" + "Hello ERS" + "</title>"
       + "<body><h1>" + "Hello ERS available!!!" + "</body></h1>" + "</html> ";
 }

}
