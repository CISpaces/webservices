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

import java.util.ArrayList;
import java.util.Map;

public class AggAnswer {

	public String formID = null;
	public QueStat[] queStat = null; 
	public Map numByDay = null; // contain (day, numOfAnswer) pairs
	public Map numByLoc = null; // contain (loc, numOfAnswer) pairs
	public Map ratioByDay = null;
	public Map ratioByLoc = null;
	public ArrayList summary =null;
	public boolean supp;
	public FormAnalysis formAnalysis;
	public boolean crowdInfo=false;
	public AggAnswer(){
		this.crowdInfo=false;
	}
	
	public AggAnswer(String formID, QueStat[] queStat, Map day, Map loc, Map ratioDay, Map ratioLoc,FormAnalysis formAns){
		this.formID = formID;
		this.queStat = queStat;
		this.numByDay = day;
		this.numByLoc = loc;
		this.ratioByDay = ratioDay;
		this.ratioByLoc = ratioLoc;
		this.formAnalysis=formAns;
		this.supp=false;
		this.crowdInfo=false;
	}
	
	public AggAnswer(String formID, QueStat[] queStat, Map day, Map loc, Map ratioDay, Map ratioLoc, ArrayList summary,FormAnalysis formAns){
		this.formID = formID;
		this.queStat = queStat;
		this.numByDay = day;
		this.numByLoc = loc;
		this.ratioByDay = ratioDay;
		this.ratioByLoc = ratioLoc;
		this.summary= summary;
		this.supp=true;
		this.formAnalysis=formAns;
		this.crowdInfo=false;
	}
}
