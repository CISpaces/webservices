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


package ersdata;




 

public class Node {

	private String ID;
	private String iID;
	private String text;
	private String pref_right;
	private String pref_left;
	private String pref_pred;
	private boolean justified;
 
	private String type;

	public Node(int id) {
		// TODO Auto-generated constructor stub
		iID="Q"+id;
		justified=false;
	}
	
   public String toString(){
	   String p=ID+":"+iID+":"+text+": "+type+":"+pref_left+":"+pref_right+":"+pref_pred+"\n";
	   return p;
   }


	public void setID(String iD) {
		ID = iD;
	}




	


	public String getText() {
		return text;
	}




	public void setText(String text) {
		this.text = text;
	}


 
	public void setType(String type) {
		this.type=type;
		
	}
	public boolean isInfo(){
		if(type.toUpperCase().equals("INFO")){
			return true;
		}
		return false;
	}
	public boolean isPref(){
		if(type.toUpperCase().equals("PREF")){
			return true;
		}
		return false;
	}


	public String getIID() {
		return iID;
	}





	public String getID() {
		return ID;
	}


public String getPref_right() {
	return pref_right;
}

public void setPref_right(String pref_right) {
	this.pref_right = pref_right;
}

public String getPref_left() {
	return pref_left;
}

public void setPref_left(String pref_left) {
	this.pref_left = pref_left;
}

public boolean isJustified() {
	return justified;
}

public void setJustified() {
	this.justified = true;
}

public String getPref_pred() {
	return pref_pred;
}

public void setPref_pred(String pref_pred) {
	this.pref_pred = pref_pred;
}
 
 

  
	
	

}
