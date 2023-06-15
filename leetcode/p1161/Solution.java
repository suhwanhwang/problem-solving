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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        int depth = 1;
        int maxSum = Integer.MIN_VALUE;
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            int sum = 0;
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                sum += node.val;
            }
            if (sum > maxSum) {
                maxDepth = depth;
                maxSum = sum;
                System.out.println(depth + " " + sum);
            }
            depth++;
        }
        return maxDepth;
    }
}
