package dync;

import java.util.TreeMap;

/*
  https://leetcode.com/contest/weekly-contest-119/problems/odd-even-jump/
Input: [10,13,12,14,15]
Output: 2
Explanation: 
From starting index i = 0, we can jump to i = 2 (since A[2] is the smallest among A[1], A[2], A[3], A[4] that is greater or equal to A[0]), then we can't jump any more.
From starting index i = 1 and i = 2, we can jump to i = 3, then we can't jump any more.
From starting index i = 3, we can jump to i = 4, so we've reached the end.
From starting index i = 4, we've reached the end already.
In total, there are 2 different starting indexes (i = 3, i = 4) where we can reach the end with some number of jumps.

add test
*/




public class OddEvenJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddEvenJumps test = new OddEvenJumps();
		int[] A = {10, 13, 12, 14, 15};
		
		System.out.println("resutl: " + test.oddEvenJumps(A));

	}
	
	public int oddEvenJumps(int[] A) {
        if ( A.length == 0)
            return 0;
        
        if (A.length == 1)
            return 1;
        
        int N = A.length;
        boolean [] odd = new boolean[N];
        boolean [] even = new boolean[N];
        
        odd[N-1] = true;
        even[N-1]  = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[N-1], N-1);
        
        for (int i = N-2; i>= 0; i--) {
            int key = A[i];
            
            Integer l1 = null, h2 = null;
            if (map.containsKey(key)) {
                odd[i]  = even[map.get(key)];
                even[i] = odd[map.get(key)];
            } else {
            	l1 = map.lowerKey(key);
            	h2 = map.higherKey(key);
                if (l1 != null) {
                    even[i] = odd[map.get(l1)];
                } 
                if (h2 != null) {
                    odd[i] = even[map.get(h2)];
                }
            }
            
            map.put(key, i);            
        }
        
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (odd[i])
                ans++;
        }
        return ans;
        
        
    }

}
