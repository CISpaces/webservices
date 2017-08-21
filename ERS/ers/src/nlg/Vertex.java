package nlg;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    
	Node node;
	
    private Node data;
    
    private List<EdgeGraph<T>> edges = new ArrayList<>();
    private List<Vertex<T>> adjacentVertexes = new ArrayList<>();
    private List<Vertex<T>> inVertexes = new ArrayList<>();
    
    public List<Vertex<T>> getInVertexes() {
		return inVertexes;
	}

	public void setInVertexes(List<Vertex<T>> inVertexes) {
		this.inVertexes = inVertexes;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public void setEdges(List<EdgeGraph<T>> edges) {
		this.edges = edges;
	}

	public void setAdjacentVertexes(List<Vertex<T>> adjacentVertexes) {
		this.adjacentVertexes = adjacentVertexes;
	}

	Vertex(Node node){
        this.node = node;
    }
    
    public Node getNode(){
        return node;
    }
    
    public void addAdjacentVertex(EdgeGraph<T> edge, Vertex<T> vertex){
        
    	edges.add(edge);
        adjacentVertexes.add(vertex);
    }
    
    public void addinVertexes(EdgeGraph<T> edge, Vertex<T> vertex){
        
    	inVertexes.add(vertex);
    }
    
    public void setData(Node data){
        this.data = data;
    }
    
    public Node getData(){
        return data;
    }
    
      
    public String toString(){
        return String.valueOf(node);
    }
    
    public List<Vertex<T>> getAdjacentVertexes(){
        return adjacentVertexes;
    }
    
    public List<EdgeGraph<T>> getEdges(){
        return edges;
    }
    
    public int getDegree(){
        return edges.size();
    }
}