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

import java.util.ArrayList;

public class AnswerCI {
	public String formID = null; //name!!
	public ArrayList queStat =null;
	public String title =null;
	public boolean crowdInfo=true;
	
	
	public AnswerCI(String title, String formID){
		this.queStat=new ArrayList();
		this.title=title;
		this.formID=formID;
		this.crowdInfo=true;
	}
	
	public void addOutput(ResponseCI[] tot){
	
	for(ResponseCI resp:tot){
		if(resp!=null){
		ArrayList array=new ArrayList();
		array.add(resp.updated_at);
		array.add(resp.est);
		//array.add(resp.dev);
		queStat.add(array);
		}
		
	}
	
	
	}
	
	
	
 
}
