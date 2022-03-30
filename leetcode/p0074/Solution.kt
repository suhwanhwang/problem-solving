class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val col = matrix[0].size
        var left = 0
        var right = matrix.size * col - 1
        while (left <= right) {
            val mid = (left + right) ushr 1
            val num = matrix[mid / col][mid % col]
            if (num == target) {
                return true
            } else if (num < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return false
    }
}
