package ers;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.internal.LinkedTreeMap;

import utils.JsonHelper;

public class AIFDBConverter {

	public LinkedTreeMap convertToAIFDB(LinkedTreeMap mgraph) {
		JsonHelper jsh=new JsonHelper();
	//	System.out.println("do I caome here");
		//String hb=jsh.convertInputJson(mgraph);
		//System.out.println(hb);
		LinkedTreeMap mgraphnew=new LinkedTreeMap();
		ArrayList nodes=(ArrayList) mgraph.get("nodes");
		mgraphnew.put("nodes",nodes);
		ArrayList<LinkedTreeMap> edges=(ArrayList<LinkedTreeMap>) mgraph.get("edges");
		ArrayList newedges=new ArrayList();
		
		for(LinkedTreeMap edge:edges){
			 String edg=jsh.convertInputJson(edge);
			 edg=edg.replace("source", "fromID");
			 edg=edg.replace("target", "toID");
			 LinkedTreeMap newedge=jsh.convertInputMapG(edg);
			 newedges.add(newedge);
		}
		mgraphnew.put("edges",newedges);
	//	String hl=jsh.convertInputJson(mgraphnew);
	//	System.out.println(hl);
		return mgraphnew;
	}

}
