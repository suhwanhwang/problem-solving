class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        if (n == 1 && trust.size == 0) return 1
        
        val adj = mutableMapOf<Int, Set<Int>>()
        
        for (t in trust) {
            adj[t[1]] = ((adj[t[1]] ?: emptySet()) + t[0])
        }
        
        val judges = mutableListOf<Int>()
        for ((k, v) in adj) {
            if (v.size == n - 1) {
                judges.add(k)
            }
        }
        if (judges.size != 1) return -1
        val judge = judges.first()
        for ((k, v) in adj) {
            if (k == judge) continue
            if (v.contains(judge)) return -1
        }
        return judge
    }
}
