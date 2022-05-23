class Solution {
    private lateinit var dp: Array<Array<IntArray>> 
    
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        dp = Array<Array<IntArray>>(strs.size + 1) { Array<IntArray>(m + 1) { IntArray(n + 1) { -1 }}}
        return helper(strs, m, n, 0)    
    }
    
    fun helper(strs: Array<String>, m: Int, n: Int, index:Int): Int {
        if (index >= strs.size) {
            return 0
        }
        
        if (dp[index][m][n] != -1) {
            return dp[index][m][n]
        }
        
        var max = 0
        val zeroCount = strs[index].count { it == '0' }
        val oneCount = strs[index].count { it == '1' }
        val countExclude = helper(strs, m, n, index + 1)
        max = Math.max(max, countExclude)
        if (m - zeroCount < 0 || n - oneCount < 0) {
            return max
        }
        
        val countInclude = 1 + helper(strs, m - zeroCount, n - oneCount, index + 1)
        max = Math.max(max, countInclude)
        dp[index][m][n] = max
        return max
    }
}
