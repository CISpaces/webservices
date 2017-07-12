package info;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import infocontrol.InfoInput;
import utils.TimeHelper;
import utils.JsonHelper;

/**
 * Servlet implementation class InfoServHttp
 */
@WebServlet("/InfoServHttp")
public class InfoServHttp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log;
	private JsonHelper jsh;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServHttp() {
        super();
        // TODO Auto-generated constructor stub
        log=Logger.getLogger(getClass().getName());
	    jsh=new JsonHelper();
	   org.apache.log4j.BasicConfigurator.configure();
	   org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
	   Logger.getLogger("com.hp.hpl.jena.query").setLevel(Level.OFF);
	   Logger.getLogger("com.hp.hpl.jena").setLevel(Level.OFF);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at GET: ").append(request.getContextPath());
		  

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.log(Level.INFO,"*** NEW INFO USER - New Post ***");
		 
		  String dest=request.getParameter("dest");
		  String stream=request.getParameter("stream");
		  if(stream==null){
			  stream="DefaultStream";
		  }
		  String nodeID= UUID.randomUUID().toString();
		  String text= request.getParameter("text");

		  String source= request.getParameter("source");
		  String did= request.getParameter("dids");
		  TimeHelper time= new TimeHelper();
		  String timep=time.nowCIS();
		  
		  String lprov=request.getParameter("lprov");
		  String[] kv=lprov.split("\n");
		  HashMap lmap=new HashMap();
		  for(String kvitem:kv){
			  if(!kvitem.equals("Key:Value")){
			  String[] item=kvitem.split(":");
			  lmap.put(item[0], item[1]);
			  }
		  }
		  HashMap post=new HashMap();
		  post.put("dest", dest);
		  post.put("stream", stream);
		  post.put("surr", source);
		  ArrayList list=new ArrayList();
		  
		  HashMap node=new HashMap();
		  node.put("nodeID", nodeID);
		  node.put("text",text);
		  node.put("dtg", timep);
		  node.put("source", did);
		  node.put ("lprov",lmap);
		  list.add(node);
		  post.put("info", list);
		  
		  /*
		   * 	
		   *   String input="{\"dest\":\""+dest+"\",
		   *   \"stream\":\""+stream+"\",
		   *    \"surr\":\""+source+"\",
		   *    \"username\":\""+user+"\",
		   *     \"info\": [{  \"nodeID\": \""+nodeID+"\",  "
		  		+ "\"text\": \""+text+"\",  \"source\": \""+did+"\",  \"dtg\": \""+timep+"\"}"
		  		+ " ]}";
		   */
	  
		  InfoInput infol=new InfoInput();
		  
		  infol.postInfoTrans(post);
		  
		 // System.out.println(jsh.convertInputJson(post));
		  
		  log.log(Level.INFO,"*** NEW INFO USER SERVICE - Request Handled ***");
		 
		  
		  //here stop database
		  infol.closeDataBase();
		  response.getWriter().append("Served at POST: ").append(request.getContextPath());
	}

}
