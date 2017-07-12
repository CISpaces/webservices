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
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.function.Function2D;
import org.jfree.data.function.NormalDistributionFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;

import com.google.gson.internal.LinkedTreeMap;

 

import core.JsonHelper;
import core.ourCategoryItemLabelGenerator;

public class GraphQues {

	public GraphQues() {
		// TODO Auto-generated constructor stub
	}
public void goBuildGraphByAllQuest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String title=request.getParameter("title");
		if(title==null){
			title="numByQuest";
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
	//	System.out.println(json);
		json=json.substring(0, json.lastIndexOf("}")+1);
		 
		//System.out.println(json);
		 HashMap resp=jsh.convertInputMap(json);
		// System.out.println(resp);
		 boolean support=(boolean) resp.get("supp");
		// System.out.print("HERE");
		 if(support){
			 buildSupport(resp, title,yax,response);
		 }else{
			 buildNoSupport(resp, title,yax,response);
		 }
		
		 
	}
		 
		 
		 
		
private void buildNoSupport(HashMap resp, String title, String yax, HttpServletResponse response) throws IOException{	   
		OutputStream out = response.getOutputStream(); /* Get the output stream from the response object */
		/* Step - 1: Define the data for the bar chart  */
	 	DefaultCategoryDataset bar_chart_servlet = new DefaultCategoryDataset();
	 	if(!resp.isEmpty()){
	    ArrayList data=(ArrayList) resp.get("queStat");
	    Iterator iter=data.iterator();
	    String s1,s2;
	    double d1,ratio;
	    int t1;
	    JFreeChart BarChartObject;
		 JFrame f=new JFrame();
		 int rows=0,ques=0;
		 //GridLayout(int rows, int cols, int hgap, int vgap)
       // f.setVisible(true);
        ArrayList labels;
        String label;
        
	    while(iter.hasNext()){
	    	labels=new ArrayList();
	    	bar_chart_servlet = new DefaultCategoryDataset();
	    	//one map for each series
	    	LinkedTreeMap map=(LinkedTreeMap) iter.next();
	    	s2="Q"+map.get("queID"); 
	    	title="Question "+s2;
	    	LinkedTreeMap count=(LinkedTreeMap)map.get("count");
	    	LinkedTreeMap ratiomap=(LinkedTreeMap)map.get("ratio");
	    	String queType=(String)map.get("queType");
	    	//need to order count keyset!!!
	    	ArrayList orderkey=new ArrayList();
	    	orderkey.addAll(count.keySet());
	    	if(queType.equals("FreeText") || queType.equals("MultiChoice")){
	    		Collections.sort(orderkey, ALPHABETICAL_ORDER);
	    	}
	    	if(queType.equals("Numerical")){
	    		Collections.sort(orderkey, NUMERICAL_ORDER);
	    	}
	    	
	    	
	    	Iterator itt=orderkey.iterator();
	    	while(itt.hasNext()){
	    		s1=(String)itt.next();
	    		d1=(Double)count.get(s1);
	    		ratio=(Double)ratiomap.get(s1);
		    	t1=(int)Math.round(d1);
		    	if(s1.length()>20){
		    		s1.substring(0,20);
		    	}
		    	
		    //	System.out.println(t1+":"+s1+":"+s2);
		    	
		    	bar_chart_servlet.addValue(t1, s1, s2);	
		    	
		    	label=ratio*100+"";
		    	label=label.substring(0,4);
		    	label = t1+"/"+label+"%";
				labels.add(label);
	    	}  	
	    	BarChartObject=ChartFactory.createBarChart(title,"",yax,bar_chart_servlet,PlotOrientation.VERTICAL,true,true,false);
	    	CategoryPlot plot=BarChartObject.getCategoryPlot();
	    	CategoryItemRenderer renderer = plot.getRenderer();
			CategoryItemLabelGenerator generator =
		            new ourCategoryItemLabelGenerator(labels);
		      renderer.setBaseItemLabelGenerator(generator);
			  renderer.setBaseItemLabelsVisible(true);
		      plot.setRenderer(renderer);
			NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
			rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits()); 
		    LegendTitle legend = BarChartObject.getLegend();
		    legend.setPosition(RectangleEdge.RIGHT);
			response.setContentType("image/png"); /* Set the HTTP Response Type */
			f.add(new ChartPanel(BarChartObject));
			ques++;
	    }
	    rows=ques/2;
	    if(ques%2!=0){
	    	rows++;
	    }
	    f.setLayout(new GridLayout(rows, 2,1,0));
	    f.pack();
	    BufferedImage image = getScreenShot(
                f.getContentPane() );
	    f.setVisible(false);
	    ChartUtilities.writeBufferedImageAsPNG(out, image);
	    out.close();/* Close the output stream */
	 	}
	
		
		
		
		
		
		
	}




 
