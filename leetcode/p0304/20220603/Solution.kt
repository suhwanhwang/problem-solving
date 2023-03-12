class NumMatrix(matrix: Array<IntArray>) {
    private val rowSum = Array<IntArray>(matrix.size) { IntArray(matrix[0].size) { 0 }}

    init {
        for (i in matrix.indices) {
            rowSum[i][0] = matrix[i][0]
        }
        for (i in matrix.indices) {
            for (j in 1 until matrix[i].size) {
                rowSum[i][j] = rowSum[i][j - 1] + matrix[i][j]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var sum = 0
        for (i in row1..row2) {
            sum += rowSum[i][col2] - (if (col1 == 0) 0 else rowSum[i][col1 - 1])
        }
        return sum 
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */
