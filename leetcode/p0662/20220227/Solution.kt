/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun widthOfBinaryTree(root: TreeNode?): Int {
        val q = ArrayDeque<TreeNode>()
        val orderQ = ArrayDeque<Int>()
        var maxWidth = 0
        q.offer(root)
        orderQ.offer(0)
        while(!q.isEmpty()) {
            var len = q.size
            var left = orderQ.peek()
            var right = -1
            for(i in 0 until len) {
                val cur = q.poll()
                val order = orderQ.poll()
                
                right = order
                if (cur.left != null) {
                    q.offer(cur.left)
                    orderQ.offer(order * 2 + 1);
                }
                if (cur.right != null) {
                    q.offer(cur.right)
                    orderQ.offer(order * 2 + 2)
                }
            }
            maxWidth = Math.max(maxWidth, right - left + 1)
        }
        return maxWidth
    }
}
