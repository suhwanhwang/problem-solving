class Solution {
    private val dp = IntArray(50) {0}
    fun climbStairs(n: Int): Int {
        if (n < 0) return 0
        else if (n == 0) return 1
        
        if (dp[n] != 0) return dp[n]
        dp[n] = climbStairs(n - 1) + climbStairs(n - 2)
        return dp[n]
    }
}
