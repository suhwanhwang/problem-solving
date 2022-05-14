data class Node(val v:Int, val t:Int)

class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val adj = mutableListOf<MutableList<Node>>()
        for (i in 0..n) {
            adj.add(ArrayList<Node>())
        }
        
        for(time in times) {
            adj[time[0]].add(Node(time[1], time[2]))
        }

        val INF = 987654321
        val q = ArrayDeque<Node>()
        val dist = IntArray(n + 1) { INF }
        dist[0] = 0
        dist[k] = 0
        q.add(Node(k, 0))
        

        while(!q.isEmpty()) {
            val cur = q.poll()
               
            for(next in adj[cur.v]) {
                val t = cur.t + next.t
                if (t >= dist[next.v]) continue
                
                dist[next.v] = t
                q.add(Node(next.v, t))
            }
        }
        //println(dist.toList())
        var max = 0
        for (d in dist) {
            max = Math.max(max, d)
        }
        return if (max != INF) max else -1
    }
}
