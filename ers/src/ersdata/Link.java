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

import java.util.ArrayList;
 
 
 



 

public class Link {

	private ArrayList tails;
	private String head;
	private String ID;
	private boolean procon;
	private String text;
	private String annot;
	private boolean neg;
	private boolean cqtype;

	public Link(String name, String pc,String t){
		this.ID=name;//ID of the link
 
		if(pc.equals("RA")){
			this.procon=true;
		}else{
			if(pc.equals("CA")){
			this.procon=false;
			}
		}
		//pro link true; con link false
		this.text=t;//free text field
		tails=new ArrayList();
		neg=false;
		cqtype=false;
	}

 
	/*
	public LinkedTreeMap  linkToMaps(){
		//create a map that can be transformed to JSON easily
		/*Example of link q1,q2->Pro(annot-text)->q3
		 JSON format {"id":"ID"
		 			  "heads":[ "q3",...] 
		 			  "tails":[ "q1","q2"]
		 			  "type":"Pro",
		 			  "annot":"annot",
		 			  "text":"text",
			}
			
		 JAVA format correspondence {} MAP, [] ArrayList
		  */
	/*	LinkedTreeMap map=new LinkedTreeMap();
		 
		map.put("id",ID);
		map.put("annot",annot);
		map.put("text", text);
		if(procon){
			map.put("type", "Pro");
		}else{
			map.put("type", "Con");
		}
		map.put("tails", tails);
		map.put("head",head);
		map.put("neg", neg);
		map.put("cqtype", cqtype);
		return map;
	}

 */

	public void setTails(String tail) {
		this.tails.add(tail);
	}

	public void setHead(String head) {
		this.head = head;
	}
	
	public void setContradictory(){
		neg=true;
	}
	public void setCqType(){
		cqtype=true;
	}


	public String getId() {
		return ID;
 
	}


	public String getHead() {
		// TODO Auto-generated method stub
		return head;
	}


	public ArrayList getTails() {
		// TODO Auto-generated method stub
		return tails;
	}


	public boolean getCQtype() {
		// TODO Auto-generated method stub
		return cqtype;
	}


	public boolean isPro() {
		return procon;
	}


	public void setProcon(boolean procon) {
		this.procon = procon;
	}


	public String getText() {
		// TODO Auto-generated method stub
		return text;
	}


	public boolean getNeg() {
		// TODO Auto-generated method stub
		return neg;
	}

	  public String toString(){
		    String p=ID+":"+tails+":"+head+":"+procon+":"+text+":"+neg+":"+cqtype+"\n";
		    return p;
	   }
 
 
}
