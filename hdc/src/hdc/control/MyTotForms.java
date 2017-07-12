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

package hdc.control;

import hdc.crowdinfo.FormCI;
import hdc.resources.Form;
 

public class MyTotForms {

public Form[] forms;
public FormCI[] formCIs;
	 
	
	public MyTotForms(Form[] forms1,FormCI[] forms2) {
	 this.forms=forms1;
	 this.formCIs=forms2;
}

	
}
