package dync;

import tree.TreeNode;

public class MinCameraCover {

    public int minCameraCover(TreeNode root) {
        int[] cnt = new int[1];
        int status = dfs(root, cnt);     
        if (status == 0) {
            cnt[0]++;
        }
        return cnt[0];
    }
    
    int dfs(TreeNode root, int[] cnt) {
        if (root == null)
            return 2;
        
        int left = dfs(root.left, cnt);
        int right = dfs(root.right, cnt);
        
        if (left == 0 || right == 0) {
            cnt[0] ++;
            return 1;
        } else if (left == 1 || right == 1) {
            return 2;
        } 
      else                  
        return 0;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinCameraCover test = new MinCameraCover();
		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(0);
		TreeNode lleft = new TreeNode(0);
		TreeNode llleft = new TreeNode(0);
		TreeNode lllright = new TreeNode(0);
		left.left = lleft;
		lleft.left = llleft;
		llleft.right = lllright;
		root.left = left;
		System.out.println("result:" + test.minCameraCover(root));
		

	}

}
