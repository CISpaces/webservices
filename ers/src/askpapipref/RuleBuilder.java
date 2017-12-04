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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jgrapht.alg.CycleDetector;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class RuleBuilder {

	private HashMap fopp;
 
	private HashSet symb;
	private HashMap rulbc;
	private HashMap rulbi;
	private HashMap kbpref;
	private HashMap kbpref_rev;
	private HashMap rpref;
	private HashSet rules;
	private HashSet prefl;
	private int counter;	
	private int countid;
	private boolean wlf;
	private DefaultDirectedGraph<String, DefaultEdge> graph;
	public RuleBuilder() {
		graph=new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		symb=new HashSet();//prevent duplicates
		fopp= new HashMap();
		counter=0;
		countid=0;
		rules=new HashSet();
		rulbc=new HashMap();
		rulbi=new HashMap();
		wlf=true;
		prefl=new HashSet();
		kbpref=new HashMap(); //map of symbol prefs
		rpref=new HashMap(); // map of hashsets rulbc that have a preference conclusion
		kbpref_rev=new HashMap();
	}
	
	
	
	public HashMap getFOpp(){
		return fopp;
	}
	
	 
	
	public HashMap getRules(String rul) {
		//System.out.println(rul);
	
		rul=rul.replaceAll(" ", "");
		 
		String token,sqk;
		String  leftx,right,id,type;
		Rule rule;
		StringTokenizer tk=new StringTokenizer(rul,";"), tg;
 
		while(tk.hasMoreTokens()){
			 
			token=tk.nextToken();
		//	System.out.println(token);
			boolean check=checkRule(token);
		  //  System.out.println(check);
			if(check){
			rule=new Rule();
			id=token.substring(token.indexOf("[")+1,token.indexOf("]"));
			 rule.setId(id);
			leftx=token.substring(token.indexOf("]")+1,token.indexOf(">")-1);
			tg=new StringTokenizer(leftx,",");
			boolean test=true;
			boolean isneg=false;
			while(tg.hasMoreTokens()){
				sqk=tg.nextToken();
				if(sqk.contains("<")){
					//then it is a preference
				 
					test=test&true;
					if(sqk.contains("~")){
						sqk=sqk.replace("~", "");
						isneg=true;
					}
					Pref pref=subPreference(sqk,kbpref);
					sqk=pref.getId();
					if(isneg){
						   //it is only one
						   addcontrary(sqk);
						   sqk="NNN"+sqk;
						   prefl.add(sqk); 
					}
				}else{ 
					test=test&false;
					if(sqk.contains("~")){
				   //it is only one
						addcontrary(sqk.substring(sqk.indexOf("~")+1));
						sqk=sqk.replace("~", "NNN");
					}
				}
				 rule.addTail(sqk);
				 symb.add(sqk);
				  
				}
			
			right=token.substring(token.indexOf(">")+1);
			if(right.contains("<")){
				//then it is a preference
				Pref pref;
				test=test&true;
				if(right.contains("~")){
					right=right.replace("~", "");
					isneg=true;
				}
				pref=subPreference(right,kbpref);
				right=pref.getId();
				if(isneg){
					   //it is only one
					   addcontrary(right);
					   sqk="NNN"+right;
					   prefl.add(sqk); 
				}
		 
				HashSet prefts;
				if(rpref.containsKey(right)){
					prefts=(HashSet) rpref.get(right);
				}else{
					prefts=new HashSet();
				}
				prefts.add(rule.getId());
				rpref.put(right,prefts);
				rule.setPref();
				
			}else{ 
			 
				if(right.contains("~")){
				//it is only one
					addcontrary(right.substring(right.indexOf("~")+1));
					right=right.replace("~", "NNN");
				}
			
			}
			rule.setHead(right);
			symb.add(right);
			type=token.substring(token.indexOf(">")-1,token.indexOf(">"));
			if(type.equals("=")){
				rule.setDefeasible();
			}else if(type.equals("-")){
				rule.setStrict();
			}
			ArrayList list;
			if(rulbc.containsKey(rule.getHead())){
				list=(ArrayList) rulbc.get(rule.getHead());
			}else{
				list=new ArrayList();
			}
			if(!rules.contains(rule)){
				if(!list.contains(rule)){
					list.add(rule);
				rulbc.put(rule.getHead(),list);
				rulbi.put(rule.getId(),rule);
				rules.add(rule);
				graphAddRule(rule);
			}
			
	
			}
			//then add into the graph
			
			
			
			
		 
			}
		}
	//	System.out.println(rulbc.toString());
		complete();
		//System.out.println(kbpref.toString());
	 //	System.out.println(rulbc.toString());
	 	
	 //	System.out.println(wlf);
		return rulbc;
	}

	
	private void graphAddRule(Rule rule) {
		String id=rule.getId();
		 graph.addVertex(rule.getHead());
		 graph.addVertex(id);
		 graph.addEdge(id,rule.getHead());
		 Iterator itt=rule.getTails().iterator();
		 while(itt.hasNext()){
			 String tail=(String) itt.next();
			 graph.addVertex(tail);
			 graph.addEdge(tail, id);
		 }
		 
		
	}

	
	public HashSet<String> testGraphStructure(HashSet prems) {
		// TODO Auto-generated method stub
		HashSet<String> remrule=new HashSet<String>();
		HashSet<String> remtemp=new HashSet<String>();
		HashSet<String> rcycle=new HashSet<String>();
		CycleDetector cycledet=new CycleDetector(graph);
		HashSet<String> cycleV=(HashSet<String>) cycledet.findCycles();
	//	System.out.println(cycleV);
		if(!cycleV.isEmpty()){
			 
			//for now we say that this is not allowed.... 
			//other way to handle this is to use all input to the cycle as premises 
			
			  for(String node:cycleV){
				  if(rulbi.containsKey(node)){
					 //it is a rule
				  }else{
					  //check if prem
					  if(prems.contains(node)){
						  //then remove the rule leading to it
						  Set<DefaultEdge> set=graph.incomingEdgesOf(node);
						  for(DefaultEdge edge:set){
							  String source=graph.getEdgeSource(edge);
							  if(cycleV.contains(source)){
								  //this is a rule
								 remtemp.add(source);
							  }
						  }  
					  }else{
						  //not a prem //search for other rules that support it
						  ArrayList list=(ArrayList) rulbc.get(node);
						  Iterator itl=list.iterator();
						  while(itl.hasNext()){
							  Rule rule=(Rule) itl.next();
							  if(!cycleV.contains(rule.getId())){
								  //then it is our candidate 
								  Set<DefaultEdge> set=graph.incomingEdgesOf(node);
								  for(DefaultEdge edge:set){
									  String source=graph.getEdgeSource(edge);
									  if(cycleV.contains(source)){
										  //this is a rule
										 remtemp.add(source);
									  }
								  }
								  
							  }
						  }
					  }
				  }
				  
			  }
			  //now all the supported part is broken 
			  //remove it from graph
			  graph.removeAllVertices(remtemp);
			  //look at unsupported cycles
			  remrule.addAll(remtemp);
			  
			  while(!cycleV.isEmpty()){
				  remtemp=new HashSet<String>();
				  cycledet=new CycleDetector(graph);
				  cycleV=(HashSet<String>) cycledet.findCycles();
				  //remove one rule
				  boolean found=false;
				  for(String node:cycleV){
					  if(rulbi.containsKey(node)){
							 //it is a rule
						  	 remtemp.add(node);
						  	 found=true;
					  }else{
						  if(found){
							  break;
						  }
					  }
				  }
				  graph.removeAllVertices(remtemp);
				  remrule.addAll(remtemp);
			  }
		}//else no cycles detected!! Great!!!
			return remrule;
	}


	private Object[] addPreference(String left,String right, HashMap map){
		Pref pref;
		String prefst=left+"<"+right;
		String oppst=right+"<"+left;
		if(kbpref.containsKey(prefst)){
			pref=(Pref) kbpref.get(prefst);
		}else{
			
			String idp="PPP"+countid++;
			String ido="PPP"+countid++;
			//System.out.println("RULE"+idp+ido);
			pref=new Pref(left,right,prefst,idp,ido);
			Pref opp=new Pref(right,left,oppst,ido,idp);
			map.put(prefst, pref);
			map.put(oppst, opp); 
		
			prefl.add(idp);
			prefl.add(ido);
			
		 	if(!left.contains("NNN") && !right.contains("NNN")){
		 		String value="("+prefst+")";
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
		 	//		System.out.println(value);
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
		 //		System.out.println(kbpref_rev);
				kbpref_rev.put(opp.getId(),opp);
			}
			
			
		}
		Object[] obj=new Object[]{map,pref};
		return obj;
	}
	
	private Pref subPreference(String pfst,HashMap base){
		 
		//System.out.println(pfst);
		char[] charArray;
		String comp;
		String initoken,token;
		String prv;
		int last=0;
		Pref pref=null;
		  while(pfst.contains("<")){
			//System.out.println("hi");
			charArray = pfst.toCharArray();
			for(int i=0;i<charArray.length;i++){
				char c=charArray[i];
				comp=String.valueOf(c);
				
				if(comp.equals("(")){
					last=i;
				}else 
				if(comp.equals(")")){
					
					token=pfst.substring(last+1,i);
				//	System.out.println(token);
					initoken=pfst.substring(last,i+1);
				//	System.out.println(initoken);
					String[] sqk=token.split("<");
					Object[] res=addPreference(sqk[0],sqk[1],base);
					base=(HashMap) res[0];
					pref=(Pref) res[1];
					
				 				//	System.out.println(pref.toString());
					pfst=pfst.replace(initoken, pref.getId());
				//	System.out.println(pfst);
					break;
			}
			
		}
		 }

		return pref;
	}

	
	
	
	private void complete() {
		//System.out.println(kbpref);
		//System.out.println(rulbc.toString());
		addPrefrulbc();
		//System.out.println(rulbc.toString());
	//	System.out.println(kbpref);
		Iterator iter=rulbi.keySet().iterator();
		HashSet rules=new HashSet();
		while(iter.hasNext()){
			String id=(String) iter.next();
			Rule rule=(Rule) rulbi.get(id);
			if(rule.isStrict()){
				HashSet srt=closeUnderTransposition(rule);
			//	System.out.println(rule+":"+srt);
				rules.addAll(srt);
			}
		}
		iter=rules.iterator();
		while(iter.hasNext()){
			Rule newrule=(Rule) iter.next();
		 ArrayList list;
		if(rulbc.containsKey(newrule.getHead())){
			list=(ArrayList) rulbc.get(newrule.getHead());
		}else{
			list=new ArrayList();
		}
		if(!list.contains(newrule)){
			list.add(newrule);
	//	System.out.println(rule.toString());
		rulbc.put(newrule.getHead(),list);
		rulbi.put(newrule.getId(),newrule);
		graphAddRule(newrule);
		}
		}
	}



	private void addPrefrulbc() {
		//transitivity
		
	    HashSet merge=new HashSet();
		Iterator itt;
		String idd;
		Pref other,pref;
		ArrayList list;
	    HashMap initset=kbpref;
		HashMap mapextra;
		
		do{ 
		//	System.out.println(kbpref);
			mapextra=new HashMap();
			merge=new HashSet();
			Iterator iter=initset.keySet().iterator();
			while(iter.hasNext()){
			//asymmetry 
				String prefid=(String) iter.next();
				pref=(Pref) initset.get(prefid);
				itt=kbpref.keySet().iterator();
				while(itt.hasNext()){
				  idd=(String) itt.next();
				  if(idd.contains(pref.getRight()+"<") && !idd.contains(pref.getLeft())){
				  	//then found a candidate!! 
					 other=(Pref)kbpref.get(idd);
					//need to add another pref
					 if(!pref.getLeft().startsWith("NNN") && !other.getRight().startsWith("NNN")){
						 String head=pref.getLeft()+"<"+other.getRight();
						 if(!kbpref.containsKey(head)){
						Pref newpref=subPreference("("+head+")",mapextra);
						//System.out.println(newpref.toString());
						merge.add(new String[]{pref.getPred(),other.getPred(),newpref.getPred()}); 
					}
					}
				  }
			  }
		
		}
		/*	System.out.println("NEW"+mapextra);
		
			Iterator itmer=merge.iterator();
			while(itmer.hasNext()){
				String[] t=(String[]) itmer.next();
				System.out.println(t[0]+" "+t[1]+" "+t[2]);
			}
			System.out.println(kbpref);
		*/
			kbpref.putAll(mapextra);
			 
			//now build a rule for each merge
			Iterator img=merge.iterator();
			while(img.hasNext()){
				String[] merr=(String[]) img.next();
				Rule rule;
				rule=new Rule();
			    rule.setStrict();
			    rule.setId("pf"+counter++);
				pref=(Pref) kbpref.get(merr[0]);
				
				rule.addTail(pref.getId());
				pref=(Pref) kbpref.get(merr[1]);
				rule.addTail(pref.getId());
				pref=(Pref) kbpref.get(merr[2]);
				rule.setHead(pref.getId());
				rule.setPref();
			 
				if(rulbc.containsKey(rule.getHead())){
					list=(ArrayList) rulbc.get(rule.getHead());
				}else{
					list=new ArrayList();
				}
			 	//System.out.println(rule.toString());
				if(!rules.contains(rule)){
					if(!list.contains(rule)){
						list.add(rule);
					rulbc.put(rule.getHead(),list);
					rulbi.put(rule.getId(),rule);
					rules.add(rule);
					graphAddRule(rule);
				}
			}
			
			} 
		//	System.out.println(mapextra);
			initset=mapextra;
		//	System.out.println(kbpref);
		}while(!mapextra.isEmpty());
		
	  Iterator iter=kbpref.keySet().iterator();
		while(iter.hasNext()){
			//asymmetry 
			String prefid=(String) iter.next();
			  pref=(Pref) kbpref.get(prefid);
			Rule  rule=new Rule();
			rule.setStrict();
			rule.setId("pf"+counter++);
			rule.addTail(pref.getId());
			String head=pref.getOppid();
			head=addcontrary(head);
			rule.setHead(head);
			rule.setPref();
			
			
			if(rulbc.containsKey(rule.getHead())){
				list=(ArrayList) rulbc.get(rule.getHead());
			}else{
				list=new ArrayList();
			}
			
		//	System.out.println(rule.toString());
			if(!rules.contains(rule)){
				if(!list.contains(rule)){
					list.add(rule);
				rulbc.put(rule.getHead(),list);
				rulbi.put(rule.getId(),rule);
				rules.add(rule);
				graphAddRule(rule);
			}
			}

			
		}
		
	}



	private HashSet closeUnderTransposition(Rule rule) {
	
		//then set new rulbc
		ArrayList ttails;
		Iterator ity=rule.getTails().iterator();
		String tconcl,tcontrcl;
		HashSet set=new HashSet();
		ArrayList list;
		while(ity.hasNext()){
			tconcl=(String) ity.next();
			Rule newrule=new Rule();
			newrule.setStrict();
			newrule.setId("tr"+counter++);
			tcontrcl=addcontrary(tconcl);
			newrule.setHead(tcontrcl);
			
			ttails=(ArrayList) rule.getTails().clone();
			ttails.add(addcontrary(rule.getHead()));
			ttails.remove(tconcl);
			newrule.setTails(ttails);
			if(prefl.contains(tcontrcl)){
				newrule.setPref();
				HashSet prefts;
				if(rpref.containsKey(tcontrcl)){
					prefts=(HashSet) rpref.get(tcontrcl);
				}else{
					prefts=new HashSet();
				}
				prefts.add(rule.getId());
				rpref.put(tcontrcl,prefts);
				rule.setPref();
			}
			 //now add new rule
			set.add(newrule);
		
			}
	 
		return set;
	}



	private boolean checkRule(String rule) {
		String pattern="\\[r\\d+\\].+(,\\w+)*[=-]>.+";
		//System.out.println(pattern);
		Pattern defrule = 
	            Pattern.compile(pattern);
	    Matcher matcher =  defrule.matcher(rule);
	    	 
	            while (matcher.find()) {
	            		matcher.group();
	                return true;
	                
	            }
	       return false;     
	}


	

	public void getContrary(String cont) {
		
		cont=cont.replaceAll(" ", "");
		String token;
		String left,right;
		String[] couple;
		StringTokenizer tk=new StringTokenizer(cont,";");
		while(tk.hasMoreTokens()){
			token=tk.nextToken();
			if(token.contains("-")){
				left=token.substring(0,token.indexOf("-"));
				right=token.substring(token.indexOf("-")+1);
				String sqk;
				boolean test=true;
		 
				if(right.contains("<")){
					//then it is a preference
					Pref pref;
				 
					if(right.contains("~")){
						right=right.replace("~", "");
					 
					}
					pref=subPreference(right,kbpref);
					right=pref.getId();
				
				}else{
				
					
					right=right.replace("~", "NNN");
				}
		 
				if(left.contains("<")){
					//then it is a preference
					Pref pref;
			 
					if(left.contains("~")){
						left=left.replace("~", "");
					 
					}
					pref=subPreference(left,kbpref);
					left=pref.getId();
				
				}else{
					left=left.replace("~", "NNN");
				}
	
				symb.add(left);
				symb.add(right);
				
				HashSet set;
				if(fopp.containsKey(left)){
					set=(HashSet) fopp.get(left);
				}else{
					set=new HashSet();
				}
				set.add(right);
				fopp.put(left,set);
				
				if(fopp.containsKey(right)){
					set=(HashSet) fopp.get(right);
				}else{
					set=new HashSet();
				}
				set.add(left);
				fopp.put(right,set);
				
			}else if(token.contains("^")){
				
				left=token.substring(0,token.indexOf("^"));
				right=token.substring(token.indexOf("^")+1);
				//System.out.println(token+left+right);
				if(left.contains("~")){
					//it is only one
					addcontrary(left.substring(left.indexOf("~")+1));
					left=left.replace("~", "NNN");
					
				}else  if(left.contains("<")){
						//then it is a preference
						Pref pref;
				 
						if(left.contains("~")){
							left=left.replace("~", "");
						 
						}
						pref=subPreference(left,kbpref);
						left=pref.getId();
					
					}
			 
				
				if(right.contains("~")){
					//it is only one
					addcontrary(right.substring(right.indexOf("~")+1));
					right=right.replace("~", "NNN");
				}else if(right.contains("<")){
					//then it is a preference
					Pref pref;
				 
					if(right.contains("~")){
						right=right.replace("~", "");
					 
					}
					pref=subPreference(right,kbpref);
					right=pref.getId();
				
				}
				//ok here I need to make sure that it is well formulated!!!
				//How? check that no consequent of a defeasible rule is contrary of a strict rule
				//System.out.println(rulbc.toString());
				ArrayList testrulbc=(ArrayList) rulbc.get(right);
				if(testrulbc!=null){//then there are no rulbc so wlf=true intrinsically
				boolean isstrict=false;
				Iterator tcs=testrulbc.iterator();
				Rule ruletest;
				while(tcs.hasNext()){
					ruletest=(Rule) tcs.next();
					if(ruletest.isStrict()){
						isstrict=true;
					}
				}
				if(isstrict){
					wlf=false;
				}
				}
				symb.add(left);
				symb.add(right);
				
				HashSet set;
				if(fopp.containsKey(left)){
					set=(HashSet) fopp.get(left);
				}else{
					set=new HashSet();
				}
				set.add(right);
				fopp.put(left,set);
				 
			}
		}
		
	}

	private String addcontrary(String item) {
		//the string  item needs to be added as a contradictory
		String left;
		String right;
		String toreturn;
	 if(item.startsWith("NNN")){
	     right=item;
		 left=item.replace("NNN", "");
		 toreturn=left;
	 }else{
		 left=item;
		 right="NNN"+item;
		 toreturn=right;
	 }	
		symb.add(left);
		symb.add(right);
		HashSet set;
		if(fopp.containsKey(left)){
			set=(HashSet) fopp.get(left);
		}else{
			set=new HashSet();
		}
		set.add(right);
		fopp.put(left,set);
		 
		if(fopp.containsKey(right)){
			set=(HashSet) fopp.get(right);
		}else{
			set=new HashSet();
		}
		set.add(left);
		fopp.put(right,set);
		
		return toreturn;
		
	}

	public HashSet getPremises(String prep) {
		HashSet prems=new HashSet();
		prep=prep.replaceAll(" ", "");
		StringTokenizer tk=new StringTokenizer(prep,";");
		String prem;
		while(tk.hasMoreTokens()){
			prem=tk.nextToken();
			prems.add(prem);
			symb.add(prem);
		}
	 
		return prems;
	}



	public HashSet getSymb() {
		// TODO Auto-generated method stub
		return symb;
	}



	public HashMap getRulesBI() {
		// TODO Auto-generated method stub
		return rulbi;
	}



	public boolean isWellFormulated() {
		// TODO Auto-generated method stub
		return wlf;
	}



	public HashMap getKPref() {
		// TODO Auto-generated method stub
		return kbpref;
	}



	public HashMap getRulePref() {
		// TODO Auto-generated method stub
		return rpref;
	}



	public int getContId() {
		// TODO Auto-generated method stub
		return countid;
	}



	public void addRulePrefs(HashSet newruleset, HashMap newkbpref, HashMap newkbpref_rev, int newcounter) {
		//System.out.println("CALLED");
		// TODO Auto-generated method stub
		//add rules bi bc and add graph and complete!!!
		countid=newcounter;
		Iterator iter=newruleset.iterator();
		Rule newrule;
		while(iter.hasNext()){
			newrule=(Rule) iter.next();
			symb.add(newrule.getHead());
			symb.addAll(newrule.getTails());
			ArrayList list;
			if(rulbc.containsKey(newrule.getHead())){
				list=(ArrayList) rulbc.get(newrule.getHead());
			}else{
				list=new ArrayList();
			}
			if(!rules.contains(newrule)){
				if(!list.contains(newrule)){
					list.add(newrule);
					rulbc.put(newrule.getHead(),list);
					rulbi.put(newrule.getId(),newrule);
					rules.add(newrule);
					graphAddRule(newrule);
					HashSet prefts;
					if(rpref.containsKey(newrule.getHead())){
						prefts=(HashSet) rpref.get(newrule.getHead());
					}else{
						prefts=new HashSet();
					}
					prefts.add(newrule.getId());
					rpref.put(newrule.getHead(),prefts);
					newrule.setPref();
					
					
				}
				
			}
		 
	 
		}
		kbpref=newkbpref;
		kbpref_rev=newkbpref_rev;
		complete();
		 
	}



	public HashMap getRules() {
		// TODO Auto-generated method stub
		return rulbc;
	}



	public HashMap getKPrefRev() {
		// TODO Auto-generated method stub
		return kbpref_rev;
	}



	 
}
