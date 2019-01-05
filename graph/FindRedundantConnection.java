
// https://leetcode.com/problems/redundant-connection/submissions/
class findRedundantConnection1 {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind help = new UnionFind(edges.length+1);
        for (int[] edge : edges) {
            if (help.find(edge[0], edge[1])) {
                return edge;
            }
            help.union(edge[0], edge[1]);
        }
        
        return new int[0];
    }
    
    class UnionFind {
        int[] parents;
        public UnionFind(int n) {
            parents = new int[n];
            for (int i =1; i < n; i++) {
                parents[i] = i;
            }
        }
        
        public void union(int start, int end) {
            int parent = parents[end];
            
            for (int i = 1; i < parents.length; i++) {
                if (parents[i] == parent) {
                    parents[i] = parents[start];
                }
            }
            
        }
        
        public boolean find(int start, int end) {
            return parents[start] == parents[end];
        }
    }
}