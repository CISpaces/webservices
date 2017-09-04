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
import utils.JsonHelper;
import utils.TimeHelper;

/**
 * Servlet implementation class InfoServQueryHttp
 */
@WebServlet("/InfoServQueryHttp")
public class InfoServQueryHttp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log;
	private JsonHelper jsh;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServQueryHttp() {
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
		  String cmd = request.getParameter("action");
	      //  System.out.println(cmd);
	        if (cmd != null) {
	        	/* 
	        	 * action: 	byloc
		 		 			byday
		 		 			byquest
		 		 			byans
		 		 */
	            if (cmd.equals("death")) {
	                goQueryDeath(request, response);
	            }
	            if (cmd.equals("trespass")) {
	                goQueryTrespass(request, response);
	            }
	            if (cmd.equals("others")) {
	                goQueryOthers(request, response);
	            }
	        }
		response.getWriter().append("Served at GET: ").append(request.getContextPath());
	}

	private void goQueryTrespass(HttpServletRequest request, HttpServletResponse response) {
		log.log(Level.INFO,"*** NEW INFO USER - New Post ***");
		  
		  String dest=request.getParameter("dest");
		  TimeHelper time= new TimeHelper();
		  String timep=time.nowCIS();
		  InfoInput infol=new InfoInput();
		  
		  String nodeID= UUID.randomUUID().toString();
		  String text=" Officials from a food preparation plant in Vastopolis informed Vastpress that an individual was arrested for trespassing near the loading docks shortly after midnight";
		  String did="01878.sgm";
		  
		  String input="{\"dest\":\""+dest+"\",\"stream\":\"VAST\", \"surr\":\"collector\",\"username\":\"IE\", \"info\": [{  \"nodeID\": \""+nodeID+"\",  "
		  		+ "\"text\": \""+text+"\",  \"source\": \""+did+"\",  \"dtg\": \""+timep+"\"}"
		  		+ " ]}";
		  HashMap map=jsh.convertInputMap(input);
		  infol.postInfoTrans(map);
		   
		/*  nodeID= UUID.randomUUID().toString();
		   text="It seems very odd that so many trespassers were seen at these sites after the deaths";
		   did="03740";
		  
		   input="{\"dest\":\""+dest+"\",\"stream\":\"VAST\", \"surr\":\"collector\",\"username\":\"IE\", \"info\": [{  \"nodeID\": \""+nodeID+"\",  "
		  		+ "\"text\": \""+text+"\",  \"source\": \""+did+"\",  \"dtg\": \""+timep+"\"}"
		  		+ " ]}";
		    map=jsh.convertInputMap(input);
		  infol.postInfoTrans(map);
		 
		  /*01878.sgm	01878.sgm-EV0	*Justice/Arrest-Jail*  Officials from a food preparation plant in Vastopolis informed Vastpress that an individual was arrested for trespassing near the loading docks shortly after midnight.``Our	PLACEHOLDER_FOR_URL
03740.sgm	03740.sgm-EV2	*Life/Die*  It seems very odd that so many trespassers were seen at these sites after the deaths.	PLACEHOLDER_FOR_URL
03740.sgm	03740.sgm-EV1	*Life/Die*  Police detective Beatrice Brothers was investigating witness accounts that several suspicious individuals were trespassing at farms where the mass livestock deaths were reported.	PLACEHOLDER_FOR_URL
*/
		  /*
		  nodeID= UUID.randomUUID().toString();
		   text="Police detective Beatrice Brothers was investigating witness accounts that several suspicious individuals were trespassing at farms where the mass livestock deaths were reported";
		   did="03740";
		  
		   input="{\"dest\":\""+dest+"\",\"stream\":\"VAST\", \"surr\":\"collector\",\"username\":\"IE\", \"info\": [{  \"nodeID\": \""+nodeID+"\",  "
		  		+ "\"text\": \""+text+"\",  \"source\": \""+did+"\",  \"dtg\": \""+timep+"\"}"
		  		+ " ]}";
		    map=jsh.convertInputMap(input);
		  infol.postInfoTrans(map);
		 
		  
		 */ 
		  
		  log.log(Level.INFO,"*** NEW INFO USER SERVICE - Request Handled ***");
		 
		  
		  //here stop database
		  infol.closeDataBase();
		 
		
		
		
		
	}

	private void goQueryDeath(HttpServletRequest request, HttpServletResponse response) {
		log.log(Level.INFO,"*** NEW INFO USER - New Post ***");
		  
		  String dest=request.getParameter("dest");
		  TimeHelper time= new TimeHelper();
		  String timep=time.nowCIS();
		  InfoInput infol=new InfoInput();
		  
		  String nodeID= UUID.randomUUID().toString();
		  String text="Mass deaths of livestock have been reported on farms a short distance outside of the Vastopolis metropolitan area";
		  String did="02385.sgm";
		  
		  String input="{\"dest\":\""+dest+"\",\"stream\":\"VAST\", \"surr\":\"collector\",\"username\":\"IE\", \"info\": [{  \"nodeID\": \""+nodeID+"\",  "
		  		+ "\"text\": \""+text+"\",  \"source\": \""+did+"\",  \"dtg\": \""+timep+"\"}";
		 
		  
		/* 
		  02385.sgm	02385.sgm-EV0	*Life/Die*  Mass deaths of livestock have been reported on farms a short distance outside of the Vastopolis metropolitan area.	PLACEHOLDER_FOR_URL
			01038.sgm	01038.sgm-EV0	*Life/Die*  While dead fish have been found on shore, they have not been seen in this quantity.	PLACEHOLDER_FOR_URL
		  02385.sgm	02385.sgm-EV1	*Life/Die*  According to Department of Agriculture Official Tony Grenier, the investigation into the deaths is ongoing.	PLACEHOLDER_FOR_URL
		  03740.sgm	03740.sgm-EV0	*Life/Die*  Suspicions about the mass livestock deaths on April 1 have been raised today.	PLACEHOLDER_FOR_URL
		  03740.sgm	03740.sgm-EV1	*Life/Die*  Police detective Beatrice Brothers was investigating witness accounts that several suspicious individuals were trespassing at farms where the mass livestock deaths were reported.	PLACEHOLDER_FOR_URL
		  03740.sgm	03740.sgm-EV2	*Life/Die*  It seems very odd that so many trespassers were seen at these sites after the deaths.	PLACEHOLDER_FOR_URL
		  04085.sgm	04085.sgm-EV0	*Life/Die*  The city has received a report from the Department of Agriculture on the deaths of farm animals outside Vastopolis.	
		 */  
		  nodeID= UUID.randomUUID().toString();
		   text="According to Department of Agriculture Official Tony Grenier, the investigation into the deaths is ongoing";
		   did="02385.sgm";
		  
		   input+=",{  \"nodeID\": \""+nodeID+"\",  "
		  		+ "\"text\": \""+text+"\",  \"source\": \""+did+"\",  \"dtg\": \""+timep+"\"}";
		   nodeID= UUID.randomUUID().toString();
		   text="While dead fish have been found on shore, they have not been seen in this quantity.g";
		   did="01038.sgm";
		  
		   input+=",{  \"nodeID\": \""+nodeID+"\",  "
		  		+ "\"text\": \""+text+"\",  \"source\": \""+did+"\",  \"dtg\": \""+timep+"\"}";
		  
		  
		  nodeID= UUID.randomUUID().toString();
		   text="Suspicions about the mass livestock deaths on April 1 have been raised today";
		   did="03740.sgm";
		  
		   input+=",{  \"nodeID\": \""+nodeID+"\",  "
			  		+ "\"text\": \""+text+"\",  \"source\": \""+did+"\",  \"dtg\": \""+timep+"\"}";
		  
		  nodeID= UUID.randomUUID().toString();
		   text="Police detective Beatrice Brothers was investigating witness accounts that several suspicious individuals were trespassing at farms where the mass livestock deaths were reported";
		   did="03740.sgm";
		  
		   input+=",{  \"nodeID\": \""+nodeID+"\",  "
			  		+ "\"text\": \""+text+"\",  \"source\": \""+did+"\",  \"dtg\": \""+timep+"\"}";
		  nodeID= UUID.randomUUID().toString();
		   text="It seems very odd that so many trespassers were seen at these sites after the deaths";
		   did="03740.sgm";
		  
		   input+=",{  \"nodeID\": \""+nodeID+"\",  "
			  		+ "\"text\": \""+text+"\",  \"source\": \""+did+"\",  \"dtg\": \""+timep+"\"}";
		   
		  nodeID= UUID.randomUUID().toString();
		   text="The city has received a report from the Department of Agriculture on the deaths of farm animals outside Vastopolis";
		   did="04085.sgm";
		  
		   input+=",{  \"nodeID\": \""+nodeID+"\",  "
			  		+ "\"text\": \""+text+"\",  \"source\": \""+did+"\",  \"dtg\": \""+timep+"\"}"
		  		+ " ]}";
		    HashMap map = jsh.convertInputMap(input);
		  infol.postInfoTrans(map);
		  
		 
		  
		  
		  
		  log.log(Level.INFO,"*** NEW INFO USER SERVICE - Request Handled ***");
		 
		  
		  //here stop database
		  infol.closeDataBase();
		 
		
		
		
		
	}
	
	
	private void goQueryOthers(HttpServletRequest request, HttpServletResponse response) {
		log.log(Level.INFO,"*** NEW INFO USER - New Post ***");
		  
		  String dest=request.getParameter("dest");
		  TimeHelper time= new TimeHelper();
		  String timep=time.nowCIS();
		  InfoInput infol=new InfoInput();
		  
		  ArrayList<String[]> list=new ArrayList<String[]>();
		  
		  
		 String[] pp=new String[]{ "01030.sgm",	"Vastopolis has suffered another serious accident on the bridge crossing the Vast River on Interstate 610."	};
		 list.add(pp);
		 pp=new String[]{ "01030.sgm",	  "Both trucks were destroyed including the other one carrying food products."	};
		 list.add(pp);
		pp=new String[]{  "01030.sgm",	 "Compounding the event, one of the trucks carrying chemicals caught fire after a minor explosion."};
		 list.add(pp);
		pp=new String[]{"01030.sgm",	 "There, another 18 wheeler was struck."	};
		 list.add(pp);
		pp=new String[]{"01030.sgm",	" Compounding the event, one of the trucks carrying chemicals caught fire after a minor explosion."};
		 list.add(pp);
		pp=new String[]{"01878.sgm",	"Wicker would only say that the FBI is conducting ongoing investigations "
				+ "of radical groups, like this one, that seem to be springing up in this area.	"};
		 list.add(pp);
		 pp=new String[]{ "03040.sgm",	  "The publication had a large focus on attacks to the food supply.	"};
			 list.add(pp);
			 pp=new String[]{"03040.sgm",	 "But some experts are still uncertain of what tactics, targets or weapons could be used in such an attack, "
		  		+ "and are therefore unsure of how to prepare properly for them.	"};
				 list.add(pp);
				 pp=new String[]{ "03212.sgm",	 "Professor Edward Patino gave a rousing talk today at Vast University in Uptown about the threat of bioterrorism.	"};
			 list.add(pp);
			 pp=new String[]{ "03295.sgm",	 " Her hope is that most everyone else has received the flu shot which should reduce the caseload shortly.	"};
			 list.add(pp);
			 pp=new String[]{ "03435.sgm",	 " Police authorities apprehended three people suspected to be part of a homegrown terror cell, Paramurderers of Chaos.	"};
			 list.add(pp);
			 pp=new String[]{"03435.sgm",	 " However, the suspects must have had some warning of the pending raid.	"};
			 list.add(pp);
			 pp=new String[]{ "03435.sgm",	 " Police refused to provide information on the cause of the raid or additional details of the operation itself.	"};
			 list.add(pp);
			 pp=new String[]{ "03435.sgm",	 " But informed sources, believed to be reliable, revealed that the suspects were in the middle of construction "
		  		+ "of some type of laboratory in the basement of the structure where they were apprehended."	};
				 list.add(pp);
				 pp=new String[]{"03435.sgm",	 " Instead of escaping they destroyed most of the equipment, and therefore most the evidence.	"};
			 list.add(pp);
		
		 
 
		  String nodeID= UUID.randomUUID().toString();
		  String text="One nearby resident commented that they may just be sick individuals who wanted to see the carnage.";
		  String did="03740.sgm";
		  
		  String input="{\"dest\":\""+dest+"\",\"stream\":\"VAST\", \"surr\":\"collector\",\"username\":\"IE\", \"info\": [{  \"nodeID\": \""+nodeID+"\",  "
		  		+ "\"text\": \""+text+"\",  \"source\": \""+did+"\",  \"dtg\": \""+timep+"\"}";
		 
		  
		/* 
		  02385.sgm	02385.sgm-EV0	*Life/Die*  Mass deaths of livestock have been reported on farms a short distance outside of the Vastopolis metropolitan area.	PLACEHOLDER_FOR_URL

		  02385.sgm	02385.sgm-EV1	*Life/Die*  According to Department of Agriculture Official Tony Grenier, the investigation into the deaths is ongoing.	PLACEHOLDER_FOR_URL
		  03740.sgm	03740.sgm-EV0	*Life/Die*  Suspicions about the mass livestock deaths on April 1 have been raised today.	PLACEHOLDER_FOR_URL
		  03740.sgm	03740.sgm-EV1	*Life/Die*  Police detective Beatrice Brothers was investigating witness accounts that several suspicious individuals were trespassing at farms where the mass livestock deaths were reported.	PLACEHOLDER_FOR_URL
		  03740.sgm	03740.sgm-EV2	*Life/Die*  It seems very odd that so many trespassers were seen at these sites after the deaths.	PLACEHOLDER_FOR_URL
		  04085.sgm	04085.sgm-EV0	*Life/Die*  The city has received a report from the Department of Agriculture on the deaths of farm animals outside Vastopolis.	
		 */  
		 
		  for(String[] a:list){
			  nodeID= UUID.randomUUID().toString();
		   input+=",{  \"nodeID\": \""+nodeID+"\",  "
			  		+ "\"text\": \""+a[1]+"\",  \"source\": \""+a[0]+"\",  \"dtg\": \""+timep+"\"}";
		   
		  }
		 
		  nodeID= UUID.randomUUID().toString();
		   text="Jose Thom is a renowned author and terrorism expert.";
		   did="04080.sgm";
		  
		   input+=",{  \"nodeID\": \""+nodeID+"\",  "
			  		+ "\"text\": \""+text+"\",  \"source\": \""+did+"\",  \"dtg\": \""+timep+"\"}"
		  		+ " ]}";
		    HashMap map = jsh.convertInputMap(input);
		  infol.postInfoTrans(map);
		 
		  
		  log.log(Level.INFO,"*** NEW INFO USER SERVICE - Request Handled ***");
		 
		  
		  //here stop database
		  infol.closeDataBase();
		 
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.getWriter().append("Served at POST: ").append(request.getContextPath());
	}

}
