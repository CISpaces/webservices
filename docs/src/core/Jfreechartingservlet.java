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


package core;



import graphs.CrowdInfoG;
import graphs.ExtraGraphs;
import graphs.GraphByDay;
import graphs.GraphByLoc;
import graphs.GraphQues;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Jfreechartingservlet
 */
public class Jfreechartingservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jfreechartingservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd;

        cmd = request.getParameter("action");
        if (cmd != null) {
        	/* 
        	 * action: 	byloc
	 		 			byday
	 		 			byquest
	 		 			byans
	 		 */
            if (cmd.equals("byloc")) {
            	GraphByLoc gbl=new GraphByLoc();
                gbl.goBuildGraphByLoc(request, response);
            }else
            if (cmd.equals("byday")) {
            	GraphByDay gbd=new GraphByDay();
                gbd.goBuildGraphByDay(request, response);
            }else
            if (cmd.equals("byallquest")) {
            	GraphQues gq=new GraphQues();
                gq.goBuildGraphByAllQuest(request, response);
            }else
            if (cmd.equals("byallcrowdinfo")) {
            	CrowdInfoG cig= new CrowdInfoG();
                 		cig.goBuildGraphByCrowdInfoBar(request, response);
    		}else 	
            	//***************old methods****************
            if(cmd.equals("barplot")) {
               ExtraGraphs eg=new ExtraGraphs();
               eg.goBuildGraph(request, response);
            }else
            if (cmd.equals("byquest")) {
            	ExtraGraphs eg=new ExtraGraphs();
                eg.goBuildGraphByQuest(request, response);
            }else
            if (cmd.equals("bysinglequest")) {
            	ExtraGraphs eg=new ExtraGraphs();
                eg.goBuildGraphBySingleQuest(request, response);
            }else
            if (cmd.equals("byans")) {
            	ExtraGraphs eg=new ExtraGraphs();
                eg.goBuildGraphByAns(request, response);
            }
            
        }
		
	}

	

	
	











	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd;

        cmd = request.getParameter("action");
        if (cmd != null) {
        	/* 
        	 * action: 	byloc
	 		 			byday
	 		 			byquest
	 		 			byans
	 		 */
            if (cmd.equals("byloc")) {
            	GraphByLoc gbl=new GraphByLoc();
                gbl.goBuildGraphByLoc(request, response);
            }else
            if (cmd.equals("byday")) {
            	GraphByDay gbd=new GraphByDay();
                gbd.goBuildGraphByDay(request, response);
            }else
            if (cmd.equals("byallquest")) {
            	GraphQues gq=new GraphQues();
                gq.goBuildGraphByAllQuest(request, response);
            }else
            if (cmd.equals("byallcrowdinfo")) {
            	CrowdInfoG cig= new CrowdInfoG();
                 		cig.goBuildGraphByCrowdInfoBar(request, response);
    		}else 	
            	//***************old methods****************
            if(cmd.equals("barplot")) {
               ExtraGraphs eg=new ExtraGraphs();
               eg.goBuildGraph(request, response);
            }else
            if (cmd.equals("byquest")) {
            	ExtraGraphs eg=new ExtraGraphs();
                eg.goBuildGraphByQuest(request, response);
            }else
            if (cmd.equals("bysinglequest")) {
            	ExtraGraphs eg=new ExtraGraphs();
                eg.goBuildGraphBySingleQuest(request, response);
            }else
            if (cmd.equals("byans")) {
            	ExtraGraphs eg=new ExtraGraphs();
                eg.goBuildGraphByAns(request, response);
            }
            
        }
		
	}

}





 

