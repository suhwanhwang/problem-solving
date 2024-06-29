class Solution {
    fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
        val adj = List(n) { mutableSetOf<Int>() }
        
        for (edge in edges) {
            adj[edge[1]].add(edge[0])
        }
        
        val ans = List(n) { mutableListOf<Int>() }
        
        for (i in 0 until n) {
            ans[i].addAll(getAncestors(adj, i))
        }
        return ans
    }
    
    private fun getAncestors(adj: List<Set<Int>>, start: Int): List<Int> {        
        val ancestors = mutableListOf<Int>()
        val visited = BooleanArray(adj.size) { false }
        val queue = ArrayDeque<Int>()
        queue.addLast(start)
        visited[start] = true
        
        while (!queue.isEmpty()) {
            val cur = queue.removeFirst()
            
            if (cur != start)
                ancestors.add(cur)
            
            for (next in adj[cur]) {
                if (visited[next]) continue

                queue.addLast(next)
                visited[next] = true
            }
        }
        return ancestors.sorted()
    }
}
