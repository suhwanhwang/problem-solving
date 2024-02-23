class Solution {
    private data class Node(val city:Int, val price:Int, val stop:Int)
    
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val adj = mutableMapOf<Int, Set<Node>>()
        
        for (flight in flights) {
            val from = flight[0]
            val to = flight[1]
            val price = flight[2]
            adj[from] = (adj[from] ?: emptySet()) + Node(to, price, 0)
        }
        
        val queue = ArrayDeque<Node>()
        val prices = IntArray(n + 1) { Int.MAX_VALUE }
        queue.add(Node(src, 0, 0))
        prices[src] = 0
        
        while (!queue.isEmpty()) {
            val cur = queue.removeFirst()
            
            if (cur.stop > k) continue
            
            for (next in adj[cur.city].orEmpty()) {
                val price = cur.price + next.price
                if (prices[next.city] > price) {
                    prices[next.city] = price
                    queue.add(Node(next.city, price, cur.stop + 1))
                }
            }
        }
        return if (prices[dst] == Int.MAX_VALUE) -1 else prices[dst]
    }
}
