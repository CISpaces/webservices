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
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;

import com.google.gson.internal.LinkedTreeMap;

import core.JsonHelper;
import core.ourCategoryItemLabelGenerator;

public class ExtraGraphs {

	public ExtraGraphs() {
		// TODO Auto-generated constructor stub
	}
	public void goBuildGraph(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title=request.getParameter("title");
		if(title==null){
			title="Plot";
		}
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
			xax="x";
		}
		String yax=request.getParameter("yax");
		if(yax==null){
			yax="y";
		}
		JsonHelper jsh=new JsonHelper();
		String json=request.getParameter("json");
		json=json.substring(0,json.lastIndexOf("}")+1);
	 
		// System.out.println(json);
	    HashMap resp=jsh.convertInputMap(json);
	    
	    
	    OutputStream out = response.getOutputStream(); /* Get the output stream from the response object */
	    /* Step - 1: Define the data for the bar chart  */
	 	DefaultCategoryDataset bar_chart_servlet = new DefaultCategoryDataset();
	 	
	 	if(!resp.isEmpty()){
	    ArrayList data=(ArrayList) resp.get("data");
	    Iterator iter=data.iterator();
	    String s1,s2;
	    double d1;
	    while(iter.hasNext()){
	    	LinkedTreeMap triple=(LinkedTreeMap)iter.next();
	    	d1=(Double)triple.get("numb");
	    	s1=(String)triple.get("series");
	    	s2=(String)triple.get("categ");
	    	bar_chart_servlet.addValue(d1, s1, s2);
	    } 
	 	}
		
		JFreeChart BarChartObject=ChartFactory.createBarChart(title,xax,yax,bar_chart_servlet,PlotOrientation.VERTICAL,true,true,false);
		LegendTitle legend = BarChartObject.getLegend();
		legend.setPosition(RectangleEdge.RIGHT);
		CategoryPlot plot=BarChartObject.getCategoryPlot();
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits()); 
		response.setContentType("image/png"); /* Set the HTTP Response Type */
		ChartUtilities.writeChartAsPNG(out, BarChartObject, x, y);/* Write the data to the output stream */
		out.close();/* Close the output stream */
		
		
	}
	
	public void goBuildGraphByQuest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
		String title=request.getParameter("title");
		if(title==null){
			title="numByQuest";
		}
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
			xax="Question";
		}
		String yax=request.getParameter("yax");
		if(yax==null){
			yax="Count";
		}
		JsonHelper jsh=new JsonHelper();
		String json=request.getParameter("json");
		json=json.substring(0, json.lastIndexOf("}")+1);
		 
		//System.out.println(json);
		 HashMap resp=jsh.convertInputMap(json);
		
		OutputStream out = response.getOutputStream(); /* Get the output stream from the response object */
	    /* Step - 1: Define the data for the bar chart  */
	 	DefaultCategoryDataset bar_chart_servlet = new DefaultCategoryDataset();
	 	if(!resp.isEmpty()){
	    ArrayList data=(ArrayList) resp.get("queStat");
	    Iterator iter=data.iterator();
	    String s1,s2;
	    double d1;
	    int t1;
	    while(iter.hasNext()){
	    	//one map for each series
	    	LinkedTreeMap map=(LinkedTreeMap) iter.next();
	    	s2="Q"+map.get("queID");
	    	LinkedTreeMap count=(LinkedTreeMap)map.get("count");
	    	Iterator itt=count.keySet().iterator();
	    	while(itt.hasNext()){
	    		s1=(String)itt.next();
	    		d1=(Double)count.get(s1);
		    	t1=(int)Math.round(d1);
		    	bar_chart_servlet.addValue(t1, s1, s2);		
	    	}  	
	    }
	 	}
	
		JFreeChart BarChartObject=ChartFactory.createBarChart(title,xax,yax,bar_chart_servlet,PlotOrientation.VERTICAL,true,true,false);
		CategoryPlot plot=BarChartObject.getCategoryPlot();
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits()); 
	    LegendTitle legend = BarChartObject.getLegend();
	    legend.setPosition(RectangleEdge.RIGHT);
		response.setContentType("image/png"); /* Set the HTTP Response Type */
		ChartUtilities.writeChartAsPNG(out, BarChartObject, x, y);/* Write the data to the output stream */
		out.close();/* Close the output stream */
		
		
	}

	public void goBuildGraphByAns(HttpServletRequest request, HttpServletResponse response) throws IOException {
	 
		String title=request.getParameter("title");
		if(title==null){
			title="numByAns";
		}
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
			xax="Answer";
		}
		String yax=request.getParameter("yax");
		if(yax==null){
			yax="Count";
		}
		JsonHelper jsh=new JsonHelper();
		String json=request.getParameter("json");
		json=json.substring(0, json.lastIndexOf("}")+1);
		
