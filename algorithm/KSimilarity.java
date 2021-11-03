package algorithm;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
//https://leetcode.com/problems/k-similar-strings/submissions/
public class KSimilarity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "abccaacceecdeea";
		String B = "bcaacceeccdeaae";
		KSimilarity test = new KSimilarity();
		
		System.out.println("result: " + test.kSimilarity(A, B));
	}
	
	Map<char[], Integer> map = new HashMap<char[], Integer>();
	
	public int kSimilarity(String A, String B) {
        int[] ss = new int[1];
        ss[0] = Integer.MAX_VALUE;
        return dfs(A.toCharArray(), B.toCharArray(), 0, ss);
    }
    

	int dfs(char[] A, char[] B, int pos, int[] ss) {
		if (pos == A.length) {
			return 0;
		}
		
		if (A[pos] == B[pos])
			return dfs(A, B, pos+1, ss);
		
		int mn = Integer.MAX_VALUE;
        for (int j = pos+1; j < A.length; j++) {
            if (A[j] == B[j] || A[j] != B[pos])
                continue;
            
            swap (A, pos, j);                
            
            int cnt = dfs(A, B, pos+1, ss);
            mn = Math.min(cnt+1, mn);
            swap(A, pos, j);
        }
        ss[0] = mn;
        return ss[0];
 
         
    }
    
    void swap (char[] A, int i, int j) {
        char c = A[i];
        A[i] = A[j];
        A[j] = c;
    }
}
