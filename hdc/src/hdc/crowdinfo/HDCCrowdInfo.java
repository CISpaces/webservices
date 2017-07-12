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
 * @author       Alice Toniolo
 * @version     1.0  
 * @since 		 April 2015           
 *   
 */

package hdc.crowdinfo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.google.gson.Gson;

 

import hdc.resources.FileManager;




public class HDCCrowdInfo {
	private FileManager fm = new FileManager();
	private Gson gson = new Gson();
	private String pathName = "./data/"; //"E:/Software/oywt/workspace/hdc/data/";
	private String port;
	private String host;
	private String path;
	private int timeout=500;
 
	public HDCCrowdInfo(String ci_path, String ci_host, String ci_port, String ci_timeout,String pathtom) {
		// TODO Auto-generated constructor stub
		if(pathtom==null){
    		pathName="./data/";
    		// create a folder
        	fm.createFolder("./data");  
    	}else{
    		pathName=pathtom+"/bin/data/";
    		// create a folder
        	fm.createFolder(pathtom+"/bin/data");  
    	}
		path=ci_path;
		host=ci_host;
		port=ci_port;
		timeout=Integer.parseInt(ci_timeout);
	}
	
	
	public void updateOverallForm(String locations) throws IOException {
		
		/*6 DB tables (with names as "query_sub", "query_yos", "query_fus", "query_bis", "query_lib" and "query_gym") for storing aggregated information.

You only need to specify the DB name of the target place when querying the server for information, i.e., using HTTP POST with URL as "http://128.97.93.172:80/query"
 and parameter as "db_name=query_sub" (you need to encode characters like _)
		
		*/
		
	
		String[] fileNames = fm.getFileNames(pathName, ".frm");
		String[] couples=locations.split(";");
	 
		FormCI form;
		FormCI[] totforms=new FormCI[couples.length];
		for (int i=0;i<couples.length;i++){
			String[] coup=couples[i].split(":");
			// check whether a form with the same name exists
			String desc=coup[0];
			String query=coup[1];
			String formId=desc+"CrowdInfo";
			form=null;
	    	if(Arrays.asList(fileNames).contains(formId+".frm")){
    		 //read from this! or update
	    		String[] content = fm.readFromFile(pathName +formId+".frm");
	        	// convert to Form obj
	    		//System.out.println(content[0]);
	    		form = gson.fromJson(content[0], FormCI.class);
    		}
	    	else
	    	{
    		
//	        //they were never read!!! 
    	     // SimpleDateFormat Class
            SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmm");
            String curTime = sdfDateTime.format(new Date(System.currentTimeMillis()));
	        // set the curTime
            String title="People at "+desc;
            form=new FormCI(formId,curTime,title,query);
	        // update the form since time is created
	        String formJson = gson.toJson(form);
	    	// save string in a file
	    	fm.writeToFileAndClear(pathName + formId +".frm", formJson + "\n");
	    	//now update the readings 
	    	
    	}
	    	form=updateForm(query, form, formId);
		}
	    	
	}

	public FormCI[] getCrowdInfoForms(String locations) throws IOException {
		
		/*6 DB tables (with names as "query_sub", "query_yos", "query_fus", "query_bis", "query_lib" and "query_gym") for storing aggregated information.

You only need to specify the DB name of the target place when querying the server for information, i.e., using HTTP POST with URL as "http://128.97.93.172:80/query"
 and parameter as "db_name=query_sub" (you need to encode characters like _)
		
		*/
		
	
		String[] fileNames = fm.getFileNames(pathName, ".frm");
		String[] couples=locations.split(";");
	 
		FormCI form;
		FormCI[] totforms=new FormCI[couples.length];
		for (int i=0;i<couples.length;i++){
			String[] coup=couples[i].split(":");
			// check whether a form with the same name exists
			String desc=coup[0];
			String query=coup[1];
			String formId=desc+"CrowdInfo";
			form=null;
	    	if(Arrays.asList(fileNames).contains(formId+".frm")){
    		 //read from this! or update
	    		String[] content = fm.readFromFile(pathName +formId+".frm");
	        	// convert to Form obj
	    		form = gson.fromJson(content[0], FormCI.class);
    		}
	    	else
	    	{
    		
//	        //they were never read!!! 
    	     // SimpleDateFormat Class
            SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmm");
            String curTime = sdfDateTime.format(new Date(System.currentTimeMillis()));
	        // set the curTime
            String title="People at "+desc;
            form=new FormCI(formId,curTime,title,query);
	        // update the form since time is created
	        String formJson = gson.toJson(form);
	    	// save string in a file
	    	fm.writeToFileAndClear(pathName + formId +".frm", formJson + "\n");
	    	//now update the readings 
	    	
    	}
	    	//form=updateForm(query, form, formId);
	    	
	    	try {
				FormCI copy=(FormCI) form.clone();
				copy.output_ci=null;
				
		    	totforms[i]=copy;
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
	    	
	    	
	    	 
	}
		
		
		return totforms;
	}
	
	
	
	
	public FormCI updateForm(String query, FormCI form, String formId){

    	/*
    	 * <updated_at>,<est>,<dev>,<n_report>

updated_at: the time the estimate is updated
est: the aggregated estimate
dev: the deviation of the aggregated estimate
n_report: the number of reports used to derive the aggregated estimate
2015-03-04 12:59:29,80,0.0,1
    	 */
		HserviceClient hsc=new HserviceClient(false);
		String response=hsc.ConnectToEvaluate(query, port, host, path, timeout);
    	//now if not null convert to responseCI otherwise read what is already there
  
    	if(response!=null){
    		try{
    	//System.out.println(response);
    		 
    		ResponseCI[] resp=  gson.fromJson(response, ResponseCI[].class);
    		
    		
    		//now update existing
    		
    		form.output_ci=resp;
    		String formJson = gson.toJson(form);
	    	// save string in a file
	    	fm.writeToFileAndClear(pathName + formId +".frm", formJson + "\n");	
	    	
    	}catch(Exception e){
    		
    	}
    	}
		
		
		return form;
		
	}

	public AnswerCI get(String formId) throws IOException {
		String[] fileNames = fm.getFileNames(pathName, ".frm");
		if(Arrays.asList(fileNames).contains(formId+".frm")){
   		 //read from this! or update
	    		String[] content = fm.readFromFile(pathName +formId+".frm");
	        	// convert to Form obj
	    		FormCI form = gson.fromJson(content[0], FormCI.class);
	    		form=updateForm(form.query,form,formId);
	    		AnswerCI ci=new AnswerCI(form.title,form.formID);
	    		if(form.output_ci!=null && form.output_ci.length>0){
	    		ci.addOutput(form.output_ci);
	    		}
	    		return ci;	
   		}
		return null;
	}

 
}
