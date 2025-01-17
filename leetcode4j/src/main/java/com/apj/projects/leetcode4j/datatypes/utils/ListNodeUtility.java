package com.apj.projects.leetcode4j.datatypes.utils;

import com.apj.projects.leetcode4j.datatypes.ListNode;

/**
 * Utility class for ListNode datatype in Leetcode which manages printing and
 * population of data.
 */
public class ListNodeUtility {

	/**
	 * Populated the LinkedList by passing the input num array and returns the head
	 * of the LinkedList
	 * 
	 * @param nums
	 * @return head ListNode (first element of LinkedList)
	 */
	public static ListNode populate(Integer[] nums) {

		ListNode head = new ListNode();
		ListNode current = null;

		for (int num : nums) {
			if (head.val == null) {
				head = new ListNode(num);
				current = head;
			} else {
				current.next = new ListNode(num);
				current = current.next;
			}
		}
		return head;
	}

	/**
	 * Prints the LinkedList
	 * 
	 * @param head : first element of linkedList
	 */
	public static void print(ListNode head) {
		while (head != null) {
			System.out.print(head + " ==> ");
			head = head.next;
		}
		System.out.println();
	}
}