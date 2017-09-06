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
import java.util.HashSet;
import java.util.Iterator;


public class Arg implements Cloneable{
	private String id;
	private String conc;
	private ArrayList argprems;
	private HashSet ordprems;
	private ArrayList lastDefRule;
	private HashSet defRule;
	private ArrayList subs;
	private HashSet prems;	
	private Rule topRule;
	private boolean pref;

	private boolean strict;
	public Arg(String d){
		subs=new ArrayList();
		prems=new HashSet();
		argprems=new ArrayList();
		ordprems=new HashSet();
		id=d;
		strict=false; //by default defeasible
		lastDefRule=new ArrayList();
		defRule=new HashSet();
		topRule=null;
		pref=false; //by default it is not preferential
	}
	
	public String toString(){
 
		String tot=id+":"+tocompareString();
		return tot;
	}
	public String tocompareString(){
		Iterator icc=argprems.iterator();
		String tot="";
			while(icc.hasNext()){
				tot=tot+icc.next()+",";
			}
			if(tot.length()>0)
			tot=tot.substring(0, tot.length()-1);
			String op="";
			if(strict){
				op="-";
			}else{
				op="=";
			}
			tot=tot+op+">"+conc;
		return tot;
	}
 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getConc() {
		return conc;
	}

	public void setConc(String conc) {
		this.conc = conc;
	}

	public ArrayList getSubs() {
		return subs;
	}

	public void setSubs(ArrayList subs) {
		this.subs = subs;
	}
	public HashSet getPrems() {
		return prems;
	}

	public void setPrems(HashSet prems) {
		this.prems = prems;
	}
	public HashSet getOrdPrems() {
		return ordprems;
	}

 	public void setOrdPrems(HashSet prems) {
		this.ordprems = prems;
	}
	public ArrayList getArgPrems() {
		return argprems;
	}

	 public void setArgPrems(ArrayList prems) {
		this.argprems = prems;
	}

	public boolean isStrict() {
		return strict;
	}

	public void setStrictDef(boolean strict) {
		this.strict = strict;
	}

	public ArrayList getlastDefRule() {
		return lastDefRule;
	}

	public void setlastDefRule(String topRule) {
		this.lastDefRule.add(topRule);
	}
	
	public void setlastDefRule(ArrayList topRule) {
		this.lastDefRule.addAll(topRule);
	}
	
	
	public HashSet getDefRule() {
		return defRule;
	}

	public void setDefRule(String Rule) {
		this.defRule.add(Rule);
	}
	
	public void setDefRule(HashSet rules) {
		this.defRule.addAll(rules);
	}
	
	public String toAllString(){

		String tal="";

			Iterator itt=subs.iterator();
			
			while(itt.hasNext()){
				tal=tal+itt.next()+",";
			}
			if(tal.length()>0)
			tal=tal.substring(0, tal.length()-1);
			
			Iterator icc=argprems.iterator();
		String tot="";
			while(icc.hasNext()){
				tot=tot+icc.next()+",";
			}
			if(tot.length()>0)
			tot=tot.substring(0, tot.length()-1);
			String op="";
			if(strict){
				op="-";
			}else{
				op="=";
			}
			tot=id+":"+tot+op+">"+conc;
	
			itt=prems.iterator();
		String prem="";
		while(itt.hasNext()){
			prem=prem+itt.next()+",";
		}
		prem=prem.substring(0,prem.length()-1);
		itt=ordprems.iterator();
		String ordprem="";
		while(itt.hasNext()){
			ordprem=ordprem+itt.next()+",";
		}
		ordprem=ordprem.substring(0,ordprem.length()-1);
		itt=lastDefRule.iterator();
		String def="";
 
		while(itt.hasNext()){
			def=def+itt.next()+",";
		}
		if(def.length()>0)
		def=def.substring(0,def.length()-1);
		
		itt=defRule.iterator();
		String deft="";
 
		while(itt.hasNext()){
			deft=deft+itt.next()+",";
		}
		if(deft.length()>0)
		deft=deft.substring(0,deft.length()-1);
		String rule="";
		if(topRule!=null)
			rule=topRule.toString();
		String ret=tot+"\n-TopRule:"+rule+"\n-Prems:"+prem+"\n-OrdPrems:"+ordprem+"\n-Subs:"+tal+"\n-LastDefRule:"+def+"\n-DefRule:"+deft+"\n-Pref:"+pref;
	 
		return ret;
		
	}

	public Rule getTopRule() {
		return topRule;
	}

	public void setTopRule(Rule topRule) {
		this.topRule = topRule;
	}

	 
	public Object clone(){
		Arg b=null;
		try {
			b = (Arg) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
			return b;
	}

	public void removePrem(String id) {
		argprems.remove(id);
	}

	public void addPrem(String id, ArrayList extra, HashSet hashSet) {
		argprems.add(id);
		subs.addAll(extra);
		prems.addAll(hashSet);
	}
 
	@Override
	public boolean equals(Object o){
	    if(o instanceof Arg){
	    
	    	Arg rulec = (Arg) o;
	    	//System.out.println("IS THIS CALLED?"+rulec.toString()+this.toString());
	        if(this.tocompareString().equals(rulec.tocompareString())){
	        	 
	        		return true;
	        		
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
