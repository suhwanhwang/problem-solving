class Solution {
    private val INF = 987654321
    private val dp = Array<IntArray>(101) { IntArray(101){INF} }
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        var minValue = INF
        for (i in 0 until matrix[0].size) {
            minValue = min(minValue, helper(matrix, 0, i))
        }
        return minValue
    }
    
    private fun helper(matrix: Array<IntArray>, row: Int, col: Int): Int {
        
        if (row == matrix.size - 1) {
            return matrix[row][col]
        }
        
        if (dp[row][col] != INF) return dp[row][col]
        
        var minValue = INF
        
        if (col > 0) {
            minValue = helper(matrix, row + 1, col - 1)
        }
        minValue = min(minValue, helper(matrix, row + 1, col))
        
        if (col + 1 < matrix[0].size) {
            minValue = min(minValue, helper(matrix, row + 1, col + 1))
        
        }
        dp[row][col] = matrix[row][col] + minValue
        return dp[row][col]
    }
}
