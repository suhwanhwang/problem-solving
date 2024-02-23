class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val adj = mutableMapOf<Int, Set<Pair<Int, Int>>>()
        
        for (flight in flights) {
            val from = flight[0]
            val to = flight[1]
            val price = flight[2]
            adj[from] = (adj[from] ?: emptySet()) + Pair(to, price)
        }
        
        val queue = ArrayDeque<IntArray>()
        val prices = IntArray(n + 1) { Int.MAX_VALUE }
        queue.add(intArrayOf(src, 0, 0))
        prices[src] = 0
        
        while (!queue.isEmpty()) {
            val cur = queue.removeFirst()
            val curIndex = cur[0]
            val curPrice = cur[1]
            val curStop = cur[2]
            
            if (curStop > k) continue
            
            for (next in adj[curIndex].orEmpty()) {
                val nextIndex = next.first
                val price = curPrice + next.second
                if (prices[nextIndex] > price) {
                    prices[nextIndex] = price
                    queue.add(intArrayOf(nextIndex, price, curStop + 1))
                }
            }
        }
        return if (prices[dst] == Int.MAX_VALUE) -1 else prices[dst]
    }
}
