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

 

public class FormCI implements Cloneable{

	public String formID = null; //name!!
	public String createTime = null;
	public ResponseCI[] output_ci =null;
	public String title =null;
	public String query=null;
 
	
 
	
	public FormCI(String formID,String createTime, String title, String query){
	this.title=title;
	this.formID = formID;
	this.createTime =createTime;
	this.output_ci=new ResponseCI[1];
	this.query=query;
 
	}
	
	protected Object clone() throws CloneNotSupportedException {
	        return super.clone();
	    }

 
}
