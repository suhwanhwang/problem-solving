class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        val pq = PriorityQueue<IntArray> {a, b -> a[0].compareTo(b[0])}
        
        for (point in points) {
            pq.offer(point)
        }
        
        var count = 0
        var prev:IntArray? = null
        while (!pq.isEmpty()) {
            if (prev == null) prev = pq.poll()
            val cur = pq.poll()
            if (prev == null || cur == null) break
            
            if (prev[1] >= cur[0]) {
                val temp = intArrayOf(cur[0], min(prev[1], cur[1]))
                prev = temp
            } else {
                count++
                prev = cur
            }
        }
        if (prev != null) count++
        return count
    }
}
