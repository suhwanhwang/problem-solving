class Solution {
    fun findBottomLeftValue(root: TreeNode?): Int {
        root ?: return -1
        
        val queue = ArrayDeque<TreeNode>()
        var left = -1
        queue.add(root)
        
        while(!queue.isEmpty()) {
            var len = queue.size
            left = queue.first().`val`
            while (len > 0) {
                val cur = queue.removeFirst()
                val leftNode = cur.left
                val rightNode = cur.right
                if (leftNode != null) queue.add(leftNode)
                if (rightNode != null) queue.add(rightNode)
                len--
            }
        }
        
        return left
    }
}
