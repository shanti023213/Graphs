package com.graphs.ravindra;

public class IfpathExists {

	public static void main(String[] args) {
		
		  Graph g = new Graph(4);
	        g.addEdgeDirectional(0, 1);
	        g.addEdgeDirectional(0, 2);
	        g.addEdgeDirectional(1, 2);
	        g.addEdgeDirectional(2, 0);
	        g.addEdgeDirectional(2, 3);
	        g.addEdgeDirectional(3, 3);
	 
	        int u = 1;
	        int v = 3;
	        if (g.isReachable(u, v))
	            System.out.println("There is a path from " + u +" to " + v);
	        else
	            System.out.println("There is no path from " + u +" to " + v);;
	            
	            u = 3;
	            v = 1;
	            if (g.isReachable(u, v))
	                System.out.println("There is a path from " + u +" to " + v);
	            else
	                System.out.println("There is no path from " + u +" to " + v);;

	}

}
