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
 * @since 		 April 2015           
 *   
 */
package hdc.crowdinfo;
 
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

 

  
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.impl.DefaultBHttpClientConnection;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.protocol.HttpCoreContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpProcessorBuilder;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.RequestConnControl;
import org.apache.http.protocol.RequestContent;
import org.apache.http.protocol.RequestExpectContinue;
import org.apache.http.protocol.RequestTargetHost;
 
 







 
import org.apache.http.util.EntityUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
 

 
 
public class HserviceClient {
 /*
  * 
  */
	private boolean PRINT;
	private static Logger log;
	private String hhost;
	private int hport;
	private String hpath;
	private int timeout;
	public HserviceClient(boolean p){
		log=Logger.getLogger(getClass().getName());
		PRINT=p;
	}
 //"http://128.97.93.172:80/query"
	
	public String ConnectToEvaluate(String eval, String port, String host, String path, int time){
		String result=null;
		hport=Integer.parseInt(port);
		hhost=host;
		hpath=path;
		timeout=time;
		try {
			return sendPost(eval);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
 
	// HTTP POST request
	private String sendPost(String eval)  {
	 
		HttpProcessor httpproc = HttpProcessorBuilder.create()
	            .add(new RequestContent())
	            .add(new RequestTargetHost())
	            .add(new RequestConnControl())
	            .add(new RequestExpectContinue(true)).build();

	        HttpRequestExecutor httpexecutor = new HttpRequestExecutor();

	        HttpCoreContext coreContext = HttpCoreContext.create();
	        HttpHost host = new HttpHost(hhost, hport);
	        // http://sykiotis.cimds.ri.cmu.edu:8002/hyperarg?jsonInput=<t
	        coreContext.setTargetHost(host);

	        DefaultBHttpClientConnection conn = new DefaultBHttpClientConnection(8 * 1024);
	        conn.setSocketTimeout(timeout);
	        ConnectionReuseStrategy connStrategy = DefaultConnectionReuseStrategy.INSTANCE;
	        String result = null;

	        try {
//db_name=query_sub
	        	 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	             nameValuePairs.add(new BasicNameValuePair("db_name", eval));
	              
	                if (!conn.isOpen()) {
	                	//System.out.print("GETS HERE>");
	                	Socket socket = new Socket();
	                	socket.connect(new InetSocketAddress(host.getHostName(), host.getPort()), timeout);
	                    conn.bind(socket);
	                }
	                BasicHttpEntityEnclosingRequest request = new BasicHttpEntityEnclosingRequest("POST",
	                        hpath);
	                
	                request.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	             
	                if(PRINT)
	                log.log(Level.INFO,">> Request URI: " + request.getRequestLine().getUri());

	                httpexecutor.preProcess(request, httpproc, coreContext);
	         
	                HttpResponse response = httpexecutor.execute(request, conn, coreContext);
	                httpexecutor.postProcess(response, httpproc, coreContext);
	                if(PRINT)
	                log.log(Level.INFO,"<< Response: " + response.getStatusLine());
	                result=EntityUtils.toString(response.getEntity());
	                if(PRINT){
	                log.log(Level.INFO,"-THIS IS THE RESULT"+result+"END-");
	                log.log(Level.INFO,"==============");
	                }
	               // if (!connStrategy.keepAlive(response, coreContext)) {
	                    conn.close();
	               // } else {
	                	 if(PRINT)
	                    log.log(Level.INFO,"Connection kept alive...");
	              //  }
	                
	            
	        } catch (IOException | HttpException e) {
				// TODO Auto-generated catch block
	         
		                log.log(Level.INFO,"Exception");
		                result=null;
	        	 
			} finally {
	            try {
					conn.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
				 
			                log.log(Level.INFO,"Exception");
				 
					result=null;
				}
	        }
	        
	        return result;
	     
	    }
 
}


 
