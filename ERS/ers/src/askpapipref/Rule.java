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
 * @since 		November 2014           
 *   
 */



package askpapipref;

import java.util.ArrayList;
import java.util.Iterator;

public class Rule {
	private String id;
	private ArrayList tails;
	private String head;
	private boolean strict;
	private boolean pref;
 

	public Rule() {
		tails=new ArrayList();
		pref=false;
	}

	public void addTail(String tail){
		tails.add(tail);
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList getTails() {
		return tails;
	}

	public void setTails(ArrayList tails) {
		this.tails = tails;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public boolean isStrict() {
		return strict;
	}

	public void setStrict() {
		this.strict = true;
	}
	public void setDefeasible(){
		this.strict=false;
	}

	public String toString(){
		Iterator itt=tails.iterator();
		String tal="";
		while(itt.hasNext()){
			tal+=itt.next()+",";
		}
		tal=tal.substring(0, tal.length()-1);
		String op="";
		if(strict){
			op="-";
		}else{
			op="=";
		}
		String ret=id+":"+tal+op+">"+head;
		return ret;
		
	}
 
	@Override
	public boolean equals(Object o){
	    if(o instanceof Rule){
	    
	    	Rule rulec = (Rule) o;
	    	//System.out.println("IS THIS CALLED?"+rulec.toString()+this.toString());
	        if(this.getHead().equals(rulec.getHead())){
	        	if(tails.size()==rulec.getTails().size()){
	        		//same size 
	        		 
	        		String tail;
	        		Iterator iter=rulec.getTails().iterator();
	        		while(iter.hasNext()){
	        			tail=(String) iter.next();
	        			if(!tails.contains(tail)){
	        			//	System.out.println("FALSE");
	        				return false;
	        			}
	        		}
	        		return true;
	        		
	        	}
	        }
	    	
	    }
	    return false;
	}

	public boolean isPref() {
		return pref;
	}

	public void setPref() {
		this.pref = true;
	}





 

 

}
