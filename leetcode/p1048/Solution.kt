class Solution {
    fun longestStrChain(words: Array<String>): Int {
        words.sortBy {it.length}
        val adj = Array<MutableList<Int>>(words.size) { mutableListOf<Int>() }
        
        for (i in words.indices) {
            for (j in (i + 1) until words.size) {
                val from = words[i]
                val to = words[j]
                if (from.isPredecessor(to)) {
                    adj[i].add(j)
                }
            }
        }
        //println(adj.toList())
        
        var max = 0
        for (i in words.indices) {
            max = Math.max(max, dfs(adj, i))
        }
        return max
    }
    
    private fun dfs(adj: Array<MutableList<Int>>, index: Int): Int {
        if (index >= adj.size) {
            return 0
        }
        
        var max = 1
        for (next in adj[index]) {
            val depth = 1 + dfs(adj, next)
            max = Math.max(max, depth)
        }
        return max
    }
     
    private fun String.isPredecessor(w: String): Boolean {
        if (this.length + 1 != w.length) return false
        
        var count = 0
        var i = 0
        var j = 0
        while (i < this.length && j < w.length) {
            if (this[i] != w[j]) {
                j++
                count++
                if (count > 1) {
                    return false
                }
            } else {
                i++
                j++
            }
        }
        return true
    }
}
