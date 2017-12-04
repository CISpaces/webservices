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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;





public class ArgMap {
 
	private HashMap arbc;//arg by conc
	private HashMap arbi;//arg by id
	private HashMap argprefs; //arg by conc
	private HashMap kbpref;
	private HashMap kbpref_rev;
	private HashMap rprefs;
	private HashSet prems;
	private int count;
	private HashMap rulbc;
	private HashMap rulbi;
	private HashMap atks;
	private HashMap defs;
	private HashMap uncuts;
	private HashMap rebs;
	private HashMap tarbi;
	private ArrayList args;
	private HashMap crebs;
	private HashMap unmines;
	private HashSet concls;
	private HashMap cunmines;
	private ArrayList atkonatk;
	private int countid;
	private HashSet newruleset;
	int counter=0;
	public ArgMap(HashMap kpef,HashMap rpef,HashMap rlbc,HashSet pre,HashMap ri,int cid, HashMap kbrev) {
		count=0;
		kbpref=kpef;
		rprefs=rpef;
		rulbc=rlbc;
		prems=pre;
		counter=0;
		arbc=new HashMap();
		arbi=new HashMap();
		argprefs=new HashMap();
		atks=new HashMap();
		defs=new HashMap();
		rulbi=ri;
		uncuts=new HashMap();
		rebs=new HashMap();
		crebs=new HashMap();
		unmines=new HashMap();
		cunmines=new HashMap();
		defs=new HashMap();
		tarbi=new HashMap();
		args=new ArrayList();
		atkonatk=new ArrayList();
		countid=cid;
		kbpref_rev=kbrev;
	}
	

	
		




	public void findArguments(HashSet conc, HashSet<String> cycle) {
		//System.out.println(rprefs);
		concls=conc;
		Iterator iter=concls.iterator();
		String con;
	 
		while(iter.hasNext()){
			con=(String) iter.next();
			recursiveFind(con,cycle);
		}
		
		iter=cycle.iterator();
		//System.out.println(arbc);
		while(iter.hasNext()){
			
			con=(String) iter.next();
			if(rulbi.containsKey(con)){
			//	System.out.println("got here"+con);
		 
				addLast((Rule)rulbi.get(con));
			}
		}
		//System.out.println(arbc);
		
	
		
		
		
	// System.out.println(arbi);
	 
 
		
	}
	
	
	private void addLast(Rule rule) {

	
		ArrayList<String> argnewlist=new 	ArrayList<String>();
		Iterator itt;
		//add a new argument 
		if(isIstantiated(rule,new HashSet())){
			//get the premises 
			
			ArrayList tails=rule.getTails();
			itt=tails.iterator();
			//for each premise call find
			ArrayList array=new ArrayList();
			while(itt.hasNext()){
				String tail=(String) itt.next();
				//recursiveFind(tail,cycle);
				//System.out.println("before"+array.toString()+"\n"+arbc.toString()+":"+tail);
				array.add((ArrayList)arbc.get(tail));
				// System.out.println(tail+array.toString());
			}
			//then create a new argument!
			//now the tails have arguments
			//find all the combinations of the premises arguments
			
			ArrayList combu=getCombinatories(array);
			
			Iterator itch = combu.iterator();
			String tot;
			Arg argi;
			//System.out.println(combu);
		 	while(itch.hasNext()){
		 	//	System.out.println(combu);
		 	//	System.out.println("CIAO");
				tot=(String) itch.next();
				String[] we=tot.split(";");
			
				ArrayList subs=new ArrayList();
				HashSet pres=new HashSet();
				ArrayList arprem=new ArrayList();
				for(int i=0;i<we.length;i++){
					subs.add(we[i]);
					argi=(Arg) arbi.get(we[i]);
					subs.addAll(argi.getSubs());
					pres.addAll(argi.getPrems());
					arprem.add(we[i]);
				}
				 
				String id="A"+count; 
				count++;
				Arg arg=new Arg(id);
				
				arg.setSubs(subs);
				arg.setConc(rule.getHead());
				if(rprefs.containsKey(rule.getHead())){
					arg.setPref();
				}
			 
				arg.setStrictDef(rule.isStrict());//strict
				//def rules
				Iterator itg=arg.getSubs().iterator();
				String argsub;
				 
				while(itg.hasNext()){
					argsub=(String) itg.next();
					//System.out.println(argsub);
					argi=(Arg) arbi.get(argsub);
					arg.setDefRule(argi.getDefRule());
					if(arg.isStrict()){
						arg.setlastDefRule(argi.getlastDefRule());
					}
				}
	 
				if(!arg.isStrict()){
					arg.setlastDefRule(rule.getId());
					arg.setDefRule(rule.getId());
				}
		 
				arg.setTopRule(rule);
				pres.addAll(rule.getTails());
				arg.setPrems(pres);
				arg.setOrdPrems(getOrdPrem(pres));
				arg.setArgPrems(arprem);
			 
				ArrayList argset;
				// argument created now add 
				if(arbc.containsKey(rule.getHead())){
					argset=(ArrayList) arbc.get(rule.getHead());
				}else{
					argset=new ArrayList();
				}
				argset.add(arg.getId());
				arbc.put(rule.getHead(),argset);
				if(arg.isPref()){
					ArrayList prefset;
					//add to argpref
					if(argprefs.containsKey(rule.getHead())){
						prefset=(ArrayList) argprefs.get(rule.getHead());
					}else{
						prefset=new ArrayList();
					}
					prefset.add(arg.getId());
					argprefs.put(rule.getHead(),prefset);
				}
				
				arbi.put(id, arg);
				args.add(id);
				
				argnewlist.add(arg.getId());
				// System.out.println("COND2"+arg.toString());
				
			} 
		 	
		}
			
	}








