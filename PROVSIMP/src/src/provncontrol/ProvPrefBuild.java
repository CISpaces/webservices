package provncontrol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.joda.time.DateTime;

import com.google.gson.internal.LinkedTreeMap;

import database.DBNQuery;
import provncontrol.pdatastr.Couple;
import provncontrol.pdatastr.Link;
import provncontrol.pdatastr.Node;
import provncontrol.pdatastr.Schemes;
import provncontrol.pdatastr.TPref;
import utils.JsonHelper;
import utils.NS;
import utils.OrdComparator;
import utils.TimeHelper;

public class ProvPrefBuild {
	
	private RDFNQuery pcore;
	
	private DBNQuery dbn;

	private String provsize;
	public ProvPrefBuild(String ps) {
		dbn = new DBNQuery(ps);
		provsize=ps;
		pcore=new RDFNQuery(provsize);
	}
	
	
	public HashMap getAllProvElements(boolean obf,String user, ArrayList nodes) {
		 
		HashMap map=new HashMap();
		ArrayList qs=new ArrayList();
		HashMap q1=new HashMap();
		q1.put("question", "Order of trustworthiness of actors");
		q1.put("qid",  "0" );
		
		ArrayList[] list=getActProcCrit(obf,user,nodes);
		q1.put("cats",list[0]);
		qs.add(q1);
		
		
		q1=new HashMap();
		q1.put("question", "Order of reliability of processes");
		q1.put("qid",  "1"  );
		  
		q1.put("cats",list[1]);
		qs.add(q1);
		
		q1=new HashMap();
		q1.put("question", "Order of criteria");
		q1.put("qid", "2" );
		q1.put("cats",list[2]);
		qs.add(q1);
		map.put("elements",qs);
		return map;
	}

	 

	public HashMap getPrefNodes(boolean obf,String user,   LinkedTreeMap nodes,  ArrayList elem) {
		
		//use 4 criteria to build pref and only those that have been sent back
		//we could have non-existing yet elements (careless)
		// then check if there is any double pref that could be overseed
		// create nodes
		//then find out if any of the pref should be deleted
		
		//check preferences if equal return nothing
		//true if no changes
		
		//every call is per se and we do only take into consideration what is new in the graph!!!!
		//need to put in array called preferences on elements {new_actors,new_procs,new_crits}
	 
		//now add temporary changes 
		//ok those are the new elements
		
		//first add them into the temp database + update the existing
		ArrayList rnd=(ArrayList)nodes.get("nodes");
		ArrayList<Couple>[] changes =  updateTempElements(obf,elem,user,rnd);
		
		HashMap to_add=new HashMap();
		HashMap to_rem=new HashMap();
		
		// parse graph
		//find prov links
		//find also pref due to prov links
		//extract existing parts + keep the nucleo together
		
		//parse graphs and get preferences
		PrefNodeBuilder ndbuild=new PrefNodeBuilder(provsize);
		Object[] ind=processPrefNodes(ndbuild,nodes,changes,user, false);
		  
		if(ind!=null){
		to_add.put("indiv", buildPrefNodes(changes[2],ndbuild,(ArrayList<TPref>[])ind[0],(HashMap)ind[1],(HashMap)ind[2],user,false));
		to_rem.put("indiv",  ndbuild.getRemNodes());
		}else{
			to_add.put("indiv", new HashMap());
			to_rem.put("indiv", new ArrayList());
		}
		//System.out.println(to_add);
		ArrayList list=new ArrayList();
		ArrayList map=(ArrayList) ((HashMap)to_add.get("indiv")).get("nodes");
		if(map!=null){
		Iterator iter=map.iterator();
		while(iter.hasNext()){
			HashMap node=(HashMap) iter.next();
			list.add(node.get("nodeID"));
		}
		pcore.addprovPaths(list, user);
		//now create nodes
		
		}
			/*{
			"to_add":{
				"indiv":
					{"nodes":[....], "edges":[.....],"prov":{....}},
				"shared":
					{"nodes":[....], "edges":[.....],"prov":{....}}
					}
			"to_rem":{
				"indiv":["74e49ee5-a2b7-42be-a27e-31c883c28ffa",....] 
				"shared": ["74e49ee5-a2b7-42be-a27e-31c883c28ffa",....]
				}
			}*/
 
		
		
		
	
		HashMap mapres=new HashMap();
		mapres.put("to_add", to_add);
		mapres.put("to_rem", to_rem);
		return mapres;
	}
	
	
	private ArrayList<Couple>[] updateTempElements(boolean obf,ArrayList elem, String user,ArrayList nodes) {
			//"elements":[{"qid":....,"cats":[["elem",val],["elem",val]]},....]
			ArrayList[] res=getActProcCrit(obf,user,nodes); //current ones!!
			//res[0]=as;
			//res[1]=ps;
			//res[2]=cs;
			
			ArrayList<ArrayList> old_actors=res[0];
			ArrayList<ArrayList> old_procs=res[1];
			ArrayList<ArrayList> old_crits=res[2];
			HashMap<String,Couple> odact=new HashMap<String,Couple>();
			HashMap<String,Couple> odproc=new HashMap<String,Couple>();
			HashMap<String,Couple> odcrits=new HashMap<String,Couple>();
			//results!!
			ArrayList<Couple> new_actors=new ArrayList<Couple>();
			ArrayList<Couple> new_procs=new ArrayList<Couple>();
			ArrayList<Couple> new_crits=new ArrayList<Couple>();
			
			for(ArrayList list:old_actors){
				Couple cc=new Couple((String)list.get(0),(double)list.get(1));
				odact.put((String)list.get(0),cc);
			}
			for(ArrayList list:old_procs){
				Couple cc=new Couple((String)list.get(0),(double)list.get(1));
				odproc.put((String)list.get(0),cc);
			}
			for(ArrayList list:old_crits){
				Couple cc=new Couple((String)list.get(0),(double)list.get(1));
				odcrits.put((String)list.get(0),cc);
			}
			
			
			
			//iteration through incoming elements
			Iterator iter=elem.iterator();
			while(iter.hasNext()){
				LinkedTreeMap mpe=(LinkedTreeMap) iter.next();
				int choice=Integer.parseInt((String)mpe.get("qid"));
				ArrayList<ArrayList> xx=(ArrayList<ArrayList>) mpe.get("cats");
				if(choice==0){
					for(ArrayList acp:xx){
						if(odact.containsKey((String)acp.get(0))){
							Couple cxp=odact.get((String)acp.get(0));
							double numb=(double)acp.get(1);
							if(cxp.val!=numb){
								cxp.setVal(numb);
							 
							}
						}else{
							Couple cxp=new Couple((String)acp.get(0),(double)acp.get(1));
							new_actors.add(cxp);
						}
					}
					
				}
				if(choice==1){
					for(ArrayList acp:xx){
						if(odproc.containsKey((String)acp.get(0))){
							Couple cxp=odproc.get((String)acp.get(0));
							double numb=(double)acp.get(1);
							if(cxp.val!=numb){
								cxp.setVal(numb);
							 
							}
						}else{
							Couple cxp=new Couple((String)acp.get(0),(double)acp.get(1));
							new_procs.add(cxp);
						}
					}
				}
				if(choice==2){
					for(ArrayList acp:xx){
						if(odcrits.containsKey((String)acp.get(0))){
							Couple cxp=odcrits.get((String)acp.get(0));
							double numb=(double)acp.get(1);
							if(cxp.val!=numb){
								cxp.setVal(numb);
								 
							}
						}else{
							Couple cxp=new Couple((String)acp.get(0),(double)acp.get(1));
							new_crits.add(cxp);
						}
					}
				}
			}
			for(String key:odact.keySet()){
				new_actors.add(odact.get(key));
			}
			for(String key:odproc.keySet()){
				new_procs.add(odproc.get(key));
			}
			for(String key:odcrits.keySet()){
				new_crits.add(odcrits.get(key));
			}
			ArrayList[] cc=new ArrayList[]{new_actors,new_procs,new_crits};
			return cc;
		}
	 
