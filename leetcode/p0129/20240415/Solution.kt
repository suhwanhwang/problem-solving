class Solution {
    fun sumNumbers(root: TreeNode?): Int {
        return helper(root, 0)
    }
    
    private fun helper(root: TreeNode?, num: Int): Int {
        if (root == null) return 0
        
        val next = num * 10 + root.`val`
        if (root.left == null && root.right == null) {
            return next
        }
        
        return helper(root.left, next) + helper(root.right, next)
    }
}
