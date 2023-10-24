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
    fun largestValues(root: TreeNode?): List<Int> {
        val largest = TreeMap<Int, Int>()
        
        dfs(root, 0, largest)
        return ArrayList(largest.values)
    }
    
    fun dfs(root: TreeNode?, depth: Int, map: MutableMap<Int, Int>) {
        if (root == null) {
            return
        }

        val prev = map[depth]
        if (prev == null || prev < root.`val`) {
            map[depth] = root.`val`
        }
        dfs(root.left, depth+1, map)
        dfs(root.right, depth+1, map)
    }
}
