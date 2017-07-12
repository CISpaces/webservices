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

package hdc.resources;

 

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;

import hdc.control.DBConnect;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
public class HDCResource {
	private DBConnect dbconn;
	private FileManager fm = new FileManager();
	private Gson gson = new Gson();
	private Response res = new Response();
	private String pathName = "./data/"; //"E:/Software/oywt/workspace/hdc/data/";

	// First create a DB
	// JDBC driver name and database URL
//	String JDBC_DRIVER; // = "org.apache.derby.jdbc.ClientDriver";  
	//String DB_URL; //  = "jdbc:derby://localhost:6414/gaiandb";
	String TB_Name = "CISPACES_FormStat"; // who created the form and reqs
	String TB_Name2 = "CISPACES_FormAnsUser"; // who answered the forms

	//  Database credentials
//	String USER; // = "gaiandb";
//	String PASS; // = "passw0rd";

//	Statement stmt = null;
	 
	
	// one constructor; provided parameters initialize its fields
    public HDCResource(String path){
    	// initiate db parameters
    	dbconn=new DBConnect();
    	if(path==null){
    		pathName="./data/";
    		// create a folder
        	fm.createFolder("./data");  
    	}else{
    		pathName=path+"/bin/data/";
    		// create a folder
        	fm.createFolder(path+"/bin/data");  
    	}
    	try{
    		createTable();
    	}catch(Exception e){
    		
    	}
    	
    }
//    // method - a task requester creates a new form with several questions
//    public String createForm(String userID, String formID, String title, 
//    	   String description, int limit, String deadline, String crowdLoc, 
//    	   Question[] ques){
//    	// to implement how to store // save the input in a form
//    	// save content in a form
//    	Form form = new Form(userID, formID, title, 
//	    	    description, limit, deadline, crowdLoc, ques);
//    	
//    	// convert form to Json
//    	String formJson = gson.toJson(form);
//    	
//    	// save string in a file
//    	fm.writeToFile(pathName + formID + ".frm", formJson + "\n");
//    	
//    	// also create a table storing form ID, crowdLoc, and form tag

//    	return "success";
//    }
 
    // method - create a table in DB, if the table exists, nothing is executed
    public void createTable(){
  
   
       	 
 
    		            
    	 ///////////////////////////////////////////////////////
    	 // create a table if not exists
//    	 System.out.println("Creating table in given database...");
     
    	
    	 // if the table does not exist
    	 if(!tableExists(TB_Name)){
	  	      	String sql = "CREATE TABLE " + TB_Name + 
	                   " (formID VARCHAR(255) not NULL, " +
	                   " userID VARCHAR(255), " + 
	                   " deadline BIGINT, " + 
	                   " numLimit INTEGER, " + 
	                   " numRemain INTEGER, " +
	                   " crowdLoc VARCHAR(255))"; 
	
	  	      	dbconn.updateSQL(sql);
//	  	      	System.out.println("Created table in given database...");
	    }
    	 
    	 // if the other table does not exist
    	 if(!tableExists(TB_Name2)){
	  	      	String sql = "CREATE TABLE " + TB_Name2 + 
	                   " (formID VARCHAR(255) not NULL, " +
	                   " ansUserID VARCHAR(255))"; 
	
	  	      dbconn.updateSQL(sql);
//	  	      	System.out.println("Created table in given database...");
	    }
	    
    	   
//    		   System.out.println("Goodbye!");
	}
        
    public Boolean tableExists(String sTablename)  {   	 	
    	return dbconn.existTable(sTablename);
    	 
    }
    
    ///////////////////////////////////////////////////////
    // method - drop a table in DB
    public String dropTable(String tableID) throws SQLException{
    	res.setResponse("fail");
    	
    	
       	 // drop when the table exists
       	 if(tableExists(tableID)){
	         String sql = "DROP TABLE " + tableID;
	         dbconn.updateSQL(sql);
       	 }
       	 
         res.setResponse("success");
         
   	   
		return gson.toJson(res);
    }
    
