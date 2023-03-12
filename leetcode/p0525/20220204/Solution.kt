class Solution {
    fun findMaxLength(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        var delta = 0
        var max = 0
        map[0] = -1
        for ((i, num) in nums.withIndex()) {
            delta += if (num == 0) -1 else 1
            val prevIndex = map[delta]
            if (prevIndex == null) {
                map[delta] = i
            } else {
                max = Math.max(max, i - prevIndex)
            }
        }
        return max
    }
}
