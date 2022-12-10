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
    public int maxProduct(TreeNode root) {
        List<Long> sums = new ArrayList<>();
        long total = dfs(root, sums);

        long max = 0;

        for (long sum : sums) {
            max = Math.max(max , (total - sum) * sum);
        }
        return (int)(max % ((int)1e9 + 7));
    }
    private long dfs(TreeNode node, List<Long> sums) {
        if (node == null) return 0;

        long left = dfs(node.left, sums);
        long right = dfs(node.right, sums);
        long sum = left + right + node.val;
        sums.add(sum);
        return sum;
    }
}
