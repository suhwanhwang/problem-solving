class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val map = mutableMapOf<Int, Int>()
        var sum = 0
        var kCount = 0
        map[sum] = 1
        for (num in nums) {
            sum += num
            kCount += (map[sum - k] ?: 0)
            map[sum] = (map[sum] ?: 0) + 1
        }
        return kCount
    }
}
