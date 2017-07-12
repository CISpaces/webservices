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

import java.util.HashSet;

 

public class FormAnalysis {

	public String formID = null;
	
	public HashSet locations;
		public String crowdloc;
	public HashSet algorithm=null;
	public String userID = null;
	
	public Question[] ques = null;
	public int nQues = 0;
	public QueStat[] queStat = null; 
	
	public String title = null;
	public String des = null;
	public String createTime = null;
	public String lastTime = null;
	
	
	public String nodeID=null;
	public String timestamp;//now
	public boolean supp;

	
	
	
	
	public FormAnalysis(){
	}
	
 
	
	public FormAnalysis(String formID, QueStat[] queStat,HashSet locs, String userID, Question[] ques,int nQues,
			String title,String des,String createTime, String lastTime,String nodeId,String timestamp, String crowdloc,boolean supp){
		
		this.formID = formID;
		this.queStat = queStat;
		this.locations = locs;
		this.userID =userID;
		this.ques=ques;
		this.nQues=nQues;
		this.title=title;
		this.des=des;
		this.createTime=createTime;
		this.lastTime=lastTime;
		this.nodeID=nodeId;
		this.timestamp=timestamp;
		this.crowdloc=crowdloc;
		this.supp=supp;
 
		
	 
	}



}
