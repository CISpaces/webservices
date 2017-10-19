
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
 * @since 		March 2015           
 *   
 */


package provncontrol;

 
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;


import utils.PatternBuilder;
import utils.TimeHelper;



 

public class PrefNodeBuilder {
	private ArrayList nodes;
	private ArrayList ndprov;
	private ArrayList edges;

 
	private TimeHelper time;
	private HashMap expref;
 
	private HashMap<String,HashSet<String>> extrap;
	private RDFNQuery conn;
	private String curanaly;
	private String source;
	private String timex;
 
	private HashMap<String,HashSet<HashSet<String>>> preflpp;
	private HashMap<HashSet<String>, HashSet<String>> prefnodspp;
	private ArrayList listrem;
	private HashMap<String, String[]> pppref;
	private HashSet<String> donottouch;
	
	
	public PrefNodeBuilder(String ps)  {
		 
		time=new TimeHelper();
		conn=new RDFNQuery(ps);
		nodes=new ArrayList();
		ndprov=new ArrayList();
		edges=new ArrayList();
		 timex=time.nowCIS();
		 expref=new HashMap();
		 pppref=new HashMap<String, String[]>();
		 preflpp=new HashMap<String,HashSet<HashSet<String>>>();
		 prefnodspp=new HashMap <HashSet<String>,HashSet<String>>();
		 extrap=new HashMap<String,HashSet<String>>();
		 donottouch=new HashSet<String>();
	}
	
	public void updatePref(String qtext, String ndpref, boolean b) {
		//System.out.println("PREFQ:"+qtext+ndpref);
		//link!
		if(!preflpp.containsKey(qtext)){
			preflpp.put(qtext,new HashSet<HashSet<String>>());
		}
		HashMap map=new HashMap();
		map.put("nodeID", ndpref);
		expref.put(qtext, map);
		extrap.put(qtext, new HashSet<String>());
		if(b){
			donottouch.add(ndpref);
		}
	}
	
