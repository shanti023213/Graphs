package com.graphs.ravindra;

public class CycleInUndirectedGraph {

	    // Driver method to test above methods
	    public static void main(String args[])
	    {
	        // Create a graph given in the above diagram
	        Graph g1 = new Graph(5);
	        g1.addEdge(1, 0);
	        g1.addEdge(0, 2);
	        //g1.addEdge(2, 0);
	        g1.addEdge(0, 3);
	        g1.addEdge(3, 4);
	        if (g1.isCyclic())
	            System.out.println("Graph contains cycle");
	        else
	            System.out.println("Graph doesn't contains cycle");
	 
	        Graph g2 = new Graph(3);
	        g2.addEdge(0, 1);
	        g2.addEdge(1, 2);
	        if (g2.isCyclic())
	            System.out.println("Graph contains cycle");
	        else
	            System.out.println("Graph doesn't contains cycle");
	        
	    	Graph g= new Graph(12);
		  	g.addEdge( 0, 1);
		  	g.addEdge( 0, 2);
	        g.addEdge( 1, 3);
	        g.addEdge( 1, 4);
	        g.addEdge( 2, 5);
	        g.addEdge( 2, 6);
	        g.addEdge( 3, 7);
	        g.addEdge( 4, 7);
	        g.addEdge( 5, 7);
	        g.addEdge( 6, 7);
	        
	        if (g.isCyclic())
	            System.out.println("Graph contains cycle");
	        else
	            System.out.println("Graph doesn't contains cycle");
	        
	        int[][] matrix =     {{0,1,1,0,0,0,0,0,0,0,0,0},
								  {1,0,0,1,1,0,0,0,0,0,0,0},
								  {1,0,0,0,0,1,1,0,0,0,0,0},
								  {0,1,0,0,0,0,0,1,0,0,0,0},
								  {0,1,0,0,0,0,0,1,0,0,0,0},
								  {0,0,1,0,0,0,0,1,0,0,0,0},
								  {0,0,1,0,0,0,0,1,0,0,0,0},
								  {0,0,0,1,1,1,1,0,0,0,0,0},
								  {0,0,0,0,0,0,0,0,0,1,1,0},
								  {0,0,0,0,0,0,0,0,1,0,0,1},
								  {0,0,0,0,0,0,0,0,1,0,0,1},
								  {0,0,0,0,0,0,0,0,0,1,1,0}};
	        
	        if (g.isCyclic(matrix))
	            System.out.println("Graph contains cycle");
	        else
	            System.out.println("Graph doesn't contains cycle");
	        
	    }
	}

