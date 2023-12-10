class Solution {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val trans = Array<IntArray>(matrix[0].size) { 
            IntArray(matrix.size)
        }
        
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[i].size) {
                trans[j][i] = matrix[i][j]
            }
        }
        return trans
    }
}
