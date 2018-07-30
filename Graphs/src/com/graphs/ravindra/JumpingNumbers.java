package com.graphs.ravindra;

import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers {

	public static void main(String[] args) {
		int x=99;
		System.out.print(0+ " ");
		for (int i=1; i<=9 && i<=x; i++)
			printJumpingNumbers(x, i);
		

	}

	public static void printJumpingNumbers(int target,int number){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(number);
		while(!queue.isEmpty()){
			int element = queue.poll();
			
			if(element<target){
				System.out.print(" "+ element);
			int lastDigit = element%10;
			if(element ==0){
				queue.add(element*10+(lastDigit+1));
			}
			else if(element==9){
				queue.add(element*10+(lastDigit-1));
			}
			else{
				queue.add(element*10+(lastDigit+1));
				queue.add(element*10+(lastDigit-1));
			}
		}
		}
	}
	
	
}
