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

import utils.JsonHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class AspServ {

	private int count;
	private JsonHelper jsh;

	protected String wlink;
 
	protected HashMap rulbi; //rulbc by id
	protected HashMap rulbc; //rulbc by conc
	protected HashMap rprefs;
	
	protected HashMap fopp;
	protected HashSet prems;
	protected HashMap kbpref;
	protected HashMap kbpref_rev;
	protected RuleBuilder rbuild;
	private PrologConn prconn;
	private HashSet conc; 
	private HashMap arbc;//arg by conc
	protected HashMap arbi;//arg by id
 
	protected HashSet symb;
	private ArgMap argbuild;
	private HashMap[] atks;
	protected ArrayList defs;
	protected ArrayList args;
	protected ArrayList atons;
	protected HashSet extensions;
	protected boolean wlf;
	protected HashSet<String> cycle;
	protected int contid;
 
	public AspServ(){
	 jsh=new JsonHelper();
	 rbuild=new RuleBuilder();
	 arbc=new HashMap();
	 arbi=new HashMap();
	// prconn=new PrologConn();
	 count=0;
 
	 wlf=true;
	 cycle=new HashSet<String>();
	 
 
	}

	public String AspRunFromJson(String json) {
		//covert map
		HashMap map=jsh.convertInputMap(json);
		//parse knowledge base and create tree of arguments
	
		String ruls=(String) map.get("rules");
		rulbc=rbuild.getRules(ruls);
		rulbi=rbuild.getRulesBI();
		//System.out.println(rulbc);
		
		
		String cont=(String) map.get("contrariness");
		
		wlink=(String)map.get("link");
	 
 
		String premises=(String) map.get("premises");
		prems=rbuild.getPremises(premises);
		
		kbpref=rbuild.getKPref();
		rprefs=rbuild.getRulePref();
		kbpref_rev=rbuild.getKPrefRev();
		rbuild.getContrary(cont);
	 
		fopp=rbuild.getFOpp();
		symb=rbuild.getSymb();
		wlf=rbuild.isWellFormulated();
		cycle=rbuild.testGraphStructure(prems);
		contid=rbuild.getContId();
		map=AspRun();
		return jsh.convertInputJson(map);
	}	
	
	

	public HashMap AspRunFromInput(String r,String fc,  String pr){
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
		return AspRun();
	}
 
	
	protected HashMap AspRun() {
	 	//printArguments();
		//Create arguments!!!!\
		boolean cond=false;
		do{
		//	System.out.println(rulbi);
		//	 System.out.println("*****************************NEW ROUND********************");
			argbuild=new ArgMap(kbpref, rprefs, rulbc, prems,rulbi,contid,kbpref_rev);
			prconn=new PrologConn(prems,rulbc);
			prconn.setCycle(cycle);
			prconn.setSymbols(symb);
		//	System.out.println(rulbi);
			prconn.setInit(rulbi);
			conc=prconn.getConc(); //get all premises+concl that are true!
		//	 System.out.println(fopp);
			argbuild.findArguments(conc,cycle);
			argbuild.findAtks(conc, fopp);
			
			Object[] obj=argbuild.test();
			HashSet newruleset=(HashSet) obj[0];
			HashMap newkbpref=(HashMap) obj[1];
			HashMap newkbpref_rev=(HashMap) obj[2];
			int newcounter=(int) obj[3];
			//s System.out.println(newruleset);
	
			if(!newruleset.isEmpty()){
				//need to do rules from scratch!!!
				rbuild.addRulePrefs(newruleset,newkbpref,newkbpref_rev,newcounter);
				rulbc=rbuild.getRules();
				rulbi=rbuild.getRulesBI();
				rprefs=rbuild.getRulePref();
				kbpref=rbuild.getKPref();
				fopp=rbuild.getFOpp();
				symb=rbuild.getSymb();
				wlf=rbuild.isWellFormulated();
				cycle=rbuild.testGraphStructure(prems);
				contid=rbuild.getContId();
				cond=false;
			}else{
				cond=true;
			}
		//	System.out.println("NEXT ROUND");
		//	 printX();
		/*	Iterator iter;
			 System.out.println("PREFERENCES - KB");
			 iter=kbpref.keySet().iterator();
			
			 while(iter.hasNext()){
				 String tol = (String) iter.next();
				 Pref list = (Pref)kbpref.get(tol);
				 System.out.println(list.toString());
			 }
			 */
			
		}while(!cond);
		
		
		HashMap[] res=argbuild.getArguments();
		arbi=res[0];
		arbc=res[1];
		atks=argbuild.getAtks();
		
		//get arguments
		ArrayList[] list=argbuild.getArgAtks();
		
		args=list[0];
		defs=list[1];
	//	System.out.println(defs);
	 	atons=list[2];
		//contains all the arguments for Engine as Strings[2] (head, tail) in a ArrayList 
		// and two-element String-arrays ([attacker, attacked])

		//evaluate arguments
		AFengine engine;
		if(atons.isEmpty()){
		//System.out.println("here");
		engine=new DAFengine(args,defs);
	 
		}else{
			engine=new AFRAengine(args,defs,atons);
		}
		extensions=engine.evaluatePreferred();
	
	//	printArguments();
		return elaborateResults();
		
	}
	
	
	
	private HashMap elaborateResults() {
		/*ArrayList extensList=(ArrayList) map.get("extensions");
	    ArrayList argsList=(ArrayList)map.get("arguments"); 
	    ArrayList attacks=(ArrayList)map.get("defeat");*/
		//example TOAST {"wellformed":true,"result":"","extensions":[["A2: p","A1: q","A4: A1=>u","A3: A2=>s"]],"arguments":["A3: A2=>s","A5: A3=>t","A2: p","A1: q","A4: A1=>u"],"defeat":["A4>A5"]}
		//example US {"wellformed":true,"extensions":[["A2","A1","A4","A3"]],"arguments":["A3: A2=>s","A5: A3=>t","A2: p","A1: q","A4: A1=>u"],"defeat":["A4>A5"]}
		
		HashMap map=new HashMap();
		map.put("wellformed",wlf);
		
		map.put("extensions",extensions);
		 Iterator iter=arbi.keySet().iterator();
		 Arg arg;
		 ArrayList list=new ArrayList();
		 while(iter.hasNext()){
			 arg=(Arg)arbi.get(iter.next());
			 //  System.out.println(arg.getConc()+kbpref_rev);
			 if(kbpref_rev.containsKey(arg.getConc())){
				 Pref pref=(Pref) kbpref_rev.get(arg.getConc());
				 String name=arg.toString();
			//	 System.out.println(name+":"+pref.getComplete_pred());
				 name=name.replace(arg.getConc(),pref.getComplete_pred());
				 list.add(name);
			 }else{
				 list.add(arg.toString());
			 }
			
		 }
		map.put("arguments", list);
		list=new ArrayList();
		iter=defs.iterator();
		 String couple[];
		 while(iter.hasNext()){
			 couple=(String[]) iter.next();
			 list.add(couple[0]+">"+couple[1]);
		 }
		map.put("defeat", list);
	//	System.out.println(map);
		//{defeat=[A4>A1], wellformed=true, extensions=[[A2, A3, A4, A5, A0]], arguments=[A1:A0=>Q1, A2:->H2, A3:A2=>PPP0, A4:A0=>H3, A5:A3->NNNPPP1, A0:->Q0]}
		return map;
	}

	public void printArguments() {
		 Iterator iter=prems.iterator();
		 System.out.println("PREMISES");
		 while(iter.hasNext()){
			 System.out.println(iter.next());
		 }
	
		 Pref list;String tol;
		 System.out.println("PREFERENCES - KB");
		 iter=kbpref.keySet().iterator();
		
		 while(iter.hasNext()){
			 tol=(String) iter.next();
			 list=(Pref)kbpref.get(tol);
			 System.out.println(list.toString());
		 }
		 
		 
		 
		 System.out.println("RULES");
		 Rule rule; 
		
		 String conc;
		 iter=rulbi.keySet().iterator();
		// System.out.println(rulbc);
		 while(iter.hasNext()){
			 conc=(String) iter.next();
			// System.out.println(conc);
			 rule=(Rule) rulbi.get(conc);
		    System.out.println(rule.toString());
		 }
		 System.out.println("ARGUMENTS");
		 iter=arbi.keySet().iterator();
		 Arg arg;
		 while(iter.hasNext()){
			 arg=(Arg)arbi.get(iter.next());
			 System.out.println(arg.toAllString());
		 }
	
		 
		 
		 
		 System.out.println("ATKS:");
		 System.out.println("U"+atks[0]+"\nM"+atks[1]+"\nR"+atks[2]+"\nCR"+atks[3]+"\ncm"+atks[4]);
 
		 System.out.println("DEFS:");
		 iter=defs.iterator();
		 String couple[];
		 while(iter.hasNext()){
			 couple=(String[]) iter.next();
			 System.out.println(couple[0]+">"+couple[1]);
		 }
		 System.out.println("ATKS ON ATKS:");
		 iter=atons.iterator();
		 while(iter.hasNext()){
			 couple=(String[]) iter.next();
			 System.out.println(couple[0]+">("+couple[1]+">"+couple[2]+")");
		 }
		 System.out.println("WELL FORMULATED:\n"+wlf);
		 
		 System.out.println("EXTENSIONS:");
			iter=extensions.iterator();
			Iterator it;
			while(iter.hasNext()){
				it=((HashSet<String>) iter.next()).iterator();
				while(it.hasNext())
				System.out.print(" "+it.next());
				System.out.println(" and ");
			} 
		
	}

	
	private void printX(){
		 Iterator iter=prems.iterator();
		 System.out.println("PREMISES");
		 while(iter.hasNext()){
			 System.out.println(iter.next());
		 }
	
		 Pref list;String tol;
		 System.out.println("PREFERENCES - KB");
		 iter=kbpref.keySet().iterator();
		
		 while(iter.hasNext()){
			 tol=(String) iter.next();
			 list=(Pref)kbpref.get(tol);
			 System.out.println(list.toString());
		 }
		 
		 
		 
		 System.out.println("RULES");
		 Rule rule; 
		
		 String conc;
		 iter=rulbi.keySet().iterator();
		// System.out.println(rulbc);
		 while(iter.hasNext()){
			 conc=(String) iter.next();
			// System.out.println(conc);
			 rule=(Rule) rulbi.get(conc);
		    System.out.println(rule.toString());
		 }
	}
	
	
	
	
	
}
