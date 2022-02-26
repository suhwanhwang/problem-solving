class Solution {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val q = ArrayDeque<Triple<Int,Int,Int>>() // state node cost
        val seen = mutableSetOf<Pair<Int,Int>>() // state node
        
        for(i in 0 until graph.size) {
            q.offer(Triple((1 shl i),i,0))
            seen.add(Pair((1 shl i),i))
        }
        
        val finalState = (1 shl graph.size) - 1
        while(!q.isEmpty()) {
            val (state, node, cost) = q.poll()
            if (state == finalState) {
                return cost
            }
            
            for (next in graph[node]) {
                val nextState = state or (1 shl next)
                if (seen.contains(Pair(nextState, next))) {
                    continue
                }
                q.offer(Triple(nextState,next, cost+1))
                seen.add(Pair(nextState, next))
            }
        }
        return 0
    }
} 