//	    System.out.println(json);
		 HashMap resp=jsh.convertInputMap(json);
		
		OutputStream out = response.getOutputStream(); /* Get the output stream from the response object */
	    /* Step - 1: Define the data for the bar chart  */
	 	DefaultCategoryDataset bar_chart_servlet = new DefaultCategoryDataset();
	 	if(!resp.isEmpty()){
	    ArrayList data=(ArrayList) resp.get("queStat");
	    Iterator iter=data.iterator();
	    String s1,s2;
	    double d1;
	    int t1;
	    while(iter.hasNext()){
	    	//one map for each series
	    	LinkedTreeMap map=(LinkedTreeMap) iter.next();
	    	s1="Q"+map.get("queID");
	    	LinkedTreeMap count=(LinkedTreeMap)map.get("count");
	    	Iterator itt=count.keySet().iterator();
	    	while(itt.hasNext()){
	    		s2=(String)itt.next();
	    		d1=(Double)count.get(s2);
		    	t1=(int)Math.round(d1);
		    	bar_chart_servlet.addValue(t1, s1, s2);		
	    	}  	
	    }
	 	}
	
		JFreeChart BarChartObject=ChartFactory.createStackedBarChart(title,xax,yax,bar_chart_servlet,PlotOrientation.VERTICAL,true,true,false);
 
		CategoryPlot plot=BarChartObject.getCategoryPlot();
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits()); 
	    LegendTitle legend = BarChartObject.getLegend();
	    legend.setPosition(RectangleEdge.RIGHT);
		response.setContentType("image/png"); /* Set the HTTP Response Type */
		ChartUtilities.writeChartAsPNG(out, BarChartObject, x, y);/* Write the data to the output stream */
		out.close();/* Close the output stream */	
		
	}

public void goBuildGraphBySingleQuest(HttpServletRequest request, HttpServletResponse response) throws IOException {
	 
	
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
	
	String yax=request.getParameter("yax");
	if(yax==null){
		yax="Count";
	}
	String id=request.getParameter("id");
	JsonHelper jsh=new JsonHelper();
	String json=request.getParameter("json");
	json=json.substring(0, json.lastIndexOf("}")+1);
	 
//	System.out.println(json);
	 HashMap resp=jsh.convertInputMap(json);
	ArrayList labels=new ArrayList();
	OutputStream out = response.getOutputStream(); /* Get the output stream from the response object */
    /* Step - 1: Define the data for the bar chart  */
 	DefaultCategoryDataset bar_chart_servlet = new DefaultCategoryDataset();
 	if(!resp.isEmpty()){
    ArrayList data=(ArrayList) resp.get("queStat");
    Iterator iter=data.iterator();
    String s1,s2="Q"+id;
    
  
    
    double d1,ratio;
    int t1;
    String label;
    String thisid;
    while(iter.hasNext()){
    	//one map for each series
    	LinkedTreeMap map=(LinkedTreeMap) iter.next();
    	thisid=(String) map.get("queID");
    	if(thisid.equals(id)){
    	LinkedTreeMap count=(LinkedTreeMap)map.get("count");
    	LinkedTreeMap ratiomap=(LinkedTreeMap)map.get("ratio");
    	Iterator itt=count.keySet().iterator();
    	while(itt.hasNext()){
    		s1=(String)itt.next();
    		ratio=(Double)ratiomap.get(s1);
    		d1=(Double)count.get(s1);
	    	t1=(int)Math.round(d1);
	    	if(s1.length()>20){
	    		s1.substring(0,20);
	    	}
	 
	    	bar_chart_servlet.addValue(t1, s1, s2);
	    
	    	label=ratio*100+"";
	    	label=label.substring(0,4);
	    	 label = t1+"/"+label+"%";
	    	  
			labels.add(label);
    	}  	
    	}
    	
    
 	}
//System.out.println(labels.toString());
	String title="Question "+s2;
	JFreeChart BarChartObject=ChartFactory.createBarChart(title,"",yax,bar_chart_servlet,PlotOrientation.VERTICAL,true,true,false);
	CategoryPlot plot=BarChartObject.getCategoryPlot();
	CategoryItemRenderer renderer = plot.getRenderer();
	CategoryItemLabelGenerator generator =
            new ourCategoryItemLabelGenerator(labels);
      renderer.setBaseItemLabelGenerator(generator);
	  renderer.setBaseItemLabelsVisible(true);
 
	NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
	rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits()); 
    LegendTitle legend = BarChartObject.getLegend();
    legend.setPosition(RectangleEdge.RIGHT);
	response.setContentType("image/png"); /* Set the HTTP Response Type */
	ChartUtilities.writeChartAsPNG(out, BarChartObject, x, y);/* Write the data to the output stream */
	out.close();/* Close the output stream */
	
 	}
}
}