	private ArrayList[] getActProcCrit(boolean obf,String user, ArrayList nodes) {
			ArrayList<Couple>[] map=dbn.getPelements(user);
		/*	for(int i=0;i<map.length;i++){
				System.out.println(map[i].toString());
			}*/
			ArrayList[] res=new ArrayList[3];
			if(map==null){
				//create a new map
			//	System.out.println("I SHOULD NOT BE HERE");
				ArrayList<ArrayList<String>> tot=getAllActorsProcs(obf,user,nodes);
				ArrayList<String> crits=new ArrayList<String>();
				crits.add("Trustworthiness");
				crits.add("Timeliness");
				crits.add("Reliability");
				crits.add("Accuracy");
				tot.add(crits);
				int i=0;
				for(ArrayList<String> a:tot){
					ArrayList list=new ArrayList();
					 
					for(String val:a){
						Couple couple=new Couple(val,1);
						list.add(couple.toArray());
					//	System.out.println(couple.toString());
						dbn.addPelemTuple(user,val, 1, i);
					}
					res[i]=list;
					
					i++;
				}
				
			}else{
				ArrayList<ArrayList<String>> tot=getAllActorsProcs(obf, user, nodes);
				ArrayList<String> ta=tot.get(0); //existing actors
				ArrayList<String> tp=tot.get(1); //existing procs
				ArrayList<Couple> actors=map[0]; //actors in database
				ArrayList<Couple> procs=map[1];  //proc in database
				ArrayList<Couple> crits=map[2]; //criteria in database
				
			/*	for(Couple t:actors){
					System.out.print(t.toString()+"---");
				}
				System.out.println();
				for(Couple t:procs){
					System.out.print(t.toString()+"---");
				}
				System.out.println();
				for(Couple t:crits){
					System.out.print(t.toString()+"---");
				}
				System.out.println();*/
				
				ArrayList cs=new ArrayList();
				for(Couple couple:crits){
					cs.add(couple.toArray());
				}
				ArrayList as=new ArrayList();
				double max=1;
				for(Couple couple:actors){
					if(!ta.contains(couple.element)){
						dbn.removePelemTuple(user,couple.element);
					}else{
						
					if(couple.val>max){
						max=couple.val;
					}
					 
						as.add(couple.toArray());
						ta.remove(couple.element);
				 
					}
				}
				Iterator itt=ta.iterator();
				max++;
				max=1;
				while(itt.hasNext()){
					String key=(String) itt.next();
					Couple couple=new Couple(key,max);
					as.add(couple.toArray());
					dbn.addPelemTuple(user,key, max, 0);
				}

				ArrayList ps=new ArrayList();
				max=0;
				for(Couple couple:procs){
					if(!tp.contains(couple.element)){
						dbn.removePelemTuple(user,couple.element);
					}else{
						
				//	System.out.println(couple.toString());
					if(couple.val>max){
						max=couple.val;
					}
					
					ps.add(couple.toArray());
					tp.remove(couple.element);
					}
				}
				itt=tp.iterator();
				max++;
				max=1;
				while(itt.hasNext()){
					String key=(String) itt.next();
					Couple couple=new Couple(key,max);
			 
					ps.add(couple.toArray());
					dbn.addPelemTuple(user,key, max, 1);
				}
				res[0]=as;
				res[1]=ps;
				res[2]=cs;
				}
			
			return res;
		}
	 private ArrayList<ArrayList<String>> getAllActorsProcs(boolean obf,String user, ArrayList nodes) {
		 	
			 Model inMod=pcore.getAllNodesAnalysis(obf, nodes, user);
		
			HashSet<String> actors=pcore.getAllActors(inMod,user);
			HashSet<String> procs=pcore.getAllProcesses(inMod);
			
		// 	System.out.println(actors +"\n"+ procs);

			 
			ArrayList<String> ret=new ArrayList<String>();
			ret.addAll(actors);
			ArrayList<String> retj=new ArrayList<String>();
			retj.addAll(procs);
			ArrayList<ArrayList<String>> retc=new ArrayList<ArrayList<String>>();
			retc.add(ret);
			retc.add(retj);
			// System.out.println(ret+"\n"+retj);
			return retc;
		}

 


