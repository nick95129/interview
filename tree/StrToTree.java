package tree;

import java.util.Stack;

public class StrToTree {

	public TreeNode str2Tree(String s) {
		
		if (s == null || s.length() == 0)
			return null;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (Character.isDigit(c) || c == '-') {
				int j = i;
				while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
					i++;
				}
				TreeNode curt = new TreeNode(Integer.valueOf(s.substring(j, i+1)));
				if (stack.isEmpty()) {
					stack.push(curt);
				} else {
					TreeNode parent = stack.peek();
					if (parent.left == null) 
						parent.left = curt;
					else 
						parent.right = curt;
					stack.push(curt);
				}
			}
			if ( c == ')')
				stack.pop();
		}
		return stack.pop();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrToTree test = new StrToTree();
		String s = "4(2(3)(1))(6((5))";
		
		TreeNode root = test.str2Tree(s);
		root.print();

	}

}
