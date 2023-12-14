class Solution {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val row = grid.size
        val col = grid[0].size
        val onesRow = IntArray(row)
        val onesCol = IntArray(col)
        
        val zerosRow = IntArray(row)
        val zerosCol = IntArray(col)
        
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (grid[i][j] == 1) {
                    onesRow[i]++
                    onesCol[j]++
                } else {
                    zerosRow[i]++
                    zerosCol[j]++
                }
            }
        }
        println(onesRow.toList())
        println(onesCol.toList())
        println(zerosRow.toList())
        println(zerosCol.toList())
        
        val diff = Array<IntArray>(row) {IntArray(col)}
        for (i in 0 until row) {
            for (j in 0 until col) {
                diff[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j]
            }
        }
        return diff
    }
}
