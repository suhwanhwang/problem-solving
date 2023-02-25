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
    private List<TreeNode> list = new ArrayList<>();
    
    public void flatten(TreeNode root) {
        dfs(root);
        
        TreeNode prev = null;
        for (TreeNode node : list) {
            node.left = null;
            if (prev == null) {
                prev = node;
            } else {
                prev.right = node;
                prev = node;
            }    
        }
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}
