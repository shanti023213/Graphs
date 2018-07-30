package com.graphs.ravindra;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	
	LinkedList<Integer>[] vertices ;
	
	public Graph( int size){
		vertices = new LinkedList[size];
		for(int i=0;i<size;i++){
			vertices[i] = new LinkedList<Integer>();
		}
	}

	
	public void addEdge(int source, int target){
		vertices[source].add(target);
		vertices[target].add(source);
	}
	
	public void addEdgeDirectional(int source, int target){
		vertices[source].add(target);
		//vertices[target].add(source);
	}
	
	public void printGraph(){
			for(int i=0;i<vertices.length;i++){
				LinkedList<Integer> list = vertices[i];
				System.out.println("Adjacency list of: " + i);
					for(Integer element:list){
						System.out.print(element);
					}
					 System.out.println("\n");
			}
	}
	
	public void bfs(int source , boolean[] visited){
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		visited[source]=true;
		System.out.print("BFS path is ");
		while(!queue.isEmpty()){
			int start = queue.poll();
			System.out.print(" "+start);
			for(Integer target : vertices[start]){
				if(!visited[target]){
					queue.add(target);
					visited[target]=true;
				}
			}
		}
	}
	
	public void dfs(int source, boolean[] visited){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(source);
		visited[source] =true;
		System.out.print("DFS path is ");
		while(!stack.isEmpty()){
			int start = stack.pop();
			System.out.print(" "+start);
			for(Integer target: vertices[start]){
				if(!visited[target]){
					stack.push(target);
					visited[target]= true;
				}
			}
		}
		
	}
	
	public void dfsRec(int source, boolean[] visited){
		System.out.print("DFS bath is ");
		visited[source]=true;
		dfsHelper(source, visited);
		
		
	}
	
	public void dfsHelper(int source, boolean[] visited){
		System.out.print(" "+ source);
		for(Integer target:vertices[source]){
			if(!visited[target]){
				visited[target]=true;
				dfsHelper(target,visited);
			}
		}
	}
	
	public void bft(){
		boolean[] visited = new boolean[vertices.length];
		for(int i=0;i<vertices.length;i++){
			if(!visited[i]){
				bfs(i,visited);
			}
		}
	}
	
	public void dft(){
		boolean[] visited = new boolean[vertices.length];
		for(int i=0;i<vertices.length;i++){
			if(!visited[i]){
				dfsRec(i,visited);
			}
		}
	}
	
	public void bft(int[][] matrix){
		boolean[] visited = new boolean[matrix.length];
		for(int i=0;i<matrix.length;i++){
			if(!visited[i]){
				bfs(matrix,i,visited);
			}
		}
	}
	
	public void bfs(int[][] matrix, int source, boolean[] visited){
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		visited[source]= true;
		System.out.println("BFS traversal is:");
		while(!queue.isEmpty()){
			int start = queue.poll();
			System.out.print(" "+start);
			for(int i=0;i<matrix.length;i++){
				if(matrix[start][i] == 1 && !visited[i]){
					queue.add(i);
					visited[i]= true;
				}
			}
		}
 	}
	
	public void dft(int[][] matrix){
		boolean[] visited = new boolean[matrix.length];
		for(int i=0;i<matrix.length;i++){
			if(!visited[i]){
				dfsRec(matrix,i,visited);
			}
		}
	}
	
	public void dfs(int[][] matrix, int source, boolean[] visited){
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(source);
		visited[source]= true;
		System.out.println("DFS traversal is:");
		while(!stack.isEmpty()){
			int start = stack.pop();
			System.out.print(" "+start);
			for(int i=0;i<matrix.length;i++){
				if(matrix[start][i]==1 && !visited[i]){
					stack.push(i);
					visited[i]=true;
				}
			}
		}
	}
	
	public void dfsRec(int[][] matrix, int source, boolean[] visited){
		visited[source]= true;
		System.out.print(" "+source);
		for(int i=0;i<matrix.length;i++){
			if(matrix[source][i]==1 && !visited[i]){
				visited[i] = true;
				dfsRec(matrix,i,visited);
			}
		}
	}
	
	public void topologicalSort(){
		
		boolean[] visited = new boolean[vertices.length];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<vertices.length;i++){
			if(!visited[i])
			topologicalSortUtil(i, visited,stack);
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}
	
	public void topologicalSortUtil(int source , boolean[] visited,Stack<Integer> stack){
	
			visited[source] = true;
			for(Integer target:vertices[source]){
				if(!visited[target]){
					visited[target]=true;
					topologicalSortUtil(target,visited,stack);
				}
			}
			stack.add(source);
		}
	
	public void topologicalSort(int[][] matrix){
		
		boolean[] visited = new boolean[matrix.length];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<matrix.length;i++){
			if(!visited[i]){
				topologicalUtil(matrix, i, visited,stack);
			}
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}
	
	public void topologicalUtil(int[][] matrix, int source, boolean[] visited, Stack<Integer>stack){
		
		visited[source]= true;
		for(int i=0;i<matrix.length;i++){
			if(matrix[source][i] ==1 && !visited[i]){
				topologicalUtil(matrix, i, visited,stack);
			}
		}
		stack.push(source);
	}
	
	public boolean isReachable(int source, int destination){
		
		boolean[] visited = new boolean[vertices.length];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(source);
		visited[source]=true;
		while(!queue.isEmpty()){
			int start = queue.poll();
			for(Integer target:vertices[start]){
				if(target == destination){
					return true;
				}
				if(!visited[target]){
					queue.add(target);
					visited[target]=true;
				}
			}
		}
		
		return false;
	}

	public boolean isCyclic(){
		
		boolean[] visited = new boolean[vertices.length];
		for(int i=0;i<vertices.length;i++){
			if(!visited[i]){
				if(dfsForCycle(i,visited,-1))
					return true;
			}
		}
		
		return false;
	}
	
	public boolean dfsForCycle(int start, boolean[] visited, int parent){
		visited[start] = true;
		for(Integer target: vertices[start]){
			if(!visited[target]){
				if(dfsForCycle(target,visited,start))
					return true;
			}else if(target!=parent){
				return true;
			}
		}
		
		return false;
	}
 
	public boolean isCyclic(int[][] matrix){
		boolean[] visited = new boolean[vertices.length];
		for(int i=0;i<matrix.length;i++){
			if(!visited[i]){
				if(isCyclicUtil(matrix, i,visited,-1))
						return true;
			}
		}
		
		return false;
	}
	
	public boolean isCyclicUtil(int[][] matrix, int start, boolean[] visited, int parent){
		visited[start]=true;
		for(int i=0;i<matrix.length;i++){
			if(matrix[start][i] ==1 && !visited[i]){
				isCyclicUtil(matrix, i,visited,start);
			}else if(start!=i){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isCyclicDirected(){
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[vertices.length];
		for(int i=0;i<vertices.length;i++){
			if(!visited[i]){
			if(cyclicDirectedUtil(stack,i,visited))
				return true;
			}
		}
		return false;
	}
	
	public boolean cyclicDirectedUtil(Stack<Integer> stack , int start,boolean[] visited){
		
		
		stack.add(start);
		visited[start] =true;
			for(Integer target: vertices[start]){
					if(stack.contains(target)){
						return true;
					}
				if(!visited[target]){
					if(cyclicDirectedUtil(stack,target,visited)){
						return true;
					}
				}
			}
		return false;
	}
}


