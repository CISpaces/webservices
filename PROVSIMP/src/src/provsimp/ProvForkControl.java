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
 * @version     2.0  
 * @since 		July 2017 
 * 
 *  This divides the analysis from simple node records
 * 
 */

package provsimp;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import provncontrol.ProvNControl;
import provscontrol.ProvSControl;
import utils.JsonHelper;

public class ProvForkControl {
	 private static Logger log;
	 private JsonHelper jsh;
	 private String provsize;
	 
	 
	 
public ProvForkControl(boolean PR, String prov_size) {
			provsize=prov_size;
			jsh=new JsonHelper();
			log = Logger.getLogger(getClass().getName());
			provsize=prov_size;
}
		
public String evaluateJsonString(String fromJSon) {
	 		log.log(Level.INFO,"***  PROVDATA SERVICE - Split ***");
	 		
	 		//need this as sometimes parsing introduces issues 
			fromJSon=fromJSon.replaceAll("\"\"", "null");
			HashMap map=jsh.convertInputMap(fromJSon); //from JSON String to map
			String request=(String) map.get("action");
			switch(request){
			case "save": ProvSControl pcs=new ProvSControl(provsize);
						 map=pcs.onSave(map);
						 break;
			case "load": pcs=new ProvSControl(provsize);
						 map=pcs.onLoad(map);
						 break;
			case "addnodes": pcs=new ProvSControl(provsize);
						 map=pcs.onAddNodes(map);
						 break;
			case "copynode": pcs=new ProvSControl(provsize);
						 map=pcs.onCopyNode(map);
			             break;
			case "getnode": pcs=new ProvSControl(provsize);
						map=pcs.onGetProvNode(map);
						break;
			case "getpaths": ProvNControl pns=new ProvNControl(provsize);
						 map=pns.onGetProvPaths(map);
						 break;
			case "getpathnodes": pns=new ProvNControl(provsize);
			 			 map=pns.onGetNodesPath(map);
			 			 break;
	 		case "getprovelems": pns=new ProvNControl(provsize);
						 map=pns.onGetElems(map);
						 break;		
			case "getprefnodes": pns=new ProvNControl(provsize);
						 map=pns.onGetPrefNds(map);
						 break;		
			case "loadpartpref": pns=new ProvNControl(provsize);
			 			 map=pns.onLoadPartPrefs(map);
			 			 break;		
			 
			}
			String response=jsh.convertInputJson(map); //from map to JSON
			return response;
		}




}
