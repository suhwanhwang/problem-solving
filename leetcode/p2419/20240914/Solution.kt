class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var maxNum = nums[0]
        var maxLen = 1
        var len = 1
        var prev = nums[0]
        for (i in 1 until nums.size) {
            val num = nums[i]
            
            if (prev == num) {
                len += 1
            } else {
                prev = num
                len = 1
            }
            
            if (num > maxNum) {
                maxNum = num
                maxLen = 1
            } else if (num == maxNum) {
                maxLen = max(maxLen, len)
            }
            
        }
        return maxLen
    }
}
