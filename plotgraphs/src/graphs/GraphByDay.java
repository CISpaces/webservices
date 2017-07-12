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
 * @since 		April 2015           
 *   
 */

package graphs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import com.google.gson.internal.LinkedTreeMap;

import core.JsonHelper;
import core.myCategoryItemLabelGenerator;

public class GraphByDay {

	public GraphByDay() {
		// TODO Auto-generated constructor stub
	}
	public void goBuildGraphByDay(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title="# Responses by day";
	 
		int x,y;
		String xdim,ydim;
		xdim=request.getParameter("xdim");
		if(xdim!=null){
			x=Integer.parseInt(xdim);
		}else{
			x=500;
		}
		ydim=request.getParameter("ydim");
		if(xdim!=null){
			y=Integer.parseInt(xdim);
		}else{
			y=400;
		}
		String xax=request.getParameter("xax");
		if(xax==null){
			xax="Day";
		}
		String yax=request.getParameter("yax");
		if(yax==null){
			yax="Count";
		}
		 ArrayList labels=new ArrayList();
		JsonHelper jsh=new JsonHelper();
		String json=request.getParameter("json");
		json=json.substring(0, json.lastIndexOf("}")+1);
		
		//System.out.println(json);
	    HashMap resp=jsh.convertInputMap(json);
	    
	    OutputStream out = response.getOutputStream(); /* Get the output stream from the response object */
	    /* Step - 1: Define the data for the bar chart  */
	 	DefaultCategoryDataset bar_chart_servlet = new DefaultCategoryDataset();
	 	if(!resp.isEmpty()){
	    LinkedTreeMap data=(LinkedTreeMap) resp.get("numByDay");
	    LinkedTreeMap ratiomap=(LinkedTreeMap) resp.get("ratioByDay");
	    
	    Iterator iter=data.keySet().iterator();
	    String s1,s2;
	    double d1,ratio;
	    int t1;
	    String tip;
	    while(iter.hasNext()){
	    	s2=(String) iter.next();
	    	s1="answers";
	    	d1=(Double)data.get(s2);
	    	
	    	t1=(int)Math.round(d1);
	    	bar_chart_servlet.addValue(t1, s1, s2);
	    	
	    	if(ratiomap==null){
		    	tip="";
		    }else{
		    	ratio=(Double)ratiomap.get(s2);
		    	 
		    	tip=ratio*100+"";
		    	tip="/"+tip.substring(0,4)+"%";
		    }
	    	String label = t1+tip;
			labels.add(label);
	    }    
	 	}
	 	
		JFreeChart BarChartObject=ChartFactory.createBarChart(title,xax,yax,bar_chart_servlet,PlotOrientation.VERTICAL,true,true,false);
		BarChartObject.removeLegend(); 
		
		CategoryPlot plot=BarChartObject.getCategoryPlot();
		CategoryItemRenderer renderer = new CustomRenderer();
		CategoryItemLabelGenerator generator =
	            new myCategoryItemLabelGenerator(labels);
	      renderer.setBaseItemLabelGenerator(generator);
		  renderer.setBaseItemLabelsVisible(true);
	      plot.setRenderer(renderer);
		
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits()); 
		response.setContentType("image/png"); /* Set the HTTP Response Type */
		ChartUtilities.writeChartAsPNG(out, BarChartObject, x, y);/* Write the data to the output stream */
		out.close();/* Close the output stream */
		
		
	}
}
