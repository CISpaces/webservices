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

public class JsonParser {
	
	public String func = null;
	public Object params = null;
	// arbitrary object
//	Form formObj = null;
//	Answer ansObj = null;
	public String time = null;
	public String formID = null;
	public String userID = null;
	public String userLoc = null;
	public String[] ans = null;
	public String tableID = null;
	
	public JsonParser(){
		
	}
	
	public JsonParser(String func, Object params, String formID, String userID, String userLoc, String time, String[] ans, String tableID){
		this.func = func;
		this.params = params;
		this.formID = formID;
		this.userID = userID;
		this.userLoc = userLoc;
		this.time = time;
		this.ans = ans;
		this.tableID = tableID;
	}

}
