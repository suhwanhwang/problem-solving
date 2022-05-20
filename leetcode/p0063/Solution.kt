class Solution {
    val dp = Array(101) { IntArray(101) { -1 }}
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        if (obstacleGrid[0][0] == 1) {
          return 0
        }
        return dfs(obstacleGrid, 0, 0)
    }
    
    val DIR = listOf<List<Int>>(listOf(0,1),listOf(1, 0))
    private fun dfs(o: Array<IntArray>, r: Int, c:Int): Int {
        if (r == o.size - 1 && c == o[0].size - 1) {
            return 1
        }
        if (dp[r][c] != -1) {
            return dp[r][c]
        }
        var sum = 0
        for (d in DIR) {
            val nr = r + d[0]
            val nc = c + d[1]
            if (nr >= o.size || nc >= o[0].size || o[nr][nc]==1) continue
            
            sum += dfs(o, nr, nc)
        }
        dp[r][c] = sum
        return sum
    }
}
