class Solution {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val row = grid.size
        val col = grid[0].size
        val modK = k % (row*col)
        val list = mutableListOf<Int>()
        
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                list.add(grid[i][j])
            }
        }
        list.reverse()
        list.subList(0, modK).reverse()
        list.subList(modK, list.size).reverse()
        
        val ans = mutableListOf<List<Int>>()
        for (i in 0 until row) {
            ans.add(list.subList(i * col, (i+1)*col))
        }
        return ans
    }
}
