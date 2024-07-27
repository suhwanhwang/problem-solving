class Solution {
    fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {
        val adj: MutableMap<Char, MutableMap<Char, Int>> = mutableMapOf()
        
        for (i in 0 until original.size) {
            val map = (adj[original[i]] ?: mutableMapOf<Char,Int>())
            map[changed[i]] = min(map[changed[i]] ?: Int.MAX_VALUE, cost[i])
            adj[original[i]] = map
        }
        
        var total = 0L
        val totalMap: MutableMap<Pair<Char, Char>, Long> = mutableMapOf()
        
        for (i in 0 until source.length) {
            if (source[i] == target[i])
                continue
            
            if (totalMap.contains(Pair(source[i], target[i]))) {
                total += (totalMap[Pair(source[i], target[i])] ?: 0)
                continue
            }
            
            val curCost = getCost(adj, source[i], target[i])
            if (curCost < 0) {
                return -1
            } else {
                //println("${source[i]} -> ${target[i]} = ${curCost}")
                totalMap[Pair(source[i], target[i])] = curCost
                total += curCost
            }
        }

        return total
    }
    
    private fun getCost(adj: Map<Char, Map<Char, Int>>, s: Char, t: Char): Long {
        
        val queue = ArrayDeque<Pair<Char, Long>>()
        queue.add(Pair(s, 0L))
        
        val dist = LongArray(26) { 987654321L }
        dist[s - 'a'] = 0L
        
        while (!queue.isEmpty()) {
            val cur = queue.removeFirst()
            
            for (next in (adj[cur.first] ?: emptyMap())) {
                if (dist[next.key - 'a'] < cur.second + next.value) {
                    continue
                }
                
                dist[next.key - 'a'] = cur.second + next.value
                queue.add(Pair(next.key, cur.second + next.value))
            }
        }
        return if (dist[t - 'a'] == 987654321L) -1 else dist[t - 'a']
    }
}
