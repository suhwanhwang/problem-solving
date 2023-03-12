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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, new ArrayList<>());
    }

    private int dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int num : list) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            return max - min;
        }

        list.add(node.val);

        int left = dfs(node.left, list);
        int right = dfs(node.right, list);
        list.remove(list.size() - 1);
        return Math.max(left, right);

    }
}
