/**
https://leetcode.com/problems/maximum-depth-of-binary-tree/

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

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
    int max = 0;
    private void dfs(TreeNode node, int d) {
        if (node == null) {
            return;
        }
        
        dfs(node.left, d+1);
        max = Math.max(max, d);
        dfs(node.right, d+1);
    }
    public int maxDepth(TreeNode root) {
        max = 0;
        dfs(root, 1);
        return max;
    }
}
