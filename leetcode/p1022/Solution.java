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
    private int sum;
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }
    
    private void dfs(TreeNode node, int num) {
        if (node == null) {
            return;
        }
        
        num = (num << 1) + node.val;
        if (node.left == null && node.right == null) {
            sum += num;
            return;
        }
        
        dfs(node.left, num);
        dfs(node.right, num);
    }
}
