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
 * @author      Alice Toniolo  
 * @version     2.0  
 * @since 		July 2017           
 *   
 */

package askpapipref;

import java.util.ArrayList;
import java.util.HashMap;

public interface AskpapiInterf {
	//call first
	public void setKBFromJson(String json);
	public void setKBFromInput(String r, String fc, String pr);
	//then extract abst
	public ArrayList[] getAbstract(); 
	public HashMap elaborateAbstract(); //this is better printing
	//then evaluate
	public HashMap getEvaluateExt();
	public String getJsonEvaluateExt();
	//print all 
	public void printFullKBArgs();



}
