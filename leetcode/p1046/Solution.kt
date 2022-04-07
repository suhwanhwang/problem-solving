class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int>{a,b -> -(a - b)}
        for (s in stones) {
            pq.offer(s)
        }
        
        while(pq.size > 1) {
            val first = pq.poll()
            val second = pq.poll()
            if (first != second) {
                pq.offer(Math.abs(first-second))
            }
        }
        return if (pq.isEmpty()) 0 else pq.poll()
    }
}
