/**
https://leetcode.com/problems/binary-tree-maximum-path-sum/

Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any node sequence from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
 

Constraints:

The number of nodes in the tree is in the range [0, 3 * 104].
-1000 <= Node.val <= 1000

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
    int maxSum;
    private int solve(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftSum = Math.max(0, solve(node.left));
        int rightSum = Math.max(0, solve(node.right));
        
        maxSum = Math.max(maxSum, leftSum + node.val + rightSum);
        return node.val + Math.max(leftSum, rightSum);
    }
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}
