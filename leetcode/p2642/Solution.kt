class Graph(n: Int, edges: Array<IntArray>) {
    private val adj = mutableListOf<MutableList<Pair<Int, Int>>>()
    private val n: Int

    init {
        this.n = n
        for (i in 0 until n) {
            adj.add(mutableListOf())
        }

        edges.forEach {
            adj[it[0]] += Pair(it[1], it[2])
        }
    }

    fun addEdge(edge: IntArray) {
        adj[edge[0]] += Pair(edge[1], edge[2])
    }

    fun shortestPath(node1: Int, node2: Int): Int {
        val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
            a.second.compareTo(b.second)
        }
        val dist = IntArray(this.n) { Int.MAX_VALUE }

        pq.offer(Pair(node1, 0))
        dist[node1] = 0

        while (!pq.isEmpty()) {
            val cur = pq.poll()

            for (next in adj[cur.first]) {
                val d = cur.second + next.second
                if (dist[next.first] <= d) {
                    continue
                }
                dist[next.first] = d
                pq.offer(Pair(next.first, d))
            }
        }
        return if (dist[node2] == Int.MAX_VALUE) -1 else dist[node2]
    }

}


/**
 * Your Graph object will be instantiated and called as such:
 * var obj = Graph(n, edges)
 * obj.addEdge(edge)
 * var param_2 = obj.shortestPath(node1,node2)
 */
