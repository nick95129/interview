package tree;

public class TreeToStr {
	public String tree2Str(TreeNode node) {
		String ret = "";
		
		if (node == null) {
			return ret;
		}
		
		ret += String.valueOf(node.val);
		
		if (node.right == null) {
			if (node.left == null)
				return ret;
			else {
				return ret += "(" + tree2Str(node.left) +")";
			}
		} else {
			 ret += "(" + tree2Str(node.left) +")";
			 ret += "(" + tree2Str(node.right) +")";
		}
		
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		TreeNode leflright = new TreeNode(4);
		left.right = leflright;
		
		TreeToStr test = new TreeToStr();
		String ret = test.tree2Str(root);
		
		System.out.println("result: " + ret);

	}

}
