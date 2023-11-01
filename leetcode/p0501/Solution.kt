class Solution {
    var map = mutableMapOf<Int,Int>()
    
    fun findMode(root: TreeNode?): IntArray {
        dfs(root)
        
        val maxCount = map.values.max()
        return map.filter {
            it.value == maxCount
        }.map {
            it.key
        }.toIntArray()
    }
    
    private fun dfs(root: TreeNode?) {
        if (root == null) return
        
        map.put(root.`val`, map.getOrDefault(root.`val`, 0)+1)
        dfs(root.left)
        dfs(root.right)
    }
}
