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

public class ResponseCI {
	public String updated_at;
	public double est;
	public double dev;
	public double n_pt;

	
	/*
	 * <updated_at>,<est>,<dev>,<n_report>

updated_at: the time the estimate is updated
est: the aggregated estimate
dev: the deviation of the aggregated estimate
n_report: the number of reports used to derive the aggregated estimate
2015-03-04 12:59:29,80,0.0,1
	 */
	public ResponseCI(String s1, double d1, double d2, double i1) {
		 updated_at=s1;
		 est=d1;
		 dev=d2;
		 n_pt=i1;
	}
	

	public ResponseCI() {
		// TODO Auto-generated constructor stub
	}
	

}
