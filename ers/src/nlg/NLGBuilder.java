package nlg;

import java.util.HashMap;

import com.google.gson.internal.LinkedTreeMap;

import utils.JsonHelper;

public class NLGBuilder {

	private JsonHelper jsh;

	public NLGBuilder() {
		 jsh=new JsonHelper();
	}

	public String prepareNLG(LinkedTreeMap mgraph) {
		/*Here structure
		{
			  "fail": false,
			  "text": "Here is nlg text..."
			}
		*/
		//dummy call 
		HashMap map=new HashMap();
		map.put("fail", false);
		map.put("text", "Here is nlg text...");
		return jsh.convertInputJson(map);
	}

}
