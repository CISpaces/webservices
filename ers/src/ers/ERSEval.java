/******************************************************************************
 * This research was sponsored by the U.S. Army Research Laboratory and the
 * U.K. Ministry of Defence under the Biennial Program Plane 2013 (BPP13),
 * Project 6, Task 3: Collaborative Intelligence Analysis.
 * The U.S. and U.K. Governments are authorized to reproduce and distribute
 * reprints for Government purposes notwithstanding any copyright notation
 * hereon.
 * **************************************************************************
 * 
 * To break down ERSCOntrol this is the class that elaborates the response
 * Easier to manage in 2 classes 
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
import java.util.StringTokenizer;

import ersdata.Node;

public class ERSEval {
 	private HashMap nodes;
 	private HashMap listh;
	private HashMap prefids;
	public ERSEval(HashMap nds,HashMap pids){
		nodes=nds;
		listh=new HashMap();
		prefids=pids;
	}

	
	
	
	  
public HashMap elaborateResponse(HashMap map){

    HashSet extensList=(HashSet) map.get("extensions");
    ArrayList argsList=(ArrayList)map.get("arguments"); 
    ArrayList attacks=(ArrayList)map.get("defeat");
    Iterator iter;
    HashMap args=new HashMap();
    HashMap skcheck=new HashMap();
    //construct an hashmap of hashsetlists
    HashSet skpref=new HashSet();
    HashMap defeats=new HashMap();
    StringTokenizer st;
    String argst,arg,head;
    String left, right;
    HashSet def;
    
    if(attacks!=null){
    iter=attacks.iterator();
 
    while(iter.hasNext()){
    	argst=(String) iter.next();
    	argst=argst.replace(" ", "");
    	st=new StringTokenizer(argst,">");
    	left=st.nextToken();
    	right=st.nextToken();
    	if(defeats.containsKey(left)){
    		def=(HashSet) defeats.get(left);
    	}else{
    		def=new HashSet();
    	}def.add(right);
    	defeats.put(left,def);
    	 
     }
 
  
    }
    ArrayList exts=new ArrayList();
  if(extensList!=null){
    //convert extensions into a vector of ArrayLists
    iter=extensList.iterator();
    Iterator itt;HashSet list;
   
    HashSet ext;
    int g;
    while(iter.hasNext()){
    	list=(HashSet) iter.next();
    	itt=list.iterator();
    	ext=new HashSet();
    	while(itt.hasNext()){
    		//this is one extension list
    		arg=(String) itt.next();
        	arg=arg.replace(" ", "");
 
        	ext.add(arg);
        	if(skcheck.containsKey(arg)){
        		 g=(Integer) skcheck.get(arg);
        		 g++;
        		 skcheck.put(arg, g);
        	}else{
        		skcheck.put(arg, 1);
        	}
    	}
    	exts.add(ext);
    }
   
    //eg. [[A2, A1, A4, A5, A7], [A2, A1, A4, A3, A6]]
    if(exts.size()!=1){
    iter=skcheck.keySet().iterator();
    int  size=exts.size();

    while(iter.hasNext()){
    	arg=(String) iter.next();
    	g=(Integer)skcheck.get(arg);
    	if(g==size){
    		skpref.add(arg);
    	}
    }
    }else{
    	skpref=(HashSet) exts.get(0);
    }
    
  }
    if(argsList!=null){
   //convert arguments into a map <arg,concl>  
     iter=argsList.iterator();
    
    while(iter.hasNext()){
    	argst=(String) iter.next();
    	argst=argst.replace(" ", "");
    	st=new StringTokenizer(argst,":");
    	arg=st.nextToken();
    	st=new StringTokenizer(st.nextToken(),"=>");
    	if(st.countTokens()>1){
    		st.nextToken();
    		head=st.nextToken();
    	}else{
    		//no tails
    		head=st.nextToken();
    	}
    	args.put(arg,head);
    		
    }
    }
    return setColorsErsResponse(exts, args, skpref, defeats);
    
 

    }

private HashMap setColorsErsResponse(ArrayList exts, HashMap args, HashSet skpref, HashMap defeats) {
	//NODE In assigned has the priority
	//so if there is a node that has two arguments for it, if there is at least one that 
	//is in the extension it will be assigned to true

	
//	System.out.println("MAX"+maxChoice);
	
	Iterator iter,itnd;
	String head, arg,node,rej;
	HashSet ext;
	HashMap colorResp=new HashMap();
	HashMap colors=new HashMap();
 	HashMap nodeext; 
  	HashMap colext;
	HashMap naext=new HashMap();
	HashSet rejs;
	String  prev;
	 HashSet assigned;
    //nodes is the comparison 
	//max is the max match
	ArrayList maxMatch=new ArrayList();
	int max=0,count;
	Node nd;
	HashSet seth;
	
		//initialise colors
		iter=nodes.keySet().iterator();
	    String key;
	    nodeext=new HashMap();
	   
	    while(iter.hasNext()){
	    	key=(String) iter.next();
	    	nd=(Node)nodes.get(key);
	    	naext.put(nd.getID(), "N/A");
	    	nodeext.put(key, "?");

	    }
	 
	    int j=0; 
	    String prevschoice;
	    seth=new HashSet();
		//populate colors
	   assigned=new HashSet();
			//there is a skeptical preferred extension 
			colext=(HashMap) nodeext.clone();
		//	System.out.println(skpref+"\n"+defeats);
		 //   System.out.println(args.toString());
			iter=skpref.iterator();
		 
			while(iter.hasNext()){
				arg=(String) iter.next();
			
				node=getPred((String) args.get(arg));
				//System.out.println(arg+node);
				if(colext.containsKey(node) && !assigned.contains(node)){
					prevschoice=(String)colext.get(node);
					colext.put(node, "V");//set accepted
					assigned.add(node);
					
				}else{//this is an hnode in the extension!!!
					seth.add(node); 
				}
				
				//now set rejected
					rejs=(HashSet) defeats.get(arg);
					//System.out.println(defeats+""+rejs+""+arg);
					if(rejs!=null){
						itnd=rejs.iterator();
						while(itnd.hasNext()){
							arg=(String) itnd.next();
							rej=getPred((String)args.get(arg));
							if(colext.containsKey(rej)){//if there is at least an arg in/arg is out!
								prev=(String) colext.get(rej);
								if(prev.equals("?")){//only if undecided otherwise it was in (leave it in)
								colext.put(rej, "X");
								
							}
						}
				}
				
				
			}
			}
			count=0;
		//	System.out.println(colext);
			//add seth into the list for PRAF
			listh.put("Skeptical Opt-"+j,seth);
			//System.out.println("HEY BEFORE"+max+" "+count+" "+maxChoice);
			colext=convert(colext);
			colors.put("Skeptical Opt-"+j, colext);
			if(count>max){
				maxMatch=new ArrayList();
				maxMatch.add("Skeptical Opt-"+j);
				max=count;
			}else if(count==max){
				maxMatch.add("Skeptical Opt-"+j);
			}
			j++;
			//System.out.println("HEY"+max+" "+count+" "+maxChoice);
	
		
		if(exts.size()>1){
			//if less than 2, there is only one preferred extension and I have already captured it in the previous one
		for(int i=0;i<exts.size();i++){
			seth=new HashSet();
			//for all the other credulous preferred extension 
			count=0; 
			assigned=new HashSet();
			colext=(HashMap) nodeext.clone();
			ext=(HashSet) exts.get(i);
			iter=ext.iterator();
			while(iter.hasNext()){
				arg=(String) iter.next();
				node=getPred((String) args.get(arg));
				if(colext.containsKey(node) && !assigned.contains(node)){
					prevschoice=(String)colext.get(node);
					colext.put(node, "V");//set accepted
					assigned.add(node);
					
				}else{//this is an hnode in the extension!!!
					seth.add(node); 
				}
				
				//now set rejected
					rejs=(HashSet) defeats.get(arg);
			//  	System.out.println(node+" "+defeats+" "+rejs+" "+arg);
					if(rejs!=null){
						itnd=rejs.iterator();
						while(itnd.hasNext()){
							arg=(String) itnd.next();
							rej=getPred((String)args.get(arg));
						//	System.out.println(rej+arg);
							if(colext.containsKey(rej)){//if there is at least an arg in/arg is out!
								prev=(String) colext.get(rej);
								if(prev.equals("?")){//only if undecided otherwise it was in (leave it in)
								colext.put(rej, "X");
								
							}
						}
				}
				
				
			}
			}
			count=0;
		
			
			 
			//add seth into the list for PRAF
			listh.put("Credulous Opt-"+j,seth);
			colext=convert(colext);
			colors.put("Credulous Opt-"+j, colext);
		//	System.out.println("BEFORE"+max+" "+count);
			if(count>max){
				maxMatch=new ArrayList();
				maxMatch.add("Credulous Opt-"+j);
				max=count;
			// 	System.out.println("HERE ");
			}else if(count==max){
				maxMatch.add("Credulous Opt-"+j);
			// 	System.out.println("OR HERE");
			}
			j++;
		//	System.out.println("AFTER this"+max+" "+count+"OPT"+j);
		}
		}
	HashMap map=new HashMap();
	 
	
	//set colors 
 
	map.put("colors",colors);
	map.put("assign-found",true);	 
		  
		
		
	//set results on the response map

	map.put("probs", "");
	map.put("fail",false);
	map.put("cause","");

	
	return map;
}





private String getPred(String string) {
	//System.out.println(prefids);
	// TODO Auto-generated method stub
	if(prefids.containsKey(string)){
		return (String)prefids.get(string);
	}
	return string;
}





private HashMap convert(HashMap colext) {
	HashMap conv=new HashMap();
	Iterator iter=colext.keySet().iterator();
	Node nd;
	String node;
	while(iter.hasNext()){
		node=(String)iter.next();
		nd=(Node) nodes.get(node);
		conv.put(nd.getID(),(String)colext.get(node));
	//	System.out.println(nd.getID()+":"+node);
	}
	return conv;
}





public HashMap getHList() {

	return listh;
}
	
	
	
	

}
