class Solution {
    val adj = mutableListOf<MutableList<Int>>()
    val disc = mutableListOf<Int>()
    val low = mutableListOf<Int>()
    val ans = mutableListOf<List<Int>>()
    var time = 1
    fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
        for (i in 0 until n) {
            adj.add(ArrayList<Int>())
            disc.add(0)
            low.add(0)
        }
        for (c in connections) {
            adj[c[0]].add(c[1])
            adj[c[1]].add(c[0])
        }
        
        dfs(0, -1)
        return ans
    }
    
    private fun dfs(cur: Int, prev: Int) {
        disc[cur] = time
        low[cur] = time
        time++
        
        for (next in adj[cur]) {
            if (disc[next] == 0) {
                dfs(next, cur)
                low[cur] = Math.min(low[cur], low[next])
            } else if (next != prev) {
                low[cur] = Math.min(low[cur], disc[next])
            }
            
            if (low[next] > disc[cur]) {
                ans.add(listOf(cur, next))
            }
        }
    }
}
