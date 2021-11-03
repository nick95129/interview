/**
2018,12.05
	Leetcode 207
*/
import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] inDepth = new int[numCourses];
        Arrays.fill(inDepth, 0);
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            int course = prerequisites[i][0];
            int req = prerequisites[i][1];
            System.out.println("re1: " + course);
            
            if (map.containsKey(req)) {
                Set<Integer> set = map.get(req);
                set.add(course);
            } else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(course);
                map.put(req, set);
            }
            inDepth[course] ++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++ ) {
            if ( inDepth[i] == 0 ) {
                queue.add(i);
            }
        }
        
        int numReq  = queue.size();
        
        while (!queue.isEmpty()) {
            int free = queue.poll();
            
            if (map.containsKey(free)) {
                Set<Integer> set  = map.get(free);
                for (Integer c2 : set ) {
                    inDepth[c2] --;
                    if (inDepth[c2] == 0) {
                        queue.add(c2);
                        numReq++;
                    }
                }
                
            } 
            map.remove(free);
        }
        
        return (numReq == numCourses)? true: false;
       
    }   
   
}
