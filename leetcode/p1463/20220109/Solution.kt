class Solution {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val dp = Array(grid.size) { 
            Array(grid[0].size) { 
                IntArray(grid[0].size) { -1 }
            }
        }
        
        return helper(dp, grid, 0, 0, grid[0].size -1)
    }
    
    val DIR = listOf(
        listOf(-1, -1), listOf(-1, 0), listOf(-1, 1),
        listOf(0, -1), listOf(0, 0), listOf(0, 1),
        listOf(1, -1), listOf(1, 0), listOf(1, 1))
    
    private fun helper(dp: Array<Array<IntArray>>, grid: Array<IntArray>, row: Int, col0: Int, col1: Int): Int {
        if (row == grid.size) {
            return 0
        }
        
        if (dp[row][col0][col1] != -1) {
            return dp[row][col0][col1]
        }
        
        val cur = if (col0 == col1) grid[row][col0] else grid[row][col0] + grid[row][col1]
        var max = 0
        for (d in DIR) {
            val ncol0 = col0 + d[0]
            val ncol1 = col1 + d[1]
            if (ncol0 < 0 || ncol0 >= grid[row].size || ncol1 < 0 || ncol1 >= grid[row].size) {
                continue
            }
            
            max = Math.max(max, helper(dp, grid, row + 1, ncol0, ncol1))
        }
        dp[row][col0][col1] = max + cur 
        return dp[row][col0][col1]
    }
}
