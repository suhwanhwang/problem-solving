class Solution {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        val time = mutableListOf<Double>()
        for (i in 0 until dist.size) {
            time.add(dist[i].toDouble() / speed[i])
        }
        time.sort()
        
        var count = 1
        for (i in 1 until time.size) {
            if (time[i] - count > 0) {
                count++
                
            } else {
                break
            }
        }
        return count
    }
}