	private HashSet getOrdPrem(HashSet pres) {
		HashSet set=new HashSet();
		Iterator itt=pres.iterator();
		while(itt.hasNext()){
			String t=(String) itt.next();
			if(prems.contains(t)){
				set.add(t);
			}
		}
		return set;
	}








	private void recursiveFind(String con, HashSet<String> cycle){
		Arg arg;
		ArrayList rulset;
		String id;
		Rule rule;
		//first check for existing arguments with same conclusion:
		ArrayList argset = (ArrayList) arbc.get(con);
	 
		if(argset!=null){//already analysed!
			//FIRST TERMINATION COND
	 
			//then do nothing 		
		}else{
			// System.out.println(prems+" AND Conc"+con);
			if(prems.contains(con)){
				//it is a premise
				//SECOND TERMINATION COND
					id="A"+count; 
					count++;
					arg=new Arg(id);
					HashSet pr=new HashSet();
					pr.add(con);
					arg.setPrems(pr);
					arg.setOrdPrems(getOrdPrem(pr));
					arg.setConc(con);
					if(rprefs.containsKey(con)){
						arg.setPref();
					}
					arg.setStrictDef(true);//strict
					//last def rules undefined
					// argument created now add 
					if(arbc.containsKey(con)){
						argset=(ArrayList) arbc.get(con);
					//	System.out.println(con+argset);
					}else{
						argset=new ArrayList();
					}
					 
					argset.add(arg.getId());
					arbc.put(con,argset);
					if(arg.isPref()){
						ArrayList prefset;
						//add to argpref
						if(argprefs.containsKey(con)){
							prefset=(ArrayList) argprefs.get(con);
						}else{
							prefset=new ArrayList();
						}
						prefset.add(arg.getId());
						argprefs.put(con,prefset);
					}
					 
					arbi.put(id, arg);
					args.add(id);
					//System.out.println("COND1"+arg.toAllString());
					 
			}
			//I could have prem and rule both with same symbol
			rulset=(ArrayList)rulbc.get(con);
			ArrayList tails; String tail;
				if(rulset!=null){
					//there are rulbc that have con as conclusion
					//now need to go back till I find other arguments with conc this or premise
					//SPLIT COND FOR RECURSION
					//go deeper one rule and call recursion! //when I come back I add this level to a new argument!!!!
					//do this for each of the rulbc here!!!
					Iterator iter=rulset.iterator();
					while(iter.hasNext()){
						rule=(Rule) iter.next();
				if(isIstantiated(rule,cycle)){
						//get the premises 
						tails=rule.getTails();
						Iterator itt=tails.iterator();
						//for each premise call find
						ArrayList array=new ArrayList();
						while(itt.hasNext()){
							tail=(String) itt.next();
							recursiveFind(tail,cycle);
							//System.out.println("before"+array.toString()+"\n"+arbc.toString()+":"+tail);
							array.add((ArrayList)arbc.get(tail));
							 //System.out.println(tail+array.toString());
						}
						//then create a new argument!
						//now the tails have arguments
						//find all the combinations of the premises arguments
						
						ArrayList comb=getCombinatories(array);
						
						Iterator itch = comb.iterator();
						String tot;
						Arg argi;
						while(itch.hasNext()){
							tot=(String) itch.next();
							String[] we=tot.split(";");
							ArrayList subs=new ArrayList();
							HashSet pres=new HashSet();
							ArrayList arprem=new ArrayList();
							for(int i=0;i<we.length;i++){
								subs.add(we[i]);
								argi=(Arg) arbi.get(we[i]);
								subs.addAll(argi.getSubs());
								pres.addAll(argi.getPrems());
								arprem.add(we[i]);
							}
							id="A"+count; 
							count++;
							arg=new Arg(id);
						 
							arg.setSubs(subs);
							arg.setConc(con);
							if(rprefs.containsKey(con)){
								arg.setPref();
							}
							arg.setStrictDef(rule.isStrict());//strict
							//def rules
							Iterator itg=arg.getSubs().iterator();
							String argsub;
							while(itg.hasNext()){
								argsub=(String) itg.next();
								//System.out.println(argsub);
								argi=(Arg) arbi.get(argsub);
								arg.setDefRule(argi.getDefRule());
								if(arg.isStrict()){
									arg.setlastDefRule(argi.getlastDefRule());
								}
							}
							if(!arg.isStrict()){
								arg.setlastDefRule(rule.getId());
								arg.setDefRule(rule.getId());
							}
					 
							arg.setTopRule(rule);
							pres.addAll(rule.getTails());
							arg.setPrems(pres);
							arg.setArgPrems(arprem);
							arg.setOrdPrems(getOrdPrem(pres));
							// argument created now add 
							if(arbc.containsKey(con)){
								argset=(ArrayList) arbc.get(con);
							}else{
								argset=new ArrayList();
							}
							argset.add(arg.getId());
							arbc.put(con,argset);
							if(arg.isPref()){
								ArrayList prefset;
								//add to argpref
								if(argprefs.containsKey(con)){
									prefset=(ArrayList) argprefs.get(con);
								}else{
									prefset=new ArrayList();
								}
								prefset.add(arg.getId());
								argprefs.put(con,prefset);
							}
							arbi.put(id, arg);
							args.add(id);
							//System.out.println("COND2"+arg.toString());
						}
						
						
					}
					
				}
					
				}else{
					//do nothing 
					//THIRD TERMINATION COND
				}
		
		}

	}
	
	 







