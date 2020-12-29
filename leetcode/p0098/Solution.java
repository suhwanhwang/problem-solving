/**
https://leetcode.com/problems/validate-binary-search-tree/

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> order;
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        
        dfs(node.left);
        order.add(node.val);
        dfs(node.right);
    }
    
    public boolean isValidBST(TreeNode root) {
        order = new ArrayList<>();
        dfs(root);
        
        if (order.size() <= 1) {
            return true;
        }
        
        for (int i = 1; i < order.size(); ++i) {
            if (order.get(i - 1) >= order.get(i)) {
                return false;
            }
        }
        return true;
    }
}
