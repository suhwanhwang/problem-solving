class Solution {
    private var totalCount:Int = 0
    
    fun averageOfSubtree(root: TreeNode?): Int {
        val result = helper(root)
        return totalCount
    }
    
    fun helper(root: TreeNode?): Pair<Int,Int> {
        if (root == null) {
            return Pair(0, 0)
        }
        val left = helper(root.left)
        val right = helper(root.right)
        
        val count = 1 + left.first + right.first
        val sum = root.`val` + left.second + right.second
        if (sum / count == root.`val`) {
            totalCount++
        }
        return Pair(count, sum)
    }
}
