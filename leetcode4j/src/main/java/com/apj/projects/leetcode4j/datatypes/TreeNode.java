package com.apj.projects.leetcode4j.datatypes;

/**
 * This class implements the TreeNode class in Leetcode (primarily used in
 * Binary Tree problems)
 */
public class TreeNode {

	/**
	 * Contains the value of a particular TreeNode
	 */
	public int val;
	/**
	 * Contains the reference to the left child TreeNode
	 */
	public TreeNode left;
	/**
	 * Contains the reference to the right child TreeNode
	 */
	public TreeNode right;

	/**
	 * Initializes a empty TreeNode object
	 */
	public TreeNode() {
	}

	/**
	 * Initializes a new TreeNode object by passing it's value
	 * 
	 * @param val
	 */
	public TreeNode(int val) {
		this.val = val;
	}

	/**
	 * Initializes a new TreeNode object by passing it's value, left child TreeNode,
	 * right child TreeNode
	 * 
	 * @param val
	 * @param left
	 * @param right
	 */
	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}