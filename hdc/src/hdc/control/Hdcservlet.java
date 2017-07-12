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
 * @author      Wentao Ouyang - Alice Toniolo
 * @version     1.0  
 * @since 		September 2014 modified April 2015           
 *   
 */


package hdc.control;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import hdc.crowdinfo.AnswerCI;
import hdc.crowdinfo.FormCI;
import hdc.crowdinfo.HDCCrowdInfo;
import hdc.crowdinfo.ResponseCI;
import hdc.resources.*;

//class-level path
@Path("")
public class Hdcservlet {

	private Gson gson = new Gson();
	private HDCResource hdc; // = new HDCResource();

	String path =null;
	String ci_path= null;
	String ci_host= null;
	String ci_port= null;
	String ci_queries= null;
	String ci_timeout=null;
	String cispaces_path=null;
   //This method is called if HTML is request. It is to test whether the service is running.
   @Context ServletConfig cont;
   @GET
   @Produces(MediaType.TEXT_PLAIN)
   public String sayHello() {
     // find the current working folder//
     File test = new File("abc.txt");
    // System.out.println(test.getAbsolutePath());
     
     
 	ci_path=cont.getInitParameter("ci_path");
	 	ci_port=cont.getInitParameter("ci_port");
	 	ci_host=cont.getInitParameter("ci_host");
	 	ci_queries=cont.getInitParameter("ci_queries");
	 	ci_timeout=cont.getInitParameter("ci_timeout");
	 	
	 	
	 	
	 path=System.getenv("CATALINA_HOME");
     HDCCrowdInfo info=new HDCCrowdInfo(ci_path,ci_host,ci_port, ci_timeout,path);
     try {
		info.updateOverallForm(ci_queries);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     return "Hello, HDC service is running!";
   }

    // input parser
    @Context ServletConfig context;
    @Path("write")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String inputParser(String input) throws IOException, SQLException{
    	path=System.getenv("CATALINA_HOME");
    	//System.out.println("HI"+input);
    	cispaces_path=System.getenv("CISPACES");
    	 
   	 try {  
		  String content = new String(Files.readAllBytes(Paths.get(ci_path+"/code/config/cis_settings.txt")));
		  JsonHelper  jsh=new JsonHelper();
		//  System.out.println(content);
		  HashMap settings=jsh.convertInputMap(content);
		  LinkedTreeMap servers=(LinkedTreeMap) settings.get("Servers");
		  LinkedTreeMap gaian=(LinkedTreeMap) servers.get("GaianDB");

		} catch (Exception e) {
		
		} 	 
	

   	 	
   	 	ci_path=context.getInitParameter("ci_path");
   	 	ci_port=context.getInitParameter("ci_port");
   	 	ci_host=context.getInitParameter("ci_host");
   	 	ci_queries=context.getInitParameter("ci_queries");
   	 	ci_timeout=context.getInitParameter("ci_timeout");
   	 	
   	 	
   	 	//System.out.println(path);
   	 	
   	 	hdc = new HDCResource(path);
   	 
    	JsonParser jp = gson.fromJson(input, JsonParser.class);
    	JsonParser jpp;
    	
    	// store the response
    	String output = null;
    	
    	switch (jp.func) {
    	case "createForm":
			// first convert back to string
			String strJson = gson.toJson(jp.params);
			// then convert to form // check whether it is really a form
			Form form = gson.fromJson(strJson, Form.class);
			// create a form
			output = hdc.createForm(form);
			break;

    	case "terminateForm":
			// first convert back to string
			// then convert to form
			jpp = gson.fromJson(gson.toJson(jp.params), JsonParser.class);
			// terminate a form
			output = hdc.terminateForm(jpp.formID);
			break;
		
    	case "deleteForm":
			// first convert back to string
			// then convert to form
			jpp = gson.fromJson(gson.toJson(jp.params), JsonParser.class);
			// delete a form
			output = hdc.deleteForm(jpp.formID);
			break;
			
    	case "isFormAvailable":
			jpp = gson.fromJson(gson.toJson(jp.params), JsonParser.class);
			// terminate a form
			output = hdc.isFormAvailable(jpp.userID, jpp.userLoc);
			break;
			
    	case "getAvlForms":
			jpp = gson.fromJson(gson.toJson(jp.params), JsonParser.class);
			// get forms
			Form[] forms = hdc.getAvlForms(jpp.userID, jpp.userLoc);
			output = gson.toJson(forms);
			break;
			
    	case "getMyForms":
			jpp = gson.fromJson(gson.toJson(jp.params), JsonParser.class);
			// get forms
			Form[] formsY = hdc.getMyForms(jpp.userID);
			HDCCrowdInfo info=new HDCCrowdInfo(ci_path,ci_host,ci_port, ci_timeout,path);
			FormCI[] formsX=info.getCrowdInfoForms(ci_queries);
			MyTotForms myforms=new MyTotForms(formsY, formsX);
			output = gson.toJson(myforms);
			//output = gson.toJson(formsY);
			break;
			
    	case "getFormByID":
			jpp = gson.fromJson(gson.toJson(jp.params), JsonParser.class);
			// get forms
			//System.out.println(jpp.formID);
			Form form1 = hdc.getFormByID(jpp.formID);
			output = gson.toJson(form1);
			break;
			
    	case "answerForm":
			jpp = gson.fromJson(gson.toJson(jp.params), JsonParser.class);
			//System.out.println(jpp.formID + "," + jpp.userID + jpp.ans);
			output = hdc.answerForm(jpp.formID, jpp.userID, jpp.userLoc, jpp.ans);
			break;
			
    	case "answerFormwTime":
			jpp = gson.fromJson(gson.toJson(jp.params), JsonParser.class);
			//System.out.println(jpp.formID + "," + jpp.userID + jpp.ans);
			output = hdc.answerFormwTime(jpp.formID, jpp.userID, jpp.userLoc, jpp.time, jpp.ans);
    	break;
			
    	case "isFormFinished":
			jpp = gson.fromJson(gson.toJson(jp.params), JsonParser.class);
			output = hdc.isFormFinished(jpp.formID);
			break;
			
    	case "getNumOfAns":
			jpp = gson.fromJson(gson.toJson(jp.params), JsonParser.class);
			output = hdc.getNumOfAns(jpp.formID);
			break;
			
    	case "getRawAns":
			jpp = gson.fromJson(gson.toJson(jp.params), JsonParser.class);
			Answer[] allAns = hdc.getRawAns(jpp.formID);
			output = gson.toJson(allAns);
			break;

    	case "getAggAns":
			jpp = gson.fromJson(gson.toJson(jp.params), JsonParser.class);
			if(hdc.testForm(jpp.formID)){
				AggAnswer allAggAns = hdc.getAggAns(jpp.formID);
				//System.out.println(allAggAns);
				output = gson.toJson(allAggAns);
			}else{
				HDCCrowdInfo infoCI=new HDCCrowdInfo(ci_path,ci_host,ci_port, ci_timeout,path);
				AnswerCI responseCI=infoCI.get(jpp.formID);
				output = gson.toJson(responseCI);
			} 
			break;
			
    	case "dropTable":
			jpp = gson.fromJson(gson.toJson(jp.params), JsonParser.class);
			output = hdc.dropTable(jpp.tableID);
			break;
			
		default:
			Response resp = new Response("Error: No such function.");
			output = gson.toJson(resp);
			break;
    	}
    	//System.out.println("THIS"+output);
    	return output;
    }
    
    
   
     

}
