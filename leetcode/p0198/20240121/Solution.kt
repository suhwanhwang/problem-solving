class Solution {
    private val dp = IntArray(101)
    fun rob(nums: IntArray): Int {
        Arrays.fill(dp, -1)
        return helper(nums, 0)
    }
    
    private fun helper(nums: IntArray, index: Int): Int {
        if (index >= nums.size) return 0

        if (dp[index] != -1) return dp[index]
        
        val rob = nums[index] + helper(nums, index + 2)
        val skip = helper(nums, index + 1)
        
        dp[index] = max(rob, skip)
        return dp[index]
    }
}
