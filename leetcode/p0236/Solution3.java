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
    private final Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, null);
        
        for (TreeNode node1 = p; node1 != null; node1 = parentMap.get(node1)) {
            for (TreeNode node2 = q; node2 != null; node2 = parentMap.get(node2)) {
                if (node1 == node2) {
                    return node1;
                }
            }
        }
        return null;
    }
    
    private void dfs(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        
        parentMap.put(node, parent);
        dfs(node.left, node);
        dfs(node.right, node);
    }
}
