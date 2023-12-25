class Solution {
    private var dp: IntArray = IntArray(101)
    fun numDecodings(s: String): Int {
        Arrays.fill(dp, -1)
        return helper(s, 0)
    }
    
    private fun helper(s: String, index: Int): Int {
        if (index >= s.length) {
            return 1
        }
        
        if (s[index] == '0') {
            return 0
        }
        
        if (dp[index] != -1) {
            return dp[index]
        }

        var result = helper(s, index + 1)
        if (index + 1 < s.length 
            && (s[index] == '1' 
                || (s[index] == '2'
                    && s[index + 1] <= '6'))) {
            result += helper(s, index + 2)
        }
        dp[index] = result
        return result
    }
}
