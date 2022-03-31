class Solution {
    val dp = Array(51) { IntArray(1001) {-1} }
    
    fun splitArray(nums: IntArray, m: Int): Int {
        return helper(nums, m, 0)
    }
    
    private fun helper(nums: IntArray, m: Int, start: Int): Int {
        if (m == 1) {
            return nums.filterIndexed { index, value -> index >= start }.sum()
        }
        
        if (dp[m][start] != -1) {
            return dp[m][start]
        }
        
        var sum = 0
        var min = Int.MAX_VALUE
        for (i in start..(nums.size - m)) {
            if (nums[i] == 0 && min != Int.MAX_VALUE) {
                continue
            }
            sum += nums[i]
            val nextSum = helper(nums, m - 1, i + 1)
            val curMax = Math.max(sum, nextSum)
            
            min = Math.min(min, curMax)
        }
        dp[m][start] = min
        return min
     }   
}
