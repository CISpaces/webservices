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

import java.util.Map;

public class QueStat {
	public String queID = null;
	public String queType = null;
	public int maxAnsLen = 0;  // the max num of characters in answers
	// for each question, there are multiple possible answers
	public Map count = null; // contain (answer, numOfAnswer) pairs
	public Map ratio = null; // contain (answer, ratioOfAnswer) pairs
	
	public QueStat(){
		
	}
	
	public QueStat(String queID, String queType, int maxAnsLen, Map count, Map ratio){
		this.queID = queID;
		this.queType = queType;
		this.maxAnsLen = maxAnsLen;
		this.count = count;
		this.ratio = ratio;
	}
	public String toString(){
			return  queID+" "+ queType+" "+  maxAnsLen+" "+  count+" "+  ratio ;
		}
		 

}
