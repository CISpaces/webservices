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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.igormaznitsa.prol.data.Term;
import com.igormaznitsa.prol.io.DefaultProlStreamManagerImpl;
import com.igormaznitsa.prol.logic.Goal;
import com.igormaznitsa.prol.logic.ProlContext;
import com.igormaznitsa.prol.parser.ProlConsult;

public class PrologConn {
	private HashSet symb;
	private HashSet conc;
	private String input;
	private ProlContext context;
	private HashSet<String> cycle;
	 
	private HashSet prems;
	private HashMap rulbc;
	private HashMap rulbi;
	public PrologConn(HashSet prs,HashMap rubc) {
		input="";
		conc=new HashSet();
		cycle=new HashSet<String>();
		try {
			context = new ProlContext("aspic",DefaultProlStreamManagerImpl.getInstance());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prems=prs;
		rulbc=rubc;
	}

	public void setInit( HashMap rules){
		rulbi=rules;
		 
		 Iterator iter=prems.iterator();
		 String prem;
		 while(iter.hasNext()){
			 prem=(String) iter.next();
			 input+=prem+".";
		 }
		 
		iter=rules.keySet().iterator();
		Rule rule;String rl;
		Iterator itt;
		String tal;
		while(iter.hasNext()){
			rule=(Rule)rules.get(iter.next());
			//System.out.println(rule);
			if(!cycle.contains(rule.getId())){
			rl=rule.getHead()+":-";
			itt=rule.getTails().iterator();
			while(itt.hasNext()){
				tal=(String) itt.next();
				rl=rl+tal+",";
			}
			rl=rl.substring(0, rl.length()-1);
		 /*	if(cycle.contains(rule.getId())){
				rl=rl+",!";
			} */
			input+=rl+".";
			} 
		}
	}

	 
	public void setSymbols(HashSet sb) {
		 symb=sb;
		
	}

	public HashSet getConc() {
		//initialise
	 
		input=input.toLowerCase();
	//	 System.out.println(input);
		final ProlConsult consult = new ProlConsult(input, context);
	    try {
			consult.consult();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	   // System.out.println(input);
	    
	    
	    
	    
	    
	  //for each symbol run test 
	    Iterator iter=symb.iterator();
	    String tal;
	    context.toString();
	    while(iter.hasNext()){
	    	tal=(String) iter.next();
	    	// System.out.println(tal+".");
 
	    	if(runTest(tal)){
	    		conc.add(tal);
	    	}
	    	 // System.out.println(tal+".OUT");
	    }
	   // System.out.println(conc);
		return conc;
	}
	
	private boolean runTest(String test){
		// System.out.println(test);
	test=test.toLowerCase();
	
    Goal goal;
	try {
		goal = new Goal(test+".", context);
		context.toString();
	 //	System.out.println("here be");
		Term result = goal.solve();
	//	System.out.println("here after");
		if (result == null) {
		       return false;
		}else if (result.forWrite().equals(test)){
		        return true;
		    }

	} catch (Exception e) {
			//System.out.println("here");
			e.printStackTrace();
			return false;
	}
	
   return false;
}

	public void setCycle(HashSet<String> c) {
		this.cycle=c;
		
	}

}
