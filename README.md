# Leetcode4j ⚡

*A simple Leetcode testing library for Java.*

## Advantages ✨

* Use your favourite IDE
* Multiple utility classes to save time and assist users in solving problems more efficiently.
* Debug your solutions locally on your machine without subscribing to 'LeetCode Premium'.

## **Installation** ⬇️

1. Clone this project
2. Make sure that you have maven installed and run the following command
```
>>> mvn clean install
```
3. Create a new maven project and add the project to your pom.xml file
```
<dependency>
    <groupId>com.apj.projects</groupId>
    <artifactId>leetcode4j</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```
4. Now you are all set to use Leetcode4j !!


## **Manual** 📖

1. Create an entry point for your application and configure the package name which contains the leetcode problems.
 
**App.java**
```
import com.apj.projects.leetcode4j.core.LeetcodeProblemManager;

public class App {
    public static void main(String[] args) {
        LeetcodeProblemManager mgr = new LeetcodeProblemManager("PCKG_NAME");
        mgr.runTestCases();
    }
}

```
2. Create a problem class and annotate the class with @LeetcodeProblem and the testcase methods with @TestCase

**com.leetcode.problems.validBST.java**
```
package com.leetcode.problems;

import java.util.LinkedList;

import com.apj.projects.leetcode4j.annotations.LeetcodeProblem;
import com.apj.projects.leetcode4j.annotations.TestCase;
import com.apj.projects.leetcode4j.datatypes.TreeNode;
import com.apj.projects.leetcode4j.datatypes.utils.LeetcodeInputTransformer;
import com.apj.projects.leetcode4j.datatypes.utils.TreeNodeUtility;

@LeetcodeProblem
public class ValidBST {

	@TestCase
	public void T1() {
		System.out
				.println(new ValidBST().isValidBST(new LeetcodeInputTransformer("[2, 1, 3]").transformToIntegerBST()));
	}

	@TestCase
	public void T2() {
		System.out.println(new ValidBST()
				.isValidBST(new LeetcodeInputTransformer("[5, 1, 4, null, null, 3, 6]").transformToIntegerBST()));
	}

	@TestCase
	public void T3() {
		System.out.println(new ValidBST().isValidBST(new LeetcodeInputTransformer("[2,2,2]").transformToIntegerBST()));

	}

    // CODE

	private LinkedList<Integer> stack = new LinkedList<Integer>();

	public boolean isValidBST(TreeNode root) {

		if (root == null)
			return true;

		boolean b1 = isValidBST(root.left);
		if (stack.size() > 0 && stack.peek() >= root.val)
			return false;

		stack.addFirst(root.val);
		boolean b2 = isValidBST(root.right);
		System.out.println(stack);
		return b1 && b2;
	}

}



```
3. Run App.java
