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

public class Card{

	public String _type = null; //name!!
	public String _style = null;
	public String _id =null;
	public long _created=0;
	public boolean _shadow=false;
	public String _label =null;
	public ArrayList direct_concept_names=null;
	public ArrayList inherited_concept_names=null;
	public PropertyVal property_values=null;
	public HashMap property_types=null;
	public int primary_sentence_count=0;
	public int secondary_sentence_count=0;
	/*[
	 * {"_type":"instance",
	 * "_style":"summary",
	 * "_id":"msg_01",
	 * "_created":1440412906049,
	 * "_shadow":false,
	 * "_label":"msg_01",
	 * "direct_concept_names":["NL card"],
	 * "inherited_concept_names":["spatio-temporal thing","card","configuration concept","spatial thing","temporal thing","thing"],
	 * "property_values":{"content":["Everything normal here"],"timestamp":"1440397701724","is_from":["Patrol 1"],"is_to":["Patrol 2"]},
	 * "property_types":{"content":"D","timestamp":"O","is_from":"O","is_to":"O"},
	 * "primary_sentence_count":1,
	 * "secondary_sentence_count":0}
	 * 
	 * ,{"_type":"instance","_style":"summary","_id":"msg_02","_created":1440412906049,"_shadow":false,"_label":"msg_02","direct_concept_names":["NL card"],
	 * "inherited_concept_names":["spatio-temporal thing","card","configuration concept","spatial thing","temporal thing","thing"],
	 * "property_values":{"content":["Red car parked outside Kish hotel"],"timestamp":"1440397801724","is_from":["Patrol 2"],"is_to":["Patrol 1"]},
	 * "property_types":{"content":"D","timestamp":"O","is_from":"O","is_to":"O"},"primary_sentence_count":1,"secondary_sentence_count":0},
	 * {"_type":"instance","_style":"summary","_id":"msg_09","_created":1440412912105,"_shadow":true,"_label":"msg_09","direct_concept_names":["NL card"],
	 * "inherited_concept_names":["spatio-temporal thing","card","configuration concept","spatial thing","temporal thing","thing"],
	 * "property_values":{},"property_types":{},"primary_sentence_count":0,"secondary_sentence_count":1},
	 * {"_type":"instance","_style":"summary","_id":"msg_11","_created":1440412912104,"_shadow":false,"_label":"msg_11","direct_concept_names":["NL card"],
	 * "inherited_concept_names":["spatio-temporal thing","card","configuration concept","spatial thing","temporal thing","thing"],
	 * "property_values":{"content":["The blue group is a suspect"],"timestamp":"1440398741046","is_from":["Forensic reasoner"],"is_to":["Moira2"]},
	 * "property_types":{"content":"D","timestamp":"O","is_from":"O","is_to":"O"},"primary_sentence_count":1,"secondary_sentence_count":0},
	 * {"_type":"instance","_style":"summary","_id":"msg_12","_created":1440412912105,"_shadow":false,"_label":"msg_12","direct_concept_names":["NL card"],
	 * "inherited_concept_names":["spatio-temporal thing","card","configuration concept","spatial thing","temporal thing","thing"],"property_values":
	 * {"content":["Message from Forensic reasoner: The blue group is a suspect"],"secondary_content":["{\n\"info\": [\n    {\n      \"nodeID\": \"df222a6d-ec6c-4f0c-a424-3cd8bb683e02\",\n      \"text\": \"Info 14f9940d 6e1e 4ffc 9c3c 07e92d3c236c\",\n      \"source\": \"DataStream\",\n      \"dtg\": \"2014\/08\/28 02:14:50\"\n    }\n]\n}"],
	 * "timestamp":"1440398741171","is_from":["Moira2"],"is_in_reply_to":["msg_09"],"is_to":["Joe"]},"property_types":{"content":"D","secondary_content":"D","timestamp":"O","is_from":"O","is_in_reply_to":"O","is_to":"O"},"primary_sentence_count":1,"secondary_sentence_count":0}]

	
 */
	public Card(String _type, String _style, String _id, long _created, boolean _shadow, String _label,
			ArrayList direct_concept_names, ArrayList inherited_concept_names, PropertyVal property_values,
			HashMap property_types, int primary_sentence_count, int secondary_sentence_count) {
		super();
		this._type = _type;
		this._style = _style;
		this._id = _id;
		this._created = _created;
		this._shadow = _shadow;
		this._label = _label;
		this.direct_concept_names = direct_concept_names;
		this.inherited_concept_names = inherited_concept_names;
		this.property_values = property_values;
		this.property_types = property_types;
		this.primary_sentence_count = primary_sentence_count;
		this.secondary_sentence_count = secondary_sentence_count;
	}
 

public String toString(){
	return _id+":"+_created+":"+property_values.toString();
}
 
 
}