	private ArrayList getCombinatories(ArrayList prefix) {
	 
		       ArrayList base=new ArrayList();
		       String p1,p2;
		       Iterator itf,its;
		       if(prefix.size()>1){
		    	   Iterator iter=prefix.iterator();
		    	   ArrayList first=(ArrayList) iter.next();
		    	   ArrayList second=new ArrayList();
		    	   while(iter.hasNext()){
		    		   //first
		    		   //second
		    		   second=(ArrayList) iter.next();
		    		   itf=first.iterator();
		    		  
		    		   while(itf.hasNext()){
		    			   p1=(String) itf.next();
		    			   its=second.iterator();
		    			   while(its.hasNext()){
		    				   p2=(String) its.next();
		    				   base.add(p1+";"+p2);  
		    			   }
		    		   }
		    		   first=base;
		    		   base=new ArrayList();
		    		 //
		    		   //System.out.println(first);
		    	   }
		    	   base=first;
		       	}else{
		    	   base=(ArrayList) prefix.get(0);
		       	}
		    	//System.out.println(base);
		       
		 return (ArrayList) base.clone();
	}



	private boolean isIstantiated(Rule rule, HashSet<String> cycle) {
		// System.out.println(cycle);
		if(concls.containsAll(rule.getTails()) && !cycle.contains(rule.getId())){
			//System.out.println(cycle);
			return true;
			
		}		
		return false;
	}



