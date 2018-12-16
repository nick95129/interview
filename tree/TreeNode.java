package tree;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int in) {
		this.val = in;
		left = null;
		right = null;
	}
	
	public int getValue() {
		return val;
	}
	
	public void print() {
		System.out.println(val);
		if (left != null)
			left.print();
		if (right != null)
			right.print();
	}
}
