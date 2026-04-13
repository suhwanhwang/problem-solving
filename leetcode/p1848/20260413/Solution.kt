class Solution {
    fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
        var minDist = Int.MAX_VALUE
        for ((i, num) in nums.withIndex()) {
            if (num == target) {
                minDist = min(minDist, abs(i - start))
            }
        }
        return minDist
    }
}
