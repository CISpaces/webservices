/******************************************************************************
 * This research was sponsored by the U.S. Army Research Laboratory and the
 * U.K. Ministry of Defence under the Biennial Program Plane 2013 (BPP13),
 * Project 6, Task 3: Collaborative Intelligence Analysis.
 * The U.S. and U.K. Governments are authorized to reproduce and distribute
 * reprints for Government purposes notwithstanding any copyright notation
 * hereon.
 * **************************************************************************
 * 
 * Interface to the PrAF service
 * 
 * @author       Alice Toniolo - Hengfei Li  
 * @version     1.0  
 * @since 		July 2014           
 *   
 */

package praf;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


import ersdata.Node;

 
public class PrafRun {
	private HashMap<String, Double> premises;
	private HashSet<String> propositions;
 
	private HashMap nonprem;
	private PafService pafServ;
	private Logger log;
	private HashMap nodes;
	private PrintStream old;
	private boolean DOIT=true;//if true stops the printout from the PrafService 
	private boolean PRINT;
	private String prems;
	private String ruls;
	private String contr;
	
	public PrafRun (HashMap no,boolean p){
		premises = new HashMap<String, Double>();
		propositions = new HashSet<String>();
 
		 
		log=Logger.getLogger(getClass().getName());
		nonprem=new HashMap();
		nodes=no;
		PRINT=p;
		// System.out.println(nodes.toString());
	}
	


	
	
	public HashMap prafrun(HashMap colors,HashMap listh) {
		// System.out.println(colors.toString()+"\n"+listh);
		 //THIS is the method that runs PrAF
	

			//THIS NEEDS A CHANGE!!!!!
			
			 
			pafServ = new PafService(premises, contr, ruls, propositions);
			 
			//first evaluate all the propositions that are not premises
			
			Iterator iter=nonprem.keySet().iterator();
			Double p;
			String tryp;
			HashSet set;
			while(iter.hasNext()){
				tryp=(String) iter.next();
				if(!PRINT){
				 	stoutOFF();
				}else{
				 log.log(Level.INFO,"*****************ERS TESTING - QUERY SINGLE NODE:"+ tryp);
				}
				set=new HashSet();
				set.add(tryp);
				p=  pafServ.evaluate(set,EvaluationType.CREDULOUS);
				
				
				if(!PRINT){
				 	stoutON();
				}else{
						log.log(Level.INFO,"*****************ERS TESTING - QUERY SINGLE NODE Result:"+ tryp+" - RESULT: "+p);
				}
				nonprem.put(tryp, p);
			}
			 
			//System.out.println("*****************ERS TESTING: Results of each nodes non-premises "+ nonprem.toString());
			
			//then assign a value for each of the extensions 
			// take all the propositions that are assigned true, create a set and then evaluate it 
			//
		 
			HashMap colin=new HashMap();
			
			iter=colors.keySet().iterator();
			String key;
			HashMap col;
			 HashSet lg;
			Iterator itt;
			Node nd;
			String node,value,prob;
			 
			while(iter.hasNext()){
		      set=new HashSet();
			  key=(String) iter.next();
			  col=(HashMap) colors.get(key);
		   //System.out.println(key);
		 	//  System.out.println(col.toString());
			  itt=nodes.keySet().iterator();
			  while(itt.hasNext()){
				  node=(String) itt.next();
				  nd=(Node) nodes.get(node);
				  value=(String) col.get(nd.getID());
				  if(value.equals("V") && !premises.containsKey(node)){ //I delete the premises? 
					  set.add(node);
				  }
			  }
			 lg=(HashSet)listh.get(key);
			 if(lg!=null){
			  set.addAll(lg);
			 }
			
			 if(!key.startsWith("Clear")){
				 
				  stoutOFF();
			 System.out.println("*****************ERS TESTING: QUERY SET TO BE TESTED:"+ set.toString());
			 
			  
			  if(key.startsWith("Credulous")){
				  p=pafServ.evaluate(set,EvaluationType.CREDULOUS);
			  }else{//skeptical
				  p=pafServ.evaluate(set,EvaluationType.SCEPTICAL);
			  }
			 
			  prob=convertPraf(p);//get a String for the prob value
			  colin.put(key+" - "+prob,col);
			  System.out.println("*****************ERS TESTING: QUERY SET TO BE TESTED:"+ key+" - "+ set.toString()+"-Result:"+prob);
			  stoutON();
			 }else{
				 colin.put(key,col);
			 }
			}
			return colin;
		 
	
		 
	}








	public void setService(HashMap toastInput) {
 
			//from ERS-CISpaces input to Praf input 
		//need to remove preferences
			ArrayList Rules=(ArrayList) toastInput.get("rules");
			ArrayList Premises=(ArrayList) toastInput.get("premises");
			ArrayList Contr=(ArrayList) toastInput.get("cont");
		 
			Iterator iter;
		
			iter=Rules.iterator();
			 ruls="";
			while(iter.hasNext()){
				ruls+=(String) iter.next();
			}
			iter=Contr.iterator();
			contr="";
			while(iter.hasNext()){
				contr+=(String) iter.next();
			}
			ArrayList allnodes=new ArrayList();
			allnodes.addAll(nodes.keySet());
			iter=Premises.iterator();
			Node nd;
			String prems;
			String pm;
		 
			while(iter.hasNext()){
				pm=(String) iter.next();
				nd=(Node) nodes.get(pm);
				premises.put(pm,nd.getUncertPrAF());
				allnodes.remove(pm);
			}
			
			 
			allnodes.addAll(nodes.keySet());
		iter=allnodes.iterator();
		while(iter.hasNext()){
			pm=(String) iter.next();
			propositions.add(pm);
		}
		iter=allnodes.iterator();
		while(iter.hasNext()){
			nonprem.put(iter.next(), 1.0);//default value
		}
		//System.out.println(premises.toString()+"\n"+rules.toString()+"\n"+propositions.toString()+"\n"+contraries.toString());
		 
	}

	public HashMap convert(HashMap ersResponse) {
		//this is used from the ERS service for generating a probability assignment for CISpaces (not needed to run it) 
		HashMap conv=new HashMap();
		nonprem.putAll(premises);
		Iterator iter=nonprem.keySet().iterator();
		Node nd;
		String node;   
		Double p;
		String value;
		while(iter.hasNext()){
				node=(String)iter.next();
				if(nodes.containsKey(node)){
					nd=(Node) nodes.get(node);
					p=(Double) nonprem.get(node);
					value=convertPraf(p);
					conv.put(nd.getID(),value);
				}
		}
		ersResponse.put("uncert",conv);
		return ersResponse;
	}

	private String convertPraf(Double p) {
		p = p*100;
		p = (double) Math.round(p);
		p = p/100;
	if(p<=0.25)
		return "Improbable";
	if(p<=0.45)
		return "Doubtful";
	if(p<=0.55)
		return "Cannot Be Judged";
	if(p<=0.65)
		return "Possible";
	if(p<=0.85)
		return "Probable";
	if(p<=1)
		return "Confirmed";
		return "Cannot Be Judged";	
	}
	
	private void stoutOFF(){
		if(DOIT){
		// Create a stream to hold the output
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    // IMPORTANT: Save the old System.out!
	 
	    old = System.out;
	    // Tell Java to use your special stream
	    System.setOut(ps);
	    // Print some output: goes to your special stream
	    //System.out.println("Foofoofoo!");
		}
	}
	private void stoutON(){
		if(DOIT){
		System.out.flush();
		System.setOut(old);
		}
	}
}
