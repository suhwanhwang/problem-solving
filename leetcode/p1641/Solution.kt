class Solution {    
    val dp = Array<IntArray>(51){ IntArray(6){0}}
    fun countVowelStrings(n: Int): Int {
        return solve(n, 5)
    }
    fun solve(n: Int, num: Int): Int {
        if (n == 1) return num
        if(dp[n][num] != 0) return dp[n][num]
        var sum = 0
        for (i in num downTo 1) {
            sum += solve(n-1, i)
        }
        dp[n][num] = sum
        return sum
    }
}
