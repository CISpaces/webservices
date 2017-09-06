/******************************************************************************
 * This research was sponsored by the U.S. Army Research Laboratory and the
 * U.K. Ministry of Defence under the Biennial Program Plane 2013 (BPP13),
 * Project 6, Task 3: Collaborative Intelligence Analysis.
 * The U.S. and U.K. Governments are authorized to reproduce and distribute
 * reprints for Government purposes notwithstanding any copyright notation
 * hereon.
 * **************************************************************************
 * 
 * Deals with provenance analysis
 * 
 * @author      Alice Toniolo  
 * @version     2.0 
 * @since 		July 2017       
 *   
 */

package provncontrol;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.internal.LinkedTreeMap;

import database.DBNQuery;
import provscontrol.ProvSControl;

import utils.JsonHelper;

public class ProvNControl extends ProvSControl{
	private RDFNQuery pcore;
	private JsonHelper jsh;
	
	public ProvNControl(String ps) {
		super(ps);
		pcore=new RDFNQuery(ps);
		jsh=new JsonHelper();
		checkTables();
		
	}
	
private void checkTables() {
	DBNQuery dbq = new DBNQuery(provsize);
	 if(!dbq.existTable("CISPACES_INFOPROV")){
		 dbq.createTableProv();
	 }
	 if(!dbq.existTable("CISPACES_PATHS")){
		 dbq.createTablePaths();
	 } if(!dbq.existTable("CISPACES_PELEM")){
		 dbq.createTableProvEleme();
	 }if(!dbq.existTable("CISPACES_PEXIST")){
		 dbq.createTableProvPathExisting();
	 }
} 
	 






//call 1 analysis
	public HashMap onGetProvPaths(HashMap map) {
			String user=(String)map.get("user");
		//	System.out.println(user);
			Boolean obf=(Boolean)map.get("obf");
			String nodeID=(String)map.get("nodeID");
			HashMap json=new HashMap();
			if(pcore.existsNode(nodeID)){
				//System.out.println(pcore.getProvPaths(obf,nodeID,user));
				json.put("paths", pcore.getProvPaths(obf,nodeID,user));
				json.put("response","success");
				
			}else{
				json=new HashMap();
				json.put("response","fail");	
			}
			pcore.saveAndUpload();
			return json;
	}	
			
			 

//call 2 analysis
	public HashMap onGetNodesPath(HashMap map) {
		String user=(String)map.get("user");
		String nodeID=(String)map.get("nodeID");
		String pathID=(String)map.get("pathID");
		HashMap json=new HashMap();
		
		json.put("response","success");
	//	System.out.println(json);
		json= pcore.getProvNodePath(user,nodeID, pathID);
		//System.out.println(json);
		return json;
	}
//call 1 pref
	public HashMap onGetElems(HashMap map) {
		String user=(String)map.get("user");
		ArrayList nodes=(ArrayList) map.get("nodes");
		Boolean obf=(Boolean)map.get("obf");
		ProvPrefBuild ppv=new ProvPrefBuild(provsize);
		map=ppv.getAllProvElements(obf, user, nodes);
		return map;
	}
//call 2 pref
	public HashMap onGetPrefNds(HashMap map) {
		String user=(String)map.get("user");
		Boolean obf=(Boolean)map.get("obf");
		LinkedTreeMap updatein=(LinkedTreeMap) map.get("graph");
		ArrayList elem=(ArrayList) map.get("elements");
		ProvPrefBuild ppv=new ProvPrefBuild(provsize);
		map= ppv.getPrefNodes(obf,user, updatein,elem);
		return map;
	}
//call 3 pref
	public HashMap onLoadPartPrefs(HashMap map) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
 
 
}
