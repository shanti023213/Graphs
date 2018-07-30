package com.graphs.ravindra;

import java.util.LinkedList;

class GraphArticulation{
	
	int size;
	int time;
	LinkedList<Integer>[] vertices;
	
	public GraphArticulation(int size){
		vertices = new LinkedList[size];
		this.size=size;
		for(int i=0;i<size;i++){
			vertices[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int source, int target){
		vertices[source].add(target);
		vertices[target].add(source);
	}
	
	public void AP(){
		boolean[] visited = new boolean[size];
		boolean[] ap = new boolean[size];
		int[] parent = new int[size];
		int[] disc = new int[size];
		int[] low = new int[size];
		
		for(int i=0;i<size;i++){
			parent[i] =-1;
		}
		for(int i=0;i<size;i++){
			if(!visited[i]){
				APUtils(i,visited,ap,parent,disc,low);
			}
		}
		
		for(int i=0;i<size;i++){
			if(ap[i]){
				System.out.print(i);
			}
		}
		System.out.println("");
	}
	
	public void APUtils(int source, boolean[] visited,boolean[] ap,int[] parent,int[] disc,int[] low){
		visited[source] =true;
		low[source] =disc[source] =++time;
		int children =0;
		for(int target: vertices[source]){
			children++;
			if(!visited[target]){
				visited[target] =true;
				parent[target] =source;
				APUtils(target,visited,ap,parent,disc,low);
				low[source] = Math.min(low[source], low[target]);
				
				if(parent[source] == -1 && children>1){
					ap[source] = true;
				}
				//visited time of source <= low time of adj
				if(parent[source] != -1 && disc[source]<=low[target]){
					ap[source] = true;
				}
			}
			
			if(parent[source] !=target){
				low[source] = Math.min(low[source] ,low[target]);
			}
		}
	}
	
}
public class ArticulationPoints {

	public static void main(String[] args) {
		
		System.out.println("Articulation points in first graph ");
		GraphArticulation g1 = new GraphArticulation(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.AP();
        System.out.println();
        
        System.out.println("Articulation points in Second Graph1");
        GraphArticulation g2 = new GraphArticulation(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.AP();
        System.out.println();
 
        System.out.println("Articulation points in Third Graph1 ");
        GraphArticulation g3 = new GraphArticulation(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.AP();

	}

}
