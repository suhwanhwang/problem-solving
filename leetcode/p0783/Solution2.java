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

    private TreeNode prevNode;
    private int minDiff;
    public int minDiffInBST(TreeNode root) {
        prevNode = null;
        minDiff = Integer.MAX_VALUE;

        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        if (prevNode != null) {
            minDiff = Math.min(minDiff, root.val - prevNode.val);
        }
        prevNode = root;
        inOrder(root.right);
    }
}
