/**
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
    int leftSum;
    public int sumOfLeftLeaves(TreeNode root) {
        leftSum = 0;
        dfs(root);
        return leftSum;
    }
    private void dfs(TreeNode node) {
        if (node == null) return;
        
        if (node.left != null && node.left.left == null && node.left.right == null) {
            leftSum += node.left.val;
        } else {
            dfs(node.left);
        }
        dfs(node.right);
    }
