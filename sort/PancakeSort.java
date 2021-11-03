package sort;

import java.util.List;
import java.util.ArrayList;

public class PancakeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PancakeSort test = new PancakeSort();
		int[] A = {3, 2, 4, 1}; //4,2,43
		//int[] A = {1, 2, 5, 3, 4};
		//int[] A = {1, 3,  2};
		List<Integer> ret = test.pancakeSort(A);
		System.out.println("Result: ");
		for (int i = 0; i < ret.size();i++) {
			System.out.println(" " + ret.get(i));
		}

	}

	public List<Integer> pancakeSort(int[] A) {
	        
	        List<Integer> ret = new ArrayList<Integer>();
	        if (A.length <= 1)
	            return ret;
	        
	        for (int i = A.length; i > 0; i--) {
	            pancakeSort(A, i, i-1, ret);
	        }      
	        return ret;	        
	    }
	    
	    void pancakeSort(int[] A, int target, int last, List<Integer> res) {
	        if (A[last] == target)
	            return;
	        
	        int k = last;
	        for (k =last; k >0; ) {
	        	if (A[0] == target)
	        		break;
	        	
	        	k = calcFlip(A, target, k);
	        	res.add(k+1);
	        	reverse(A, k);	        	
	        }
        	res.add(last+1);
        	reverse(A, last);	
	    }
	    
	    int calcFlip(int[] A, int target, int end) {
	    	int pos = 0;
	    	for (pos = 0; pos <=end; pos++) {
	    		if (A[pos] == target) {
	    			break;
	    		}
	    	}
	    	
	    	int len = end+1;
	    	int mid = (len%2==1) ? len/2 : len/2-1;
	    	mid = (mid==0) ? 1 : mid;
	    	if (pos > mid) {
	    		return end;
	    	} else {
	    		return mid;
	    	}
	    }
	    
	    void reverse(int[] A, int end) {
	    	int i = 0, j = end;
	    	while ( i < j) {
	    		int temp = A[i];
	    		A[i] = A[j];
	    		A[j] = temp;
	    		i++;
	    		j--;	    			
	    	}	    	
	    }
}
