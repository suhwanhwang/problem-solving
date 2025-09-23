class Solution {
    fun maxFrequencyElements(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        var maxFreq = 0
        for (n in nums) {
            val freq = (map[n] ?: 0)
            map[n] = freq + 1
            maxFreq = max(maxFreq, freq + 1)
        }

        var result = 0
        for ((k, v) in map) {
            if (v == maxFreq) {
                result += maxFreq
            }
        }
        return result
    }
}
