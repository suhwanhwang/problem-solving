class Solution {
    fun findMaxLength(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>() // count, index
        
        var count = 0
        var maxLen = 0
        map[0] = -1
        for (i in 0 until nums.size) {
            count += if (nums[i] == 0) -1 else 1
            
            val prevIndex = map[count]
            if (prevIndex == null) {
                map[count] = i
            } else {
                maxLen = max(maxLen, i - prevIndex)
            }
        }
        return maxLen
    }
}
