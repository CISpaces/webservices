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


package ersdata;

import java.util.HashMap;

 

 

public class Node {

	private String ID;
	private String iID;
	private String text;
	private String uncert;

	private String pref_right;
	private String pref_left;
	private String pref_pred;
	private boolean justified;
	private String eval;
	private int commit;
	private String type;
	private double prob;
	private double[] bdu={0.0,0.0,1};
	 

 
	public Node(int id) {
		// TODO Auto-generated constructor stub
		iID="Q"+id;
		prob=1;
		justified=false;
	}
	
	public Node(String p){
		String[] items=p.split(":");
		//System.out.println(items.toString());
		ID=items[0];
		iID=items[1];
		text=items[2];
		eval=items[3];
		type=items[4];
		prob=Double.parseDouble(items[5]);
		justified=false;
	}

 
   public String toString(){
	    String p=ID+":"+iID+":"+text+":"+eval+":"+type+":"+prob+":"+pref_left+":"+pref_right+":"+pref_pred+"\n";
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



 


	public String getEval() {
		return eval;
	}
	 

	public void setEval(String eval) {
		this.eval = eval;
	}


	public int getCommit() {
		return commit;
	}


	public void setCommit(int commit) {
		this.commit = commit;
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





	public String getUncert() {
		return uncert;
	}


	public void setUncert(String uncert) {
		//this just codes in 6 different levels
		this.uncert = uncert;
		if(uncert.equals("Confirmed")){
			this.prob=1;
			double[] jk={1,0,0};
			this.bdu=jk;
		}else if(uncert.equals("Probable")){
			this.prob=0.8;
			double[] jk={0.8,0.0,0.2};
			this.bdu=jk;
		}else if(uncert.equals("Possible")){
			this.prob=0.6;
			double[] jk={0.6,0.0,0.4};
			this.bdu=jk;
		}else if(uncert.equals("Doubtful")){
			this.prob=0.4;
			double[] jk={0.4,0.0,0.6};
			this.bdu=jk;
		}else if(uncert.equals("Improbable")){
			this.prob=0.2;
			double[] jk={0.2,0.0,0.8};
			this.bdu=jk;
		}else if(uncert.equals("Cannot Be Judged")){
			this.prob=0.5;
			double[] jk={0.5,0.0,0.5};
			this.bdu=jk;
		}else{
			this.prob=1;
			double[] jk={1,0,0};
			this.bdu=jk; //default
		}
	}

	/* 
	 * 1 Confirmed (100%)
	 * 2 Probably (80%)
	 * 3 Possibly (60%)
	 * 4 Doubtful (40%)
	 * 5 Improbable (20%)
	 * 6 Cannot be judged (50%)
	 */

   public double getUncertPrAF(){
	   return prob;//default
   }





public HashMap getUncertHyperArg() {
	HashMap map=new HashMap();
	map.put("b",bdu[0]);
	map.put("d",bdu[1]);
	map.put("u",bdu[2]);
	return map;
}




public Double getBel() {
	// TODO Auto-generated method stub
	return bdu[0];
}





public void setHyperArg(double[] d1) {
	bdu=d1;
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
