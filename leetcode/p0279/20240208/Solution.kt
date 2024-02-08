class Solution {
    private var dp = IntArray(10001) { -1 }
    
    fun numSquares(n: Int): Int {
        if (n == 0) return 0
        if (dp[n] != -1) return dp[n]
        
        var min = Int.MAX_VALUE
        for (i in 1..sqrt(n.toDouble()).toInt()) {
            min =min(min, 1 + numSquares(n - (i * i)))
        }
        dp[n] = min
        return min
    }
}