	public void findAtks(HashSet conc, HashMap fopp){
		
		 
		Iterator iteri=arbi.keySet().iterator();
		Iterator iterj;
		Arg A,B;
		while(iteri.hasNext()){
			 A=(Arg) arbi.get(iteri.next());
			 iterj=arbi.keySet().iterator();
			 while(iterj.hasNext()){
				B=(Arg) arbi.get(iterj.next()); 
				 
		 	if(!A.equals(B)){ 
		 		//System.out.println("check"+A+":"+B+fopp);
		 		computeAtks(A, B, fopp);
		 	}
		 	}
		 }
		 
		
	}
	
	
	
	

	








	private void computeAtks(Arg A, Arg B, HashMap fopp) {
		
 //do arguments by argument
 
		boolean undercut=false;
		String conc,cont;
		HashSet cuts;
		HashSet setcont;
		Iterator itcnt;
		  
						//System.out.println(A.getId()+"-"+B.getId());
						conc=A.getConc(); //if it is a negated rule then it will start with NNN, find its contrary
						setcont=(HashSet)fopp.get(conc);
						//System.out.println(setcont);
					 if(setcont!=null){
						itcnt=setcont.iterator();
						while(itcnt.hasNext()){
					
							cont=(String) itcnt.next();
				
							if(rulbi.containsKey(cont)){
	 				//then it is attacking a rule 
								Rule fl=(Rule) rulbi.get(cont);
								if(!fl.isStrict()){
									undercut=true;
								}
							}
	 		 
				
			
			 		
			 			//undercut? 
			 			if(undercut){
			 				cuts=(HashSet) uncuts.get(A.getId());
			 				
			 				if(cuts==null || !cuts.contains(B.getId())){
			 					//then new arg
			 					
			 					Rule tops=B.getTopRule();
			 					
			 					if(tops!=null){
			 						if(cont.equals(tops.getId())){
			 							//then undercut
			 							if(cuts==null){
			 								cuts=new HashSet();
			 							}
			 							cuts.add(B.getId());
			 							uncuts.put(A.getId(), cuts);
			 						}else{
			 							//check subs
			 							String defs;
			 							
			 							if(B.getDefRule().contains(cont)){
			 						 
			 								if(cuts==null){
						 						cuts=new HashSet();
			 								}
						 					cuts.add(B.getId());
						 					uncuts.put(A.getId(), cuts);
						 				}
			 						}
			 
			 					 
			 					}//else no attack
			 					
			 				}
			 			}else{
			 				
			 		 	
			 			//undermine?
			 				// System.out.println(A.getId()+"-"+B.getId()+":"+cont);
			 				// System.out.println(B.getPrems());
			 				
			 			if(B.getOrdPrems().contains(cont)){
			 				//System.out.println(B.getPrems());
			 				boolean bok=false;
			 				
			 				if(fopp.containsKey(cont)){
			 				//	System.out.println("I am checking if this is undermine");
			 					 
			 					HashSet hope=(HashSet) fopp.get(cont);
			 					if(hope.contains(conc)){
			 					//then contradictory
			 						HashSet array;
			 						AtkTrip triple=new AtkTrip(B.getId(),cont);
			 					if(unmines.containsKey(A.getId())){
			 						array=(HashSet) unmines.get(A.getId());
			 						if(!array.contains(triple)){
			 							array.add(triple);
			 							//Create silly argument and add preference if needed!!!
			 							String id="A"+count; 
			 							count++;
			 							Arg arg=new Arg(id);
			 							HashSet pr=new HashSet();
			 							pr.add(cont);
			 							arg.setPrems(pr);
			 							arg.setOrdPrems(getOrdPrem(pr));
			 							arg.setConc(cont);
			 							if(rprefs.containsKey(cont)){
			 								arg.setPref();
			 							}
			 							arg.setStrictDef(true);//strict
			 							//last def rules undefined
			 							// argument created now add 
			 							tarbi.put(id, arg);
			 							 
			 							 
			 						}
			 					}else{
			 						array=new HashSet();
			 						array.add(triple);
			 						//Create silly argument and add preference if needed!!!
		 							String id="A"+count; 
		 							count++;
		 							Arg arg=new Arg(id);
		 							HashSet pr=new HashSet();
		 							pr.add(cont);
		 							arg.setPrems(pr);
		 							arg.setOrdPrems(getOrdPrem(pr));
		 							arg.setConc(cont);
		 							if(rprefs.containsKey(cont)){
		 								arg.setPref();
		 							}
		 							arg.setStrictDef(true);//strict
		 							//last def rules undefined
		 							// argument created now add 
		 							tarbi.put(id, arg);
		 					 
		 							 
			 					}
			 					unmines.put(A.getId(), array);
			 					//System.out.println(A.getId()+":"+B.getId());
			 					bok=true;
			 					}
			 				}if(!bok){
			 					//then contrary
			 					HashSet array;
			 					if(cunmines.containsKey(A.getId())){
			 						array=(HashSet) cunmines.get(A.getId());
			 					}else{
			 						array=new HashSet();
			 					}
			 					array.add(B.getId());
			 					cunmines.put(A.getId(), array);

			 				}
			 				
			 			}
			 			
			 			
			 			//rebut? 
			 			ArrayList toprules=(ArrayList) B.getSubs().clone();
			 			toprules.add(B.getId());
			 			
			 			Iterator itr=toprules.iterator();
			 			String gBi;Arg Bi;
			 			boolean bok;
			 			while(itr.hasNext()){
			 				gBi=(String) itr.next();
			 				Bi=(Arg) arbi.get(gBi);
			 				bok=false;
			 				
			 				if(Bi.getConc().equals(cont) && !Bi.isStrict()){
			 					//System.out.println(A.getId()+":"+Bi.getId()+":"+cont+":"+conc);
			 					if(fopp.containsKey(cont)){
			 						
			 						HashSet hope=(HashSet) fopp.get(cont);
				 					if(hope.contains(conc)){
				 						//System.out.println("contradictory"+B.getId()+Bi.getId());
			 						//then contradictory
				 						HashSet array;
				 						AtkTrip triple=new AtkTrip(B.getId(),Bi.getId());
				 						if(rebs.containsKey(A.getId())){
				 							array=(HashSet) rebs.get(A.getId());
				 							if(!array.contains(triple)){
					 							array.add(triple);
					 						}
				 						}else{
				 							array=new HashSet();
				 							array.add(triple);
				 						}
				 						 
				 						rebs.put(A.getId(), array);
				 						bok=true;
				 					}
				 		
			 					} 
			 					//then contrary
			 					if(!bok){
			 					//	System.out.println("contrary"+B.getId()+Bi.getId());
			 						HashSet array;
			 						if(crebs.containsKey(A.getId())){
			 							array=(HashSet) crebs.get(A.getId());
			 						}else{
			 							array=new HashSet();
			 						}
			 						array.add(Bi.getId());
			 						array.add(B.getId());
			 						crebs.put(A.getId(), array);

			 				}
			 				}
			 			}
			 			
			 			}
			 		}
				}
				
	
		
		
		
		
	}



 
 



