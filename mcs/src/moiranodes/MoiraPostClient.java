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
 * @since 		June 2014           
 *   
 */
package moiranodes;
 
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

 

  
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
 

 
 
public class MoiraPostClient {
 /*
  * 
  */
	private boolean PRINT=false;
	private static Logger log;
	private String m_host;
	private String m_path;
	private int m_port;
	public MoiraPostClient(boolean p){
		log=Logger.getLogger(getClass().getName());
		PRINT=p;
	}
 
	
	public String ConnectToEvaluate(int m_port2, String host, String path,String card){
		//System.out.println("got  1");
		String result=null;
	//	System.out.println("got  2");
		m_port=m_port2;
	//	System.out.println("got  3");
		m_host=host;
		m_path=path;
	//	System.out.println("got  4");
		result=sendPost(card);
		return result;
	}
	
 
	// HTTP POST request
	private String sendPost(String card)  {
	//	System.out.println("got 5");
		HttpProcessor httpproc = HttpProcessorBuilder.create()
	            .add(new RequestContent())
	            .add(new RequestTargetHost())
	            .add(new RequestConnControl())
	     
	            .add(new RequestExpectContinue(true)).build();

	        HttpRequestExecutor httpexecutor = new HttpRequestExecutor();

	        HttpCoreContext coreContext = HttpCoreContext.create();
	        HttpHost host = new HttpHost(m_host, m_port);
	   
	        coreContext.setTargetHost(host);

	        DefaultBHttpClientConnection conn = new DefaultBHttpClientConnection(8 * 1024);
	 //       ConnectionReuseStrategy connStrategy = DefaultConnectionReuseStrategy.INSTANCE;
	        String result = null;
	        Socket socket = null;
	        try {

	         	 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	         	 nameValuePairs.add(new BasicNameValuePair("ceText", card));
	         	nameValuePairs.add(new BasicNameValuePair("action", "save"));
	              
	         	
	                if (!conn.isOpen()) {
	                    socket= new Socket(host.getHostName(), host.getPort());
	                    conn.bind(socket);
	                }
	                BasicHttpEntityEnclosingRequest request = new BasicHttpEntityEnclosingRequest("POST",
	                        m_path);
	                
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
	                log.log(Level.INFO,"-"+result+"-");
	                log.log(Level.INFO,"==============");
	                }
	              //  if (!connStrategy.keepAlive(response, coreContext)) {
	                
	                    conn.close();
	               // } else {
	               // 	 if(PRINT)
	                //    log.log(Level.INFO,"Connection kept alive...");
	               // }
	                
	            
	        } catch (IOException | HttpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	            try {
					conn.close();
					 if(socket!=null){
                		 socket.close();
                	 }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        return result;
	    }
 
}
 
