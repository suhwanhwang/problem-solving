class Solution {
    val dp = Array(51) { IntArray(1001) {-1} }
    var prefixSum = IntArray(1000001) {0}
    fun splitArray(nums: IntArray, m: Int): Int {
        prefixSum[0] = nums[0]
        for(i in 1..nums.size) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1]
        }
        return helper(nums, m, 0)
    }
    
    private fun helper(nums: IntArray, m: Int, start: Int): Int {
        if (m == 1) {
            return prefixSum[nums.size] - prefixSum[start]
        }
        
        if (dp[m][start] != -1) {
            return dp[m][start]
        }
        
        var sum = 0
        var min = Int.MAX_VALUE
        for (i in start..(nums.size - m)) {
        
            sum += nums[i]
            val nextSum = helper(nums, m - 1, i + 1)
            val curMax = Math.max(sum, nextSum)
            
            min = Math.min(min, curMax)
        }
        dp[m][start] = min
        return min
     }   
}