	private Object[] processPrefNodes(PrefNodeBuilder ndbuild, LinkedTreeMap mapinp, ArrayList<Couple>[] changes, String user, boolean shared) {
		ArrayList rnd=(ArrayList)mapinp.get("nodes");
		if(rnd!=null && !rnd.isEmpty()){
		ArrayList reg=(ArrayList)mapinp.get("edges");
	
		Object[] res=createNodesFrom(rnd);
		HashMap nodes=(HashMap) res[0];
		ArrayList prefnodes=(ArrayList) res[1];
		DefaultDirectedGraph<String, DefaultEdge> graph=(DefaultDirectedGraph<String, DefaultEdge>) res[2];
		
		res=getLinksFrom(rnd,reg,graph, nodes, prefnodes);
		graph=(DefaultDirectedGraph<String, DefaultEdge>) res[1];
		HashMap links=(HashMap) res[0];
		ArrayList lpvnd=(ArrayList) res[3];
		ArrayList lppnd=(ArrayList) res[2]; //these are the preference links
		ArrayList prefs=(ArrayList) res[4]; //these are the preference nodes
		
		ArrayList acts=new ArrayList();
		ArrayList ents=new ArrayList();
		 
		ArrayList agts=new ArrayList();
		HashMap mapnodes=new HashMap();
		HashMap mapelems=new HashMap();
		Iterator iter=lpvnd.iterator();
			//	System.out.println(lpvnd.size());
		while(iter.hasNext()){
			Link link=(Link) links.get((String) iter.next());
			Iterator itt=link.getTails().iterator();
			
			while(itt.hasNext()){
				Node nd=(Node) nodes.get((String)itt.next());
				String text=nd.getText().replaceAll("\n", "");
				if(text.startsWith("Info - ")){
					//then it is a pattern 
					//get info node id
					
					Node node=(Node) nodes.get(link.getHead());
					Object list[]=parseCore(text,mapnodes,mapelems,nd.getID(), node.getID());
					acts.addAll((HashSet)list[0]);
					ents.addAll((HashSet)list[1]);
					agts.addAll((HashSet)list[2]);
					mapnodes=(HashMap)list[3];
					mapelems=(HashMap)list[4];
					
				}
			}
		}
	//	System.out.println(mapnodes+":"+mapelems);
		//now I parsed all the objects... time to write preferences
	//	System.out.println(changes+"\n"+agts+"\n"+acts+"\n"+ents);
		//evaluate criterion trustworthiness
		
		ArrayList<Couple> o_agt=changes[0];
	
		//System.out.println("SHOOO"+o_agt+"\n"+agts);
		HashSet<String> least_agts=findleast(o_agt,agts,mapelems);
		ArrayList<TPref> Tprefs_agt=getTPrefs(o_agt,least_agts, mapnodes);
		
	//	System.out.println("ELEMENT:"+least_agts.size());
	//	System.out.println("TRUST:"+Tprefs_agt.size());
		//evaluate criterion reliability
		
		ArrayList<Couple> o_act=changes[1];
		HashSet<String> least_acts=findleast(o_act,acts,mapelems);
		ArrayList<TPref> Tprefs_act=getTPrefs(o_act,least_acts, mapnodes);
		
	//	System.out.println("ELEMENT:"+least_acts.size());
	//	System.out.println("REL:"+Tprefs_act.size());
		
		//extract nodes to be checked 
		//only those nodes that had their prov analysed
		iter=lpvnd.iterator();
		HashSet<String> checknds=new HashSet<String>();
		while(iter.hasNext()){
			Link link=(Link) links.get((String) iter.next());
			String node=link.getHead();
			checknds.add(node);
		}
		
		
		Object[] kkk=getTimeDistance(checknds,user);
	 
		String[] nods=(String[]) kkk[0];
		DateTime[] times=(DateTime[]) kkk[1];
		int[] dist=(int[]) kkk[2];

	/*	for(int i=0;i<nods.length;i++){
			System.out.println(nods[i]+"--"+times[i]+"--"+dist[i]);
		}*/
		
		//evaluate criterion timeliness
		ArrayList<TPref> Tprefs_times=getTPrefs(nods,times);
	//	System.out.println("TIME:"+Tprefs_times.size());
		//evaluate criterion distance
		
		ArrayList<TPref> Tprefs_dist=getTPrefs(nods,dist);
	//	System.out.println("DIST:"+Tprefs_dist.size());
		//now I have all the preferences
		//in theory I should check whether there are new preferences but for now forget it !
		
		
		//remember that at the moment I am not removing the nodes!
		
		
		//so what do I do? 
		
		//need now to return this
		//
		//{"nodes":[....], "edges":[.....],"prov":{....}},
		
		//ok now before continuing I parse the preferences 
		//first add all preferences nodes to the nodebuilder
		Iterator itpif=prefs.iterator();
		while(itpif.hasNext()){
			Node nd=(Node) nodes.get((String)itpif.next());
			ndbuild.updatePref(nd.getText(), nd.getID(), nd.getJust());
		}
		//now add the links that are already there
		
		Iterator itp=lppnd.iterator();
		while(itp.hasNext()){
			String dt=(String) itp.next();
		//	System.out.println(dt);
			Link link=(Link) links.get(dt);
			if(link.getHead()!=null){
			Node pref=(Node) nodes.get(link.getHead());
		//	System.out.println("HEAD"+link.getHead());
			boolean test=false;
			if(link.getTails().size()>0){
				HashSet<String> newhash0=new HashSet<String>();
				HashSet<String> newhash1=new HashSet<String>();
				HashSet<String> newhash2=new HashSet<String>();
				newhash0.add(pref.getText());
				newhash1.add(pref.getText());
				newhash2.add(pref.getText());
				HashSet<String> newids=new HashSet<String>();
				String[] center=new String[4];
				String ty="";
				Iterator itt=link.getTails().iterator();
				while(itt.hasNext()){
					Node nd=(Node) nodes.get((String)itt.next());
				//	System.out.println(nd.getText()+link.getHead());
					String text=nd.getText().replaceAll("\n", "");
					//case 0
					//-less acc/time
					
					//case 1
					//-less rel/trust
					//- info 1
					//- info 2
					
					
					//case 2
					//-less pref
					//-less acc/tim/rel/tru
					 
					
					if(text.startsWith("Info - ")){
						 newhash1.add(nd.getID());
					}else{ 
						if(text.contains("is less") && (text.contains("reliable") || text.contains("trustworthy") )){
							 newhash1.add(text);
						//	 newhash2.add(text);
							 if(shared){
									if(text.startsWith(user+": ")){
										newids.add(nd.getID());
										center[0]=pref.getText();//pref text
										center[1]=pref.getID();//pref ndid
										//center[2]=nd.getID();//claimid
										center[2]=pref.getPref_right(); //right
										center[3]=pref.getPref_left(); //left
										ty=text;
										test=false;
									}else{
										test=true;
									}
								}else{
									newids.add(nd.getID());
									center[0]=pref.getText();//pref text
									center[1]=pref.getID();//pref ndid
								//	center[2]=nd.getID();//claimid
									center[2]=pref.getPref_right(); //right
									center[3]=pref.getPref_left(); //left
									ty=text;
									test=false;
								}
						}else{
							if(text.contains("is less") &&  (text.contains("timely") || text.contains("accurate") )){
								 newhash0.add(text);
							//	 newhash2.add(text);
								 if(shared){
										if(text.startsWith(user+": ")){
											newids.add(nd.getID());
											center[0]=pref.getText();//pref text
											center[1]=pref.getID();//pref ndid
										//	center[2]=nd.getID();//claimid
											center[2]=pref.getPref_right(); //right
											center[3]=pref.getPref_left(); //left
											ty=text;
											test=false;
										}else{
											test=true;
										}
									}else{
										newids.add(nd.getID());
										center[0]=pref.getText();//pref text
										center[1]=pref.getID();//pref ndid
									//	center[2]=nd.getID();//claimid
										center[2]=pref.getPref_right(); //right
										center[3]=pref.getPref_left(); //left
										ty=text;
										test=false;
									}
							}else{
								if(text.contains("is less preferred")){
								 	newhash2.add(text);
									if(shared){
										if(text.startsWith(user+": ")){
											newids.add(nd.getID());
											center[0]=pref.getText();//pref text
											center[1]=pref.getID();//pref ndid
											center[2]=pref.getPref_right(); //right
											center[3]=pref.getPref_left(); //left
											ty=text;
											test=false;
										}else{
											test=true;
										}
									}else{
										newids.add(nd.getID());
										center[0]=pref.getText();//pref text
										center[1]=pref.getID();//pref ndid
										//center[2]=nd.getID();//claimid
										center[2]=pref.getPref_right(); //right
										center[3]=pref.getPref_left(); //left
										ty=text;
										test=false;
									}
								}
							}
							}
					}
						
						
						
						
				
				if(newhash0.size()==2){
					ndbuild.updateLpp(ty,center,newhash0,newids,pref.getText(),link.getId(),test);
				}else{
					if(newhash1.size()==4){
						ndbuild.updateLpp(ty,center,newhash1,newids,pref.getText(),link.getId(),test);
					}else{
						if(newhash2.size()==2){
							//System.out.println("UPLLPP"+newhash2);
							ndbuild.updateLpp(ty,center,newhash2,newids,pref.getText(),link.getId(),test);
						}
					}
				}
		}
			}
		}}
		
		ArrayList<TPref>[] rest=new ArrayList[4];
		rest[0]=Tprefs_agt;
		rest[1]=Tprefs_act;
		rest[2]=Tprefs_times;
		rest[3]=Tprefs_dist;
		
		return new Object[]{rest,links,nodes};
		}
		
		
		return null;
		
		
		
	}

	
	
 


