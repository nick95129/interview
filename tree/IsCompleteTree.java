package tree;

import java.util.Queue;
import java.util.LinkedList;

public class IsCompleteTree {
	
  public boolean isCompleteTree(TreeNode root) {  
       if (root == null || (root.left == null && root.right == null)  ) {
           return true;
       } 
       
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.add(root);       
       return isCompleteTree(queue);
    }
	    
     public boolean isCompleteTree(Queue<TreeNode> queue) {
             
        boolean haveNext = true; 
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	
        	for (int i =0; i < size; i++) {
            	TreeNode node = queue.poll();
            	if (haveNext) {            		
            		if (node.left == null ) {
            			haveNext = false;
                		if (node.right != null)
                			return false;
                	}
                	else if (node.right == null) {
                		haveNext = false;
                        queue.add(node.left);
                 	} else {
                		queue.add(node.left);
                		queue.add(node.right);
                	}
            	}
            	else {
            		if (node.left != null || node.right != null)
            			return false;
            	}        		
        	}

        }
        
        return true;
     }

	     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsCompleteTree test = new IsCompleteTree();
		// [1,2,3,5,null,7,8]
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		
		TreeNode lleft = new TreeNode(4);
		TreeNode lright = new TreeNode(5);		
		left.left = lleft;
		//left.right = lright;
		
		TreeNode rleft = new TreeNode(6);
		TreeNode rright = new TreeNode(7);	
		//right.left = rleft;
		//right.right = rright;
		
		System.out.println("Result: " + test.isCompleteTree(root));
		

	}

}