private void buildSupport(HashMap resp, String title, String yax, HttpServletResponse response) throws IOException{	   
	OutputStream out = response.getOutputStream(); /* Get the output stream from the response object */
	/* Step - 1: Define the data for the bar chart  */
 	DefaultCategoryDataset bar_chart_servlet = new DefaultCategoryDataset();
 	if(!resp.isEmpty()){
    ArrayList data=(ArrayList) resp.get("queStat");
    Iterator iter=data.iterator();
    String s1,s2;
    double d1;
    int t1;
    JFreeChart BarChartObject;
	 JFrame f=new JFrame();
	 int rows=0,ques=0;
	 //GridLayout(int rows, int cols, int hgap, int vgap)
   // f.setVisible(true);
    ArrayList labels;
    String label;
    
    while(iter.hasNext()){
    	labels=new ArrayList();
    	bar_chart_servlet = new DefaultCategoryDataset();
    	//one map for each series
    	LinkedTreeMap map=(LinkedTreeMap) iter.next();
    	s2="Q"+map.get("queID"); 
    	title="Question "+s2;
    	
    	String queType=(String)map.get("queType");
    	//need to order count keyset!!!
    	
    	
    	if(queType.equals("FreeText")){
    		ArrayList orderkey=new ArrayList();
    		LinkedTreeMap count=(LinkedTreeMap)map.get("count");
        	LinkedTreeMap ratiomap=(LinkedTreeMap)map.get("ratio");
        	orderkey.addAll(count.keySet());
    		Collections.sort(orderkey, ALPHABETICAL_ORDER);
    		Iterator itt=orderkey.iterator();
    		double ratio;
    		while(itt.hasNext()){
    			s1=(String)itt.next();
    			d1=(Double)count.get(s1);
    			ratio=(Double)ratiomap.get(s1);
    			t1=(int)Math.round(d1);
    			if(s1.length()>20){
    				s1.substring(0,20);
    			}
	    	
	    //	System.out.println(t1+":"+s1+":"+s2);
	    	
    			bar_chart_servlet.addValue(t1, s1, s2);	
	    	
    			label=ratio*100+"";
    			label=label.substring(0,4);
    			label = t1+"/"+label+"%";
    			labels.add(label);
    		}  	
    		BarChartObject=ChartFactory.createBarChart(title,"",yax,bar_chart_servlet,PlotOrientation.VERTICAL,true,true,false);
    		CategoryPlot plot=BarChartObject.getCategoryPlot();
    		CategoryItemRenderer renderer = plot.getRenderer();
    		CategoryItemLabelGenerator generator = new ourCategoryItemLabelGenerator(labels);
    		renderer.setBaseItemLabelGenerator(generator);
    		renderer.setBaseItemLabelsVisible(true);
    		plot.setRenderer(renderer);
    		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits()); 
    		LegendTitle legend = BarChartObject.getLegend();
    		legend.setPosition(RectangleEdge.RIGHT);
    		response.setContentType("image/png"); /* Set the HTTP Response Type */
    		f.add(new ChartPanel(BarChartObject));
    		ques++;
    }else if (queType.equals("MultiChoice")){
    		LinkedTreeMap count=(LinkedTreeMap)map.get("count");
    		Iterator itt=count.keySet().iterator();
    	//	System.out.println(count.toString());
    		while(itt.hasNext()){
    			s1=(String)itt.next();
    			d1=(Double)count.get(s1);
	    	
	     //	System.out.println(d1+":"+s1+":"+s2);
	    	bar_chart_servlet.addValue(d1, s1, s2);	
    		}  	
    		
    		yax="Expectation";
   	BarChartObject=ChartFactory.createBarChart(title,"",yax,bar_chart_servlet,PlotOrientation.VERTICAL,true,true,false);
   	CategoryPlot plot=BarChartObject.getCategoryPlot();
  
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createStandardTickUnits()); 
		
		
		
	    LegendTitle legend = BarChartObject.getLegend();
	    legend.setPosition(RectangleEdge.RIGHT);
		response.setContentType("image/png"); /* Set the HTTP Response Type */
		f.add(new ChartPanel(BarChartObject));
		ques++;
    	
    }else if (queType.equals("Numerical")){
    	LinkedTreeMap count=(LinkedTreeMap)map.get("count");
    	double std=(double) count.get("std");
    	if(std<=0){
    		std=0.001;
    	}
    	double mean=(double) count.get("mean");
     
    	Function2D normal = new NormalDistributionFunction2D(mean, std);
    	XYDataset dataset = DatasetUtilities.sampleFunction2D(normal, mean-(4*std), mean+(4*std), 1000, "Normal");
    	  yax="Mean";
    	JFreeChart chart=ChartFactory.createXYLineChart(title, "", yax, dataset);
    	XYPlot plot = chart.getXYPlot();
    	XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
 
    	// sets paint color for each series
    	renderer.setSeriesPaint(0, Color.BLUE);
  
    	// sets thickness for series (using strokes)
    	renderer.setSeriesStroke(0, new BasicStroke(3.0f));
  
    	plot.setRenderer(renderer);
    	chart.removeLegend();
    	 
    	
		response.setContentType("image/png"); /* Set the HTTP Response Type */
		f.add(new ChartPanel(chart));
		ques++; 
		
    }
    	
    }
    rows=ques/2;
    if(ques%2!=0){
    	rows++;
    }
    f.setLayout(new GridLayout(rows, 2,1,0));
    f.pack();
    BufferedImage image = getScreenShot(
            f.getContentPane() );
    f.setVisible(false);
    ChartUtilities.writeBufferedImageAsPNG(out, image);
    out.close();/* Close the output stream */
 	}

}

private BufferedImage getScreenShot(Container component) {
	BufferedImage image = new BufferedImage(
		      component.getWidth(),
		      component.getHeight(),
		      BufferedImage.TYPE_INT_RGB
		      );
		    // call the Component's paint method, using
		    // the Graphics object of the image.
		    component.paint( image.getGraphics() ); // alternately use .printAll(..)
		    return image;
}






private static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
    public int compare(String str1, String str2) {
        int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
        if (res == 0) {
            res = str1.compareTo(str2);
        }
        return res;
    }
};
private static Comparator<String> NUMERICAL_ORDER = new Comparator<String>() {
    public int compare(String str1, String str2) {
    	double strn1=Double.parseDouble(str1);
    	double strn2=Double.parseDouble(str2);
    	if(strn1<strn2){
			//System.out.println("min"+t1.getTimestamp()+""+t2.getTimestamp());
			return -1;
		}else {if(strn1==strn2){
			return 0;
		}else {
			//System.out.println("mag"+t1.getTimestamp()+""+t2.getTimestamp());
			return 1;
		}}
    }
};



}