	private void findCritPrefs(HashMap<String, String[]> mapleft, HashMap<String, String[]> mapright, double d1, double d2, String n1, String n2, PrefNodeBuilder ndbuild, String extra) {
	 // System.out.println("386"+mapleft+""+mapright);
		String text="";
		 for(String l_pref:mapleft.keySet()){
			 String[] l_stt=mapleft.get(l_pref);
			 for(String r_pref:mapright.keySet()){
				 String[] r_stt=mapright.get(r_pref);
				 //now what do I compare to? 
				 // 
			//	 System.out.println("COMPARE"+l_stt[2]+":"+r_stt[3]+":"+l_stt[3]+":"+r_stt[2]);
				 if(l_stt[2].equals(r_stt[3]) &&  l_stt[3].equals(r_stt[2])){
				//	 System.out.println("CONF"+l_stt[2]+":"+l_stt[3]);
					 //then there is a conflict and I already know that d1 !=d2
					 if(d1<d2){
						 //n1 is more preferred left is more preffered
						 text=extra+""+n2+" is less preferred than "+n1;
						 String qtext="["+r_stt[0]+" < "+l_stt[0]+"]";
						 //(ij: < ik:)
						
						 ndbuild.addPrefNodes(l_stt[1],r_stt[1],null,null,text,qtext); 
					 }else{
						 text=extra+""+n1+" is less preferred than "+n2;
						 String qtext="["+l_stt[0]+" < "+r_stt[0]+"]";
						
						 ndbuild.addPrefNodes(r_stt[1],l_stt[1],null,null,text,qtext); 
					 }
					 
				 }
				 
			 
			 }
			 
			 }
	  
	}


