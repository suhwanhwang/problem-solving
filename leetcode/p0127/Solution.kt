class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        
        val list = mutableListOf<String>()
        list.add(beginWord)
        list.addAll(wordList)
        
        val adj = mutableListOf<MutableList<Int>>()
        for (i in 0 until list.size) {
            adj.add(mutableListOf<Int>())
        }
        for (i in 0 until list.size - 1) {
            for (j in i + 1 until list.size) {
                if (!canTrans(list[i], list[j])) {
                    continue;
                }
                adj[i].add(j)
                adj[j].add(i)
            }
        }
        
        return getDist(adj, 0, list.indexOf(endWord))
    }
    
    fun canTrans(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) {
            return false
        }
        var diff = 0
        for(i in 0 until s1.length) {
            if (s1[i] != s2[i]) {
                diff++
            }
        }
        return diff < 2
    }
    
    fun getDist(adj: List<List<Int>>, start:Int, end: Int): Int {
        val visited = BooleanArray(adj.size) { false }
        val queue = ArrayDeque<Int>()
        queue.offer(start)
        visited[start] = true
        
        var dist = 0
        while(!queue.isEmpty()) {
            var len = queue.size
            dist++
            while(len-- > 0) {
                val cur = queue.poll()
                if (cur == end) {
                    return dist
                }
                for (next in adj[cur]) {
                    if (visited[next]) {
                        continue
                    }
                    queue.offer(next)
                    visited[next] = true
                }
            }
        }
        return 0
    }
}
