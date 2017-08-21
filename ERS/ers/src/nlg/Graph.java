package nlg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Graph<T>{

    private List<EdgeGraph<T>> edges;
    private Map<Node ,Vertex<T>> vertexes;
   
    boolean directed = false;
    ArrayList<Vertex<Node>> nodeIn = new  ArrayList<Vertex<Node>>();
    
    public Graph(boolean directed){
    	edges = new ArrayList<EdgeGraph<T>>();
    	vertexes = new HashMap<Node,Vertex<T>>();
        this.directed = directed;
    }
    
    public void addEdge(Node node1, Node node2){
        addEdge(node1,node2,0);
    }
    
   
    public void addVertex(Vertex<T> vertex){
        if(vertexes.containsKey(vertex.getNode())){
            return;
        }
        vertexes.put(vertex.getNode(), vertex);
        for(EdgeGraph<T> edge : vertex.getEdges()){
        	edges.add(edge);
        }
    }
    
    public Vertex<T> addSingleVertex(Node node){
        
    	if(vertexes.containsKey(node)){
            return vertexes.get(node);
        }
    	
        Vertex<T> v = new Vertex<T>(node);
        vertexes.put(node, v);
        
        return v;
    }
    
    public Vertex<T> getVertex(Node node){
        return vertexes.get(node);
    }
    
    public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean isDirected) {
		this.directed = isDirected;
	}

	public ArrayList<Vertex<Node>> getNodeIn() {
		return nodeIn;
	}

	public void setNodeIn(ArrayList<Vertex<Node>> nodeIn) {
		this.nodeIn = nodeIn;
	}

	public void setEdges(List<EdgeGraph<T>> edges) {
		this.edges = edges;
	}

	public void setVertexes(Map<Node, Vertex<T>> vertexes) {
		this.vertexes = vertexes;
	}

	public void addEdge(Node node1,Node node2, int weight){
        
		Vertex<T> vertex1 = null;
        Vertex<T> vertex2 = null;
        
        if(vertexes.containsKey(node1)){
            vertex1 = vertexes.get(node1);
        }else{
            vertex1 = new Vertex<T>(node1);
            vertexes.put(node1, vertex1);
        }
        
       
        if(vertexes.containsKey(node2)){
            vertex2 = vertexes.get(node2);
        }else{
            vertex2 = new Vertex<T>(node2);
            vertexes.put(node2, vertex2);
        }

        EdgeGraph<T> edge = new EdgeGraph<T>(vertex1,vertex2,directed,weight);
        edges.add(edge);
        
        vertex1.addAdjacentVertex(edge, vertex2);
        vertex2.addinVertexes(edge, vertex1);
        if(!directed){
            vertex2.addAdjacentVertex(edge, vertex1);
            
        }

    }
    
   

	public List<EdgeGraph<T>> getEdges(){
        return edges;
    }
    
    public Collection<Vertex<T>> getVertexes(){
        return vertexes.values();
    }
    public void setDataForVertex(Node node, Node data){
        if(vertexes.containsKey(node)){
            Vertex<T> vertex = vertexes.get(node);
            vertex.setData(data);
        }
    }

    public boolean containsVertex(Node vertex) {
        return vertexes.containsKey(vertex);
    }
    
    public void  dfs(Vertex<Node> start){
    	
    	nodeIn.clear();
		
    	if(!containsVertex(start.getNode())) {
         	
             throw new RuntimeException("Vertex does not exist.");
         }
    	 
    	/*
    	 * initialize a stack
    	 */
    	Stack<Vertex<Node>> stack = new Stack<Vertex<Node>>(); 
        
    	/*
    	 * Maintains order of visited nodes
    	 */
    	List<Vertex<Node>> visited = new ArrayList<Vertex<Node>>();
    	
    
    	System.out.println("Start= " + start);
    	
    	if(start.getNode().getEval().equals("V") || start.getNode().getText().equals("Pro")){
    		stack.push(start);
    	
    	/*
    	* check if stack is empty
    	*/
        while(!stack.isEmpty()){ 
        	Vertex<Node> popped = stack.pop(); 
        
            if(!visited.contains(popped)){ 
            	if(popped.getNode().getEval().equals("V") || popped.getNode().getEval().equals("Pro")){//backtrack if the vertex is already visited
               /*
                * mark it as visited as it is not yet visited
                */
            	visited.add(popped); 
            	
                for(Vertex<Node> node: popped.getAdjacentVertexes()){ 
                        stack.add(node);
                        System.out.println("Nodd= " + node.getNode());
                }
            }}
        }
        

		int j=0;
		for(Vertex<Node> v1 : visited){
			nodeIn.add(j,v1);
     		j++;
         	}        
    	}    
    }  
}
