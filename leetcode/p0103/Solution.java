/**
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:

[
  [3],
  [20,9],
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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer, List<Integer>> order = new TreeMap<>();
        dfs(root, 0, order);
        
        List<List<Integer>> ans = new ArrayList<>(order.values());
        for(int i = 0; i < ans.size(); ++i) {
            if (i % 2 == 1) {
                Collections.reverse(order.get(i));
            }
        }
        return ans;
    }
}
