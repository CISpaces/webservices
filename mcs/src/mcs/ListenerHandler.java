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
 * @author      Alice Toniolo  
 * @version     1.0  
 * @since 		August 2015           
 *   
 *    
 */

package mcs;



import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.ws.rs.core.Context;

import com.google.gson.internal.LinkedTreeMap;

import moirapolls.MoiraPollControl;
import utils.JsonHelper;



@WebListener // register it as you wish
public class ListenerHandler implements ServletContextListener {
	 private  Logger log=Logger.getLogger(getClass().getName());
	 private ScheduledExecutorService scheduler;
	 private JsonHelper jsh;
 
	 private String ci_path;
	 private String i_host;
	 private String i_port; 
	 private String m_host;
	 private int m_port; 
	 private String m_ask;
	 private int interval;
	 private boolean PRINT=false;
	 

	
	
    @Override
    public void contextInitialized(ServletContextEvent event) {
    	interval=30;
    	jsh=new JsonHelper();
    	scheduler = Executors.newSingleThreadScheduledExecutor();
    	log.log(Level.INFO,"*** MCS Polling ***");
    	ci_path=System.getenv("CISPACES");
    	
    	//get info of the database and the info service location
    	
    	try {
			
  		  String content = new String(Files.readAllBytes(Paths.get(ci_path+"/code/config/cis_settings.txt")));
  		 
  		  HashMap settings=jsh.convertInputMap(content);
  		  LinkedTreeMap servers=(LinkedTreeMap) settings.get("Servers");
  		  LinkedTreeMap gaian=(LinkedTreeMap) servers.get("GaianDB");
  		 
  		  LinkedTreeMap iss=(LinkedTreeMap) servers.get("ISS");
  		  i_host=(String) iss.get("host_name"); 
  		  i_port=""+Math.round((Double) iss.get("port")); 
  		  LinkedTreeMap mcs=(LinkedTreeMap) servers.get("MCS");
 		  m_host=(String) mcs.get("moira_host_name"); 
 		  m_port=(int)Math.round((Double) mcs.get("moira_port")); 
  		  m_ask=(String) mcs.get("moira_cards");
  		  interval=(int)Math.round((Double) mcs.get("interval_sec")); 
  		} catch (Exception e) {
  //		System.out.println("NOT HERE"+e);
  //		e.printStackTrace();
  		} 	 
  		
 
  	  if(!test()){
  		 // System.out.println("hello3");
  		  //else set default
  		  
  		   i_host="localhost"; 
		   i_port="8080"; 
		   m_port=8080;
		   m_ask="/CeStoreWeb/concepts/card/instances";
		   m_host="localhost";
		   interval=60;
  	  }
    	
        scheduler.scheduleAtFixedRate(new UpdateCounts(), 0, interval, TimeUnit.SECONDS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	
    	Enumeration<Driver> drivers = DriverManager.getDrivers();
    	 while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
               log.log(Level.INFO, String.format("deregistering jdbc driver: %s", driver));
            } catch (SQLException e) {
                 log.log(Level.SEVERE, String.format("Error deregistering driver %s", driver));
            }

        }
    	 
    	scheduler.shutdownNow();
    }
    public class UpdateCounts implements Runnable {

        @Override
        public void run() {
             MoiraPollControl mpc=new MoiraPollControl(i_host,i_port,m_host,m_port,m_ask,PRINT);
             mpc.check();
        }

    }
    
    private boolean test(){
  	  if(  i_host==null || i_port==null || m_ask==null || m_host==null) 
  		  return false;
  	  return true;
    }
	


}