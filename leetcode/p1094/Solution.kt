class Solution {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val sorted = trips.sortedBy { it[1] }
        val pq = PriorityQueue<Int>()
        var max = 0
        for (t in sorted) {
            while(!pq.isEmpty() && pq.peek() <= t[1]) {
                pq.poll()
            }
            
            for (i in 0 until t[0]) {
                pq.offer(t[2])
            }
            
            max = Math.max(max, pq.size);
        }
        return max <= capacity
    }
}