	private HashSet<String> findleast(ArrayList<Couple> couples, ArrayList agts, HashMap mapelems) {
		//couples all the pairs element:value
		//agts all the elements in the analysis
		//mapelems given a node - all its elements 
		 OrdComparator comp=new OrdComparator();
		 Collections.sort(couples,comp);
		 //here I sort from the most preferred to the least preferred 
		 //now I need to find a vector of the least preferred elements for each node
		 
		//group by node
		 //then find the least on that
		 HashSet<String> temp,least=new HashSet<String>();
		 ArrayList<String> sort;
		 Iterator itt=mapelems.keySet().iterator();
		// System.out.println(couples);
		 while(itt.hasNext()){
			 //for each node
			 temp=(HashSet<String>) mapelems.get((String)itt.next());
			 //I have a list of elements 
			// System.out.println("TEMP"+temp);
			 sort=new ArrayList<String>();
			 for(String item:temp){
				 if(agts.contains(item)){ //if this is an element of the type wanted and it has been listed 
					 sort.add(item);//then it is open for comparison!
				 }
			 }
			// System.out.println("SORT"+sort);
			 String min = null;
			 //now find the least
			 //navigate till the end (but what if there are many???
			 double val= 1;
		    for(Couple cp:couples){
					if(sort.contains(cp.getElement())){
						min=cp.getElement(); 
						val=cp.getVal();
					 }
				 }
		    least.add(min);
				 //once I have the minimum add the others
			for(String st:sort){
				Couple tryc=new Couple(st,val);
				if(couples.contains(tryc)){
					least.add(st);
				}
			}
		 }
	//	 System.out.println("MIN"+least);
		return least;
	}
	
	public Object[] getTimeDistance(HashSet<String> checknds, String user) {
		 
		 String[] nodes=new String[checknds.size()];
		 DateTime[] time=new DateTime[checknds.size()];
		 int[] dist=new int[checknds.size()];
		 
		 int i=0;
		 for(String node:checknds){
			// System.out.println("N"+node);
			 Object[] ojb=pcore.getTimeDistance(node,user);
			 nodes[i]=node;
			 time[i]=(DateTime) ojb[0];
			 dist[i]=(int) ojb[1];
			// System.out.println(nodes[i]+""+time[i]+""+dist[i]);
			 i++;
		 }
		
		return new Object[]{nodes,time,dist};
	}
	
	
	
	
	private ArrayList<TPref> getTPrefs(String[] nods, int[] dist) {
		ArrayList<TPref> tprefs=new ArrayList<TPref>();
		for(int i=0;i<=nods.length-1;i++){
			for(int j=i+1;j<nods.length;j++){
			//	System.out.println(dist[i]+"+"+dist[j]);
				if(dist[i]<dist[j]){
					 //i preferred than j
					TPref tp=new TPref(nods[i],nods[j]);
					if(!tprefs.contains(tp))
					tprefs.add(tp);
					//System.out.println(tp);
				 }else if(dist[j]<dist[i]){
					TPref tp=new TPref(nods[j],nods[i]);
					if(!tprefs.contains(tp))
					tprefs.add(tp);
				//	System.out.println(tp);
				 }
			}
		}
		return tprefs;
	}

	private ArrayList<TPref> getTPrefs(String[] nods, DateTime[] times) {
		ArrayList<TPref> tprefs=new ArrayList<TPref>();
		for(int i=0;i<=nods.length-1;i++){
			for(int j=i+1;j<nods.length;j++){
			//System.out.println(times[i]+"+"+times[j]);
			//2016-03-05T04:00:28.000Z
			//2016-03-05T04:00:30.000Z
				if(!times[i].isEqual(times[j])){
				if(times[i].isBefore(times[j])){
					 //j preferred than i
					TPref tp=new TPref(nods[j],nods[i]);
					if(!tprefs.contains(tp))
					tprefs.add(tp);
				 }else if(times[j].isBefore(times[i])){
					 //i is preferred thatn J
					 TPref tp=new TPref(nods[i],nods[j]);
					 if(!tprefs.contains(tp))
						tprefs.add(tp);
				 }
				}
			}
		}
		return tprefs;
	}

	
	private ArrayList<TPref> getTPrefs(ArrayList<Couple> couples, HashSet<String> least, HashMap mapnodes) {
		
		
		 
		ArrayList<ArrayList<String>> buck=new ArrayList<ArrayList<String>>();
		//couples is still ordered from least to most preferred
		
		//need to see where there is a preference!!!!
	//	System.out.println("TPREF"+couples+"\n"+least);
		
		for(Couple cp:couples){
			ArrayList<String> newa=new ArrayList<String>();
			if(cp.getVal()>buck.size()){
				buck.add(newa);
			}else{
				newa=buck.get(buck.size()-1);
			}
			if(least.contains(cp.element)){
				newa.add(cp.element);
			}
		}
		
	//	System.out.println(buck);
		
		ArrayList<TPref> tprefs=new ArrayList<TPref>();
		if(buck.size()>1){
			//then preferences needed 
			//System.out.println("PREFERENCE NEEDED");
			for(int i=1;i<=buck.size()-1;i++){
				 ArrayList<String> aft=buck.get(i);
				 for(int j=i-1;j>=0;j--){
					 ArrayList<String> bef=buck.get(j);
						//then build pref
					// 	System.out.println(aft+""+bef);
						 for(String elemA:bef){
							 for(String elemB:aft){
								 HashSet<String> ndsA=(HashSet<String>) mapnodes.get(elemA);
								 HashSet<String> ndsB=(HashSet<String>) mapnodes.get(elemB);
								 for(String ndA:ndsA){
									
									 for(String ndB:ndsB){
										// System.out.println(ndA+":"+ndB);
										 if(!ndA.equals(ndB)){
										 TPref tp=new TPref(ndA,ndB,elemA,elemB);
										 if(!tprefs.contains(tp))
										 tprefs.add(tp);
										// System.out.println(tp);
										 }
									 } 
									 }	
						 }
					 }
				 }

			}
		}
		return tprefs;
		
	}

