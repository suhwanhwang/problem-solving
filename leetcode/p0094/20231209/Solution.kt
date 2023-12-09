class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        return helper(root, list)
    }
    
    private fun helper(root: TreeNode?, list: MutableList<Int>): List<Int> {
        if (root == null) return list
        
        helper(root.left, list)
        list.add(root.`val`)
        helper(root.right, list)
        return list
    }
}
