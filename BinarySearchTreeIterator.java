/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/

import java.util.*;
public class BinarySearchTreeIterator {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	public Stack<TreeNode> stack = new Stack<>();
	public BinarySearchTreeIterator(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
	public boolean hasNext() {
		if (stack.isEmpty())
			return false;
		return true;
	}
	public int next() {
		TreeNode res = null;
		if (!stack.isEmpty()) {
			res = stack.pop();
			if (res.right != null) {
				TreeNode temp = res.right;
				while (temp != null) {
					stack.push(temp);
					temp = temp.left;
				}
			}
		}
		return res.val;
	}
}
