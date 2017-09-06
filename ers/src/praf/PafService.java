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
 * @author     Hengfei Li  
 * @version     1.0  
 * @since 		July 2014           
 *   
 */

package praf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
 


public class PafService {
	private HashSet<String> propositions;
	private HashMap<String, Double> p_premises;	// grounded premises and their probabilities
	private String rules;
	

	private AspTheory as;
 
	 
	
 
	public PafService(HashMap<String, Double> premises, String contr, String ruls, HashSet<String> prop)  {
		this.propositions = new HashSet<String>();
		this.p_premises = new HashMap<String, Double>();
		as = new AspTheory();
		//ADD PREFERENCES TOO!!
		//addRules(rules);
		//addContraries(contraries);
		addPremises(premises);
 
 
 
 
		as.setAspFromInput( ruls, contr,   "");
	}
	
	
	
	public Double evaluate(HashSet<String> query, EvaluationType evalType) {
		Double result_p = 0.0;
		ArrayList<String> premises = new ArrayList<String>();
		premises.addAll(p_premises.keySet());
		HashSet kb=new HashSet();
		int n = premises.size();
		int power = 1 << n;		// this is equal to 'power = 2^n'
		
		// we start from 1 (instead of 0) because we don't need empty set
		for( long i = 1; i < power; i++) {	
			kb=new HashSet();
			
			//Iterator<Proposition> k = this.propositions.iterator();
			//while(k.hasNext()) {
			//	kb.addPremise(k.next());
			//}
			
		    Set<String> element = new HashSet<String>();
		    Double p_set = 1.0;
		    for( int j = 0; j < n; j++ ) {
		    	String premise = premises.get(j);
		        if(( (i >> j) & 1 ) == 1 ) {		        	
		        	element.add(premise);
		        	kb.add(premise);
		        	p_set = p_set * p_premises.get(premise);
		        }
		        else {
		        	p_set = p_set * (1 - p_premises.get(premise));
		        }
		    }
		    
		    //dundee.aspicplus.ArgumentationTheory at = new ArgumentationTheory(as, kb);
		    as.addPremises(kb);
			as.runAsp();
			System.out.println(" --- ******START**** --- ");
			System.out.println(" --- Arguments Start --- ");
			System.out.println(as.getArguments());
			System.out.println(" --- Arguments End --- ");
			
			
			
			HashSet<HashSet<String>> extensions = as.getExtensions();
			
			System.out.println("--- Extensions Start ---");
			Iterator<HashSet<String>> i_ext = extensions.iterator();
			while(i_ext.hasNext()) {
				System.out.println(i_ext.next().toString());
			}
			System.out.println("--- Extensions End ---");
			
			System.out.println(" --- Attacks Start ---");
			System.out.println(as.getDefeat());
			System.out.println(" --- Attacks End --- ");
			System.out.println(" --- ****END**** --- ");
			
			
			if(as.runQuery(query, evalType)) {
				result_p += p_set;
			}
			
		    //System.out.println(p_set.toString() + "\t" + element);		
			
		}

		return result_p;
	}
	
	
	

	
	public void addPremises(HashMap<String, Double> premises) {
		Iterator<String> i = premises.keySet().iterator();
	 
		while(i.hasNext()) {
			String premise = i.next();
			Double p_value = premises.get(premise);
			this.p_premises.put(premise, p_value);
		
		}
	}
	
	
	
}
