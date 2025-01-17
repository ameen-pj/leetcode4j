package com.apj.projects.leetcode4j.datatypes.utils;

import com.apj.projects.leetcode4j.datatypes.ListNode;
import com.apj.projects.leetcode4j.datatypes.TreeNode;
import com.apj.projects.leetcode4j.datatypes.exceptions.BadInputException;

/**
 * Handles all the input conversion and validation of complex data types such as
 * LinkedList and BinaryTree
 */
public class LeetcodeInputTransformer {

	private String input;

	/**
	 * Initializes the transformer by passing the input string
	 * 
	 * @param input
	 */
	public LeetcodeInputTransformer(String input) {
		this.input = input;
	}

	/**
	 * Transforms the input string to int array. ( NOTE: The input string must start
	 * with '[' and should end with ']' with numbers seperated by a comma ',' eg -
	 * [1, 2, 3] )
	 * 
	 * @return Integer[] 1D array
	 * @throws BadInputException
	 */
	public Integer[] transformTo1DIntArray() throws BadInputException {

		if (input.contains("[") && input.contains("]")) {

			String[] splitted = input.substring(input.indexOf('[') + 1, input.indexOf(']')).split(",");
			int length = splitted.length;
			Integer[] result = new Integer[length];

			for (int i = 0; i < length; i++) {
				try {
					String s = splitted[i].trim().toLowerCase();
					if (s.equals("null")) {
						result[i] = null;
					} else {
						int a = Integer.valueOf(s);
						result[i] = a;
					}

				} catch (NumberFormatException e) {
					throw new BadInputException("Could not convert " + splitted[i].trim() + " to int");
				}
			}
			return result;
		} else {
			throw new BadInputException("Could not find array identifier \'[\' or \']\'");
		}
	}

	/**
	 * Transforms the input string to String array. ( NOTE: The input string must
	 * start with '[' and should end with ']' with string seperated by a comma ','
	 * eg - [hello, world, !] )
	 * 
	 * @return String[] 1D array
	 * @throws BadInputException
	 */
	public String[] transformTo1DStringArray() throws BadInputException {

		if (input.contains("[") && input.contains("]")) {

			String[] splitted = input.substring(input.indexOf('[') + 1, input.indexOf(']')).split(",");
			int length = splitted.length;
			String[] result = new String[length];

			for (int i = 0; i < length; i++) {
				result[i] = splitted[i].trim();
			}
			return result;
		} else {
			throw new BadInputException("Could not find array identifier \'[\' or \']\'");
		}
	}

	/**
	 * Transforms the input int array to Linked list ( NOTE: The input string must
	 * start with '[' and should end with ']' with string seperated by a comma ','
	 * eg - [hello, world, !] )
	 * 
	 * @return head ListNode (i.e first element of the LinkedList)
	 * @throws BadInputException
	 */
	public ListNode transformToIntegerLinkedList() throws BadInputException {

		Integer[] intArr = transformTo1DIntArray();
		ListNode head = ListNodeUtility.populate(intArr);
		return head;
	}

	/**
	 * Transforms the input int array to Binary Search Tree ( NOTE: The input string
	 * must start with '[' and should end with ']' with string seperated by a comma
	 * ',' eg - [hello, world, !] )
	 * 
	 * @return head ListNode (i.e first element of the LinkedList)
	 * @throws BadInputException
	 */
	public TreeNode transformToIntegerBST() throws BadInputException {
		Integer[] intArr = transformTo1DIntArray();
		TreeNode root = TreeNodeUtility.populate(intArr);
		return root;

	}
}
