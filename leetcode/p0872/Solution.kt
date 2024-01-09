class Solution {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        return leaf(root1) == leaf(root2)
    }
    
    private fun leaf(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        
        val list = mutableListOf<Int>()
        list.addAll(leaf(root.left))
        if (root.left == null && root.right == null) {
            list.add(root.`val`)
        }
        list.addAll(leaf(root.right))
        return list
    }
}
