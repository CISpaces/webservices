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

public class Response {

	String response = null;
	public Response(){
		
	}
	
	public Response(String response){
		this.response = response;
	}
	
	public void setResponse(String response){
		this.response = response;
	}
	
	public String getResponse(){
		return response;
	}
}