	private Object[] parseCore(String text,HashMap mapnodes, HashMap mapelems, String node, String iID) {
		HashSet act=new HashSet();
		HashSet ent=new HashSet();
		HashSet agt=new HashSet();
		 
		
		String[] tokens=text.split("- was");
 
		for(String tk:tokens){
			if(tk.contains("derived from")){
				tk=tk.replace("derived from","");
				tk=tk.replaceAll(" ", "");
				String[] jj=tk.split(",");
				for(String j:jj){
					ent.add(j);
					HashSet list=new HashSet();
					if(mapnodes.containsKey(j)){
						list=(HashSet) mapnodes.get(j);
					}
					list.add(node);
					mapnodes.put(j,list);
					  
					list=new HashSet();
					if(mapelems.containsKey(iID)){
						list=(HashSet) mapelems.get(iID);
					}
					list.add(j);
					mapelems.put(iID,list);
					
				}
			}
			else if(tk.contains("associated with")){
				tk=tk.replace("associated with","");
				tk=tk.replaceAll(" ", "");
				String[] jj=tk.split(",");
				for(String j:jj){
					agt.add(j);
					HashSet list=new HashSet();
					if(mapnodes.containsKey(j)){
						list=(HashSet) mapnodes.get(j);
					}
					list.add(node);
					mapnodes.put(j,list);
					
					list=new HashSet();
					if(mapelems.containsKey(iID)){
						list=(HashSet) mapelems.get(iID);
					}
					list.add(j);
					mapelems.put(iID,list);
				}
			}
			else if(tk.contains("generated by using primary sources")){
				tk=tk.replace("generated by using primary sources","");
				tk=tk.replaceAll(" ", "");
				String[] jj=tk.split(",");
				for(String j:jj){
					ent.add(j);
					HashSet list=new HashSet();
					if(mapnodes.containsKey(j)){
						list=(HashSet) mapnodes.get(j);
					}
					list.add(node);
					mapnodes.put(j,list);
					
					list=new HashSet();
					if(mapelems.containsKey(iID)){
						list=(HashSet) mapelems.get(iID);
					}
					list.add(j);
					mapelems.put(iID,list);
				}
			}
			else if(tk.contains("generated by using")){
				tk=tk.replace("generated by using","");
				tk=tk.replaceAll(" ", "");
				String[] jj=tk.split(",");
				for(String j:jj){
					ent.add(j);
					HashSet list=new HashSet();
					if(mapnodes.containsKey(j)){
						list=(HashSet) mapnodes.get(j);
					}
					list.add(node);
					mapnodes.put(j,list);
					
					list=new HashSet();
					if(mapelems.containsKey(iID)){
						list=(HashSet) mapelems.get(iID);
					}
					list.add(j);
					mapelems.put(iID,list);
				}
			}
			else if(tk.contains("generated to satisfy goal")){
				tk=tk.replace("generated to satisfy goal","");
				tk=tk.replaceAll(" ", "");
				String[] jj=tk.split(",");
				for(String j:jj){
					ent.add(j);
					HashSet list=new HashSet();
					if(mapnodes.containsKey(j)){
						list=(HashSet) mapnodes.get(j);
					}
					list.add(node);
					mapnodes.put(j,list);
					
					list=new HashSet();
					if(mapelems.containsKey(iID)){
						list=(HashSet) mapelems.get(iID);
					}
					list.add(j);
					mapelems.put(iID,list);
				}
			}
			else if(tk.contains("generated by")){
				tk=tk.replace("generated by","");
				tk=tk.replaceAll(" ", "");
				String[] jj=tk.split(",");
				for(String j:jj){
					act.add(j);
					HashSet list=new HashSet();
					if(mapnodes.containsKey(j)){
						list=(HashSet) mapnodes.get(j);
					}
					list.add(node);
					mapnodes.put(j,list);
					
					list=new HashSet();
					if(mapelems.containsKey(iID)){
						list=(HashSet) mapelems.get(iID);
					}
					list.add(j);
					mapelems.put(iID,list);
				}
			}
		 
			
			else if(tk.contains("informed by")){
				tk=tk.replace("informed by","");
				tk=tk.replaceAll(" ", "");
				String[] jj=tk.split(",");
				for(String j:jj){
					act.add(j);
					HashSet list=new HashSet();
					if(mapnodes.containsKey(j)){
						list=(HashSet) mapnodes.get(j);
					}
					list.add(node);
					mapnodes.put(j,list);
					
					list=new HashSet();
					if(mapelems.containsKey(iID)){
						list=(HashSet) mapelems.get(iID);
					}
					list.add(j);
					mapelems.put(iID,list);
				}
			}
			
			
		}
	 
	//	System.out.println(act+"\n"+ent+"\n"+agt);
		Object[] list=new Object[]{act,ent,agt,mapnodes,mapelems};
		 
	  return list;
 
	 
	}

	private Object[] createNodesFrom(ArrayList arrayList) {
		  //Here I create a node hashmap  
		
		Object[] res=new Object[3];
		DefaultDirectedGraph<String, DefaultEdge> graph=new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
			HashMap nodes=new HashMap();
			ArrayList prefnodes=new ArrayList();
		   Iterator iter=arrayList.iterator();
	
		 
		   String eval;
		   LinkedTreeMap mapNode;
		   String type;
		   Node nd;
		 	while(iter.hasNext()){
		 		mapNode=(LinkedTreeMap)iter.next();
		 		//System.out.println(mapNode);
		 		if(mapNode.get("type").equals("I") || mapNode.get("type").equals("P")){
		 			//System.out.println(mapNode);	
		 		eval=((String) mapNode.get("eval")).toUpperCase();
		 		type=(String) mapNode.get("input");
		 		while(eval.contains(" ")){
		 			eval=eval.replace(" ", "");
		 		}
		 		nd=new Node((String) mapNode.get("nodeID"),(String) mapNode.get("text"));
		 		graph.addVertex(nd.getID());
		 		 
	 
		 		while(type.contains(" ")){
			 			type=type.replace(" ", "");
			 		}
		 		nd.setType(type);
		 		  
		 		
		 		nodes.put(nd.getID(),nd);
		 		 
		 		if(mapNode.get("type").equals("P")){
		 			prefnodes.add(nd.getID());
		 		}
		 		}else{
		 			//still need to add vertex 
		 			String lid=(String) mapNode.get("nodeID");
		 			graph.addVertex(lid);
		 		}
		 }
		 	res[0]=nodes;
		 	res[1]=prefnodes;
		 	res[2]=graph;
		
		 	return res;
	}



