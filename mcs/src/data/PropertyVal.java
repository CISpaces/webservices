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
 * @author       Alice Toniolo
 * @version     1.0  
 * @since 		 August 2015           
 *   
 */

package data;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import utils.JsonHelper;

public class PropertyVal {
//	"property_values":{"content":["Red car parked outside Kish hotel"],"timestamp":"1440397801724","is_from":["Patrol 2"],"is_to":["Patrol 1"]},
	public ArrayList content=null;
	public String timestamp=null;
	public ArrayList is_from=null;
	public ArrayList is_to=null;
	public ArrayList secondary_content=null;
	public ArrayList is_in_reply_to=null;
	public CispCard cispdata=null;
	
	public PropertyVal(ArrayList content, String timestamp, ArrayList is_from, ArrayList is_to,
			ArrayList secondary_content, ArrayList is_in_reply_to, CispCard cispdata) {
		super();
		this.content = content;
		this.timestamp = timestamp;
		this.is_from = is_from;
		this.is_to = is_to;
		this.secondary_content = secondary_content;
		this.is_in_reply_to = is_in_reply_to;
		this.cispdata=cispdata;
	}
	
	public String toString(){
		return "\n->AT: "+timestamp+"\n-> FROM:"+is_from+" TO:"+is_to+" IN_REPLY_TO:"+is_in_reply_to+""
				+ "\n->"+content;
	}
	
	public void getCispacesData(){
	 
		cispdata=new CispCard(new ArrayList(), false, null, null,null);
		if(secondary_content!=null && !secondary_content.isEmpty()){
			
		    Gson json=new Gson();
			String string=(String)secondary_content.get(0);
			//System.out.println(string);
			string = string.replace("\n", "").replace("\r", "");
			cispdata=json.fromJson(string, CispCard.class);
		//	System.out.println(map);
		/*	if(map.containsKey("sources")){
				cispdata.sources=(ArrayList) map.get("sources");
			}
			if(map.containsKey("to_cispaces")){
				cispdata.to_cispaces=(boolean) map.get("to_cispaces");
			}
			if(map.containsKey("nodeID")){
				cispdata.nodeID=(String) map.get("nodeID");
			}
			if(map.containsKey("forwarded_from")){
				cispdata.forwarded_from=(String) map.get("forwarded_from");
			}
			if(map.containsKey("forwarded_from")){
				cispdata.forwarded_from=(String) map.get("forwarded_from");
			}
			if(map.containsKey("rationale")){
				ArrayList rat=(ArrayList) map.get("rationale");
				cispdata.rationale=json.convertInputJson(rat);
			}
			*/
		} 
	}
	

	public boolean isEmpty() {
		if(timestamp==null){
			return true;
		}
		return false;
	}
		
}
