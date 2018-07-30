package com.graphs.ravindra;

public class TopologicalSort {

	public static void main(String[] args) {
		
		  Graph g = new Graph(6);
	        g.addEdgeDirectional(5, 2);
	        g.addEdgeDirectional(5, 0);
	        g.addEdgeDirectional(4, 0);
	        g.addEdgeDirectional(4, 1);
	        g.addEdgeDirectional(2, 3);
	        g.addEdgeDirectional(3, 1);

	        System.out.println("Following is a Topological " +
                    "sort of the given graph");
	       // g.topologicalSort();
	        
	        int[][] matrix = {{0,0,0,0,0,0},
	        				  {0,0,0,0,0,0},
	        				  {0,0,0,1,0,0},
	        				  {0,1,0,0,0,0},
	        				  {1,1,0,0,0,0},
	        				  {1,0,1,0,0,0}};
	        
	        g.topologicalSort(matrix);
	}

}