    ///////////////////////////////////////////////////////
    // method - a task requester creates a new form with several questions
    public String createForm(Form form){
    	
    	// first try to create tables in DB
    	 
			createTable();
		  
    	
    	// to implement how to store // save the input in a form
    	// convert form to Json
     
   
      	
    	String formJson = gson.toJson(form);
    	
    	// check whether a form with the same name exists
    	String[] fileNames = fm.getFileNames(pathName, ".frm");
    	if(Arrays.asList(fileNames).contains(form.formID + ".frm")){
    		res.setResponse("A form with the same name already exists. Please use a different formID.");
        	// also create a table storing form ID, crowdLoc, and form tag
    	}
    	else
    	{
//	        java.util.Date date= new java.util.Date();
//	        Timestamp curtime = new Timestamp(date.getTime());
    		
    		// if no time specified, use current system time
    		if (form.createTime == null){
    	     // SimpleDateFormat Class
            SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmm");
            String curTime = sdfDateTime.format(new Date(System.currentTimeMillis()));
	        // set the curTime
            form.createTime = curTime; //.toString();
    		}
    		
	        // update the form since time is created
	        formJson = gson.toJson(form);
	    	// save string in a file
	    	fm.writeToFile(pathName + form.formID + ".frm", formJson + "\n");
	    	
	    	// insert the form content in the DB
	    	 
	    	
	    	// insert record - initially set numRemain = numLimit
	    	// note: you need '' around strings but not around integers
	        String sql = "INSERT INTO " + TB_Name + 
            " VALUES ('" + form.formID + "','" + form.userID + "'," + form.deadline + ","
            + form.limit + "," + form.limit + ",'" + form.crowdLoc +"')";
//	        System.out.println(sql);
	        
	        dbconn.updateSQL(sql);
      		
//      		System.out.println("Inserted record in DB!");
	     
	    	// set response
	    	res.setResponse("success");
    	}
    	return gson.toJson(res);
    }

    ////////////////////////////////////////////////////////////
    // method - the task requester terminates a form
    // once terminated, the form is not available for further query from the crowd
    public String terminateForm(String formID){
    	// read from the form table
  
   	  	   
   	       // update - table FormStat
   	       String sql = "DELETE FROM " + TB_Name + 
   	    		        " WHERE formID = '" + formID + "'";
   	      dbconn.updateSQL(sql);   	 
    	
    	res.setResponse("success");
    	return gson.toJson(res);
    }
    
    // method - delete a form
    public String deleteForm(String formID){
    	// first remove from DB
      
      	 
       	  	   
       	       // update - table FormStat
       	       String sql = "DELETE FROM " + TB_Name + 
       	    		        " WHERE formID = '" + formID + "'";
       	        dbconn.updateSQL(sql);
    	   
    	// second delete from local disc
    	String response = fm.deleteFile(pathName + formID + ".frm");
    	res.setResponse(response);
    	return gson.toJson(res);
    }
    
//    // method - delete all forms of a user
//    public String deleteAllForms(String userID){
////    	String response = fm.deleteFile(pathName + formID + ".frm");
////    	res.setResponse(response);
//    	
//    	return gson.toJson(res);
//    }
    
    // method - a crowd worker checks if any form is available
    public String isFormAvailable(String userID, String userLoc){    	
    	res.setResponse("yes");
    	return gson.toJson(res);
    }
    
