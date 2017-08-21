package nlg;

public class EdgeGraph<T>{
	
    private boolean directed = false;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    
    private int weight;
    
    EdgeGraph(Vertex<T> vertex1, Vertex<T> vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    EdgeGraph(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected,int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.directed = isDirected;
    }
    
    EdgeGraph(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.directed = isDirected;
    }
    
    Vertex<T> getVertex1(){
        return vertex1;
    }
    
    Vertex<T> getVertex2(){
        return vertex2;
    }
    
    int getWeight(){
        return weight;
    }
    
    public boolean isDirected(){
        return directed;
    }
}