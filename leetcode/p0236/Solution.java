/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean dfs(TreeNode cur, TreeNode p, List<TreeNode> anc) {
        if (cur == null) {
            return false;
        }
        anc.add(cur);
        if (cur == p) {
            return true;
        }
        
        if (dfs(cur.left, p, anc)) return true;
        
        if (dfs(cur.right, p, anc)) return true;
        
        anc.remove(anc.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        
        List<TreeNode> pAnc = new ArrayList<>();
        List<TreeNode> qAnc = new ArrayList<>();
        dfs(root,p,pAnc);
        dfs(root,q,qAnc);
        
        TreeNode prev = null;
        for (int i = 0; i < pAnc.size() && i < qAnc.size(); ++i) {
            if (pAnc.get(i) != qAnc.get(i)) {
                return prev;
            }
            prev = pAnc.get(i);
        }
        return prev;
    }
    
    private TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        solve(root, p, q);
        return lca;
    }
    
    private boolean solve(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        int mid = (node == p || node == q) ? 1 : 0;
        int left = solve(node.left, p, q) ? 1 : 0;
        int right = solve(node.right, p, q) ? 1 : 0;
        if ((mid + left + right) == 2) {
            lca = node;
        }
        return (mid + left + right) > 0;
    }
}
