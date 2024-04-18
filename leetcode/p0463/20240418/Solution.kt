class Solution {
    private val DIR = arrayOf(
        intArrayOf(0, 1), 
        intArrayOf(1, 0), 
        intArrayOf(0, -1),
        intArrayOf(-1, 0),  
    )
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var sum = 0
        for (r in 0 until grid.size) {
            for (c in 0 until grid[r].size) {
                if (grid[r][c] == 0) continue

                for (d in DIR) {
                    val nr = r + d[0]
                    val nc = c + d[1]
                    if (nr < 0 || nr >= grid.size || nc < 0 || nc >= grid[0].size
                    || grid[nr][nc] == 0) {
                        sum++
                    }
                }
            }
        }
        return sum  
    }
}
