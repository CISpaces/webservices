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


package ers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import askpapipref.AskpapiInterf;
import askpapipref.AspServ;

public class ASPHelper {
	private static Logger log;
	private AskpapiInterf aspic;
	private boolean transp;
	private  boolean PRINT; 
	private String rules;
	private String rpref;
	private String contr,wlink,prems,kpref;
	public ASPHelper(boolean pr) {
		aspic=new AspServ();
		transp=true;
		log=Logger.getLogger(getClass().getName());
		PRINT=pr;
		wlink="last";

		rpref="";
		kpref="";
	}

	public void prepareInputAspApi(HashMap toastInput) {
		 
		 
		ArrayList Rules=(ArrayList) toastInput.get("rules");
		ArrayList Premises=(ArrayList) toastInput.get("premises");
		ArrayList Contr=(ArrayList) toastInput.get("cont");
	 
		Iterator iter;
		iter=Premises.iterator();
	 
		prems="";
		while(iter.hasNext()){
			prems+=(String) iter.next()+";";
		}
	
		iter=Rules.iterator();
		 rules="";
		while(iter.hasNext()){
			rules+=(String) iter.next();
		}
		iter=Contr.iterator();
		contr="";
		while(iter.hasNext()){
			contr+=(String) iter.next();
		}	

	}
	
	
	
	public HashMap evaluate() {
	//  System.out.println("do I get here?");
		if(PRINT){
		 log.log(Level.INFO,"AskApiPref computation with "+rules+":"+contr+":"+prems);
		}
		 aspic.setKBFromInput(rules,contr,prems);
		 aspic.getAbstract(); 
		 HashMap response=aspic.getEvaluateExt();  

//		System.out.println(response);
		return response;
		
	 
		}

}
