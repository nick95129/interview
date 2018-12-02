package algorithm;

import java.util.Arrays;

public class LargestTimeFromDigits {

	 public String largestTimeFromDigits(int[] A) {
	        int hours = 0;
	        int minutes = 0;
	        int total = -1;
	        String ret = "";
	        
	        for (int i = 0; i < A.length; i++) {
	         for (int j = 0; j < A.length; j++) {
	             hours = A[i] *10 + A[j];
	             if (i != j && (hours < 24) ) {
	                 for (int k = 0; k < A.length; k++) {
	                     if (k != i && k != j) {
	                         int l = 3+2+1 -i-j-k;
	                         minutes = A[k]*10+A[l];
	                         if (minutes < 60) {
	                             total = Math.max(total, hours * 60 + A[k]*10+A[l]);
	                         }
	                     }
	                }
	             }
	          }
	       }
	        
	        return total >= 0 ? String.format("%02d:%02d", total/60, total%60) : "";       
	    }
	 

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1, 2, 3, 4};
		//int [] A = {2,0,6,6};
		LargestTimeFromDigits test = new LargestTimeFromDigits();
		String ret = test.largestTimeFromDigits(A);
		
		System.out.println("Results: " + ret);

	}

}
