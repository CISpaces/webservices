package nlg;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Paths<T> {

	private ArrayList<ArrayList<Node>> listsIn =  new ArrayList<ArrayList<Node>>();
	private ArrayList<ArrayList<Node>> listsCon =  new ArrayList<ArrayList<Node>>();
	 
    public void findPaths(Graph<Node> graph, Vertex<Node> startNode, Vertex<Node> destinationNode){
        
    	Set<Vertex<Node>> visitedNodes = new LinkedHashSet<Vertex<Node>>();
        
    	findPaths(visitedNodes,destinationNode,startNode);
    }
    
    private void findPaths(Set<Vertex<Node>> visitedNodes ,Vertex<Node> destinationNode,Vertex<Node> currentNode){
        
    	ArrayList<Node> listOfNodes = new ArrayList<Node>();
    	
    	if(visitedNodes.contains(currentNode)){
            return;
        }
    	
        if(destinationNode.equals(currentNode)){
            for(Vertex<Node> vertex : visitedNodes){
            	listOfNodes .add(vertex.getNode());         
            }
            listOfNodes .add(destinationNode.getNode());
            listsIn.add(listOfNodes );
            listsCon.add(listOfNodes );            
            return;
        }
        
        visitedNodes.add(currentNode);
        for(Vertex<Node> node : currentNode.getAdjacentVertexes()){
        	findPaths(visitedNodes, destinationNode, node);
        }
        
        visitedNodes.remove(currentNode);    	
    }

	public ArrayList<ArrayList<Node>> getListsCon() {
		return listsCon;
	}

	public void setListsCon(ArrayList<ArrayList<Node>> listsCon) {
		this.listsCon = listsCon;
	}

	public ArrayList<ArrayList<Node>> getLists() {
		return listsIn;
	}

	public void setLists(ArrayList<ArrayList<Node>> lists) {
		this.listsIn = lists;
	}    
}
