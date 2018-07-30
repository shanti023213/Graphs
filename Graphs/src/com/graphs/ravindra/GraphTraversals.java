package com.graphs.ravindra;

public class GraphTraversals {

	public static void main(String[] args) {
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
	        
	        g.addEdge( 8, 9);
	        g.addEdge( 8, 10);
	        g.addEdge( 10, 11);
	        g.addEdge( 9, 11);

	      /*  g.printGraph();
	        
	        g.bfs(0, new boolean[g.vertices.length]);
	        g.dfsRec(0);
	        
	        g.addEdge( 8, 9);
	        g.addEdge( 8, 10);
	        g.addEdge( 10, 11);
	        g.addEdge( 9, 11);
	        
	        g.printGraph();*/
	        //g.dft();
	        
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
	       //g.bft(matrix);
	        g.dft(matrix);
	        
	        
	}

}
