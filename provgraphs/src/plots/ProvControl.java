
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
 */

package plots;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.internal.LinkedTreeMap;

import provservice.JsonHelper;
import provservice.ProvServ;

public class ProvControl {

	private ProvServ serv;
	private static Logger log;
	private String path;
	private boolean prtnodes;
	public ProvControl(String pathToWeb,String port, String host, Boolean printnodes) {
		path=pathToWeb;
		 log = Logger.getLogger(getClass().getName());
		 serv=new ProvServ(path,port,host);
		 prtnodes=printnodes;
	}

	public String getProv(String json) {
		//System.out.println("hey"+json);
		JsonHelper jsh=new JsonHelper();
		HashMap map=jsh.convertInputMap(json); //from JSON String to map
		String request=(String) map.get("request");
		
			log.log(Level.INFO,"New request Get Provenanance of Node");
		      request=getProvNode(map);
	
		return request; 
		 
		 
		
	}

	

	private String getProvNode(HashMap map) {
		
 
		String nodeID=(String)map.get("nodeID");
 
		Boolean obf=(Boolean)map.get("obf");
	 
		String user=(String)map.get("user");
 
		//System.out.println(map.toString());
		return serv.printProvNode(user,nodeID ,obf);
	}

	

	
	
	
}
