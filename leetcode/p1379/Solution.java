/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode clonedTarget = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(original, cloned, target);
        return clonedTarget;
    }
    
    private void dfs(TreeNode root, TreeNode cloned, TreeNode target) {
        if (root == null) {
            return;
        }
        if (root == target) {
            clonedTarget = cloned;
        }
        dfs(root.left, cloned.left, target);
        dfs(root.right, cloned.right, target);
    }
}
