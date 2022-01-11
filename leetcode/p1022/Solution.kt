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
    private var sum = 0
    fun sumRootToLeaf(root: TreeNode?): Int {
        sum = 0
        dfs(root, 0)
        return sum
    }
    
    private fun dfs(node: TreeNode?, num: Int) {
        if (node == null) {
            return
        }
        
        val curNum = (num shl 1) + node.`val`
        if (node.left == null && node.right == null) {
            sum += curNum
            return;
        }
        dfs(node.left, curNum)
        dfs(node.right, curNum)
    }
}
