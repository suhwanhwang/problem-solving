class Solution {
    fun earliestFinishTime(landStartTime: IntArray, landDuration: IntArray, waterStartTime: IntArray, waterDuration: IntArray): Int {
        var minFinishTime = Int.MAX_VALUE

        for (i in landStartTime.indices) {
            for (j in waterStartTime.indices) {
                // land first
                val landFirst = max(landStartTime[i] + landDuration[i], waterStartTime[j]) + waterDuration[j]

                // water first
                val waterFirst = max(waterStartTime[j] + waterDuration[j], landStartTime[i]) + landDuration[i]
                minFinishTime = minOf(minFinishTime, landFirst, waterFirst)
            }
        }
        return minFinishTime
    }
}
