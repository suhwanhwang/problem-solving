/*
https://leetcode.com/problems/diameter-of-binary-tree/description/

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
    int maxDepth;
    public int diameterOfBinaryTree(TreeNode root) {
        
        dfs(root);
        return maxDepth;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        
        
        int leftH = dfs(node.left);
        int rightH = dfs(node.right);
        maxDepth = Math.max(maxDepth, leftH + rightH);
        
        return 1 + Math.max(leftH, rightH);
    }
}
