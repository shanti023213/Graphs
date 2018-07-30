package com.graphs.ravindra;

public class CycleInDirectedGraph {

	public static void main(String[] args) {
			Graph graph = new Graph(7);
			graph.addEdgeDirectional(0,1);
		    graph.addEdgeDirectional(0,2);
		    graph.addEdgeDirectional(1,3);
		    graph.addEdgeDirectional(1,4);
		    graph.addEdgeDirectional(2,5);
		    graph.addEdgeDirectional(6,2);
		    graph.addEdgeDirectional(5,6);
		   
		    
		    if(graph.isCyclicDirected()){
		        System.out.println("Graph contains cycle");
		    }else{
		    	System.out.println("Graph does not contains cycle");
		    }
	}

}
