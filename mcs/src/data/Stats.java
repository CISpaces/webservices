package data;

import java.util.ArrayList;
import java.util.HashMap;

public class Stats {
	/*
	 * {"alerts":{"debugs":[],"infos":[],"warnings":[],"errors":[]},
	"message":[],
	"stats":{"code_version":"1.2.10690","server_time":"1440426382504","duration":"0.002","sentence_count":"713","instance_count":"320"},
	"structured_response":
		
	*/
	public HashMap alerts;
	public ArrayList message;
	public HashMap stats;
	public ArrayList<Card> structured_response;
	public Stats(HashMap alerts, ArrayList message, HashMap stats, ArrayList<Card> structured_response) {
	 
		this.alerts = alerts;
		this.message = message;
		this.stats = stats;
		this.structured_response = structured_response;
	}
	
	public String getServerTime(){
		String text=(String) stats.get("server_time");
		return text;
	}
 
}
