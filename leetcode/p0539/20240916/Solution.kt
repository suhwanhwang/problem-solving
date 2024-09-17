class Solution {
    fun findMinDifference(timePoints: List<String>): Int {
    
        val sorted = timePoints.sorted()
        println(sorted)
        
        var min = 23 * 60 + 59
        for (i in 1 until sorted.size) {
            val pre = sorted[i - 1].split(":").map { it.toInt() }
            val cur = sorted[i].split(":").map { it.toInt() }
            
            val preMin = pre[0] * 60 + pre[1]
            val curMin = cur[0] * 60 + cur[1]
            min = min(min, curMin - preMin)
        }
        
        val left = sorted.first().split(":").map { it.toInt() }
        val right = sorted.last().split(":").map { it.toInt() }
        val leftMin = (left[0] + 24) * 60 + left[1]
        val rightMin = right[0] * 60 + right[1]
        min = min(min, leftMin - rightMin)
        
        return min
    }
}
