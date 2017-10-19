
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


package plots;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
 


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 








import provservice.JsonHelper;

import com.google.gson.internal.LinkedTreeMap;

 






/**
 * Servlet implementation class PlotServlet
 */
public class PlotProvServlet extends HttpServlet implements javax.servlet.Servlet {
	 
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	private String path;
	private String port;
	private String host;
	private String folder;
	private Boolean printnodes;

	private String ci_path;

	private JsonHelper jsh;
	
    public PlotProvServlet () {
        // TODO Auto-generated constructor stub
    	super();
    	String pathfile=System.getenv("CATALINA_HOME");
    	if(pathfile==null){
    		path="./bin/provpng/";
    		folder="./bin/provpng";
    	}else{
    		path=pathfile+"/bin/provpng/"; 
    		folder=pathfile+"/bin/provpng";
    	}
    	
    }
    
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	 ci_path=System.getenv("CISPACES");
    	try {
  		  String content = new String(Files.readAllBytes(Paths.get(ci_path+"/code/config/cis_settings.txt")));
  		  //System.out.println(content);
  		  jsh=new JsonHelper();
  		  HashMap settings=jsh.convertInputMap(content);
  		  LinkedTreeMap servers=(LinkedTreeMap) settings.get("Servers");
  		  LinkedTreeMap provd=(LinkedTreeMap) servers.get("ProvDM");
  		  port=(String) provd.get("port"); 
  		  host=(String) provd.get("host_name");  
  		 
  		} catch (Exception e) {
  		
  		} 	 
  		
  	  if(!test()){
  		  //else read web.xml
  	   try { 
  		  // System.out.println("hello2");
  		 port=config.getInitParameter("port");  
		 host=config.getInitParameter("host_name");  
  	   } catch (Exception e) {
  			
  		} 
  	  }
  	  if(!test()){
  		 // System.out.println("hello3");
  		  //else set default
  		 port="8080";  
		 host="localhost";  
  	  }
		 printnodes=Boolean.parseBoolean(config.getInitParameter("aprov_print_nodes"));
    }
    private boolean test(){
  	  if(port==null || host==null) 
  		  return false;
  	  return true;
    }
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd;
		//System.out.println(request.toString());
	
	    createFolder(folder);
 
		
		  
        cmd = request.getParameter("action");
      //  System.out.println(cmd);
        if (cmd != null) {
        	/* 
        	 * action: 	byloc
	 		 			byday
	 		 			byquest
	 		 			byans
	 		 */
            if (cmd.equals("printprov")) {
                goPrintProv(request, response);
            }
             
     
		
	}
	}

	 

	private void goPrintProv(HttpServletRequest request,
			HttpServletResponse response) {
		String json=request.getParameter("json");
		json=json.substring(0, json.lastIndexOf("}")+1);
		 
		ProvControl cont=new ProvControl(path,port,host,printnodes);
		//System.out.println(json);
		String image=cont.getProv(json);
		response.setContentType("image/png"); /* Set the HTTP Response Type */
		if(!image.equals("fail")){
		
	 
//System.out.println(json);
		
		File f = new File(path+image+ "prov.png");
		//System.out.print("HELLO!"+pathToWeb);
		OutputStream out;
		BufferedImage bi;
		try {
			bi = ImageIO.read(f);
		
		out = response.getOutputStream();
		ImageIO.write(bi, "png", out);
		out.flush();
		out.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
		
	}
	/*
	 * 
http://localhost:8080/provgraphs/Prov?action=printprov&json={"request":"getprovnode","nodeID":"d2a0848e-e6e0-41huufb-b711-49dyfghhb96a","text": "Info pippo","source": "USERPIPPO", "dtg": "2014/08/13 01:19:17"}
http://localhost:8080/provgraphs/Prov?action=printprov&json={"dtg":"2014/08/21 03:29:56","text":"The gang G is crossing the north border","request":"getprovnode","nodeID":"dadbcbd9-5963-4f42-920c-c6640e7c1815","source":"MessageReceived"}


	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd;
		//System.out.println(request.toString());
	
	    createFolder(folder);
 
		
		  
        cmd = request.getParameter("action");
      //  System.out.println(cmd);
        if (cmd != null) {
        	/* 
        	 * action: 	byloc
	 		 			byday
	 		 			byquest
	 		 			byans
	 		 */
            if (cmd.equals("printprov")) {
                goPrintProv(request, response);
            }
             
        }
		
	}
	
	
	
	public void createFolder(String folderName){
		File file = new File(folderName);
		if (!file.exists()) {
			 file.mkdir();
			}
		}

}
