package com.graphs.ravindra;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
	   // Driver program to test above function
    public static void main (String[] args)
    {
	   int G[][] = {{0, 1, 0, 1},
		            {1, 0, 1, 0},
		            {0, 1, 0, 1},
		            {1, 0, 1, 0}};
	   
	        if (isBipartite(G, 0))
	           System.out.println("Yes");
	        else
	           System.out.println("No");

}
    
    public static boolean isBipartite(int[][] matrix,int start){
    	
    	int[] color = new int[matrix.length];
    	for(int i=0;i<matrix.length;i++){
    		color[i]=-1;
    	}
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(start);
    	color[start] =1;
    	
    	while(!queue.isEmpty()){
    		int source = queue.poll();
    		
    		if(matrix[source][source] ==1){
    			return false;
    		}
    		for(int i=0;i<matrix[0].length;i++){
    			if(matrix[source][i] ==1 && color[i]==-1){
    					queue.add(i);
    					color[i] = 1-color[source];
    			}else if(matrix[source][i] ==1 && color[i]==color[source]){
    				return false;
    			}
    		}
    		
    	}
    	
    	return true;
    }
}