    // method - a crowd worker retrieves all the available forms
    // may or may not need to record the userID for the form
    public Form[] getAvlForms(String userID, String userLoc) throws IOException{
       
       List<Form> forms = new ArrayList<Form>();
    	
       
      
 	   
 	   // get current time
 	   SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmm");
 	   String curTime = sdfDateTime.format(new Date(System.currentTimeMillis()));
 	   
 	   // retrieve record
 	   // loc should match a user's loc, remain limit is greater than 0
 	   // not the user's own form
 	   // not the form that the user has answered
 	   // crowdLoc should contain userLoc
 	   String sql = "SELECT formID FROM " + TB_Name
 	    		  + " WHERE crowdLoc LIKE '%" + userLoc + "%' AND userID != '" + userID 
 	    		  + "' AND numRemain > 0 AND deadline > " + "CAST(" + curTime + " AS BIGINT)"
 	    		  +	" AND " + TB_Name + ".formID" +" NOT IN (SELECT " + TB_Name2 + ".formID FROM " + TB_Name2
 	    		  + " WHERE ansUserID = '" + userID + "')";
 	  // System.out.println(sql);
 	   
 	  ArrayList<HashMap<String,Object>> rs = dbconn.execSQL(sql);
 	 //System.out.println(rs);
 	   
       for(HashMap<String,Object> rsm:rs){
           // Retrieve by column name
           String formID  = (String) rsm.get("formid");
           // Display values
//           System.out.print("FormID: " + formID + "\n");
       //    System.out.println(formID);
           // Get the stored form
           String[] content = fm.readFromFile(pathName + formID + ".frm");
           // Add form to the array
           forms.add(gson.fromJson(content[0], Form.class));
        }
 	   
 	  
 	   
    	
//    	// currently simply return all the forms saved under the directory
//    	String[] fileNames = fm.getFileNames(pathName, ".frm");
//    	// read form from file
//    	int nFiles = fileNames.length;
//    	Form[] forms = new Form[nFiles];
//    	int h = 0;
//    	for (String fileName:fileNames)
//    	{	
//    		// read in form
//    		String[] content = fm.readFromFile(pathName + fileName);
//    		// convert to Form obj
//    		forms[h] = gson.fromJson(content[0], Form.class);
//    		h += 1;
//    		
//    	}
 	   
 	    // convert List<Form> to Form[]
 	    Form[] forms2 = new Form[forms.size()];
 	    forms2 = forms.toArray(forms2);
    	return forms2;
    }
    
    ///////////////////////////////////////////
    // method - get a specific form by ID
    public Form getFormByID(String formID) throws IOException{
    //	System.out.println(formID);
    	String[] content = fm.readFromFile(pathName + formID + ".frm");
    	// convert to Form obj
    	Form form = gson.fromJson(content[0], Form.class);
    	return form;
    }
    