	public void updateLpp(String ty,String[] center, HashSet<String> newhash,HashSet<String> newids, String qtext,String lid, boolean test) {
		//link!
	//	System.out.println("UPDATE"+ty+":"+center+":"+newhash+":"+newids+":"+qtext+":"+lid+":"+test);
		HashSet<HashSet<String>> lpppref=new HashSet<HashSet<String>>();
		if(preflpp.containsKey(qtext)){
			lpppref=preflpp.get(qtext);
		}
		lpppref.add(newhash);
		preflpp.put(qtext, lpppref);
		//now pref
		if(!test)
		newids.add(lid);
		prefnodspp.put(newhash, newids);
		HashSet<String> ids=extrap.get(qtext);
	
		ids.add(lid);
		extrap.put(qtext, ids);
		pppref.put(ty,center);
	//	System.out.println(pppref);
	}

	
	public String[] addPrefNodes(String idA, String idB, String elemAid, String elemBid, String ptext, String qtext) {
		
	 //	 System.out.println("UPDATE\n"+idA+"\n"+idB+"\n"+elemAid+"\n"+elemBid+"\n"+ptext+"\n"+qtext+"\n");
		// Ineed to return the node that has the preference claim!!!
		HashMap ndpref=new HashMap();
		String pID;
		boolean expf=false;
		
		if(expref.containsKey(qtext)){
			//System.out.println("FOUND");
			ndpref=(HashMap) expref.get(qtext);
			pID=(String) ndpref.get("nodeID");
			expf=true;
		}else{
			pID=UUID.randomUUID().toString();
		}
	//	System.out.println(qtext+":"+expf);
		
		
		if(expf){
			HashSet<HashSet<String>> lpppref=new HashSet<HashSet<String>>();
			lpppref=preflpp.get(qtext);
			HashSet<String> newhash=new HashSet<String>();
			
			newhash.add(ptext);
			newhash.add(qtext);
			if(elemAid!=null && elemBid!=null){
				newhash.add(elemAid);
				newhash.add(elemBid);
			}
		//System.out.println(lpppref+":"+newhash);
			for(HashSet<String> test:lpppref){
			//	System.out.println("TEST"+test+newhash);
				if(test.containsAll(newhash)){
					
					//before that, we should remove this
					//if it is already there than it means that it should be removed!
					//now test points to the same so look for test in 
					 prefnodspp.remove(test);
					//System.out.println("do I not come back");
					 if(pppref.containsKey(ptext)){
						 return pppref.get(ptext);
					 }
					return null;
				}
			}
		}
		
  //	System.out.println("I am not there" + ptext+qtext);
		
		String claimID=UUID.randomUUID().toString();
		source="Pref_Analysis_Node_"+pID;//remember
	   
		String idArgScheme=UUID.randomUUID().toString();
		//I need 3 new nodes - 1 claim, 1 pro, 1 pref

		//claim
		HashMap node=new HashMap();
	    node.put("text", ptext);
	    node.put("uncert","Confirmed");// for now we leave it like that!
	    node.put("eval","N/A");
	    node.put("input", "CLAIM");
	    //source and dtg with provenance
	    node.put("commit","N/A");
	    node.put("type", "I");
	    node.put("dtg", timex);
	    node.put("source", source);
	    node.put("nodeID", claimID);
	    HashMap ann=new HashMap();
	    ann.put("conc", new HashMap());
	    HashMap scheme=new HashMap();
	    HashMap charact=new HashMap();
	    ArrayList prems=new ArrayList();
	    prems.add("PPP2");
	    charact.put("prem", prems);
	    charact.put("cqs", new ArrayList());
	    charact.put("id", "LPP");
	    charact.put("assump", new ArrayList());
	    scheme.put(idArgScheme, charact);
	    ann.put("prem_assump", scheme);
	    node.put("annot", ann);
	    nodes.add(node);
	    ndprov.add(node);
	    
	    
	    
		
		// link
	  
	    node=new HashMap();
	    node.put("text", "LPP");
	    node.put("dtg", timex);
	    node.put("nodeID", idArgScheme);
	    node.put("type", "RA");
	    node.put("source", source);
	    ann=new HashMap();
	    ann.put("id", "LPP");
	    node.put("annot", ann);
	    nodes.add(node);
	    
	    
	    if(!expf){
	    //pref
		ndpref=new HashMap();
		ndpref.put("text", qtext);
		ndpref.put("uncert","Confirmed");
		ndpref.put("eval","N/A");
		ndpref.put("input", "PREF");
		//System.out.println("TEXT"+qtext);
	    //source and dtg with provenance
	    ndpref.put("commit","N/A");
	    ndpref.put("type", "P");
	    ndpref.put("dtg", timex);
	    ndpref.put("source", source);
	    ndpref.put("nodeID", pID);
	    ann=new HashMap();
	    charact=new HashMap();
	    charact.put("cqs", new ArrayList());
	    prems=new ArrayList();
	    prems.add("CPP1");
	    charact.put("conc",prems );
	    charact.put("id", "LPP");
	    scheme=new HashMap();
	    scheme.put(idArgScheme, charact);
	    ann.put("conc", scheme);
	    ann.put("prem_assump", new HashMap());
	    ndpref.put("annot", ann);
	   
	    }else{
	    	if(ndpref.containsKey("annot")){ //else it is an old node!
	    	ann=(HashMap) ndpref.get("annot");
	    	scheme=(HashMap) ann.get("conc");
	    	charact=new HashMap();
	    	prems=new ArrayList();
	 	    prems.add("CPP1");
	 	    charact.put("cqs", new ArrayList());
	    	charact.put("conc",prems );
	  	    charact.put("id", "LPP");
	  	    scheme.put(idArgScheme, charact);
	  	    ann.put("conc", scheme);
	  	    ndpref.put("annot", ann);
	    }
	    }
	    expref.put(qtext, ndpref);
	    HashSet<String> ids=new  HashSet<String>();
	    if(extrap.containsKey(qtext)){
	    		ids=extrap.get(qtext);
	    }
		ids.add(pID);
		extrap.put(qtext, ids);
	 
	    
	    //now edges 4 !!!
	    
	    HashMap edge=new HashMap();
	
	    String idx=UUID.randomUUID().toString();

		
		
		edge=new HashMap();
		edge.put("toID", idArgScheme);
		edge.put("fromID", claimID);
		edge.put("formEdgeID",null);
	    idx=UUID.randomUUID().toString();
		edge.put("edgeID", idx);
		edges.add(edge);
		
		
		edge=new HashMap();
		edge.put("toID", pID);
		edge.put("fromID", idArgScheme);
		edge.put("formEdgeID",null);
	    idx=UUID.randomUUID().toString();
		edge.put("edgeID", idx);
		edges.add(edge);
		
		if(!expf){
		edge=new HashMap();
		edge.put("toID", idB);
		edge.put("fromID", pID);
		edge.put("formEdgeID",null);
	    idx=UUID.randomUUID().toString();
		edge.put("edgeID", idx);
		edges.add(edge);
		
		
		edge=new HashMap();
		edge.put("toID", pID);
		edge.put("fromID", idA);
		edge.put("formEdgeID",null);
	    idx=UUID.randomUUID().toString();
		edge.put("edgeID", idx);
		edges.add(edge);
		}
		
		if(elemAid!=null && elemBid!=null){
		//	System.out.println(elemAid+":"+elemBid);
		   edge=new HashMap();
			edge.put("toID", idArgScheme);
			edge.put("fromID", elemAid);
			edge.put("formEdgeID",null);
		     idx=UUID.randomUUID().toString();
			edge.put("edgeID", idx);
			edges.add(edge);
			
			edge=new HashMap();
			edge.put("toID", idArgScheme);
			edge.put("fromID", elemBid);
			edge.put("formEdgeID",null);
		    idx=UUID.randomUUID().toString();
			edge.put("edgeID", idx);
			edges.add(edge);
		}
		HashSet<HashSet<String>> lpppref=new HashSet<HashSet<String>>();
		if(preflpp.containsKey(qtext)){
			lpppref=preflpp.get(qtext);
		}
		HashSet<String> newhash=new HashSet<String>();
		newhash.add(elemAid);
		newhash.add(elemBid);
		newhash.add(ptext);
		newhash.add(qtext);
		lpppref.add(newhash);
		preflpp.put(qtext, lpppref);
		
		String[]  stt=new String[4];
		stt[0]=qtext;//pref text
		stt[1]=pID;//pref ndid
	//	stt[2]=claimID;//claimid
		stt[2]=idA; //right
		stt[3]=idB; //left
		
		pppref.put(ptext,stt);
		
		
		 return stt;
		
		
		
	}

 


