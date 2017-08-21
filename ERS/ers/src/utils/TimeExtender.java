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


package utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import utils.TimeHelper;


public class TimeExtender extends TimeHelper{

	public String getDateCISnoSep(String text){
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMddHHmmss");
		DateTime dt = formatter.parseDateTime(text); 
		DateTimeFormatter ft =  DateTimeFormat.forPattern("dd-MM-yyyy hh:mm:ss");
		return ft.print(dt); 
	}
	public String getDateCISTurn(String text){
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		DateTime dt = formatter.parseDateTime(text); 
		DateTimeFormatter ft =  DateTimeFormat.forPattern("dd-MM-yyyy hh:mm:ss");
		return ft.print(dt); 
	}

}
