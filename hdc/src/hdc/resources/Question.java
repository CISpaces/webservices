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

public class Question {

	public String queType = null;
	public String que = null;
	public String[] ansOptions = null;
	public String srcUrl = null; // this is provided by the task requester
	public String[] ansValues = null;
	public double[] Con;
	public double[] Pro;
	public String queID;
	
	public Question(){
	
	}
	
	public Question(String queType, String que){
		this.queType = queType;
		this.que = que;
	}
	
	public Question(String queType, String que, String srcUrl){
		this.queType = queType;
		this.que = que;
		this.srcUrl = srcUrl;
	}
	
	
	
	public Question(String queType, String que, String[] ansOptions){
		this.queType = queType;
		this.que = que;
		this.ansOptions = ansOptions;
	}

	public Question(String queType, String que, String[] ansOptions, String srcUrl){
		this.queType = queType;
		this.que = que;
		this.ansOptions = ansOptions;
		this.srcUrl = srcUrl;
	}
	
	public Question(String queType, String que, String[] ansOptions,String[] ansValues, String srcUrl){
		this.queType = queType;
		this.que = que;
		this.ansOptions = ansOptions;
		this.srcUrl = srcUrl;
		this.ansValues = ansValues;
	}
	
	public Question(String queType, String que, String srcUrl, double[] Con, double[] Pro){
		this.queType = queType;
		this.que = que;
		this.srcUrl = srcUrl;
		this.Con =Con;
		this.Pro =Pro;
	}
	
	public void setId(String id){
		this.queID=id;
	}
	
}
