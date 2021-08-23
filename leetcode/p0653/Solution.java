/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
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
    private List<Integer> list;
    public boolean findTarget(TreeNode root, int k) {
        list = new ArrayList<>();
        dfs(root);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); ++i) {
            int target = k - list.get(i);
            if (set.contains(target)) {
                return true;
            }
            set.add(list.get(i));
        }
        return false;
    }
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
}
