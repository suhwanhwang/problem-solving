class Solution {
    private val INF = 987654321
    val dp = IntArray(10001) { -1 }
    
    fun coinChange(coins: IntArray, amount: Int): Int {
        val ans = helper(coins, amount)
        return if (ans == INF) -1 else ans
    }
    
    fun helper(coins: IntArray, amount: Int): Int {
        if (amount == 0) {
            return 0
        }
        
        if (dp[amount] != -1) return dp[amount]
        
        var min = INF
        for (c in coins) {
            val remain = amount - c
            if (remain < 0) continue
            
            min = Math.min(min, 1 + helper(coins, remain))
        }
        dp[amount] = min
        return min
    }
}
