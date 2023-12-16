class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var sum = 0
        for (i in 1 until points.size) {
            val prev = points[i - 1]
            val cur = points[i]
            val deltaX = abs(cur[0] - prev[0])
            val deltaY = abs(cur[1] - prev[1])
            val minDelta = min(deltaX, deltaY)
            sum += (deltaX + deltaY) - minDelta
        }
        return sum
    }
}
