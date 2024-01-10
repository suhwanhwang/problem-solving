class Solution {
    fun amountOfTime(root: TreeNode?, start: Int): Int {
        val adj = mutableMapOf<Int, MutableList<Int>>()
        
        dfs(root, null, adj)
        println(adj)
        
        val queue = ArrayDeque<Int>()
        val visited = mutableSetOf<Int>()
        queue.add(start)
        visited.add(start)
        var depth = 0
        while (!queue.isEmpty()) {
            var len = queue.size
            while (len-- > 0) {
                val cur = queue.removeFirst()
                val curList = adj[cur] ?: continue
                
                for (next in curList) {
                    if (visited.contains(next)) continue
                    visited.add(next)
                    queue.add(next)
                }
                
            }
            depth++
        }
        return depth-1
    }
    
    private fun dfs(root: TreeNode?, parent: TreeNode?, map: MutableMap<Int, MutableList<Int>>) {
        if (root == null) return
        
        if (parent != null) {
            val list  = map[parent.`val`] ?: mutableListOf<Int>()
            list.add(root.`val`)
            map[parent.`val`] = list
            

            val list2  = map[root.`val`] ?: mutableListOf<Int>()
            list2.add(parent.`val`)
            map[root.`val`] = list2
        }
        dfs(root.left, root, map)
        dfs(root.right, root, map)
    }
}
