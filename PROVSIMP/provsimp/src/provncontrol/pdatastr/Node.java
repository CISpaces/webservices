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
 * @since 		June 2014           
 *   
 */


package provncontrol.pdatastr;

 

 

 

public class Node {

	private String ID;
	 
	private String text;
	private String pref_right;
	private String pref_left;
	private String pref_pred;
	private String type;

	private boolean setJust;

	public Node(String id,String tx) {
		// TODO Auto-generated constructor stub
		ID=id;
		text=tx;
		setJust=false;
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
	 
	public boolean isPref(){
		if(type.toUpperCase().equals("PREF")){
			return true;
		}
		return false;
	}


	 



	public String getID() {
		return ID;
	}




 

	/* 
	 * 1 Confirmed (100%)
	 * 2 Probably (80%)
	 * 3 Possibly (60%)
	 * 4 Doubtful (40%)
	 * 5 Improbable (20%)
	 * 6 Cannot be judged (50%)
	 */
 


 

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

 
public String getPref_pred() {
	return pref_pred;
}

public void setPref_pred(String pref_pred) {
	this.pref_pred = pref_pred;
}



public boolean getJust() {
	// TODO Auto-generated method stub
	return setJust;
}
 
 
public void setJust() {
	// TODO Auto-generated method stub
	 setJust=true;
}
  
	
	

}
