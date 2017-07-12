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
 * @author      Wentao Ouyang  
 * @version     1.0  
 * @since 		September 2014           
 *   
 */

package hdc.resources;

public class Form {

	public String userID = null;
	public String formID = null;
	public String title = null;
	public String des = null;
	public int limit = 0;
	public String createTime = null;
	public String deadline = null;
	public String crowdLoc = null;
	public int flag = 1; // if tag is 0, the form is no longer available
	public int nQues = 0;
	public Question[] ques = null;
	public boolean supp =false;
	public String nodeID="";
 
	public Form(){
 
	}
	
	public Form(String userID, String formID, String title, 
	    	    String des, int limit, String deadline, String crowdLoc, Question[] ques, boolean supp){
	this.userID = userID;
	this.formID = formID;
	this.title = title;
	this.des = des;
	this.limit = limit;
	this.deadline = deadline;
	this.crowdLoc = crowdLoc;
	this.ques = ques;
	this.supp =supp;
 
	}
	
	public Form(String userID, String formID, String title, String createTime, 
    	    String des, int limit, String deadline, String crowdLoc, Question[] ques,boolean supp){
	this.userID = userID;
	this.formID = formID;
	this.title = title;
	this.createTime = createTime;
	this.des = des;
	this.limit = limit;
	this.deadline = deadline;
	this.crowdLoc = crowdLoc;
	this.ques = ques;
	this.supp =supp;
 
	}
	
	public Form(String userID, String formID, String title, 
    	    String des, int limit, String deadline, String crowdLoc, Question[] ques, boolean supp, String nodeID){
this.userID = userID;
this.formID = formID;
this.title = title;
this.des = des;
this.limit = limit;
this.deadline = deadline;
this.crowdLoc = crowdLoc;
this.ques = ques;
this.supp =supp;
this.nodeID = nodeID;
 
}

public Form(String userID, String formID, String title, String createTime, 
	    String des, int limit, String deadline, String crowdLoc, Question[] ques,boolean supp, String nodeID){
this.userID = userID;
this.formID = formID;
this.title = title;
this.createTime = createTime;
this.des = des;
this.limit = limit;
this.deadline = deadline;
this.crowdLoc = crowdLoc;
this.ques = ques;
this.supp =supp;
this.nodeID=nodeID;
 
}
	
	public void setNQues(int num){
		this.nQues = num;
	}
}
