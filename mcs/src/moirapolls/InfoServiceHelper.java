
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
 * @since 		October 2014           
 *   
 */

package moirapolls;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;



 

public class InfoServiceHelper {
	private static Logger log;
	private static String port;
	private static String host;
 
	public InfoServiceHelper(String p,String h) {
		 log=Logger.getLogger(getClass().getName());
	 
		 port=p;
		 host=h;
		
	}
	
	public String ConnectToEvaluate(String gsonmap){
	String result=null;
	 try{
		 long startTime = System.currentTimeMillis();
   
	  ClientConfig clientConfig = new ClientConfig();
	  Client client = ClientBuilder.newClient(clientConfig);
	  client.property(ClientProperties.CONNECT_TIMEOUT,120000);
	  client.property(ClientProperties.READ_TIMEOUT,   120000);
	  WebTarget service = client.target(getBaseURI());
	  log.log(Level.INFO,"Start INFO SERVICE");
	  Response   response=service.path("PostInfo").request(MediaType.APPLICATION_JSON).post(Entity.entity(gsonmap, MediaType.APPLICATION_JSON));

		  if(response.getStatus()!=200){
				  log.log(Level.INFO,"Something went wrong when connecting to INFO SERVICE");
				  response.close();
				  result=null;
			  }
			  else {
			  String output=response.readEntity(String.class);
			  
			  long endTime   = System.currentTimeMillis();
			  long totalTime = endTime - startTime;
				 

				log.log(Level.INFO,"Time INFO taken: " + totalTime +" ms"); // formatted string like "12.3 ms"
		       		result=output;
			  }
		 
			  
	 }catch(Exception e){
		 log.log(Level.SEVERE,"Exception",e);
	 
		  result=null;
	 } 
	 return result;
  }

 

private static URI getBaseURI() {
	return UriBuilder.fromUri("http://"+host+":"+port+"/info/rest/").build();
	 
  }

 

 
}