	private Object[] getLinksFrom(ArrayList nodes, ArrayList edges, DefaultDirectedGraph<String, DefaultEdge> graph,HashMap nodesmap,ArrayList prefnodes) {
		//this maps the links with heads and tails and also replace the internal IDs
		HashMap linksp=new HashMap();
	    Iterator iter=nodes.iterator();
		   ArrayList lpp=new ArrayList();
		   ArrayList prefs=new ArrayList();
		   ArrayList lpv=new ArrayList();
	    Schemes schemes = new Schemes();
		HashSet cqs=schemes.getCQs();
	    Link link;
		while(iter.hasNext()){
	    	LinkedTreeMap nd=(LinkedTreeMap) iter.next();
	    	if(nd.get("type").equals("CA") || nd.get("type").equals("RA")){
	    		link=new Link((String)nd.get("nodeID"),(String)nd.get("type"),(String)nd.get("text")); 
	    		//here if the node underminer or a rebuttal specify contradictory negation
	    		if(((String)nd.get("type")).equals("CA")){
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
	    		 }
	    		linksp.put(nd.get("nodeID"), link);
	    		
	    	    if(link.isPro()){
	    	   // 	System.out.println(link.getText());
	    	    	if(link.getText().equals("LPP")){
	    	    		lpp.add(link.getId());
	    	    	}
	    	    	if(link.getText().equals("LPV")){
	    	    		lpv.add(link.getId());
	    	    	}
	    	    }
	    		
	    	}else{
	    		if(nd.get("type").equals("P")){
	    			prefs.add((String)nd.get("nodeID"));
	    		}
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
		    		link.setTails(from);
		    		
		    	}
		    	else{if (linksp.containsKey(from)){
		    		//then it is a head
		    		link=(Link) linksp.get(from);
		    		link.setHead(to);
		    	//	System.out.println(to);
		    		if(link.isPro() && prefnodes.contains(to)){
			    		Node tond=(Node) nodesmap.get(to);//pref
			    		if(!link.getText().contains("LPP")){
			    			tond.setJust();
			    		}
	    	    	}
		    		 
		    	}else{
		    	
		    	//System.out.println("FROM"+from+" TO "+to);
		    	if(prefnodes.contains(from)){ ///from is a pref
		    		if(prefnodes.contains(to)){
		    			//this is a pref of pref
		    			//here this is the difficult part 
		    			//I need to go into the nodes and see where they belong to 
		    
			    		Node tond=(Node) nodesmap.get(to);
		    			String totext=tond.getText();
		    			 
			    		Node fromnd=(Node) nodesmap.get(from);
		    			String fromtext=fromnd.getText();
		    			//first establish which one is above
		    			//System.out.println(fromtext+":"+totext);
		    			if(fromtext.length()>totext.length()){
		    				// above is fromnd;
		    			//	System.out.println("above is from");
		    				fromnd.setPref_left(to);
		    			}else{
		    				tond.setPref_right(from);
		    			//	System.out.println("above is to");
		    			}
		    			// ok now forget the below!!!
			    		
		    		}else{
		    			//to is a node
		    			 
			    		Node fromnd=(Node) nodesmap.get(from);
			    		fromnd.setPref_left(to);
			    		
		    		}	
		    	}else{
		    		if(prefnodes.contains(to)){ //this is the right
		    			//the from is a node!
			    		Node tond=(Node) nodesmap.get(to);
			    		tond.setPref_right(from);
		    		}
		    	}
		    		//System.out.println(ed);
		     
		    	}
		    	}
		    }
	     
	    Object[] res=new Object[]{linksp,graph,lpp,lpv,prefs}; 
	  
	    return res;
	  
	}
	
	
	
	

	 

	
	
	
	private HashMap buildPrefNodes(ArrayList<Couple> o_crts,PrefNodeBuilder ndbuild,ArrayList<TPref>[] ind, HashMap links, HashMap nodes,String user, boolean test) {
		
		  ArrayList<TPref> Tprefs_agt=ind[0];
		  ArrayList<TPref> Tprefs_act=ind[1];
		  ArrayList<TPref> Tprefs_times=ind[2];
		  ArrayList<TPref> Tprefs_dist=ind[3];
		 
		  
	//	System.out.println("NNN"+Tprefs_agt+"\n"+Tprefs_act+"\n"+Tprefs_times+"\n"+Tprefs_dist+"\nNNNN");
	String extra="";
		if(test){
			extra=user+": ";
		}
		//System.out.println("TRUST");
		HashMap<String, String[]> maptrust=buildSetElem(ndbuild," is less trustworthy than ",Tprefs_agt,links,nodes,extra);
		// System.out.println("RELIABLE");
		HashMap<String, String[]> maprel=buildSetElem(ndbuild," is less reliable than ",Tprefs_act,links,nodes,extra);
		HashMap<String, String[]> maptime=buildSetNode(ndbuild,"  is less timely than ",Tprefs_times,nodes,extra);
		HashMap<String, String[]> mapacc=buildSetNode(ndbuild," is less accurate than ",Tprefs_dist,nodes,extra);
	//	  System.out.println("DO I GET HERE?");
		buildSetPref(o_crts,maptrust, maprel, maptime, mapacc,ndbuild,extra);
			
		 
		 //set the nodes
		  ndbuild.setNodes(user);
		 //check if needing some preferences over criteria
		  
		  
		  //now add prov and return maps
		 HashMap mp= ndbuild.getNodes(user);
		 
		return mp;
	}
	 
	
 


