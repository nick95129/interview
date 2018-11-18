package dync;

/*
 * We are given S, a length n string of characters from the set {'D', 'I'}. (These letters stand for "decreasing" and "increasing".)

A valid permutation is a permutation P[0], P[1], ..., P[n] of integers {0, 1, ..., n}, such that for all i:

If S[i] == 'D', then P[i] > P[i+1], and;
If S[i] == 'I', then P[i] < P[i+1].

 */
public class DiStringMatch {

	  public int[] diStringMatch(String S) {
	        int[] ret = new int[S.length()+1];
	        
	        int N = S.length();
	        for (int i = 0; i <= N; i++) {
	            ret[i] = i;
	        }
	        
	        for (int i = 0; i < N; i++) {
	            if (S.charAt(i) == 'D') {
	                int j = i; 
	                while( i < N && S.charAt(i) == 'D' ) {
	                    i++;
	                }
	                if (i > j)
	                	switchPos(ret, j, i);
	            }
	        }
	 
	        return ret;
	    }
	    
	    void switchPos(int[] arr, int start, int end) {
	        int i = start, j = end;
	        while (j > i) {
	            int temp = arr[j];
	            arr[j] = arr[i];
	            arr[i] = temp;
	            i++;
	            j--;
	        }
	        
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DIMatching test = new DIMatching();
		String S = "IDID";
		
		int[] ret = test.diStringMatch(S);
		for (int i = 0; i < ret.length; i++) {
			System.out.print(" " + ret[i]);
		}
			

	}

}