
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


package visual;
 
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

 

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.stream.file.FileSinkImages;
import org.graphstream.stream.file.FileSinkImages.LayoutPolicy;
import org.graphstream.stream.file.FileSinkImages.OutputType;
import org.graphstream.stream.file.FileSinkImages.RendererType;
import org.graphstream.stream.file.FileSinkImages.Resolutions;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;
 
/*
 
edge.tollway { size: 2px; }
edge.addAttribute("ui.class", "tollway");
*/
public class SGraph {
private   Graph graph;
 private static FileSinkImages pic;
 private String style;
 private ArrayList entities;
 private ArrayList actors;
 private ArrayList activities;
 private HashMap attNd;

 private final int laywei=8;
 private final int layedge=6;
 private HashMap outgoingNd;
 private int maxi=0;
 private int maxj=0;
 private int minj=0;
 private int AttCount;
 private  SpriteManager sman;
 private String path;
	private static Logger log;
 
	public SGraph(String title,String pah) {
	
		 log=Logger.getLogger(getClass().getName());
		path=pah;
		attNd=new HashMap();
		AttCount=0;
		outgoingNd=new HashMap();
		System.setProperty("org.graphstream.ui.renderer",
                "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
	  graph = new SingleGraph(title);
 
  // viewer = graph.display();
//  viewer.setCloseFramePolicy(CloseFramePolicy.EXIT);
 //   View view = viewer.getDefaultView();
	  sman = new SpriteManager(graph);
	  style=  "node {"
		  		+ "shape: box;"
		  		+ "size: 80px,60px;"
		  		+ "fill-mode: plain;"
		  		+ "fill-color: #6699FF;"
		  		+ "stroke-mode: plain;"
		  		+ "stroke-color: black;"
		  		+ "text-mode: normal;"
		  		+ "text-background-mode: plain;"
		  		+ "text-size: 16;"
		  	//	+ "text-alignment: at-right;"
		  	//	+ "text-padding: 1;"
		  		+ "}"
		  	+ "node.provnode {"
		  		+ "fill-color: orange;"
		  		+ "shape: circle;"
		  		+ "}"
		  	+ "node.entity {"
		  		+ "shape: circle;"
		  		+ "}"
		  	+ "node.actor {"
		  		+ "stroke-mode: none;"
		  		+ "size: 85px,65px;"
		  		+ "fill-mode: image-scaled;"
		  	 	+ "fill-image: url('pic.png');"
		  		+ "}"
		  	+ "node.attrib {"
		  		+ "shape: circle;"
		  		+ "size: 7px,5px;"
		  		+ "fill-color: white;"
		  		+ "stroke-color: white;"
		  		+ "text-background-color: #c8ffad;"
		  		+ "text-size: 10;"
	  			+ "}"
		  	+ "node.fillnd {"
		  		+ "shape: circle;"
		  		+ "size: 7px,5px;"
		  		+ "fill-color: white;"
		  		+ "stroke-color: white;"
		  		+ "text-mode: hidden;"
		  		+ "}"
		  	+ "edge {"
		  		+ "arrow-shape: arrow;" 
		  		+ "fill-color: black;"
		  		+ "text-mode: normal;"
		  		+ "text-background-mode: plain;"
		  		+ "text-alignment: above;"
		  		+ "}"
		  	+ "edge.attr {"
		  		+ "arrow-shape: none;" 
		  		+ "fill-mode: none;"
		  		+ "size: 0px;"
	  			+ "stroke-mode: dashes;"
	  			+ "stroke-width: 1px;"
	  			+ "text-mode: hidden;"
	  			+ "stroke-color: #0f4d0c;"
		  		+ "}"
	  		+ "sprite {"
	  			+ "text-mode: normal;"
		  		+ "text-background-mode: rounded-box;"
		  		+ "text-alignment: at-left;"
		  		+ "shape: arrow;"
		  		+ "sprite-orientation: projection;"
		  		+ "text-style: italic;"
		  		+ "text-background-color: #c8ffad;"
		  		+ "arrow-size: 0.4,1;"
				+ "fill-mode: plain;"
		  		+ "fill-color: #0f4d0c;"
		  		+ "stroke-mode: plain;"
		  		+ "stroke-color: #0f4d0c;"
		  		+ "}"
		  		;
	  
	  graph.addAttribute("ui.stylesheet",style);
	  graph.addAttribute( "ui.antialias" );
	  graph.addAttribute( "ui.quality" );
	  activities=new ArrayList();
	  entities=new ArrayList();
	  actors=new ArrayList();

	}

	



 

 
	 
 
 

	public void clear(){
	 
		graph.clear();
		
	}
	
	
	
	
	





	public void addNode(String lab) {
		if(graph.getNode(lab)==null){
		graph.addNode(lab);
		Node nd = graph.getNode(lab);
		nd.addAttribute("ui.class", "provnode");
		String name=LabelConstructor.getLabEntityRules(lab);
		name=name.replace("Node","");
		name="Node "+name+"..";
		nd.setAttribute("ui.label", name);
		entities.add(lab);
		nd.setAttribute( "layout.weight", laywei);
		//System.out.println(name);
		}
	}

	 



	public void addEntity(String lab) {
		if(graph.getNode(lab)==null){
		graph.addNode(lab);
		Node nd = graph.getNode(lab);
		nd.addAttribute("ui.class", "entity");
		String name=LabelConstructor.getLabEntityRules(lab);
		nd.setAttribute("ui.label", name);
		entities.add(lab);
		nd.setAttribute( "layout.weight", laywei);
		//nd.setAttribute("xy",jgh++,3);
		}
	}





	public void addActor(String lab) {
		if(graph.getNode(lab)==null){
		graph.addNode(lab);
		Node nd = graph.getNode(lab);
		nd.addAttribute("ui.class", "actor");
		nd.setAttribute("ui.label", lab);
		actors.add(lab);
		nd.setAttribute( "layout.weight", laywei);
		}
	}


	private String addAttribute(String lab) {
		String id="att"+AttCount++;
		if(graph.getNode(id)==null){
		graph.addNode(id);
		Node nd = graph.getNode(id);
		nd.addAttribute("ui.class", "attrib");
		nd.setAttribute("ui.label", lab);
		nd.addAttribute("xy", 3, 3);
		}
		return id;
		
	}


	public void addActivity(String lab) {
		if(graph.getNode(lab)==null){
		graph.addNode(lab);
		activities.add(lab);
		Node nd = graph.getNode(lab);
		lab=LabelConstructor.getLabActivityRules(lab);
		nd.setAttribute("ui.label", lab);
		nd.setAttribute( "layout.weight", laywei);
		//nd.addAttribute("xy", 0.0, -1.0);
		}
	}
	
	
	
	public void setMaxMin(int mj,int mini,int mxj){
		maxi=mini;
		maxj=mj;
		minj=mxj;
	}
	public synchronized void printImage(boolean layout, String pid){
	 	pic = new FileSinkImages(OutputType.PNG, Resolutions.VGA);
		int x=maxi*180+100;
		int y=(maxj-minj)*180+200;
		//System.out.println(x + " "+ y);
		pic.setResolution(x, y);
		pic.setRenderer(RendererType.SCALA);
		pic.setStyleSheet(style);
		if(layout){
			pic.setLayoutPolicy(LayoutPolicy.NO_LAYOUT);
		}else{
			pic.setLayoutPolicy(LayoutPolicy.COMPUTED_FULLY_AT_NEW_IMAGE);
		}
	try {
		 
		pic.writeAll(graph, path+pid+"prov.png");
		pic.flush();
		pic.end();
		
		// viewer.close();
		 
		 log.log(Level.INFO,"Image written");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 
	}
	
	public int getType(String lab){
		/*
		 * 0:none
		 * 2:actors
		 * 3:activities
		 * 1:entities
		 */
		if(actors.contains(lab)){
			return 2;
		}else if(activities.contains(lab)){
			return 3;
		}else if(entities.contains(lab)){
			return 1;
		}
		return 0;
	}








	public void addEdge(String nd1, String nd2,String rel) {
		graph.addEdge(nd1+nd2, nd1, nd2,true);
		Edge eg = graph.getEdge(nd1+nd2);
		eg.setAttribute("ui.label", rel);
		eg.setAttribute( "layout.weight", layedge);
		ArrayList list=(ArrayList) outgoingNd.get(nd1);
		if(list==null){
			list=new ArrayList();
		}
		if(!list.contains(nd2)){
			list.add(nd2);
		}
		outgoingNd.put(nd1, list);
	}
	
	
	public void addAttEdge(String nd1, String nd2) {
		graph.addEdge(nd1+nd2, nd1, nd2,true);
		Edge eg = graph.getEdge(nd1+nd2);
		eg.addAttribute("ui.class", "attr");
		ArrayList list=(ArrayList) attNd.get(nd1);
		if(list==null){
			list=new ArrayList();
		}
		if(!list.contains(nd2)){
			list.add(nd2);
		}
		attNd.put(nd1, list);
	}
	
	public void addTimeAttEdge(String nd1,String nd2,String label){
		String id="sprite"+AttCount++;
		Sprite s = sman.addSprite(id);
		s.attachToEdge(nd1+nd2);
		s.setPosition(0.3, 0.08, 0);
		s.setAttribute("ui.label", "Time:"+label);
	}
	
	public void setLayout(String node){
		double iunit=1;
		double junit=iunit;
		HashMap nodes=setMajorNodes(node);
		setfinals(nodes,junit,iunit);
		setAttributes(nodes,junit,iunit);
		
	}




private void setAttributes(HashMap nodes, double junit, double iunit) {
	Iterator iter=attNd.keySet().iterator(),itt;
	ArrayList list;
	String node,attrib;
	int count=0;int div;
	double ax = 0,ay = 0,x = 0,y = 0;
	double iscale=0.3;
	double jscale=0.5;
	Node nd,att;
	int coord[];
	//max of 4 attributes allowed :( 
	while(iter.hasNext()){
		node=(String) iter.next();
		nd=graph.getNode(node);
		coord=(int[]) nodes.get(node);
		x=maxi-coord[0]*iunit;
		y=coord[1]*junit;
		list=(ArrayList)attNd.get(node);
		itt=list.iterator();
		count=0;
		while(itt.hasNext()){
			attrib=(String)itt.next();
			div=count%4;
			att=graph.getNode(attrib);
			switch(div){
			case 0:
				ax=x-iscale*iunit;
				ay=y+jscale*junit;
				break;
			case 1:
				ax=x+iscale*iunit;
				ay=y-jscale*junit;
				break;
			case 2:
				ax=x+iscale*iunit;
				ay=y+jscale*junit;
				break;
			case 3:
				ax=x-iscale*iunit;
				ay=y-jscale*junit;
				break;
			}
			count++;
			att.setAttribute("xy", ax,ay);
			
			
		}
	}
	
	
		
	}












private HashMap setMajorNodes(String node) {
	maxi=0;maxj=0;
	HashMap attributes=new HashMap();
	int size=graph.getNodeCount();
	size=3*size+1;
	minj=size;
	boolean[][] net=new boolean[size][size];
	int i=0,j=size/2;
	//set the position of the main node!!
	net[i][j]=true;
	attributes.put(node,new int[]{i,j});
 	//System.out.println(node+":"+i+","+j);
	//now recursively 
 	if(i>maxi){
		maxi=i;
	}
	if(j>maxj){
		maxj=j;
	}
	if(j<minj){
		minj=j;
	}
	ArrayList nodesToAssign=new ArrayList();
	nodesToAssign.addAll(entities);
	nodesToAssign.addAll(actors);
	nodesToAssign.addAll(activities);
	nodesToAssign.remove(node);
	ArrayList list;
	String search=node;
	Iterator iter;
	String newnode;
	int type,type1;
	ArrayList items = null;
	ArrayDeque fifo=new ArrayDeque();
	int[] coord = null;
	//System.out.println(nodesToAssign.toString());
	//printNet(net);
	int newi,newj;
	while(!nodesToAssign.isEmpty()){
		//System.out.println(nodesToAssign.toString());
		list=(ArrayList) outgoingNd.get(search);
		if(list!=null){
		iter=list.iterator();
		while(iter.hasNext()){
			newnode=(String) iter.next();
			if(nodesToAssign.contains(newnode)){
			type=getType(newnode);
			type1=getType(search);
			/*
			 * 0:none
			 * 2:actors
			 * 3:activities
			 * 1:entities
			 */
			if(type1==1){
				if(type==1){
					newi=i+2;
					newj=j;
					if(newi>=size){
						newi=0;
						newj=size/2;
					}
					coord=findupspace(newi,newj,net);
				}else if(type==2){
					newi=i+1;
					newj=j-2;
					if(newi>=size || newj<0){
						newi=1;
						newj=size/2-2;
					}
					coord=finddownspace(newi,newj,net);
				}else if(type==3){
					newi=i+1;
					newj=j-1;
					if(newi>=size || newj<0){
						newi=1;
						newj=size/2-1;
					}
					coord=finddownspace(newi,newj,net);
					
				}
			}else if(type1==2){
				if(type==2){
					newi=i;
					newj=j-3;
					if(j<0){
						newi=1;
						newj=size/2-2;
					}
					coord=finddownspace(newi,newj,net);
				}
			}else if(type1==3){
				if(type==1){
					newi=i+1;
					newj=j+1;
					if(newi>=size){
						newi=0;
						newj=size/2;
					}
					coord=findupspace(newi,newj,net);
					//System.out.println("I should get here!");
				}else if(type==2){
					newi=i;
					newj=j-1;
					if(newi>=size ||  newj<0){
						newi=1;
						newj=size/2-2;
					}
					coord=finddownspace(newi,newj,net);
				}else if(type==3){
					newi=i+2;
					newj=j;
					if(newi>=size){
						newi=1;
						newj=size/2-1;
					}
					coord=finddownspace(newi,newj,net);
				}
			}
			attributes.put(newnode, coord);

			//System.out.println(newnode+":"+coord[0]+","+coord[1]);
			if(coord[0]>maxi){
				maxi=coord[0];
			}
			if(coord[1]>maxj){
				maxj=coord[1];
			}
			if(coord[1]<minj){
				minj=coord[1];
			}
			//printNet(net);
			net[coord[0]][coord[1]]=true;
			nodesToAssign.remove(newnode);
			items=new ArrayList();
			items.add(newnode);
			items.add(coord[0]);
			items.add(coord[1]);
			fifo.push(items);
		}
		}
		}
		
		
		items=(ArrayList) fifo.pop();
		if(items!=null){
			search=(String) items.get(0);
			i=(int)items.get(1);
			j=(int)items.get(2);
		}
	//	System.out.println(search);
		
	}
	return attributes;
	}












private void setfinals(HashMap attributes,double junit,double iunit) {
	
	Node nd;
	Iterator iter=attributes.keySet().iterator();
	String node;
	int[] coord;
	//add empty nodes to the graph!!
	graph.addNode("fil1");
	nd = graph.getNode("fil1");
	nd.addAttribute("ui.class", "fillnd");
	nd.setAttribute("xy",(-0.5)*iunit,(minj-0.5)*junit);
	graph.addNode("fil2");
	nd = graph.getNode("fil2");
	nd.addAttribute("ui.class", "fillnd");
	nd.setAttribute("xy",(maxi+0.5)*iunit,(maxj+0.5)*junit);
	//System.out.println(maxi+":"+maxj+":"+minj);
	while(iter.hasNext()){
		node=(String) iter.next();
		coord=(int[]) attributes.get(node);
		nd=graph.getNode(node);
		nd.setAttribute("xy",(maxi-coord[0])*iunit,coord[1]*junit);
	}
	
	}












public void printNet(boolean[][] net){
	for(int j=0;j<net.length;j++){
		for(int i=0;i<net.length;i++){
			if(net[i][j]){
			System.out.print("T");
			}else{
				System.out.print("F");
			}
		}
		System.out.println();
	}
}




	private int[] findupspace(int i,int j,boolean[][] net) {
		int[] newpt=new int[2];
		boolean found=false;
		int step=3;
		int size=net.length;
	
		while(!found){
			// System.out.println("first ent"+i+" "+j);
			if(!net[i][j]){
				found=true;
				break;
			}else{
			j=j+step;
			if(j<size && !net[i][j]){
					found=true;
					break;
				}else{
					j=j-2*step;
					if(j>0 && !net[i][j]){
						found=true;
						break;
					}
				}
			}
			//did not find it yet
			step+=3;
			if(j<0){
				//this is the case that there is no space in that line
				step=3;
				j=0;
				i+=2;
				if(i>=size){
					break;
				}
			}
			
			
		}
	
		if(!found){//assign a random!!
			for(int p=0;p<size;p++){
				for(int q=0;q<size;q++){
					if(net[p][q]){
						i=p;
						j=q;
						break;
					}
				}
			}
		}
		//System.out.println(i+" "+j);
		newpt[0]=i;
		newpt[1]=j;
		return newpt;
	}
	
	private int[] finddownspace(int i,int j,boolean[][] net) {
		int[] newpt=new int[2];
		boolean found=false;
		int step=3;
		int size=net.length;
	
		while(!found){
		//	 System.out.println("first proc"+i+" "+j);
			if(!net[i][j]){
				found=true;
				break;
			}else{
			j=j-step;
			if(j>0 && !net[i][j]){
					found=true;
					break;
				}else{
					j=j+2*step;
					if(j<size && !net[i][j]){
						found=true;
						break;
					}
				}
			}
			//did not find it yet
			step+=3;
			if(j<0){
				//this is the case that there is no space in that line
				step=3;
				j=0;
				i+=2;
				if(i>=size){
					break;
				}
			}
			
			
		}
	
		if(!found){//assign a random!!
			for(int p=0;p<size;p++){
				for(int q=0;q<size;q++){
					if(net[p][q]){
						i=p;
						j=q;
						break;
					}
				}
			}
		}
		//System.out.println(i+" "+j);
		newpt[0]=i;
		newpt[1]=j;
		return newpt;
	}



	public void addNodeLab(String nodeID, String info) {
		if(info.length()>50){
			info=info.substring(0,49)+"..";
		}
		String id=addAttribute(info);
		//now to add a special edge
		 addAttEdge(nodeID,id);
	}

	public void addPrimS(String nodeID) {
		String id=addAttribute("Primary Source");
		//now to add a special edge
		addAttEdge(nodeID,id);
		
	}

 

	public void addGoals(String nodeID) {
		String id=addAttribute("Goal");
		//now to add a special edge
		addAttEdge(nodeID,id);
		
	}







 
	
	
	
	
}


	