	 public void setNodes(String user) {
			
			
			HashSet<String> last=new HashSet<String>();
			for(HashSet<String> set:prefnodspp.keySet()){
				HashSet<String> extra=prefnodspp.get(set);
				last.addAll(extra);
			
			}
			listrem=new ArrayList();
			//System.out.println("REM"+listrem);
			listrem.addAll(last);
			
			for(String pp:extrap.keySet()){
				HashSet<String> extra=extrap.get(pp);
				extra.removeAll(listrem);
				extrap.put(pp, extra);
			}
			
			
	
			Iterator itt=expref.keySet().iterator();
			while(itt.hasNext()){
				String pref=(String)itt.next();
				HashMap node=(HashMap)expref.get(pref);
				if(!extrap.get(pref).isEmpty()){
					if(node.containsKey("annot")){
						nodes.add(node);
						ndprov.add(node);
					}//otherwise old node!
				}else{
					if(!donottouch.contains(node.get("nodeID"))) 
					listrem.add(node.get("nodeID"));
				}
			}
			
	 }
	 public HashMap getNodes(String user) {	
		 HashMap results=new HashMap();
			if(!nodes.isEmpty()){
			results.put("nodes", nodes);
			results.put("edges", edges);
			String provs="CISpaces_Pref_Service";
			addNodes(timex,source,provs,user);
			return results;
			}else{
				return new HashMap();
			}
		
	}
	 
	public ArrayList getRemNodes(){
		return listrem;
	}
	
  
	 private void addNodes(String timex,String source,String provs,String user) {
		
		// System.out.println(timex);
		timex=time.getDateCIS(timex); 
		//for each node 
		//create prov node 
		//and add the node to the analysis!!!!
		PatternBuilder prov = new PatternBuilder();
		HashMap node;
		ArrayList nodes=new ArrayList();
		Iterator iter=ndprov.iterator();
		while(iter.hasNext()){
			node=(HashMap) iter.next();
			String[] nodeID=new String[2];
			nodeID[0]=(String) node.get("nodeID");
			nodeID[1]=(String) node.get("text");
			nodes.add(nodeID[1]);
			String act="Analyse_Pref_Chain_"+UUID.randomUUID().toString();
			prov.makeGenerationPattern(nodeID, source , act, provs, timex);
			prov.makeSimpleGenerationPattern(nodeID, act, user, timex);
			conn.addNodeModel(prov.getModel(), nodeID[0]); 
		}
 
		
 	
		
	}
	 
	 

 







	 
}
