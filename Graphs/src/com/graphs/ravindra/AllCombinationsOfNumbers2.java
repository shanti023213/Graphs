package com.graphs.ravindra;

import java.util.ArrayList;

public class AllCombinationsOfNumbers2 {
	static void makeCombiUtil(ArrayList<ArrayList<Integer>> ans,
			ArrayList<Integer> tmp, int n, int left, int k)
		{
		    // Pushing this vector to a vector of vector
		    if (k == 0) {
		        ans.add(tmp);
		        return;
		    }
		 
		    // i iterates from left to n. First time
		    // left will be 1
		    for (int i = left; i < n; ++i)
		    {
		        tmp.add(i);
		        makeCombiUtil(ans, tmp, n, i + 1, k - 1);
		 
		        // Popping out last inserted element
		        // from the vector
		        tmp.remove(i);
		    }
		}
		 
		// Prints all combinations of size k of numbers
		// from 1 to n.
	static ArrayList<ArrayList<Integer>> makeCombi(int n, int k)
		{
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>(); 
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		
		
		    makeCombiUtil(ans, tmp, n, 1, k);
		    return ans;
		}
		 
		// Driver code
		public static void main(String[] args)
		{
		    // given number
		    int n = 5;
		    int k = 3;
		    ArrayList<ArrayList<Integer>> ans = makeCombi(n, k);
		    for (int i = 0; i < ans.size(); i++) {
		        for (int j = 0; j < ans.get(i).size(); j++) {
		            System.out.println(ans.get(i).get(j)+" ");
		        }
		      
		    }
		}

}
