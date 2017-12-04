/******************************************************************************
 * This research was sponsored by the U.S. Army Research Laboratory and the
 * U.K. Ministry of Defence under the Biennial Program Plane 2013 (BPP13),
 * Project 6, Task 3: Collaborative Intelligence Analysis.
 * The U.S. and U.K. Governments are authorized to reproduce and distribute
 * reprints for Government purposes notwithstanding any copyright notation
 * hereon.
 * **************************************************************************
 * 
 * This is the core of the service, translates WORKBOXS graphs to TOAST 
 * Returns a color assignment
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import utils.JsonHelper;
import com.google.gson.internal.LinkedTreeMap;
import ersdata.Link;
import ersdata.Node;
import ersdata.Schemes;



public class ERSControl {
 
	private  int countid=0;
	private JsonHelper jsh;
	private int counter=1;
	private int artefact=1;
	private ASPHelper aspic;
	private RuleChecker ruler;
	private final String PRB0="Sorry, you must have at least one node for evaluation, please try again.";
	private final String PRB2="Sorry, the reasoner has given no response, please try again.";
	private final String PRB3="Sorry, the result was corrupted, please try again.";
	private final String PRB4="Sorry, there are problems with the structure of the links, please fix them and try again.";
	private final String PRB5="Sorry, there are nodes with the same id, please delete and try again.";
	private final String WARN1="Warning: There is a cycle among the Pro Links";
	private final String WARN2="Warning: The preference is not justified";

	private HashMap nodes;
	private HashMap mapINDs;
	private ArrayList links;
	private boolean PRINT;

	private HashSet infonodes;//list of id
	private HashSet prefnodes;//list of id
	private HashMap prefids;//list of id
	private HashSet cispprefnodes;//list of id
	private HashSet unprefs;
	private Schemes schemes;
	private ERSEval ersev;

	

	public ERSControl(boolean PR, String scheme_str) {
		 PRINT=PR;
		 jsh=new JsonHelper();
		 aspic=new ASPHelper(PRINT);
		 ruler=new RuleChecker();
		 nodes=new HashMap();
		 links=new ArrayList();
		 infonodes=new HashSet();
		 prefnodes=new HashSet();
		 cispprefnodes=new HashSet();
		 schemes=new Schemes(scheme_str);
		 mapINDs=new HashMap();
		 unprefs=new HashSet();
		 prefids=new HashMap();
		
	}
 	/* private   void print(String st) {
		 try {
				BufferedWriter out = new BufferedWriter(new FileWriter("/users/alice/Dropbox/WorkingBox/workspace/ers/ocq.cis"));
				out.write(st); 
				out.close();
			} catch (IOException e) {
				 
			}
		
	} */ 
	public String evaluateJsonString(LinkedTreeMap mgraph) {
		//first Convert Json to maps
 
		   
	 
	 String ersResponse;
 
		ArrayList list=new ArrayList();
		
		//Then create lists of Nodes/Links
		ArrayList rnd=(ArrayList)mgraph.get("nodes");
		 if(rnd.isEmpty()){
			  return setSomethingWrongResponse(PRB0);
		 }
		 
		boolean testnodes=createNodesFrom(rnd);
		
		if(!testnodes){
			return setSomethingWrongResponse(PRB5);
		}
		
		getLinksFrom(rnd,(ArrayList) mgraph.get("edges"));
		
		//System.out.println(nodes+"\n"+links);
		HashMap Probs=ruler.testRules(nodes,links,prefnodes);
		
		if(!Probs.isEmpty()){
			//prepare problems string to return with empty evaluation 
				HashMap ErsResponse=setProbsErsResponse(Probs);
				ersResponse=jsh.convertInputJson(ErsResponse);
				return ersResponse;
		}else{
		/*for TOAST I need:
		 * List of Rules
		 * List of Premises (that we consider all ordinary premises)
		 * List of Assumptions
		 * List of Contrariness Rules 
		 * Force Modus Tollens use transposition
		*/
		ArrayList special=ruler.getSpecial();
		HashMap samehead=ruler.getSamehead();
		Set st=ruler.getCycle();
		
		list=checkPreferences(list);
		HashMap Input=writeRules(special,samehead,st);
		aspic.prepareInputAspApi(Input);
		HashMap resmap=aspic.evaluate();
		
		
		
		
		if(resmap==null){
				return setSomethingWrongResponse(PRB2);
		}
		
		if(resmap.isEmpty() || resmap.get("wellformed").equals(false)){
				return setSomethingWrongResponse(PRB3);
		}else{
			
			//this sets the evaluation on the nodes
			 //now prepare a string to send back 
			 //labelling list IN/OUT/UNDEC for each node and a list of Probs
			 ersev=new ERSEval(nodes,prefids);
			 HashMap ErsResponse= ersev.elaborateResponse(resmap);
				
			 if(st!=null){
				 
				 list.add(WARN1);
				 
			 }
			 if(!list.isEmpty()){
				 ErsResponse.put("warnings", list);
			 }
			 ersResponse=jsh.convertInputJson(ErsResponse);
		}
		}
	//	System.out.println(ersResponse);
		return ersResponse;
	}
		

	 

	private ArrayList checkPreferences(ArrayList warns) {
 
		HashSet checked=(HashSet) prefnodes.clone();
		boolean cond;
		HashSet removals=new HashSet();
		while(!checked.isEmpty()){
			removals=new HashSet();
			Iterator itt=checked.iterator();
			while(itt.hasNext()){
				cond=false;
				String id=(String) itt.next();
				Node pref=(Node) nodes.get(id);
				
				Node left=(Node) nodes.get(pref.getPref_left());
				Node right=(Node) nodes.get(pref.getPref_right());
				if(!left.isPref()){
					if(!right.isPref()){
						//ok we can make it
						pref.setPref_pred("("+left.getIID()+"<"+right.getIID()+")");
						cond=true;
					}else{
						if(right.getPref_pred()!=null){
							//then it is ok use predicate
							pref.setPref_pred("("+left.getIID()+"<"+right.getPref_pred()+")");
							cond=true;
						}
					}
				}else{
					if(left.getPref_pred()!=null){
						if(!right.isPref()){
							//ok we can make it
							pref.setPref_pred("("+left.getPref_pred()+"<"+right.getIID()+")");
							cond=true;
						}else{
							if(right.getPref_pred()!=null){
							//then it is ok use predicate
							pref.setPref_pred("("+left.getPref_pred()+"<"+right.getPref_pred()+")");
							cond=true;
						}
					}
					
					
					
					}//else ignore
					
					
				}
				if(cond){
					// I have set this now remove 
					removals.add(id);
					if(!pref.isJustified()){
						warns.add("["+pref.getID()+"] "+WARN2);
						unprefs.add(pref.getIID());
					}
					prefids.put(pref.getPref_pred(), pref.getIID());
				}
				
				
				
			}
			checked.removeAll(removals);
		}
		//System.out.println(nodes);
		return warns;
	}
	
	//testing method
	private void convertInputToASKPAPI(HashMap input,HashMap colors,HashMap listh, HashMap ErsResponse) {
		JsonHelper jsh=new JsonHelper();
		HashMap map= new HashMap();
		map.put("map", nodes);
		String first=jsh.convertInputJson(map);
		String second=jsh.convertInputJson(input);
		map= new HashMap();
		map.put("map", colors);
		String third=jsh.convertInputJson(map);
		map= new HashMap();
		map.put("map", listh);
		String fourth=jsh.convertInputJson(map);
		String fifth=jsh.convertInputJson(ErsResponse);
	/*	//now print it
		 try {
				BufferedWriter out = new BufferedWriter(new FileWriter("/Users/alice/CISpaces/quaquaquaqua.txt"));
				out.write(first+"\n"+second+"\n"+third+"\n"+fourth+"\n"+fifth); 
				out.close();
			} catch (IOException e) {
				 
			}*/
		
		
	}

		
		
		
	

	

	private boolean createNodesFrom(ArrayList arrayList) {
		  //Here I create a node hashmap + map the ids to their internal id 
		  //(from now onwards only internal ids are used)
		   Iterator iter=arrayList.iterator();
		   LinkedTreeMap mapNode;
		   String type;
		   String eval;
		   Node nd;
		 	while(iter.hasNext()){
		 		mapNode=(LinkedTreeMap)iter.next();
		 		//System.out.println(mapNode);
		 		if(mapNode.get("type").equals("I") || mapNode.get("type").equals("P")){
		 			
		 			//System.out.println(mapNode);	
		 		//eval=((String) mapNode.get("eval")).toUpperCase();
		 		type=(String) mapNode.get("input");
		 	//	while(eval.contains(" ")){
		 	//		eval=eval.replace(" ", "");
		 	//	}
		 		
		 		nd=new Node(countid++);
		 	//	nd.setEval(eval);
		 		nd.setID((String) mapNode.get("nodeID"));
		 		nd.setText((String) mapNode.get("text"));
		 		
		 		while(type.contains(" ")){
			 			type=type.replace(" ", "");
			 		}
		 		nd.setType(type);
		 		if(nd.isInfo()){
		 				infonodes.add(nd.getIID());
		 			} 
		 		
		 		nodes.put(nd.getIID(),nd);
		 		if(mapINDs.containsKey((String) mapNode.get("nodeID"))){
		 			return false;//two nodes with the same id ...get back!!
		 		}else{
		 			mapINDs.put((String) mapNode.get("nodeID"), nd.getIID());
		 		}
		 		if(mapNode.get("type").equals("P")){
		 			prefnodes.add(nd.getIID());
		 			cispprefnodes.add(mapNode.get("nodeID"));
		 			
		 		}
		 		}
		 		
		 		
		 		
		 		
		 }
		 	return true;
	}



	private void getLinksFrom(ArrayList nodes, ArrayList edges) {
		//this maps the links with heads and tails and also replace the internal IDs
		HashMap linksp=new HashMap();
	    Iterator iter=nodes.iterator();
	    Link link;
	 //   HashSet cqs=schemes.getCQs();
	    while(iter.hasNext()){
	    	LinkedTreeMap nd=(LinkedTreeMap) iter.next();
	    	if(nd.get("type").equals("CA") || nd.get("type").equals("RA")){
	    		link=new Link((String)nd.get("nodeID"),(String)nd.get("type"),(String)nd.get("text")); 
	    		//here if the node underminer or a rebuttal specify contradictory negation
	    		//This was the old check for Critical questions, removed for logic consistency
	    		/*if(((String)nd.get("type")).equals("CA")){
	    			//this is a con link
	    			LinkedTreeMap annot=(LinkedTreeMap) nd.get("annot");
	    			if(annot.containsKey("cq_id")){
	    				String cq=(String)annot.get("cq_id");
	    				if(cq!=null){
	    					//this is a cq link 
	    					link.setCqType();
	    					//if its annotation is not one of the undercut then it is a contradictory negation
	    					if(!cqs.contains(cq)){
	    						link.setContradictory();
	    					}
	    				 }
	    			 }
	    		 }*/
	    		linksp.put(nd.get("nodeID"), link);
	    		
	    		
	    	}
	    	
	    }
	    String from,to;
	    String id;
	    iter=edges.iterator();
	    //linksp is indexed by the id of the link round node
	    while(iter.hasNext()){
	    	LinkedTreeMap ed=(LinkedTreeMap) iter.next();
	    	from=(String) ed.get("fromID");
	    	to=(String) ed.get("toID");
	    	
	    	
	    	if(linksp.containsKey(to)){
	    	
	    		//then it is a tail
	    		link=(Link) linksp.get(to);
	    		id=(String) mapINDs.get(from);
	    		link.setTails(id);
	    		//if this is a tail but the head is a link
	    		//
	    		if(linksp.containsKey(from)){
	    			link=(Link) linksp.get(from);
	    			link.setPotHead(to);
	    		}
	    		
	    	}
	    	else{if (linksp.containsKey(from)){
	    		//then it is a head
	    		link=(Link) linksp.get(from);
	    		id=(String) mapINDs.get(to);
	    		link.setHead(id);
	    		//collect all heads for a check later
	    		link.setPotHead(to);
	    		
	    	
	    	//	System.out.println(to);
	    		if(link.isPro() && cispprefnodes.contains(to)){
	    			String toid=(String) mapINDs.get(to);
		    		Node tond=(Node) this.nodes.get(toid);
    	    		tond.setJustified();
    	    	}
	    		 
	    	}else{
	    	
	    	//System.out.println("FROM"+from+" TO "+to);
	    	if(cispprefnodes.contains(from)){ ///from is a pref
	    		if(cispprefnodes.contains(to)){
	    			//this is a pref of pref
	    			//here this is the difficult part 
	    			//I need to go into the nodes and see where they belong to 
	    			String toid=(String) mapINDs.get(to);
		    		Node tond=(Node) this.nodes.get(toid);
	    			String totext=tond.getText();
	    			String fromid=(String) mapINDs.get(from);
		    		Node fromnd=(Node) this.nodes.get(fromid);
	    			String fromtext=fromnd.getText();
	    			//first establish which one is above
	    			//System.out.println(fromtext+":"+totext);
	    			if(fromtext.length()>totext.length()){
	    				// above is fromnd;
	    			//	System.out.println("above is from");
	    				fromnd.setPref_left(toid);
	    			}else{
	    				tond.setPref_right(fromid);
	    			//	System.out.println("above is to");
	    			}
	    			// ok now forget the below!!!
		    		
	    		}else{
	    			//to is a node
	    			String fromid=(String) mapINDs.get(from);
		    		Node fromnd=(Node) this.nodes.get(fromid);
		    		 
		    		if(mapINDs.containsKey(to)){//this is the left of the preference
		    			String toid=(String) mapINDs.get(to);
		    			fromnd.setPref_left(toid);
		    		}
	    		}	
	    	}else{
	    		if(cispprefnodes.contains(to)){ //this is the right
	    			//the from is a node!
	    			String toid=(String) mapINDs.get(to);
		    		Node tond=(Node) this.nodes.get(toid);
		    		
	    			if(mapINDs.containsKey(from)){//this is the right of the preference
			    		String fromid=(String) mapINDs.get(from);
			    		tond.setPref_right(fromid);
			    	}
	    			
	    			
	    			
	    		}
	    	}
	    		//System.out.println(ed);
	     
	    	}
	    	}
	    }
	    //add all to links
	    Iterator mit=linksp.keySet().iterator();
	    String key;
	    while(mit.hasNext()){
	    	key=(String) mit.next();
	    	links.add(linksp.get(key));
	    }
	  
	  
	}
	
	


