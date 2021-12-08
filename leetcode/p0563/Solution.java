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
    public int findTilt(TreeNode root) {
        return helper(root);
    }
    
    private int helper(TreeNode node) {
        if (node == null) return 0;
        
        int diff = Math.abs(sum(node.left) - sum(node.right));
        return diff + helper(node.left) +
        helper(node.right);
    }
    
    private int sum(TreeNode node) {
        if (node == null) return 0;
        
        return node.val + sum(node.left) + sum(node.right);
    }
}
