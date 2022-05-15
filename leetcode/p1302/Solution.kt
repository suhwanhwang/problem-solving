class Solution {
    fun deepestLeavesSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        
        val q = ArrayDeque<TreeNode>()
        q.offer(root)
        var latestSum = 0
        while(!q.isEmpty()) {
            var len = q.size
            var curSum = 0
            while(len-- > 0) {
                val node = q.poll()
                curSum += node.`val`
                if (node.left != null) {
                    q.offer(node.left)
                }
                if (node.right != null) {
                    q.offer(node.right)
                }
            }
            latestSum = curSum
        }
        return latestSum
    }
}
