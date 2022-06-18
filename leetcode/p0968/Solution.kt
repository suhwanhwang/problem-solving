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
    val set = mutableSetOf<TreeNode?>()
    var ans = 0
    fun minCameraCover(root: TreeNode?): Int {
        set.add(null)
        dfs(root, null)
        return ans
    }
    
    fun dfs(root: TreeNode?, parent:TreeNode?) {
        root ?: return
        
        dfs(root.left, root)
        dfs(root.right, root)
        
        if (((parent == null) and !set.contains(root)) 
            or !set.contains(root.left)
           or !set.contains(root.right)) {
            ans++
            set.add(root)
            set.add(parent)
            set.add(root.left)
            set.add(root.right)
        }
       
    }
}
