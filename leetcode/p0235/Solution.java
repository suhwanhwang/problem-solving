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
    private Map<TreeNode, TreeNode> map;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        map = new HashMap<>();
        
        makeParent(root, null);
        
        Set<TreeNode> set = new HashSet<>();
        TreeNode cur = p;
        while (cur != null) {
            set.add(cur);
            cur = map.get(cur);
        }
        
        cur = q;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = map.get(cur);
        }
        return null;
    }
    
    private void makeParent(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        
        if (parent != null) {
            map.put(node, parent);
        }
        makeParent(node.left, node);
        makeParent(node.right, node);
    }
}
