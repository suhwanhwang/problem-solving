class Solution {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val sorted = trips.sortedBy { it[1] }
        val pq = PriorityQueue<Int> { i0, i1 ->
            sorted[i0][2] - sorted[i1][2]
        }
        var curCapacity = 0
        var max = 0
        for ((i, t) in sorted.withIndex()) {
            while(!pq.isEmpty() && sorted[pq.peek()][2] <= t[1]) {
                curCapacity -= sorted[pq.poll()][0]
            }
            
            pq.offer(i)
            curCapacity += sorted[i][0]
            
            max = Math.max(max, curCapacity);
        }
        return max <= capacity
    }
}
