package com.test;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

public class Demo {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);

		root.left = new TreeNode(5);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);

		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);

		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		// p and q
		TreeNode p = root.left; // 5
		TreeNode q = root.left.right.right; // 4

		// call your function
		TreeNode lca = lowestCommonAncestor(root, p, q);

		// System.out.println(lca.val); // Expected: 3
		// System.out.println(root.left.right.right.val);
	}

	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (p.left != null && p.left.val == root.val) {

			lowestCommonAncestor(root, p, q);
		}

		return new TreeNode(0);
	}
}