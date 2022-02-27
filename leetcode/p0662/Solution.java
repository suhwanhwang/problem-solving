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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        Queue<Integer> orderQ = new ArrayDeque<Integer>();
        int maxWidth = 0;
        queue.offer(root);
        orderQ.offer(0);
        while(!queue.isEmpty()) {
            int len = queue.size();
            int left = orderQ.peek();
            int right = 0;
            while(len-- > 0) {
                TreeNode cur = queue.poll();
                int order = orderQ.poll();
                right = order;
                if (cur.left != null) {
                    queue.offer(cur.left);
                    orderQ.offer(order * 2 + 1);
                }
                
                if (cur.right != null) {
                    queue.offer(cur.right);
                    orderQ.offer(order * 2 + 2);
                }
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        return maxWidth;
    }
}
