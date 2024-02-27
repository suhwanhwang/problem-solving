class Solution {
    private var maxDepth = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        helper(root)
        return maxDepth
    }
    
    private fun helper(root: TreeNode?): Int {
        if (root == null) return 0
        
        val left = helper(root.left)
        val right = helper(root.right)
        maxDepth = max(maxDepth, left + right)
        return 1 + max(left, right)
    }
}
