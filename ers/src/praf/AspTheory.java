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

 
 
import java.util.HashSet;
import java.util.Iterator;

import askpapipref.Arg;
import askpapipref.AspServ;


 
public class AspTheory extends AspServ {

	
	
	public AspTheory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public void setAspFromInput(String r,String fc,String pr){
		//parse knowledge base and create tree of arguments
	 
		rulbc=rbuild.getRules(r);
		rulbi=rbuild.getRulesBI();
		rprefs=rbuild.getRulePref();
		prems=rbuild.getPremises(pr);
		kbpref=rbuild.getKPref();
		kbpref_rev=rbuild.getKPrefRev();
		rbuild.getContrary(fc);
		fopp=rbuild.getFOpp();
		symb=rbuild.getSymb();
		wlf=rbuild.isWellFormulated();
		cycle=rbuild.testGraphStructure(prems);
		
		contid=rbuild.getContId();
		
	}
	public boolean runQuery(HashSet<String> query, EvaluationType evalType) { 
		HashSet<HashSet<String>> exts = extensions;
		Iterator<HashSet<String>> i_exts = exts.iterator();
		Iterator<String> i_ext;
		// If there are extensions, set this to true and change it to
		// false if we find any extension that does not contain the
		// query. If there is no extension, set it to false directly.
		boolean inAllExts = i_exts.hasNext();
		
		while(i_exts.hasNext()) {
			HashSet<String> ext = i_exts.next();
			HashSet<String> ext_cons = new HashSet<String>();
			
			i_ext = ext.iterator();
			while(i_ext.hasNext()) {
				Arg arg=(Arg)arbi.get(i_ext.next());
				ext_cons.add(arg.getConc());
			}
			
			if(ext_cons.containsAll(query)) {
				if(evalType == EvaluationType.CREDULOUS) {
					return true;
				}
			}
			else {
				inAllExts = false;
			}			
		}
		
		// At this point, if evalType == CREDULOUS, then there is no extension 
		// contains the query and return false
		return inAllExts;		
	}


	public void addPremises(HashSet kb) {
		Iterator iter;
		iter=kb.iterator();
	 
		String pr="";
		while(iter.hasNext()){
			pr+=(String) iter.next()+";";
		}
		prems=rbuild.getPremises(pr);
	}


	public String getArguments() {
		// TODO Auto-generated method stub
		return args.toString();
	}


	public HashSet<HashSet<String>> getExtensions() {
		// TODO Auto-generated method stub
		return extensions;
	}


	public String getDefeat() {
		String result="";
		Iterator iter=defs.iterator();
		 String couple[];
		 while(iter.hasNext()){
			 couple=(String[]) iter.next();
			 result+="["+couple[0]+">"+couple[1]+"]";
		 }
		return result;
	}


	public void runAsp() {
		AspRun();
		
	}
}

