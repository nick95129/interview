import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        buildMap(A, B, map1);
        
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        buildMap(C, D, map2);
       
        int ret = 0;
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(-key)) {
                ret += map2.get(-key) * map1.get(key);                    
            }     
        }
        
        return ret;       
    }
    
    void buildMap(int[] A, int[] B, HashMap<Integer, Integer> map1) {
        int n = A.length;
        Set<String> set1 = new HashSet<String>(); 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = A[i] + B[j];
                if (map1.containsKey(key)) {
	                	map1.put(key, map1.get(key) +1);
	                } else {
	                	map1.put(key, 1);
	                }
            }
        }
    }
}