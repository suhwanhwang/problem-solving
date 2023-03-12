class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val map = IntArray(n + 1)
        val adj = mutableListOf<MutableList<Int>>()
        for (i in 0..n) {
            adj.add(mutableListOf<Int>())
        }
        for (t in trust) {
            adj[t[0]].add(t[1])
            map[t[1]]++
        }
        //println(adj)
        for (i in 1..n) {
            if (adj[i].size == 0 && map[i] == n - 1) {
                return i
            }
        }
        return -1
    }
}
