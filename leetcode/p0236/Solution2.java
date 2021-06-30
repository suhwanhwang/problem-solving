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
    private Map<TreeNode, TreeNode> parent = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        dfs(root, null);
        
        Set<TreeNode> parentSet = new HashSet<>();
        TreeNode cur = p;
        while(cur != null) {
            parentSet.add(cur);
            
            TreeNode next = parent.get(cur);
            cur = next;
        }
        
        cur = q;
        while(cur != null) {
            if (parentSet.contains(cur)) {
                return cur;
            }
            TreeNode next = parent.get(cur);
            cur = next;
        }
        return null;
    }
    
    private void dfs(TreeNode node, TreeNode p) {
        if (node == null) {
            return;
        }
        parent.put(node, p);
        
        dfs(node.left, node);
        dfs(node.right, node);
    }
}
