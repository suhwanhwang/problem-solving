class Solution {
    /*
    fun minimumHammingDistance_TL(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int {
        val targetMap = mutableMapOf<Int, MutableSet<Int>>()
        for ((i, num) in target.withIndex()) {
            targetMap.getOrPut(num) { mutableSetOf() }.add(i)
        }

        val adj = mutableMapOf<Int, MutableList<Int>>()
        for (edge in allowedSwaps) {
            adj.getOrPut(edge[0]) { mutableListOf() }.add(edge[1])
            adj.getOrPut(edge[1]) { mutableListOf() }.add(edge[0])
        }
        
        var count = 0
        for (i in 0 until source.size) {
            val num = source[i]
            val endSet = targetMap[num]
            if (endSet == null) {
                count++
                continue
            } else if (endSet.contains(i)){
                endSet.remove(i)
                continue
            }
            
            val queue = ArrayDeque<Int>()
            val visited = BooleanArray(source.size) { false }
            queue.addLast(i)
            visited[i] = true
            var isFounded = false
            while (!queue.isEmpty()) {
                val current = queue.removeFirst()
                if (endSet.contains(current)) {
                    endSet.remove(current)
                    isFounded = true
                    break
                }
                val nexts = adj[current] ?: emptyList()
                for (next in nexts) {
                    if (visited[next]) {
                        continue
                    }

                    queue.addLast(next)
                    visited[next] = true
                }
            }
            if (!isFounded) {
                count++
            }
        }

        return count
    }
    */

    fun minimumHammingDistance(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int {
        val n = source.size
        val parent = IntArray(n) { it }

        fun find(a: Int): Int {
            var current = a
            while (parent[current] != current) {
                current = parent[current]
            }
            return current
        }

        fun union(a: Int, b: Int) {
            val rootA = find(a)
            val rootB = find(b)
            if (rootA != rootB) {
                parent[rootB] = rootA
            }
        }

        for (swap in allowedSwaps) {
            union(swap[0], swap[1])
        }

        val group = mutableMapOf<Int, MutableMap<Int, Int>>()
        val roots = IntArray(n) { find(it) }
        for (i in source.indices) {
            val map = group.getOrPut(roots[i]) { HashMap() }
            map[source[i]] = (map[source[i]] ?: 0) + 1
        }

        var count = 0
        for (i in target.indices) {
            val map = group[roots[i]]!!
            val v = map[target[i]]
            if (v == null || v < 1) {
                count++
            } else {
                map[target[i]] = v - 1
            }
        }

        return count
    }
}
