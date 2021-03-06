package com.graphs.ravindra;

import java.util.LinkedList;
import java.util.Stack;

class AdjNode{
	int vertex;
	int weight;
	
	public AdjNode(int vertex, int weight){
		this.vertex =vertex;
		this.weight =weight;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public int getVertex(){
		return vertex;
	}
}

class DirectedGraph{
	
	LinkedList<AdjNode>[] vertices;
	
	public DirectedGraph(int size){
		vertices = new LinkedList[size];
		
		for(int i=0;i<size;i++){
			vertices[i] = new LinkedList<AdjNode>();
		}
	}
	
	public void addEdge(int source, int destination, int weight){
			AdjNode node = new AdjNode(destination,weight);
			vertices[source].add(node);
	}
	
	public void shortestPath(int source){
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[vertices.length];
		for(int i=0;i<vertices.length;i++){
			if(!visited[i])
			topologicalSort(i,visited,stack);
		}
		int[] dis = new int[vertices.length];
		
		for(int i=0;i<vertices.length;i++){
			dis[i] =Integer.MAX_VALUE;
		}
		dis[source]=0;
		
		while(!stack.isEmpty()){
			int element = stack.pop();
			
			if(dis[element]!=Integer.MAX_VALUE){
				LinkedList<AdjNode> list = vertices[element];
				for(AdjNode node : list){
					if(dis[node.vertex] > dis[element] + node.weight){
						dis[node.vertex] = dis[element] + node.weight;
					}
				}
			}
			
		}
		for (int i = 0; i < vertices.length; i++)
        {
            if (dis[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( dis[i] + " ");
        }
		
	}
	public void topologicalSort(int source, boolean[] visited, Stack<Integer> stack){
		visited[source]=true;
		for(AdjNode node: vertices[source]){
			if(!visited[node.vertex]){
				topologicalSort(node.vertex,visited,stack);
			}
		}
		stack.add(source);
	}
}
	public class ShotestPath {
	
			public static void main(String[] args) {
				DirectedGraph g = new DirectedGraph(6);
			        g.addEdge(0, 1, 5);
			        g.addEdge(0, 2, 3);
			        g.addEdge(1, 3, 6);
			        g.addEdge(1, 2, 2);
			        g.addEdge(2, 4, 4);
			        g.addEdge(2, 5, 2);
			        g.addEdge(2, 3, 7);
			        g.addEdge(3, 4, -1);
			        g.addEdge(4, 5, -2);
			        g.shortestPath(1);
		
			}

}
