class Solution {
    
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        val visited = Array(grid.size) {
            BooleanArray(grid[0].size)
        }
        
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == '0' || visited[i][j]) continue
                
                count++
                dfs(grid, i, j, visited)
            }
        }
        return count
    }
    
    private val DIR = arrayOf(
        intArrayOf(0,1),
        intArrayOf(1,0),
        intArrayOf(-1,0),
        intArrayOf(0,-1),
    )
    private fun dfs(grid: Array<CharArray>, row: Int, col: Int, visited: Array<BooleanArray>) {
        visited[row][col] = true
        for (d in DIR) {
            val nr = row + d[0]
            val nc = col + d[1]
            
            if (nr < 0 || nr >= grid.size || nc < 0 || nc >= grid[0].size || grid[row][col] == '0' || visited[nr][nc]) {
                continue
            }
            dfs(grid, nr, nc, visited)
        }
    }
}
