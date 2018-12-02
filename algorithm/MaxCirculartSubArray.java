
/**
https://leetcode.com/contest/weekly-contest-105/problems/maximum-sum-circular-subarray/
918. Maximum Sum Circular Subarray

Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  
(Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  
(Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
*/
public class MaxCirculartSubArray {

	 public int maxSubarraySumCircular(int[] A) {
	        
	        int max = A[0];
	        int max_start = 0;
	        int max_end = 0;
	        
	        int tillNow = A[0];
	        int tillNow_start=0;
	        int tillNow_end = 0;
	        
	        for (int start = 0; start < A.length; start++) {
	        	tillNow = A[start];
	        	tillNow_start=start;
	        	tillNow_end = start;
	        	
		        for (int i = start+1; i < 2*A.length-1; i ++) {
		        	if (tillNow_end - tillNow_start >= A.length-1 )
		        		break;	        	
		        	
		        	int i2 = (i>=A.length ? i-A.length: i);
		            if (tillNow > 0) {
		            	tillNow += A[i2];
		            } else {
		            	start = i;
		                tillNow = A[i2];
		                tillNow_start = i;
		            }
		        	
		            tillNow_end = i;
		            if (max <= tillNow) {
		            	max = tillNow;
		            	max_start = tillNow_start;
		            	max_end = tillNow_end;
		            }


		        }
		        	        	
	        
	        }

	        return max;
	        
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaxCirculartSubArray test = new MaxCirculartSubArray();
		//int[] A = {3,-1,2,-1};
		//int[] A = {-2,-3,-1};
		int[] A = {5,-3,5};
		System.out.println("Result: " + test.maxSubarraySumCircular(A));

	}

}
