package algorithm;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/*
 * https://leetcode.com/contest/weekly-contest-117/problems/numbers-with-same-consecutive-differences/
 * 
 * 967. Numbers With Same Consecutive Differences

	Difficulty: Medium
	Return all non-negative integers of length N such that the absolute difference 
	between every two consecutive digits is K.
	
	Note that every number in the answer must not have leading zeros except for the number 0 itself. 
	For example, 01 has one leading zero and is invalid, but 0 is valid.
	
	You may return the answer in any order.
	
	 
	
	Example 1:
	
	Input: N = 3, K = 7
	Output: [181,292,707,818,929]
	Explanation: Note that 070 is not a valid number, because it has leading zeroes.
	Example 2:
	
	Input: N = 2, K = 1
	Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 */



public class NumsSameConsecDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 3;
		NumsSameConsecDiff test = new NumsSameConsecDiff();
		
		int[] res = test.numsSameConsecDiff(2, 0);
		System.out.println("Result:");
		for (int i = 0; i < res.length; i++) {
			System.out.println(", " + res[i]);
		}

	}
	
  	public int[] numsSameConsecDiff(int N, int K) {


        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i <= 9; i++) {  
            
            Queue<String> queue = new LinkedList<String>();
            queue.add(String.valueOf(i));
            
            boolean stop = false;
            while (!queue.isEmpty() && !stop) {
                int ss = queue.size();
                int j = 0;
                String item = null;
                stop = false;
                while (j < ss) {
                    item = queue.peek();
                    if (item.length() < N) {
                    	item = queue.poll();
                        String last = item.substring(item.length()-1, item.length());
                        int val = Integer.valueOf(last);
                        boolean valid = isValid(item);
                        
                        if (valid && val - K >=0) {
                            queue.add(item+String.valueOf(val-K));
                        }
                        if (valid && K!= 0 && val +K <=9) {
                            queue.add(item+String.valueOf(val+K));
                        }
                    } 
                    j++;
                } 
                if ( item != null && item.length() == N)
                	stop = true;
                
            }
            while (!queue.isEmpty()) {
                String item = queue.poll();
                res.add(Integer.valueOf(item));                
            }

        }
        
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        
        return ret;
        
    }
	
	boolean isValid(String item) {
		char c = item.charAt(0);
		if ( c != '0')
			return true;
		else {
			return false;
		}
	}
    
	
	
}
