package com.graphs.ravindra;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {

	public static void main(String[] args) {
	
		int mat[][] =  {{1, 1, 0, 0, 0},
		                {0, 1, 0, 0, 1},
		                {1, 0, 0, 1, 1},
		                {0, 0, 0, 0, 0},
		                {1, 0, 1, 0, 1}};
		
		int noOfIslandsDFS = noOfIslandsDFS(mat);
		int noOfIslandsBFS = noOfIslandsBFS(mat);
		
		System.out.println("noOfIslandsDFS :" + noOfIslandsDFS);
		System.out.println("noOfIslandsBFS :" + noOfIslandsBFS);

}
	
	public static int noOfIslandsDFS(int[][] matrix){
		
		boolean[][] visited= new boolean[matrix.length][matrix[0].length];
		int count =0;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(!visited[i][j] && matrix[i][j]==1){
					count++;
					DFS(matrix,visited,i,j);
				}
			}
		}
		
		return count;
	}
	
	public static void DFS(int[][] matrix, boolean[][] visited,int x, int y){
		
		if(x<0 || x>=matrix.length || y>=matrix[0].length || y<0){
			return;
		}
		
		 if(matrix[x][y] ==0 && visited[x][y]){
			 visited[x][y] =true;
	            return;
	        }
		 
		if(matrix[x][y] ==1 && !visited[x][y]){
			visited[x][y] =true;
			DFS(matrix,visited,x+1,y);
			DFS(matrix,visited,x-1,y);
			DFS(matrix,visited,x,y+1);
			DFS(matrix,visited,x,y-1);
			
			DFS(matrix,visited,x-1,y-1);
			DFS(matrix,visited,x-1,y+1);
			DFS(matrix,visited,x+1,y+1);
			DFS(matrix,visited,x+1,y-1);
		}
		
	}
	
	public static int noOfIslandsBFS(int[][] matrix){
		
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int count =0;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j] ==1 && !visited[i][j]){
					count++;
					BFS(matrix,visited,i,j);
				}
			}
		}
		
		return count;
	}
	
	public static void BFS(int[][] matrix, boolean[][] visited, int x, int y){
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x*matrix.length+y);
		visited[x][y]= true;
	
		 while(!queue.isEmpty()){
			 int element = queue.poll();
			 
			 int i = element/matrix.length;
			 int j = element%matrix.length;
			
			 if(checkLocation(matrix, i+1,j,visited)){
				 queue.add(((i+1)*matrix.length)+j);
				 visited[i+1][j]=true;
			 }
			 if(checkLocation(matrix,i-1,j,visited)){
				 queue.add(((i-1)*matrix.length)+j);
				 visited[i-1][j]=true;
			 }
			 
			 if(checkLocation(matrix,i,j+1,visited)){
				 queue.add((i*matrix.length)+(j+1));
				 visited[i][j+1]=true;
			 }
			 
			 if(checkLocation(matrix,i,j-1,visited)){
				 queue.add((i*matrix.length)+(j-1));
				 visited[i][j-1]=true;
			 }
			 
			 if(checkLocation(matrix,i-1,j-1,visited)){
				 queue.add(((i-1)*matrix.length)+(j-1));
				 visited[i-1][j-1]=true;
			 }
			
			 if(checkLocation(matrix,i-1,j+1,visited)){
				 queue.add(((i-1)*matrix.length)+(j+1));
				 visited[i-1][j+1]=true;
			 }
			 if(checkLocation(matrix,i+1,j+1,visited)){
				 queue.add(((i+1)*matrix.length)+(j+1));
				 visited[i+1][j+1]=true;
			 }
			
			 if(checkLocation(matrix,i+1,j-1,visited)){
				 queue.add(((i+1)*matrix.length)+(j-1));
				 visited[i+1][j-1]=true;
			 }
			 
			
		
			 
		 }
	}
	
	public static boolean  checkLocation(int[][] matrix, int i, int j,boolean[][] visited){
		 if(i<0 || i>=matrix.length || j>=matrix[0].length || j<0 || matrix[i][j] ==0 || visited[i][j]){
			 	return false;
		 }
		 return true;
	}
}
