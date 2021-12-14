/*
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
    private int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root, low, high);
        return sum;
    }
    private void dfs(TreeNode node, int low, int high) {
        if (node == null) return;
        
        dfs(node.left, low, high);
        
        if (low <= node.val && node.val <= high) {
            sum += node.val;
        }
        
        dfs(node.right, low, high);
    }
}
