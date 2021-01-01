/**
https://leetcode.com/problems/binary-tree-level-order-traversal/
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
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
    
    private void dfs(TreeNode node, int d, Map<Integer, List<Integer>> order) {
         if (node == null) {
             return;
         }
        dfs(node.left, d+1, order);
        List<Integer> list = order.getOrDefault(d, new ArrayList<>());
        list.add(node.val);
        order.put(d, list);
        dfs(node.right, d+1, order);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> order = new TreeMap<>();
        dfs(root, 0, order);
        
        return new ArrayList<>(order.values());
    }
}
