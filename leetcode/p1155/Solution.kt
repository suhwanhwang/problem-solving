class Solution {
    private val dp = Array<IntArray>(31) {IntArray(1001){-1}}
    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        if (n == 0 && target == 0) return 1
        
        if (n < 0 || target < 0) return 0

        if(dp[n][target] != -1) return dp[n][target]

        var sum = 0
        for (i in 1..k) {
            sum += numRollsToTarget(n - 1, k, target - i)
            sum %= 1000000007
        }
        dp[n][target] = sum
        return sum
    }
