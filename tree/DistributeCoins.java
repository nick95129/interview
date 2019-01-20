package tree;

// https://leetcode.com/contest/weekly-contest-120/problems/distribute-coins-in-binary-tree/

public class DistributeCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// dist[0]: total move
	// dist[1]: balance coin
	// 
	public int distributeCoins(TreeNode root) {
        int[] dist = new int[1];
        distributeCoins(root, dist);
        
        return dist[0];
    }
	
	public void distributeCoins(TreeNode root, int[] dist) {
		
		if (root == null)
			return ;
		
		if (root.left != null) {
			distributeCoins( root.left, dist) ;
			root.val += root.left.val-1;
		}
		
		if (root.right != null) {
			distributeCoins( root.right, dist) ;
			root.val += root.right.val-1;
		}
		

		dist[0] += Math.abs(root.val-1);
		
	}
}