    // method - get a specific form by ID
    public String getFormJsonByID(String formID){
    	//System.out.println(formID);
    	String[] content;
		try {
			content = fm.readFromFile(pathName + formID + ".frm");
			return content[0];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    	// convert to Form obj
		return null;
    	
    }
    
    ///////////////////////////////////////////
    // method - get forms of a specific owner
    public Form[] getMyForms(String userID) throws IOException{
       List<Form> forms = new ArrayList<Form>();
    	
    
 
  	   
  	   // retrieve record
  	   String sql = "SELECT formID FROM " + TB_Name
  	    		  + " WHERE userID = '" + userID + "'";
//  	   System.out.println(sql);
  	   
  	 ArrayList<HashMap<String,Object>> rs = dbconn.execSQL(sql);
	  
	   
     for(HashMap<String,Object> rsm:rs){
            // Retrieve by column name
            String formID  = (String) rsm.get("formid");
            // Display values
 //System.out.print("FormID: " + formID + "\n");
            
            // Get the stored form
            String[] content = fm.readFromFile(pathName + formID + ".frm");
            // Add form to the array
            forms.add(gson.fromJson(content[0], Form.class));
         }
  	   
  	   
  	    // convert List<Form> to Form[]
  	    Form[] forms2 = new Form[forms.size()];
  	    forms2 = forms.toArray(forms2);
     	return forms2;
    }
    
    //////////////////////////////////////////////////////////
    // method - get the number of questions of a form
    public int getFormNumOfQues(String formID) throws IOException{
    	String[] content = fm.readFromFile(pathName + formID + ".frm");
    	// convert to Form obj
    	Form form = gson.fromJson(content[0], Form.class);
    	int numOfQues = form.ques.length;
    	
    	return numOfQues;
    }
    
    private HashMap getFormInfo(String formID, int numOfQues) throws IOException {
    	String[] content = fm.readFromFile(pathName + formID + ".frm");
    	// convert to Form obj
    	Form form = gson.fromJson(content[0], Form.class);
    	
    	Question[] quess= form.ques;
    	Question curr;
    	for(int i=0; i < numOfQues; i++){
    		int quePOS=numOfQues-i-1;
    		curr=quess[quePOS];
    		curr.setId(Integer.toString(i));
    	}
    	HashMap map=new HashMap();
    	map.put("ques",quess);
    	map.put("userID",form.userID);
	
		map.put("title",form.title);
		map.put("des",form.des);
		map.put("createTime",form.createTime);
		map.put("nodeId",form.nodeID);
		map.put("crowdloc",form.crowdLoc);
		map.put("supp",form.supp);
		return map;
	}
    
    //////////////////////////////////////////////////////////
    // method - get the type of a question
    private String getFormTypeofQuestion(String formID, int curQueID) throws IOException {
    	String[] content = fm.readFromFile(pathName + formID + ".frm");
    	// convert to Form obj
    	Form form = gson.fromJson(content[0], Form.class);
    	
    	Question[] quess= form.ques;
    	
    	Question ques=quess[curQueID];
    	
    	
    	String type=ques.queType;
    	//System.out.println(type+":"+formID+":"+curQueID);
    	return type;
  	}
    
    //////////////////////////////////////////////////////////
    // method - get the type of support
	private boolean getFormSupport(String formID) throws IOException {
		String[] content = fm.readFromFile(pathName + formID + ".frm");
    	// convert to Form obj
    	Form form = gson.fromJson(content[0], Form.class);
    	boolean support = form.supp;
    	
    	return support;
	}
	 //////////////////////////////////////////////////////////
    // method - get the summary
	
	private String getSummary(String formID, int curQueID) throws IOException {
		String[] content = fm.readFromFile(pathName + formID + ".frm");
    	// convert to Form obj
    	Form form = gson.fromJson(content[0], Form.class);
    	
    	Question[] quess= form.ques;
    	
    	Question ques=quess[curQueID];
    	
    	
    	String type=ques.queType;
    	String summary="";
    	//System.out.println(type+":"+formID+":"+curQueID);
		if(type.equals("Numerical")){
			summary+="("+curQueID+") "+ques.que+" Answers: ";
			summary+="Con ["+ques.Con[0]+","+ques.Con[1]+"], ";
			summary+="Pro ["+ques.Pro[0]+","+ques.Pro[1]+"]";
		}else if(type.equals("MultiChoice")){
			summary+="("+curQueID+") "+ques.que+" Answers:";
			for (int i=0;i<ques.ansOptions.length;i++){
				summary+=" ["+ques.ansOptions[i]+":"+ques.ansValues[i]+"]";
			}
		}
		
		return summary;
	}
    
    ////////////////////////////////////////////////////////
    // method - a crowd worker answers a form
    public String answerForm(String formID, String userID, String userLoc, String[] ans){
    	// to implement how to save data
    	// each answer should be mapped to the corresponding formID and queID
    	// create an Answer object for each answer
    	java.util.Date date= new java.util.Date();
    	Timestamp curtime = new Timestamp(date.getTime());
    	int queID = 0;
    	for (String an:ans)
    	{
    		//create an Answer object for each answer
    		Answer a = new Answer(formID, userID, userLoc, curtime.toString(),
    			      Integer.toString(queID), an);
    		queID += 1;
    		//convert to Json
    		String answerJson = gson.toJson(a);
    		//save to file
    		fm.writeToFile(pathName + formID + ".ans", answerJson + "\n");
    	}

       // update the DB table to reduce numRemain by 1
       // connect to DB and check
      
 
       // update - table FormStat
       String sql = "UPDATE " + TB_Name + 
                    " SET numRemain = numRemain - 1" + 
    		        " WHERE formID = '" + formID + "' AND numRemain > 0";
       dbconn.updateSQL(sql);
       
       // insert - table FormAnsUser
       // cannot insert duplicate rows
       sql = "INSERT INTO " + TB_Name2 + 
               " VALUES ('" + formID + "','" + userID + "')";
//   	   System.out.println(sql);
       dbconn.updateSQL(sql);
       
//       // retrieve and check whether the record is updated
//       sql = "SELECT formID, numRemain FROM " + TB_Name;
//       ResultSet rs = stmt.executeQuery(sql);
//
//       while(rs.next()){
//          //Retrieve by column name
//          String myFormID = rs.getString("formID");
//          int myNumRemain = rs.getInt("numRemain");
//
//          //Display values
//          System.out.print("formID: " + myFormID);
//          System.out.print(", numRemain: " + myNumRemain + "\n");
//       }
//       rs.close();
//       
//       // retrieve and check whether the record is inserted
//       sql = "SELECT formID, ansUserID FROM " + TB_Name2;
//       rs = stmt.executeQuery(sql);
//
//       while(rs.next()){
//          //Retrieve by column name
//          String myFormID = rs.getString("formID");
//          String myUserID = rs.getString("ansUserID");
//
//          //Display values
//          System.out.print("formID: " + myFormID);
//          System.out.print(", userID: " + myUserID + "\n");
//       }
//       rs.close();
  	   
    	res.setResponse("success");
    	return gson.toJson(res);
    }

    ////////////////////////////////////////////////////////
    // method - a crowd worker answers a form
    public String answerFormwTime(String formID, String userID, String userLoc, String time, String[] ans){
    	int queID = 0;
    	for (String an:ans)
    	{
    		//create an Answer object for each answer
    		Answer a = new Answer(formID, userID, userLoc, time,
    			      Integer.toString(queID), an);
    		queID += 1;
    		//convert to Json
    		String answerJson = gson.toJson(a);
    		//save to file
    		fm.writeToFile(pathName + formID + ".ans", answerJson + "\n");
    	}

       // update the DB table to reduce numRemain by 1
       // connect to DB and check
   
      
       // update - table FormStat
       String sql = "UPDATE " + TB_Name + 
                    " SET numRemain = numRemain - 1" + 
    		        " WHERE formID = '" + formID + "' AND numRemain > 0";
       dbconn.updateSQL(sql);
       
       // insert - table FormAnsUser
       // cannot insert duplicate rows
       sql = "INSERT INTO " + TB_Name2 + 
               " VALUES ('" + formID + "','" + userID + "')";
//   	   System.out.println(sql);
   	        
       dbconn.updateSQL(sql);
  	  
    	res.setResponse("success");
    	return gson.toJson(res);
    }
    
    ////////////////////////////////////////////////////////////////
    // method - the task requester checks the status of a form
    public String isFormFinished(String formID){
    	String response = "no";
    	// to implement how to check whether a form is finished
    	// i.e. any of the constraint is satisfied
      
     
   	  	   
   	  	   // retrieve record
   	  	   String sql = "SELECT numRemain, deadline FROM " + TB_Name
   	  	    		  + " WHERE formID = '" + formID + "'";
//   	  	   System.out.println(sql);
   	  	   
   	  	 
   	  	   
   	 	   // get current time
   	 	   SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmm");
   	 	   String curTime = sdfDateTime.format(new Date(System.currentTimeMillis()));
   	  	   
   	 	ArrayList<HashMap<String,Object>> rs = dbconn.execSQL(sql);
   	  
  	   
        for(HashMap<String,Object> rsm:rs){
            // Retrieve by column name
            int numRemain  = (int) rsm.get("numremain");
            Long deadline = (Long) rsm.get("deadline");
            // Display values
//            System.out.print("numRemain: " + numRemain + "\n");
           
            // no available count
            if((numRemain == 0)||deadline < Long.parseLong(curTime)){
            response = "yes";	
            }
         }
  	    
   	  	   
  	   
    	res.setResponse(response);
    	return gson.toJson(res);
    }
    
    // method - the task requester checks the number of answers
    // not the number of people who has provided answers
    public String getNumOfAns(String formID) throws IOException{
    	String fileName = pathName + formID + ".ans";
    	File file = new File(fileName);
    	if(file.exists()){
    	int numOfAnswers = fm.getNumLine(fileName);
    	res.setResponse(Integer.toString(numOfAnswers));
    	} else {
    		res.setResponse("0");
    	}
    	
    	return gson.toJson(res);
    }
    
    // method - the task requester retrieves all the raw answers for a form
    // the answers are in the original format, not aggregated
    public Answer[] getRawAns(String formID) throws IOException{
    	String fileName = pathName + formID + ".ans";
    	File file = new File(fileName);
    	Answer[] answers;
    	if(file.exists()){
   		// read in answers
    		String[] content = fm.readFromFile(fileName);
    		int numContent = content.length;
    		answers = new Answer[numContent];
    		int h = 0;
    		// convert to Answer obj
    		for (String an:content)
    		{
    		answers[h] = gson.fromJson(an, Answer.class);
    		h += 1;
    		}
    	} else {
    		answers = new Answer[1];
    		answers[0] = null;
    	}
		return answers;
    	
    }
    
    // method - the task requester retrieves all the aggregated answers for a form
    public AggAnswer getAggAns(String formID) throws IOException{
    	// first get all the raw answers
    	//first check all the
    	
    	
    	Answer[] allAnswer = getRawAns(formID);
    	AggAnswer allAggAnswer = null;
    
    	if(allAnswer[0]!= null){
    	// then get the number of questions of a form
    	int numOfQues = getFormNumOfQues(formID);
    	boolean support= getFormSupport(formID);
    	ArrayList summary=new ArrayList();
    	// then create a QueStat array
    	QueStat[] queStat = new QueStat[numOfQues];
    	    	
    	// create array to store day and loc
		List<String> dayArray = new ArrayList<String>();
		List<String> locArray = new ArrayList<String>();
		
    	//then iterate over different queIDs
    	int i;
 
    	HashSet locs=new HashSet();
    	HashSet<String> timeid=new HashSet<String>();
    	String randID = null;
    	
    	for(i=0; i < numOfQues; i++){
    		// current queID
    		String curQueID = Integer.toString(i);
    		int quePOS=numOfQues-i-1;
    		String curQueType= getFormTypeofQuestion(formID,quePOS);
    		 
    				
    		// iterate over different answers to retrieve
    		List<String> answerArray = new ArrayList<String>();
    		
    		// max answer length for current que
    		int curMaxAnsLen = 0;
    		//System.out.println("NEW LINE");
    		int count=0;
    		// get all the arrays
    		for(Answer an:allAnswer){
    		//	System.out.println(an+":"+count++);
    	 
    			if (an.queID.equals(curQueID)) {
    		        answerArray.add(an.answer);
    		        
    		        // find the maxAnsLen
    	    		int curAnsLen = an.answer.length();
    	    		if(curAnsLen > curMaxAnsLen)
    	    		{
    	    			curMaxAnsLen = curAnsLen;
    	    		}
    	    		
    		        // calculate stats on day and loc only for the first que
    		        if (an.queID.equals("0")){
    		        dayArray.add(an.time.substring(0,10));
    		        locArray.add(an.userLoc);
    		        locs.add(an.userLoc);
    		        timeid.add(an.time);
    		        randID=an.time;
    		        
    		        }
    			}
    		}
    		Map<String, Integer> hashCount;
    		Map  sortHashCount =null;
    		Map  sortHashRatio =null;
    	
    		if(curQueType.equals("FreeText") || !support){
//    	this is the case where there is no support or it is FreeTEXT for which we cannot do anything else than count
    		//find unique
    			hashCount = getUnique(answerArray.toArray(new String[answerArray.size()]), true);
    		  sortHashCount = sortByValue(hashCount);
    		// convert count to ratio
    		Map<String, Float> hashRatio = countToRatio(sortHashCount);
    		 sortHashRatio = sortByValue(hashRatio);
    		 
    		}else{
    			hashCount = getUnique(answerArray.toArray(new String[answerArray.size()]), false);
    			
    			
    			Map<String, Double> hashExpec= new TreeMap<String, Double>();
    			if(curQueType.equals("Numerical")){
    				
    				// Get a DescriptiveStatistics instance
    				DescriptiveStatistics stats = new DescriptiveStatistics();

    				// Add the data from the array
    			 
    				String key;
    				Integer value;
    				//dirichlet settings
    				double keynumb;
    				 
    				Iterator iter=hashCount.keySet().iterator();
    				while(iter.hasNext()){
    					key=(String) iter.next();
    					value=(Integer) hashCount.get(key);
    					if(!key.equals("1.0E308") && !key.equals("-1.0E308")){
    						try{ 
    						keynumb=Double.parseDouble(key);
    						for( int k = 0; k < value; k++) {
    							stats.addValue(keynumb);
    						}
    					}catch (NumberFormatException e) {
    						
    					}
    					}
    				}
    				 
    				// Compute some statistics
    				double mean = stats.getMean();
    				double std = stats.getStandardDeviation();
    				hashExpec.put("mean",mean);
    				hashExpec.put("std", std);
    				hashExpec.put("right", stats.getMax());
    				hashExpec.put("left", stats.getMin());
    				sortHashCount=hashExpec;
    				sortHashRatio=new TreeMap();
    				 
    			}else if(curQueType.equals("MultiChoice")){
    			
    				//hasCount has key+numbers of time that key comes out with!
    				// I jsut use the calculation not a real dirichlet distribution
    				Iterator iter=hashCount.keySet().iterator();
    			 
    				String key;
    				Integer value;
    				Double exvalue;
    				//dirichlet settings
    				double C=2;
    				double alpha=1/(double)hashCount.size();
    				double totvalues=0;
    				while(iter.hasNext()){
    					key=(String) iter.next();
    					value=(Integer) hashCount.get(key);
    					totvalues+=value;
    				}
    				iter=hashCount.keySet().iterator();
    				while(iter.hasNext()){
    					key=(String) iter.next();
    					value=(Integer) hashCount.get(key);
    			//		System.out.println(value+":"+C+":"+alpha+":"+totvalues);
    		
    					exvalue=(value+C*alpha)/(C+totvalues);
    					hashExpec.put(key, exvalue);
    				}
    				
    				sortHashCount=hashExpec;
    				sortHashRatio=new TreeMap();
    			}
    			summary.add(getSummary(formID,quePOS));
    		}
			// assign values to QueStat
    		queStat[i] = new QueStat(curQueID, curQueType, curMaxAnsLen, sortHashCount, sortHashRatio);
    		
    		
    	}
    	
//    	System.out.println(locArray.size());
    	
    	// find unique
		Map<String, Integer> hashDay = getUnique(dayArray.toArray(new String[dayArray.size()]), false);
		Map<String, Integer> hashLoc = getUnique(locArray.toArray(new String[locArray.size()]), false);
		
//		for (Map.Entry<String, Integer> entry : hashLoc.entrySet()) {
//		    System.out.println(entry.getKey()+" : "+entry.getValue());
//		}
		
		// convert count to ratio
		Map<String, Float> hashRatioDay = countToRatio(hashDay);
		Map<String, Float> hashRatioLoc = countToRatio(hashLoc);
 
 
		HashMap mapForm=getFormInfo(formID,numOfQues);
		Date lastDate=null;
		SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ms");
		try { 
		lastDate= sdfDateTime.parse(randID);
 	    for(String curTime:timeid){
 	     	
 	    	 Date date;
		
				date = sdfDateTime.parse(curTime);
			
             if(date.after(lastDate)){
            	 lastDate=date;
             }
		}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	   String lastTime = sdfDateTime.format(lastDate);
 	   String timestamp = sdfDateTime.format(new Date(System.currentTimeMillis()));
 	  FormAnalysis formAns=new FormAnalysis(
				 formID,  queStat, locs,   (String)mapForm.get("userID"),   (Question[]) mapForm.get("ques"),  numOfQues,
				 (String)mapForm.get("title"), (String)mapForm.get("des"),  (String)mapForm.get("createTime"),   lastTime,  (String)mapForm.get("nodeId"), timestamp,    (String)mapForm.get("crowdloc"),(boolean)mapForm.get("supp"));
 	  	 
		// create an AggAnswer
		if(!support){
			allAggAnswer = new AggAnswer(formID, queStat, hashDay, hashLoc, hashRatioDay, hashRatioLoc,formAns);
		}else{
			allAggAnswer = new AggAnswer(formID, queStat, hashDay, hashLoc, hashRatioDay, hashRatioLoc,summary,formAns);
		}
    	}
    	return allAggAnswer;
    }
    
  
  

	
	
	// method - get the number of unique strings in a string array
    public Map<String, Integer> getUnique(String[] words, Boolean lower){
	 Map<String, Integer> map = new TreeMap<String, Integer>();
	 
	 int lth = words.length;
	 // convert to lower case
	 if(lower){
		 for(int i=0; i< lth; i++)
			 words[i] = words[i].toLowerCase();
	 }
	 
	 // you need to sort the strings first
	 Arrays.sort(words);
//	 for (String w:words)
//		 System.out.println(w);
	 // Specify a broad length
	 String[] unique = new String[lth];
	 int[] times = new int[lth];

	 int i = 0;
	 int j = 0;
	 int count;
	 while (i < lth) {
	     String w = words[i];
	     count = 1;
	     while(++i < lth && words[i].equals(w)) ++count;
	     unique[j] = w;
	     times[j++] = count;
	 }

	 // Reduce the length of the arrays    
	 unique = Arrays.copyOf(unique, j);
	 times  = Arrays.copyOf(times, j);     

	 for (i = 0; i < unique.length;++i){
//	     System.out.println(unique[i] + " " + times[i]);
	     map.put(unique[i],times[i]);
	     }
	 
		return map;
    }
    
    // method - sort the map by values
    @SuppressWarnings({"rawtypes","unchecked"})
	public Map<String, Integer> sortByValue(Map map) {
        List list = new LinkedList(map.entrySet());
        // sort in ascending order
        Collections.sort(list, new Comparator() {
             public int compare(Object o1, Object o2) {
                  return ((Comparable) ((Map.Entry) (o1)).getValue())
                 .compareTo(((Map.Entry) (o2)).getValue());
             }
        });

       // sort in descending order
       Collections.reverse(list);
        
       Map result = new LinkedHashMap();
       for (Iterator it = list.iterator(); it.hasNext();) {
           Map.Entry entry = (Map.Entry)it.next();
           result.put(entry.getKey(), entry.getValue());
       }
       return result;
   }
    
    // method - convert hashCount to hashRatio
    public Map<String, Float> countToRatio(Map<String,Integer> hashCount){	
    	Map<String, Float> hashRatio = new TreeMap<String, Float>();
    	float sum = 0.0f;
    	// sum over all counts
    	for (int f : hashCount.values()) {
    	    sum += f;
    	}
    	
    	// the order of keys in keySet() may be different from your input
    	for (String key: hashCount.keySet()) {
    	    hashRatio.put(key, hashCount.get(key)/sum);
    	}
    	
    	return hashRatio;
    }

	public boolean testForm(String formID) {
	 
    	String formJson;
    	String[] fileNames = fm.getFileNames(pathName, ".frm");
		if(Arrays.asList(fileNames).contains(formID+".frm")){
			formJson = getFormJsonByID(formID);
			if(formJson!=null){
				HashMap form = gson.fromJson(formJson, HashMap.class);
				if(form.containsKey("output_ci")){
					return false;
				}
			}
		}
		return true;
	}

	
}