	private void buildSetPref(ArrayList<Couple> couples, HashMap<String, String[]> maptrust,
			HashMap<String, String[]> maprel, HashMap<String, String[]> maptime, HashMap<String, String[]> mapacc,
			PrefNodeBuilder ndbuild, String extra) {
		
		//so here I do it all in once otherwise things get too complex!!!!
	//	System.out.println("CP"+couples);
		 OrdComparator comp=new OrdComparator();
		 ArrayList<TPref> tps=new ArrayList<TPref>();
		 //here I sort from the most preferred to the least preferred 
		 HashMap<String, Double> list=new  HashMap<String, Double>();
		 for(Couple cp:couples){
			 list.put(cp.getElement(), (double)cp.getVal());
			 //System.out.println(list);
		 }
	// System.out.println(list);
		// System.out.println(list.get("Timeliness")+":"+list.get("Accuracy"));
		 if((double)list.get("Timeliness")!=(double)list.get("Accuracy")){
			//  System.out.println(list.get("Timeliness")+"T:A"+list.get("Accuracy"));
			  findCritPrefs(maptime,mapacc,(double)list.get("Timeliness"),(double) list.get("Accuracy"),"Timeliness","Accuracy",ndbuild,extra); 
		 
		 }
		// System.out.println(list.get("Timeliness")+":"+list.get("Reliability"));
		 if((double)list.get("Timeliness")!=(double)list.get("Reliability")){
	 	//	 System.out.println(list.get("Timeliness")+"T:R"+list.get("Reliability"));
			 findCritPrefs(maptime,maprel,(double)list.get("Timeliness"),(double) list.get("Reliability"),"Timeliness","Reliability",ndbuild,extra); 
		 }
	//	 System.out.println(list.get("Timeliness")+":"+list.get("Trustworthiness"));
		if((double)list.get("Timeliness")!=(double)list.get("Trustworthiness")){
	 	 //System.out.println(list.get("Timeliness")+"T:T"+list.get("Trustworthiness"));
			 findCritPrefs(maptime,maptrust,(double)list.get("Timeliness"),(double) list.get("Trustworthiness"),"Timeliness","Trustworthiness",ndbuild,extra);  
		 }
	//	System.out.println(list.get("Accuracy")+":"+list.get("Reliability"));
		if((double)list.get("Accuracy")!=(double)list.get("Reliability")){
	 	//	 System.out.println(list.get("Accuracy")+"A:R"+list.get("Reliability"));
			 findCritPrefs(mapacc,maprel,(double)list.get("Accuracy"),(double) list.get("Reliability"),"Accuracy","Reliability",ndbuild,extra); 	 
				
		 }
	//	 System.out.println(list.get("Accuracy")+":"+list.get("Trustworthiness"));
		if((double)list.get("Accuracy")!=(double)list.get("Trustworthiness")){
	 	// System.out.println(list.get("Accuracy")+"A:T"+list.get("Trustworthiness"));
			 findCritPrefs(mapacc,maptrust,(double)list.get("Accuracy"), (double)list.get("Trustworthiness"),"Accuracy","Trustworthiness",ndbuild,extra);  	
		 }
	//	 System.out.println(list.get("Reliability")+":"+list.get("Trustworthiness"));
		 if((double)list.get("Reliability")!=(double)list.get("Trustworthiness")){
	 		 //System.out.println(list.get("Reliability")+"R:T"+list.get("Trustworthiness"));
			  findCritPrefs(maprel,maptrust,(double)list.get("Reliability"), (double)list.get("Trustworthiness"),"Reliability","Trustworthiness",ndbuild,extra);  	
		 }
		

		
		
		//now first I settle the preferences
			
				
			

	}


 


	private HashMap<String, String[]> buildSetNode(PrefNodeBuilder ndbuild, String line, ArrayList<TPref> tprefs_times, HashMap nodes, String extra) {
		//here the preference does not take as input the elements
			HashMap<String, String[]> map=new HashMap<String, String[]>();
		  for(TPref pref:tprefs_times){
			//  System.out.println(pref);
			  
			  String aa=((Node)nodes.get(pref.getNdA())).getText().substring(0, 3);
			  String bb=((Node)nodes.get(pref.getNdB())).getText().substring(0, 3);
			  String ptext=extra+bb+line+aa;
			  String qtext="("+bb+" < "+aa+")";
			  String idis[]= ndbuild.addPrefNodes(pref.getNdA(),pref.getNdB(),null,null,ptext,qtext);
			  map.put(ptext, idis); 
			/*  System.out.println(ptext);
			  for(String id:idis){
				  System.out.println("-"+id);
			  }*/
		  }
		  return map;
	}


	private HashMap<String, String[]> buildSetElem(PrefNodeBuilder ndbuild,String line,ArrayList<TPref> tprefs_agt,HashMap links,HashMap nodes, String extra){
   // System.out.println(Tprefs);
		HashMap<String, String[]> map=new HashMap<String, String[]>();
	  for(TPref pref:tprefs_agt){
		  ArrayList<String[]> idnA=new ArrayList<String[]>();
		  ArrayList<String[]> idnB=new ArrayList<String[]>();
		 //   System.out.println(pref);
		  //find the nodes that need to be linked regarding the elements of provenance!
		  Iterator iter=links.keySet().iterator();
		  while(iter.hasNext()){
			  Link link=(Link) links.get(iter.next());
			  if(link.getText().equals("LPV")){
				  if(link.getTails().contains(pref.getNdA())){
					  Node nd=(Node) nodes.get(link.getHead());
					  idnA.add(new String[]{link.getHead(),nd.getText()});
				  }
				  if(link.getTails().contains(pref.getNdB())){
					  Node nd=(Node) nodes.get(link.getHead());
					  idnB.add(new String[]{link.getHead(),nd.getText()});
				  }
			  }
		  }
		  
		  
		  String ptext=extra+pref.getElemB()+line+pref.getElemA();
		  for(String[] aa: idnA){
			  for(String[] bb: idnB){
				  String qtext="("+bb[1].substring(0, 3)+" < "+aa[1].substring(0, 3)+")";
				 
				  String[] idis= ndbuild.addPrefNodes(aa[0],bb[0],pref.getNdA(),pref.getNdB(),ptext,qtext); 
				/*  System.out.println(ptext);
				  for(String id:idis){
					  System.out.println("-"+id);
				  }*/
			 
				  
				  map.put(ptext, idis); 
			  }
		  }
		  
		  
	  }
	  return map;
	}


	 

 public void updateElementsFinal(ArrayList elem, String user) {
		Iterator iter=elem.iterator();
		while(iter.hasNext()){
			LinkedTreeMap mpe=(LinkedTreeMap) iter.next();
			int choice=Integer.parseInt((String)mpe.get("qid"));
			ArrayList<ArrayList> xx=(ArrayList<ArrayList>) mpe.get("cats");
				for(ArrayList acp:xx){
						double numb=(double)acp.get(1);
						String el=(String)acp.get(0);
						dbn.updatePelemTuple(user, el, numb, choice);
				}
	}
 }
	 

}