	public HashMap getPrefs() {
		// TODO Auto-generated method stub
		return argprefs;
	}



	public HashMap[] getAtks() {
		
		HashMap[] map=new HashMap[5];
	//	System.out.println("GET THEM"+uncuts+"\n"+unmines+"\n"+rebs+"\n"+crebs+"\n"+cunmines);
		map[0]=uncuts;
		map[1]=unmines;
		map[2]=rebs;
		map[3]=crebs;
		map[4]=cunmines;
		return map;
	}



 

 

	public ArrayList[] getArgAtks(){
		// and two-element String-arrays ([attacker, attacked])
		
		ArrayList defeats=new ArrayList();
		//now convert 
		Iterator iter=defs.keySet().iterator();
		//System.out.println(defs);
		String[] couple;
		Iterator itxx;
		String A,B;
		// System.out.println("ALL");
		while(iter.hasNext()){
			A=(String) iter.next();
			itxx=((HashSet)defs.get(A)).iterator();
			while(itxx.hasNext()){
				B=(String) itxx.next();
				couple=new String[2];
				couple[0]=A;
				couple[1]=B;
				defeats.add(couple);
			   // System.out.print("\""+A+">"+B+"\",");
			}
		}
		//System.out.println("\nALL");
		ArrayList list[]=new ArrayList[3];
		list[0]=args;
		list[1]=defeats;
		list[2]=atkonatk;
		return list;
		
		
		
	}








