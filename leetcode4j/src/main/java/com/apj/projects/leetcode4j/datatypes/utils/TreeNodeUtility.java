package com.apj.projects.leetcode4j.datatypes.utils;

import com.apj.projects.leetcode4j.datatypes.TreeNode;

/**
 * Utility class for TreeNode datatype in Leetcode which manages printing and
 * population of trees.
 */
public class TreeNodeUtility {

	/**
	 * Populated the TreeNode by passing the input num array and returns the root of
	 * the Binary Tree
	 * 
	 * @param inputNumArr
	 * @return root TreeNode
	 */
	public static TreeNode populate(Integer[] inputNumArr) {

		TreeNode tree = new TreeNode();
		if (inputNumArr.length == 0) {
			return null;
		}
		// setting root
		tree.val = inputNumArr[0];
		populateSub(tree, inputNumArr, 0);
		return tree;
	}

	private static void populateSub(TreeNode tree, Integer[] vals, int currentPos) {

		TreeNode left = new TreeNode();
		TreeNode right = new TreeNode();

		if ((2 * currentPos) + 1 < vals.length && vals[(2 * currentPos) + 1] != null) {
			left.val = vals[(2 * currentPos) + 1];
			tree.left = left;
			populateSub(left, vals, (2 * currentPos) + 1);
		} else {
			tree.left = null;
		}

		if ((2 * currentPos) + 2 < vals.length && vals[(2 * currentPos) + 2] != null) {
			right.val = vals[(2 * currentPos) + 2];
			tree.right = right;
			populateSub(right, vals, (2 * currentPos) + 2);
		} else {
			tree.right = null;
		}

	}
}