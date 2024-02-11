class Solution {
    data class Position(val row: Int, val col: Int)
    private val dp = Array(71) {
        Array(71) {
            Array(71) {
                IntArray(71) { -1 }
            }
        }
    }
    
    fun cherryPickup(grid: Array<IntArray>): Int {
        
        return helper(grid, Position(0, 0), Position(0, grid[0].size - 1))
    }
    
    private fun helper(grid: Array<IntArray>, p1: Position, p2: Position): Int {
        if (p1.row < 0 || p1.row >= grid.size || p1.col < 0 || p1.col >= grid[0].size) {
            return 0
        }
        
        if (p2.row < 0 || p2.row >= grid.size || p2.col < 0 || p2.col >= grid[0].size) {
            return 0
        }
        
        if (dp[p1.row][p1.col][p2.row][p2.col] != -1) {
            return dp[p1.row][p1.col][p2.row][p2.col]
        }
        
        var max = 0
        for (i in -1..1) {
            for (j in -1..1) {
                max = max(max, helper(grid, Position(p1.row + 1, p1.col + i), Position(p2.row + 1, p2.col + j)))
            }
        }
        
        var sum = grid[p1.row][p1.col]
        if (p1 != p2) {
            sum += grid[p2.row][p2.col]
        }
        sum += max
        dp[p1.row][p1.col][p2.row][p2.col] = sum
        return sum
    }
}