private HashMap writeRules(ArrayList special, HashMap samehead, Set st) {
		
		HashMap maprules=new HashMap();
		/*Contains:
		 * -List of Rule problems and then 
		 * -for TOAST I need:
		 * 		List of Rules
		 * 		List of Assumptions
		 * 		List of Premises (that we consider all ordinary premises)
		 * 		List of Contrariness Rules 
		 * 		Transposition true
		 * 
		*/
		String rule, tail,head;
		ArrayList Rules=new ArrayList();
		Link link,link1;
		ArrayList Contr=new ArrayList();
		ArrayList entryPrem=new ArrayList();
		Iterator iter=nodes.keySet().iterator();
		String prem;
		while(iter.hasNext()){
			prem=(String) iter.next();
			if(unprefs.contains(prem)){
				counter++;
				artefact++;
				String ahead="H"+artefact;
				rule="[r"+counter+"] "+ahead+"=>"+getPred(prem)+";";
			//	System.out.println(rule.toString());
				Rules.add(rule);
				entryPrem.add(ahead);
				//System.out.println(ahead+rule.toString());
			}else{
				entryPrem.add(getPred(prem));
			}
		}
	//	System.out.println("PREM"+entryPrem.toString());
	
		//find a->con->b and b->con->a
		
		Iterator itrule=special.iterator(),itdouble;
		HashSet difflinks=new HashSet();
		String head1,tail1;
		while(itrule.hasNext()){
			link=(Link) itrule.next();
			if(!difflinks.contains(link.getId())){
			head=(String) link.getHead();
			itdouble=special.iterator();
			while(itdouble.hasNext()){
				link1=(Link) itdouble.next();
				tail1=(String)link1.getTails().get(0);
				if(tail1.equals(head)){
					//found a potential
					head1=(String) link1.getHead();
					tail=(String)link.getTails().get(0);
					if(head1.equals(tail)){
						//FOUND IT 
						
						//1. add the link ids to difflinks
						difflinks.add(link.getId());
						difflinks.add(link1.getId());
						//2. Add a contrariness function 
						 String cont=getPred(head)+" - "+getPred(tail)+";"; //contradictory existing if there are two cons one against the other
						 Contr.add(cont); 
						break;
					}
				 }
				
			}
			
			
			}
			
			
			
		}
		
		//Start with the Pro Rules
		
	    iter=links.iterator();
		Iterator itt;
		while(iter.hasNext()){
			link= (Link) iter.next();
			itt=link.getTails().iterator();
			tail="";
			while(itt.hasNext()){
				tail+=getPred((String)itt.next())+",";
			}
			tail=tail.substring(0,tail.length()-1);
			counter++;
		if(!difflinks.contains(link.getId())){
			if(link.isPro()){
				
				rule="[r"+counter+"] "+tail+"=>"+getPred(link.getHead())+";";
				Rules.add(rule);
				//System.out.println("PREM"+entryPrem.toString());
				entryPrem.remove((String)getPred(link.getHead()));
				//System.out.println("PREM-REM"+(String)getPred(link.getHead())+entryPrem.toString());
			}else if(!link.isPro()){
		
		//Con links will be all defeasible rules  with an artefact head that leads to a contrariness instance
		   //STRICT
				/*	counter++;
				rule="[r"+counter+"] "+tail+"->~"+link.get("head")+";";
				Rules.add(rule);*/
				 
		//DEFEASIBLE
				 boolean neg=link.getNeg();
				 if(neg){
					String cont=tail+" - "+getPred(link.getHead())+";";
					Contr.add(cont);
				 }else{
				 artefact++;
				 String ahead="H"+artefact;
				 rule="[r"+counter+"] "+tail+"=>"+getPred(ahead)+";";
				 
				Rules.add(rule);
				String cont=getPred(ahead)+"^ "+getPred(link.getHead())+";";
				Contr.add(cont);
				 }
				
			}
		}
		}
	 
		//add cycle premises if any
		if(st!=null){
			Iterator itera=st.iterator();
			String node;
			while(itera.hasNext()){
				node=(String) itera.next();
				if(infonodes.contains(node)){
					entryPrem.add(node);
				}
				
			}
		}
		maprules.put("rules",Rules);
		maprules.put("premises",entryPrem);
		maprules.put("cont", Contr);
		
		return maprules;
	}

	

	

	 
	private String getPred(String node) {
		if(prefnodes.contains(node)){
			//System.out.println(node);
			Node nd=(Node) nodes.get(node);
			return nd.getPref_pred();
		}else{
			return node;
		}
	}
	
	
	private HashMap setAllUndecided(){
		HashMap colors=new HashMap();
		HashMap nodeext=new HashMap();
			//initialise colors
		Iterator iter=nodes.keySet().iterator();
		 String key;
		 while(iter.hasNext()){
		    	key=(String) iter.next();
		    	nodeext.put(key, "?");
		    	 
		    }
		 colors.put("No Evaluation Available",nodeext);
		 return colors;
	}
	


	

private String setSomethingWrongResponse(String string){
	HashMap map=new HashMap();
	map.put("fail",true);
	map.put("cause",string);
	map.put("probs", "");
	map.put("assign-found",false);
	map.put("colors",setAllUndecided());
	String ersResponse=jsh.convertInputJson(map);
	return ersResponse;
}



private HashMap setProbsErsResponse(HashMap probs) {
	HashMap map=new HashMap();
	map.put("probs", probs);
	map.put("colors", "");
	map.put("fail",true);
 
	map.put("cause",PRB4);
	return map;
}


	
}
