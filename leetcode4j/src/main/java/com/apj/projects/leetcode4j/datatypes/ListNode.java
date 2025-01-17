package com.apj.projects.leetcode4j.datatypes;

/**
 * This class implements the ListNode class in Leetcode (primarily used in
 * LinkedList problems)
 */
public class ListNode {

	/**
	 * Contains the value of a particular ListNode
	 */
	public Integer val;
	/**
	 * Contains the reference to next ListNode
	 */
	public ListNode next;

	/**
	 * Initializes an empty ListNode
	 */
	public ListNode() {
	}

	/**
	 * Initializes a new ListNode by passing the ListNode value
	 * 
	 * @param val
	 */
	public ListNode(Integer val) {
		this.val = val;
	}

	/**
	 * Initializes a new ListNode by passing the ListNode value and by passing the
	 * reference to the next ListNode
	 * 
	 * @param val
	 * @param next
	 */
	public ListNode(Integer val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "[" + val + "]";
	}
}
