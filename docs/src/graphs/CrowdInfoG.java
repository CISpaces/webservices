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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.TextAnchor;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.gson.internal.LinkedTreeMap;

import core.JsonHelper;
import core.myCategoryItemLabelGenerator;

public class CrowdInfoG {

	public CrowdInfoG() {
		
	}
	
	

public void goBuildGraphByCrowdInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
	try {
	
	String json=request.getParameter("json");
	JsonHelper jsh=new JsonHelper();
	json=json.substring(0, json.lastIndexOf("}")+1);
	
	
	TimeSeries series1 = new TimeSeries("Data");
	Date lastDate=null;
	SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//System.out.println(json);
	HashMap resp=jsh.convertInputMap(json);
	String title=(String) resp.get("title");
	ArrayList queStat=(ArrayList) resp.get("queStat");
	Iterator iter=queStat.iterator();
	ArrayList ans;
	while(iter.hasNext()){
		ans=(ArrayList) iter.next();
		lastDate= sdfDateTime.parse((String)ans.get(0));
		series1.add(new Millisecond(lastDate),(double)ans.get(1));
		//do something with the dev
		
	}
	
	TimeSeriesCollection dataset = new TimeSeriesCollection();
	dataset.addSeries(series1);
	String yax="Estimations";
	 JFreeChart chart = ChartFactory.createTimeSeriesChart(
			   title,  // title
			     "Date",             // x-axis label
			     yax,   // y-axis label
			       dataset,            // data
			     true,               // create legend?
			      true,               // generate tooltips?
			       false               // generate URLs?
			   );
			 
			    chart.setBackgroundPaint(Color.white);
			    chart.removeLegend();
			       XYPlot plot = (XYPlot) chart.getPlot();
			   //    plot.setBackgroundPaint(Color.white);
			 //    plot.setDomainGridlinePaint(Color.white);
			  //   plot.setRangeGridlinePaint(Color.white);
			     
			 //     plot.setDomainCrosshairVisible(true);
			 //     plot.setRangeCrosshairVisible(true);
			 
			        XYItemRenderer r = plot.getRenderer();
			       if (r instanceof XYLineAndShapeRenderer) {
			           XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
			            renderer.setBaseShapesVisible(true);
			             renderer.setBaseShapesFilled(true);
			             Shape shape  = new Ellipse2D.Double(0,0,5,5);
			           //  renderer.setSeriesShape(0, shape);
			            renderer.setDrawSeriesLineAsPath(true);
			             renderer.setSeriesPaint(0, Color.BLUE);
			        
			    	// sets thickness for series (using strokes)
			    	//renderer.setSeriesStroke(0, new BasicStroke(2.0f));
			       }
			 
			         DateAxis axis = (DateAxis) plot.getDomainAxis();
			         axis.setDateFormatOverride(new SimpleDateFormat("MM-dd"));
	 	response.setContentType("image/png"); /* Set the HTTP Response Type */
	OutputStream out = response.getOutputStream();
	int x,y;
	x=800;y=400;
	ChartUtilities.writeChartAsPNG(out, chart, x, y);
	/* Write the data to the output stream */
	out.close();/* Close the output stream */
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
	
}


public void goBuildGraphByCrowdInfoBar(HttpServletRequest request, HttpServletResponse response) throws IOException{
	long limit=100;
	
	
	String json=request.getParameter("json");
	JsonHelper jsh=new JsonHelper();
	json=json.substring(0, json.lastIndexOf("}")+1);
	
	DefaultCategoryDataset series1 = new DefaultCategoryDataset();
	
	//System.out.println(json);
	HashMap resp=jsh.convertInputMap(json);
	String title=(String) resp.get("title");

	ArrayList queStat=(ArrayList) resp.get("queStat");
ArrayList labels=new ArrayList();
	Iterator iter=queStat.iterator();
	ArrayList ans;
	int interval=0;
	DateTime lastDate=null,thisDate=null;
    DateTimeFormatter ft =  DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    DateTimeFormatter formatter =  DateTimeFormat.forPattern("yyyy-MM-dd");
    double weight;
    double max=0;
    double top=0;
	while(iter.hasNext()){
		ans=(ArrayList) iter.next();
		interval++;
		//lastDate= sdfDateTime.parse((String)ans.get(0));
		 weight=(double)ans.get(1);
		 if(weight>100){
			 weight=100;
		 }
			 if(weight>max){
				 max=weight;
			 }
		series1.addValue(weight,"Data",(String)ans.get(0));
		//do something with the dev
		String label="";
		thisDate=ft.parseDateTime((String)ans.get(0));
		//System.out.println(thisDate.toString());
		if(lastDate==null){
			lastDate = ft.parseDateTime((String)ans.get(0));
			label="                "+formatter.print(lastDate);
			interval=0;
			if(weight>top){
				 top=weight;
			 }
		}else{
		if((lastDate.plusDays(1).isBefore(thisDate) && interval>=25 && weight<100) || !iter.hasNext()){
				lastDate=thisDate;
				
				label="                "+formatter.print(thisDate);
				interval=0;
				if(weight>top){
					 top=weight;
				 }
		}
		
		}
		 
		 labels.add(label);
		 
	}
	
	
	
 
	String yax="Estimations";
	JFreeChart BarChartObject=ChartFactory.createLineChart(
			   title,  // title
			     "Date",             // x-axis label
			     yax,   // y-axis label
			       series1,            // data
			       PlotOrientation.VERTICAL,true,true,false);
	
	BarChartObject.removeLegend(); 
	
	CategoryPlot plot=BarChartObject.getCategoryPlot();
	LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
	

 
 
	//renderer.setSeriesVisible(1, false);
	renderer.setSeriesPaint(0, Color.BLUE);
	//renderer.setSeriesPaint(1, Color.RED);
 
   
	
	NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
	rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits()); 
	limit=Math.round(top+50);
	if(limit<max){
		limit=Math.round(max);
	}
	
	
	
	rangeAxis.setRange(0,limit);
	CategoryAxis domainAxis = plot.getDomainAxis();
	domainAxis.setTickLabelsVisible(false);
	
	 
  
    
       
   	// sets thickness for series (using strokes)
   	renderer.setSeriesStroke(0, new BasicStroke(1.0f));
     
   
	CategoryItemLabelGenerator generator =
            new myCategoryItemLabelGenerator(labels);
      renderer.setBaseItemLabelGenerator(generator);
	  renderer.setBaseItemLabelsVisible(true);
	  renderer.setSeriesPositiveItemLabelPosition(0,   
              new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.BOTTOM_LEFT, TextAnchor.BOTTOM_LEFT, - Math.PI / 2));
      plot.setRenderer(renderer);

	
	
	
	
	
	
	 	response.setContentType("image/png"); /* Set the HTTP Response Type */
	OutputStream out = response.getOutputStream();
	int x,y;
	x=800;y=400;
	ChartUtilities.writeChartAsPNG(out, BarChartObject, x, y);
	/* Write the data to the output stream */
	out.close();/* Close the output stream */
	 
	
}


}
