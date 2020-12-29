/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
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
    List<Integer> ans;
    private void solve(TreeNode node) {
        if (node == null) {
            return;
        }
        
        solve(node.left);
        ans.add(node.val);
        solve(node.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        solve(root);
        return ans;
    }
}
