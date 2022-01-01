class Solution {
    private lateinit var dp:Array<IntArray>;
    
    fun maxCoins(nums: IntArray): Int {
        val temp = IntArray(nums.size + 2);
        temp[0] = 1;
        temp[temp.size - 1] = 1;
        for ((i, value) in nums.withIndex()) {
            temp[i + 1] = value
        }
        
        dp = Array(temp.size, {IntArray(temp.size)});
        return helper(temp, 0, temp.size - 1);
    }
    private fun helper(nums: IntArray, left: Int, right: Int): Int {
        if (left + 1 == right) {
            return 0
        }
        
        if (dp[left][right] != 0) {
            return dp[left][right]
        }
        
        var max = 0
        
        for (i in (left+1) until right) {
            max = Math.max(max, nums[left] * nums[i] * nums[right] + helper(nums, left, i) + helper(nums, i, right));
        }
        dp[left][right] = max
        return max
    }
}
