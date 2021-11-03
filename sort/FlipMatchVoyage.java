package sort;

/*
 * https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import tree.TreeNode;

public class FlipMatchVoyage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlipMatchVoyage test = new FlipMatchVoyage();
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		int[] voyage = {1, 3, 2};
		List<Integer> res = test.flipMatchVoyage(root, voyage);
		
		System.out.println("result: ");
		for (Integer it : res) {
			System.out.println(" " + it);
		}

	}
	
	int pos = 0;
	int[] voyage = null;
	
	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		
		this.voyage = voyage;	
		this.pos = 0;
		List<Integer> res = new ArrayList<Integer>();	
		
		if (!flipMatchVoyage(root, res)) {
			List<Integer> dum = new ArrayList<Integer>();
			dum.add(-1);
			return dum;
		}
		else {
			return res;
		}			        
    }
	
	
	boolean flipMatchVoyage(TreeNode root,  List<Integer> res) {		
		if (root == null)
			return true;
		
		if (pos >= voyage.length || root.val != voyage[pos]) {
			return false;
		}
		
		pos++;
		if (root.left == null) {
			if (root.right == null) {
				return true;
			} else {	
				
				return flipMatchVoyage(root.right, res);
			}
		} else {
			if (root.right == null) {
				return flipMatchVoyage(root.left, res); 
			} else {
				//pos++;
				if (voyage[pos] == root.left.val) { 
					return flipMatchVoyage(root.left, res) && flipMatchVoyage(root.right, res);
				} else if (voyage[pos] == root.right.val) {
					res.add(root.val);
					return flipMatchVoyage(root.right, res) && flipMatchVoyage(root.left, res);
				} else {
					return false;
				}
			}
				
		}
		
	}

}
