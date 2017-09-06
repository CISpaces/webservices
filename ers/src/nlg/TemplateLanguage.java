package nlg;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class TemplateLanguage<T> {


	private ArrayList<Node> nodes = new ArrayList<Node>();
	private ArrayList<Edge> edges =  new ArrayList<Edge>();
	private ArrayList<Node> claim = new ArrayList<Node>();
	private  ArrayList<Node> info  = new ArrayList<Node>();
	private  ArrayList<Node> type  = new ArrayList<Node>();
	private  ArrayList<String> listOfString  = new ArrayList<String>();
	
	//Map<ArrayList<Node>, Node> nodesRoot = new HashMap<ArrayList<Node>, Node>();
	Map nodesRoot = new HashMap();
	
	Vector<String> inferenceTypes = new Vector<String>();
	
	private int max = -Integer.MAX_VALUE;
	
	
	private static Graph<Node> graph; 
	private static Graph<Node> graphCon; 
	private static Graph<Node> graphfinal; 
	
	private Collection<Vertex<Node>> nodesAndPremisesIn =  new ArrayList<Vertex<Node>>();
	
	private Node root = null; 
	StringBuilder finalText;
	String and = " and ";
	String becauseof= " because of ";
	String text = "";
	String textCon = "";
	String but = ", but ";
	String temp = " is a reason for not accepting ";
	private final static String JSON_DATA = "";
			 
	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	public Example getValue() {
		return value;
	}

	public void setValue(Example value) {
		this.value = value;
	}

	ObjectMapper mapper = new ObjectMapper();
	private Example value = null;
	String string = "";
	
	
	public String createMinimalInfereanceTemplate(String json) throws FileNotFoundException{

		try {
			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//			value = mapper.readValue(new File("scheme.cis"), Example.class);
            System.out.println("***** JSON INPUT TO NLG: ******");
            System.out.println(json);
            value = mapper.readValue(json, Example.class);
            System.out.println("Example is successfully built");
            populateNodesInfoClaimsEdges();
			addTypes();
			createTree();

		} catch (Exception e) {
			e.printStackTrace();
		}   
		JSONObject jsonOb = new JSONObject();
		try {
			jsonOb.put("fail", false);
			jsonOb.put("text", finalText);
		} catch (JSONException e) {
			e.printStackTrace();
		}


		return jsonOb.toString();
	}

	public void populateNodesInfoClaimsEdges(){

		for( Node node : value.getNodes()){
			nodes.add(node);
		}	

		for( Node node : value.getNodes()){
			if(!(node.getInput().equals("null"))){
				if(node.getInput().equals("CLAIM")){
					claim.add(node);
				}
				else{
					info.add(node);
				}
			}
			else {
				type.add(node);	
			}
		}

		for( Edge edge : value.getEdges()){
			edges.add(edge);
		}
	}
	
	public void addTypes(){
		inferenceTypes.add("Pro");
		inferenceTypes.add("LCE");
		inferenceTypes.add("Con");
		
	}
	public void createTree(){


		graph = new Graph(false);
		graphCon = new Graph(true);
		
		Iterator<Node> iterNodes = nodes.iterator();

		while(iterNodes.hasNext()){
			Node node = iterNodes.next();
			Iterator<Node> iterNodess = nodes.iterator();
			while(iterNodess.hasNext()){
				Node nodee = iterNodess.next();
				for(Edge edge: edges){
					if(node.getNodeID().equals(edge.getFromID()) && nodee.getNodeID().equals(edge.getToID())){
						graph.addEdge(node, nodee);
						graphCon.addEdge(node, nodee);
					}
				}
			}
		}
		
		generateLanguageIn();
		generateLanguageOut();
		print(listOfString);
	}
		
	public void findRoot(ArrayList<ArrayList<Node>> list){

		Iterator<ArrayList<Node>> iteratorLists = list.iterator();
		
		int sizeEdges = edges.size();
		while(iteratorLists.hasNext()){
			ArrayList<Node> listPath = iteratorLists.next();
			int size  = list.size();
			boolean in = false;
			for(int i=0; i <=listPath.size()-1 && in ==false; i++){
				Node node = listPath.get(i);
				Vertex<Node>  vert = graphCon.getVertex(node);
				int count = 0;
				if(vert.getInVertexes().size()>=1 && vert.getAdjacentVertexes().size()!=1){
					for (Iterator<Vertex<Node>> j = vert.getInVertexes().iterator(); j.hasNext();) {
							Vertex<Node> vertex= j.next();							
							if(!vertex.getNode().getText().equals(inferenceTypes.get(0)))
								count++;
						}					
					if(count == vert.getInVertexes().size())
						in = true;					
				}	
				if(in == true){
					root = node;
					nodesRoot.put(listPath, root);								
				}
			}
		}
	}
	
	
	public Map<ArrayList<Node>, Node> getNodesRoot() {
		return nodesRoot;
	}

	public void setNodesRoot(Map<ArrayList<Node>, Node> nodesRoot) {
		this.nodesRoot = nodesRoot;
	}

	public ArrayList<ArrayList<Node>> removeDuplicates(ArrayList<ArrayList<Node>> list){
		
		int i=0;
		while(i<=list.size()-1){
		
			ArrayList<Node> list1 = (ArrayList<Node>)   list.get(i);
			int j=i+1;
			while(j<= list.size()-1){
				ArrayList<Node> list2 = (ArrayList<Node>)  list.get(j);
				if((list1.containsAll(list2) && list1.size()>list2.size())){
					 list.remove(list2);	
					i--;						
				}	
				if(list2.containsAll(list1) && list2.size()>list1.size()){
					list.remove(list1);	
					i--;
				}
				if(list2.containsAll(list1) && list2.size() == list1.size() && list1!=list2){
					list.remove(list1);	
					list.remove(list2);
					i--;
				}
				j++;
			}
			i++;
			
		}
		return list;
		
	}
	
	public void generateLanguageIn(){
			
			/*
			 * It gets all the paths from the leaves
			 */
			Paths pathsIn = new Paths();
			for(Vertex<Node> node1: graph.getVertexes()){	
				if(node1.getAdjacentVertexes().size()==1){
					for(Vertex<Node> node2: graph.getVertexes()){
						pathsIn.findPaths(graph, node1, node2);
					}
				}
			}


			/*
			 * It iterates over the paths and remove those paths which contain
			 * arguments that are out
			 */			
			Iterator<ArrayList<Node>> iterator = pathsIn.getLists().iterator();
			while(iterator.hasNext()){
				ArrayList<Node> list = iterator.next();
				Iterator<Node> iterateLists = list.iterator();
				int count = 0;
				while(iterateLists.hasNext()){
					Node node = iterateLists.next();
					if(node.getEval().equals("V") || node.getText().equals(inferenceTypes.get(0)))
						count++;					
				}		
				if(count!=list.size() || list.size()<=2)
					iterator.remove();
			}

						
			/*
			 * It gets the longest path
			 */
			Iterator<ArrayList<Node>> itMax = pathsIn.getLists().iterator();
			while(itMax.hasNext()){
				ArrayList<Node> list = itMax.next();
				int size  = list.size();
				if(size>max)
					max=size;				
			}			
				
			/*
			 * It removes the paths that are not of maximum length
			 
			/*
			 * Iterator<ArrayList<Node>> iteratorRemove = pathsIn.getLists().iterator();
			 */
			
			Iterator<ArrayList<Node>> iteratorRemove = pathsIn.getLists().iterator();
			while(iteratorRemove.hasNext()){
				ArrayList<Node> list = iteratorRemove.next();
				int size  = list.size();
				if(size!=max)
					iteratorRemove.remove();				
			}
			
			/*
			 * It finds the root
			 */
			
			
			findRoot( pathsIn.getLists());
			
				
			/*
			 * It removes the type of inference from the lists
			 */
			Iterator<ArrayList<Node>> iterLists = pathsIn.getLists().iterator();
			while(iterLists.hasNext()){
				ArrayList<Node> list = iterLists.next();
				int size  = list.size();
				Iterator<Node> iterList = list.iterator();
				int contor = 0;
				while(iterList.hasNext()){
					Node node = iterList.next();
					if(node.getText().equals(inferenceTypes.get(0))){
						iterList.remove();
					}					
				}
			}
			
			
			
			/*
			 * It generates the natural language
			 */
			Iterator<ArrayList<Node>> iteratorFinal = pathsIn.getLists().iterator();

			Node node1;
			Node node2;
			
		
			while(iteratorFinal.hasNext())
			{
				ArrayList<Node> list = iteratorFinal.next();
				Node root = returnValue(nodesRoot, list);
				text = "";				
				int i=0;
				node1= list.get(i);
				int change  =0;
				while(i < list.size()-1 && change ==0){
					
					node2 = list.get(i+1);
					if(node1!=root && node2!=root)
					{
						text=text.concat(node1.getText());
						text=text.concat(becauseof);
						text=text.concat(node2.getText());
						text=text.concat(and);
						
					}
					else if(node2 == root)
					{
						change=1;
						text=text.concat(node1.getText());
						text=text.concat(becauseof);
						text=text.concat(node2.getText());
						
					}
					node1= node2;
					i++;
					
				}		
				listOfString.add(text);
			}			
		}
		
		public ArrayList<String> getListOfString() {
		return listOfString;
	}

	public void setListOfString(ArrayList<String> listOfString) {
		this.listOfString = listOfString;
	}

	
	public Node returnValue(Map mp, ArrayList<Node> list) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry pair = (Entry)it.next();
	        if(pair.getKey().equals(list))
	        	return (Node) pair.getValue();
	      it.remove();
	    }
	    return null;
	}
	
	public void generateLanguageOut(){
			
			/*
			 * It finds all the paths in the graph
			 */
			Paths paths = new Paths();
			for(Vertex<Node> node1: graphCon.getVertexes()){
				for(Vertex<Node> node2: graphCon.getVertexes()){
					paths.findPaths(graph, node1, node2);
					}
				
			}				
			
			/*
			 * It removes the paths whise arguments are in
			 */
			Iterator<ArrayList<Node>> itConLists = paths.getListsCon().iterator();

			while(itConLists.hasNext()){
				ArrayList<Node> list = itConLists.next();
				int size  = list.size();
				Iterator<Node> itCon = list.iterator();
				int count = 0;
				while(itCon.hasNext()){
					Node node = itCon.next();
					if(!node.getText().equals(inferenceTypes.get(0))){
						count++;
					}
					if(node.getText().equals(inferenceTypes.get(2))){
						itCon.remove();
					}					
				}
				if(count!=size || list.size()<=1)
					itConLists.remove();						
			}
			
			Set<String> s = new LinkedHashSet<>(paths.getListsCon());
			paths.getListsCon().clear();
			paths.getListsCon().addAll(s);
			
			
			paths.setListsCon(removeDuplicates(paths.getListsCon()));
						
				
			/*
			 * It generates the natural language
			 */
			Iterator<ArrayList<Node>> iterateFinal = paths.getListsCon().iterator();

			Node node1;
			Node node2;
			
			while(iterateFinal.hasNext())
			{
				ArrayList<Node> list = iterateFinal.next();
				text = "";				
				int count =0;
				node1= list.get(count);
				int sw=0;
				while(count < list.size()-1 && sw==0){
					
					node2 = list.get(count+1);
					if(count!=list.size()-2){
						text=text.concat(node1.getText());
						text=text.concat(temp);
						text=text.concat(node2.getText());
						text=text.concat(but);						
					}
					else if(count==list.size()-2){
						sw=1;
						text=text.concat(node1.getText());
						text=text.concat(temp);
						text=text.concat(node2.getText());						
					}
					node1= node2;
					count++;					
				}	
				
				listOfString.add(text);
				
				}
			
			
		}
		
		/*
		 * It checks is two list of nodes are equal
		 */
		public static <T> boolean listEqualsNoOrder(ArrayList<Node> l1, ArrayList<Node> l2) {
	    final Set<Node> s1 = new HashSet<>(l1);
	    final Set<Node> s2 = new HashSet<>(l2);
	    return s1.equals(s2);
	}

		public Node getRoot() {
			return root;
		}

		public void setRoot(Node root) {
			this.root = root;
		}
		
		public void print(ArrayList<String> list){
			finalText = new StringBuilder();
			for(String str: list){
				//System.out.println(str);
				finalText.append(str);
				finalText.append("\n");
			}
		}
}