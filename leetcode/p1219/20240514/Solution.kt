class Solution {
    private var visited = Array(25) {
        BooleanArray(25)
    }
    
    fun getMaximumGold(grid: Array<IntArray>): Int {
        var max = 0
        
        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == 0) {
                    continue
                }
                
                val gold = helper(grid, i, j)
                max = max(max, gold)
            }
        }
        return max
    }
    
    private val DIR = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0)
    )
    
    private fun helper(grid: Array<IntArray>, row:Int, col:Int): Int {
        var max = grid[row][col]
        
        visited[row][col] = true
        for (d in DIR) {
            val nr = row + d[0]
            val nc = col + d[1]
            
            if (nr < 0 || nr >= grid.size || nc < 0 || nc >= grid[0].size
               || grid[nr][nc] == 0 || visited[nr][nc]) {
                continue
            }
            max = max(max, grid[row][col] + helper(grid, nr, nc))
        }
        visited[row][col] = false
        return max
    }
}