	public HashMap[] getArguments() {
		HashMap[] res=new HashMap[2];
		res[0]=arbi;
		res[1]=arbc;
		return res;
	}








	public Object[] test() {
		//this is to test if there is need to add more strict rules
		//and then check attacks on attacks
		//for all unmines, rebs
		
		newruleset=computeDefeats();
		return new Object[]{newruleset,kbpref,kbpref_rev,countid};
	}
	
	
 
	
	
	
	
	
	private HashSet computeDefeats() {
		
		HashSet ruleset=new HashSet();
	   //check rebuttals
		HashMap defeats=new HashMap();
		String A,B;
		Arg ArgA,ArgB;
		HashSet rebuttals;
		AtkTrip triple;
		String p1,p2;
		Iterator itcc,iter=rebs.keySet().iterator();
		Iterator itpa,itpb;
		Pref pref;
		
		while(iter.hasNext()){
			A=(String)iter.next();
			rebuttals= (HashSet) rebs.get(A);
			itcc=rebuttals.iterator();
			//adddefea
			HashSet carray;
			if(defeats.containsKey(A)){
				carray=(HashSet) defeats.get(A);
			}else{
				carray=new HashSet();
			}
			while(itcc.hasNext()){
				triple=(AtkTrip) itcc.next();
				B=triple.getArgument();
				carray.add(B);
				
				//is there need of a new strict rule? 
				ArgA=(Arg) arbi.get(A);
				ArgB=(Arg) arbi.get(B);
			//	System.out.println("do I get here?");
				//check all the combinations of the premises of the two arguments
				itpa=ArgA.getPrems().iterator();
				 
				while(itpa.hasNext()){
					itpb=ArgB.getPrems().iterator();
					p1=(String) itpa.next();
					while(itpb.hasNext()){
						p2=(String) itpb.next();
						//now need to know if there is an argument that has conclusion pref(p1,p2)
						//how do I represent pref(p1,p2)? need a map .....
						String prefst=p1+"<"+p2;
						//System.out.println(prefst);
						String extrach=ArgA.getConc()+"<"+ArgB.getConc();
						ArrayList prefset=null;
						if(kbpref.containsKey(prefst) && !prefst.equals(extrach)){
							pref=(Pref) kbpref.get(prefst);
							String prefconc=pref.getId();
							if(argprefs.containsKey(prefconc)){
								prefset=(ArrayList) argprefs.get(prefconc);
							}
						}
						//System.out.println(prefset);
						//two reasons for being null, not a preference, or not an argument for it
						if(prefset!=null){
						//	System.out.println("new rule"+prefset);
							//a new strict rule is added!!! 
							//create it now!
							//exclude arguments with negative preferences
							
							Rule rule;
							 
							rule=new Rule();
						    rule.setStrict();
						    
						    rule.setId("expf"+counter++);
						   
							pref=addPreference(p1,p2);
						//	System.out.println("reb-pref1"+pref.toString());
							rule.addTail(pref.getId());
						 
							//System.out.println(ArgA.toString()+ArgB.toString()+":");
							pref=addPreference(ArgA.getConc(),ArgB.getConc());
							// System.out.println("reb:"+p1+":"+p2+":"+rule.getId()+" "+pref);
						//	System.out.println("reb-pref2"+pref.toString());
							rule.setHead(pref.getId());
							rule.setPref();
						//	 System.out.println("rule:"+rule.toString());
							if(rulbc.containsKey(rule.getHead())){
								ArrayList list=(ArrayList) rulbc.get(rule.getHead());
								if(!list.contains(rule)){
									//there is no duplicate
									ruleset.add(rule);
								}
							}else{
								ruleset.add(rule);
							}
						}
						
					}
				}
				if((ArgA.isStrict() && ArgB.isStrict()) || !ArgA.isStrict()){
				//now check if there is need of an attack on the attack
				String prefst=ArgA.getConc()+"<"+ArgB.getConc();
				if(kbpref.containsKey(prefst)){
			//System.out.println(argprefs);
				pref=(Pref) kbpref.get(prefst);
				String prefconc=pref.getId();
				if(argprefs.containsKey(prefconc)){
					ArrayList prefset=(ArrayList) argprefs.get(prefconc);
					Iterator itarg=prefset.iterator();
					while(itarg.hasNext()){
						String arg=(String) itarg.next();
						// ([attacker, attacker,attacked])
						String[] tuple=new String[]{arg,A,B};
						atkonatk.add(tuple);
					//	System.out.println(tuple);
					}
				}
				}
				}
			}
			defeats.put(A, carray);

		}
		
	//	System.out.println("defeats"+defeats);
		
		HashSet undermines;
		iter=unmines.keySet().iterator();
		while(iter.hasNext()){
			//System.out.println("I am getting here");
			try{
			A=(String)iter.next();
			//System.out.println(A);
			undermines= (HashSet) unmines.get(A);
			//System.out.println(undermines);
			itcc=undermines.iterator();
			//adddefea
			HashSet carray;
			if(defeats.containsKey(A)){
				carray=(HashSet) defeats.get(A);
			}else{
				carray=new HashSet();
			}
			while(itcc.hasNext()){
				triple=(AtkTrip) itcc.next();
				B=triple.getArgument();
				carray.add(B);
				
				//is there need of a new strict rule? 
				ArgA=(Arg) arbi.get(A);
				ArgB=(Arg) arbi.get(B);
				//check all the combinations of the premises of the two arguments
				itpa=ArgA.getPrems().iterator();
			//	System.out.println("do I get here? 1 ");
				while(itpa.hasNext()){
					itpb=ArgB.getPrems().iterator();
					p1=(String) itpa.next();
					while(itpb.hasNext()){
						p2=(String) itpb.next();
						//now need to know if there is an argument that has conclusion pref(p1,p2)
						//how do I represent pref(p1,p2)? need a map .....
						String prefst=p1+"<"+p2;
						String extrach=ArgA.getConc()+"<"+ArgB.getConc();
						ArrayList prefset=null;
						if(kbpref.containsKey(prefst) && !prefst.equals(extrach)){
							pref=(Pref) kbpref.get(prefst);
							String prefconc=pref.getId();
							if(argprefs.containsKey(prefconc)){
								prefset=(ArrayList) argprefs.get(prefconc);
							}
						}
						//two reasons for being null, not a preference, or not an argument for it
						if(prefset!=null){
							//a new strict rule is added!!! 
							//create it now!
							//System.out.println("new rule"+prefset);
							Rule rule;
							 
							rule=new Rule();
						    rule.setStrict();
						    rule.setId("expf"+counter++);
						    
							pref=addPreference(p1,p2);
							// System.out.println("underm - pref1:"+pref.toString());
							rule.addTail(pref.getId());
							//System.out.println(ArgA.toString()+ArgB.toString()+":");
							pref=addPreference(ArgA.getConc(),ArgB.getConc());
							// System.out.println("underm - pref2:"+pref.toString());
							rule.setHead(pref.getId());
							rule.setPref();
						//	System.out.println("underm:"+p1+":"+p2+":"+rule.getId()+":"+pref);
						//	 System.out.println("rule:"+rule.toString());
							if(rulbc.containsKey(rule.getHead())){
								ArrayList list=(ArrayList) rulbc.get(rule.getHead());
								if(!list.contains(rule)){
									ruleset.add(rule);
								}
							}else{
								ruleset.add(rule);
							}
						}
						
					}
				}
				if((ArgA.isStrict() && ArgB.isStrict()) || !ArgA.isStrict()){
				//now check if there is need of an attack on the attack
				String prefst=ArgA.getConc()+"<"+ArgB.getConc();
				if(kbpref.containsKey(prefst)){
				//	System.out.println(argprefs);
				pref=(Pref) kbpref.get(prefst);
				String prefconc=pref.getId();
				if(argprefs.containsKey(prefconc)){
					ArrayList prefset=(ArrayList) argprefs.get(prefconc);
					Iterator itarg=prefset.iterator();
					while(itarg.hasNext()){
						String arg=(String) itarg.next();
						// ([attacker, attacker,attacked])
						String[] tuple=new String[]{arg,A,B};
						atkonatk.add(tuple);
					//	System.out.println(tuple);
					}
				}}
				}
			}
			defeats.put(A, carray);
			}catch(Exception a){
				System.out.println(a);
			}
		}
	//	System.out.println("I am getting out");
		
		
		//now if there are new rules need to do it from scratch 
		//else prepare defeats
	 	if(ruleset.isEmpty()){
	 //		System.out.println("BEFORE"+defs);
			defs.putAll(defeats);
		//	System.out.println("BEFORE 1"+defs);
			//now add all undercuts
			defs.putAll(uncuts);
	//		System.out.println("BEFORE UNCUTS"+defs);
			//now contrary unmines and rebuttals
			iter = crebs.keySet().iterator();
			HashSet array,darr;
			//if contrary rebut
			while(iter.hasNext()){
				A=(String) iter.next();
				array=(HashSet) crebs.get(A);
				if(defs.containsKey(A)){
					darr=(HashSet) defs.get(A);
					darr.addAll(array);
				}else{
					darr=new HashSet();
					darr.addAll(array);
				}
				defs.put(A, darr);
			}
			//System.out.println("BEFORE REBS"+defs);
			iter = cunmines.keySet().iterator();
			//if contrary rebut
			while(iter.hasNext()){
				A=(String) iter.next();
				array=(HashSet) cunmines.get(A);
				if(defs.containsKey(A)){
					darr=(HashSet) defs.get(A);
					darr.addAll(array);
				}else{
					darr=new HashSet();
					darr.addAll(array);
				}
				defs.put(A, darr);
			}
		//	System.out.println("BEFORE CMINES"+defs);
			
	 	} 
       return ruleset;
		 
		
		
		
		
		
	 
		
	}
	
	
	private Pref addPreference(String left,String right){
		
		Pref pref;
		String prefst=left+"<"+right;
		String oppst=right+"<"+left;
		if(kbpref.containsKey(prefst)){
			pref=(Pref) kbpref.get(prefst);
			
		}else{
			
			String idp="PPP"+countid++;
			String ido="PPP"+countid++;
			 
			
			pref=new Pref(left,right,prefst,idp,ido);
			Pref opp=new Pref(right,left,oppst,ido,idp);
			kbpref.put(prefst, pref);
			kbpref.put(oppst, opp); 
	
			if(!left.contains("NNN") && !right.contains("NNN")){
		 		String value="("+prefst+")";
		 		while(value.contains("PPP")){
		 			//System.out.println(value);
		 			String spt[]=value.split("<");
		 			for(String tok:spt){
		 				if(tok.contains("PPP")){
		 					//System.out.println(kbpref_rev);
		 				
		 					tok=tok.replaceAll("\\(","");
		 					tok=tok.replaceAll("\\)","");
		 					if(kbpref_rev.containsKey(tok)){
		 						Pref pf=(Pref) kbpref_rev.get(tok);
		 						value=value.replace(tok, "("+pf.getPred()+")");
		 						//System.out.println(tok+pf.getPred());
		 					}
		 				}
		 			}
 
		 		}
		 	//	System.out.println(pref+":"+value);
		 		pref.setComplete_pred(value);
		 	//	System.out.println(kbpref_rev);
				kbpref_rev.put(pref.getId(),pref);
				  value="("+oppst+")";
		 		while(value.contains("PPP")){
		 		//	System.out.println(value);
		 			String spt[]=value.split("<");
		 			for(String tok:spt){
		 				if(tok.contains("PPP")){
		 					//System.out.println(kbpref_rev);
		 				
		 					tok=tok.replaceAll("\\(","");
		 					tok=tok.replaceAll("\\)","");
		 					if(kbpref_rev.containsKey(tok)){
		 						Pref pf=(Pref) kbpref_rev.get(tok);
		 						value=value.replace(tok, "("+pf.getPred()+")");
		 					//	System.out.println(tok+pf.getPred());
		 					}
		 				}
		 			}
 
		 		}
		 	//	System.out.println(opp+":"+value);
		 		opp.setComplete_pred(value);
		 	//	System.out.println(kbpref_rev);
				kbpref_rev.put(opp.getId(),opp);
			}
			
			
		}
			 
	 
		return pref;
	}
	
	
	
	
	

}
