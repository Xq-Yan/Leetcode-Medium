/*
98. Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Solution {
    List<Integer> res = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        inorder(root);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) <= res.get(i - 1)) return false;
        }
        return true;
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            res.add(root.val);
            inorder(root.right);
        }
    }
}
