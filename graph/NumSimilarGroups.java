package graph;

import java.util.Map;
import java.util.HashMap;

// https://leetcode.com/problems/similar-string-groups/submissions/
public class NumSimilarGroups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] A = {"tars","rats","arts","star"};
		String[] A = {"aaaaaaaaa","aaaaaaaaa","aaaaaaaaa","aaaaaaaaa"};
		
		NumSimilarGroups test = new NumSimilarGroups();
		System.out.println("result: " + test.numSimilarGroups(A));
		

	}

    public int numSimilarGroups(String[] A) {
        if (A == null || A.length == 0)
            return 0;
        
        ParUnion pu = new ParUnion(A);
        for (int i =0; i < A.length-1; i++) {
            for (int j = i+1; j < A.length; j++) {
            	if (similar(A[i], A[j]))
            		pu.union(i, j);
            }
        }

        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
    	for (int i = 0; i < A.length;i++) {
    		int help = pu.find(i);
    		if (map2.containsKey(help)) {
    			map2.put(help, map2.get(help)+1);
    		} else {
    			map2.put(help, 1);
    		}
    	}
        return map2.size();
    }
    
    boolean similar(String s1, String s2) {

    	int cnt = 0;
    	for (int i =0; i < s1.length(); i++) {
    		if (s1.charAt(i) != s2.charAt(i))
    				cnt++;
    	}
    	if (cnt > 2)
    		return false;
    	else 
    		return true;
    }
	    
    class ParUnion {
        String[] A;
        int[] parent;
        Map<String, Integer> map;
        
        ParUnion(String[] A) {
            int N = A.length;
            this.A = A;
            map = new HashMap<String, Integer>();
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                map.put(A[i], i);
            }
           
        }
        
        public String find(String str) {
        	int index = map.get(str);
        	int ret = find(index);
        	
        	return A[ret];
        	
        }
        
        public int find(int index) {
        	if (parent[index] != index) {
        		parent[index] = find(parent[index]);
        	}
        	return parent[index];
        	
        }
        
        public void union(String s1, String s2) {
        	int i1 = map.get(s1);
        	int i2 = map.get(s2);
        	
        	parent[find(i1)] = find(i2);
        	
        }
        public void union(int i1, int i2) {        	
        	parent[find(i1)] = find(i2);
        	
        }
        
    }
}
