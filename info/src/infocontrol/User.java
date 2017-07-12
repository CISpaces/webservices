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
 * @version     1.0  
 * @since 		September 2014           
 *   
 */


package infocontrol;

 

public class User{
	private int lastset;
	private int currentset;
	private long time;
	private String aff;
	private String user;
	
	public User(){
		
	}

	public int getLastset() {
		return lastset;
	}

	public void setLastset(int lastset) {
		this.lastset = lastset;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getAff() {
		return aff;
	}

	public void setAff(String aff) {
		this.aff = aff;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}


	 
	public void setTimeS(String string) {
		this.time=Long.parseLong(string);
		
	}

	public int getCurrentset() {
		return currentset;
	}

	public void setCurrentset(int currentset) {
		this.currentset = currentset;
	}

 
	
	
	
}
