class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        var max = 0
        val dp = Array(matrix.size) { IntArray(matrix[0].size) { -1 } }

        for (r in matrix.indices) {
            for (c in matrix[r].indices) {
                if (dp[r][c] != -1) continue
                
                max = Math.max(max, 1 + dfs(matrix, r, c, dp))
            }
        }
        return max
    }
    
    private val DIR = listOf(listOf(0, -1), listOf(0, 1), listOf(-1, 0), listOf(1, 0))
    
    private fun dfs(m: Array<IntArray>, row:Int, col:Int, dp: Array<IntArray>): Int {
        if (dp[row][col] != -1) {
            return dp[row][col]
        }
        
        val cur = m[row][col]
        var max = 0
        for (d in DIR) {
            val nr = row + d[0]
            val nc = col + d[1]
            if (nr < 0 || nr >= m.size || nc < 0 || nc >= m[0].size ||
               m[nr][nc] <= cur) {
                continue
            }
            max = Math.max(max, 1 + dfs(m, nr, nc, dp))
        }
        dp[row][col] = max
        return max
    }
}
