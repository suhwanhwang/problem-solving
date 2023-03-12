class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val next = Array(board.size) { IntArray(board[0].size) { 0 } }
        
        for (i in board.indices) {
            for (j in board[i].indices) {
                next[i][j] = getLive(board, i, j)
            }
        }
        
        for (i in board.indices) {
            for (j in board[i].indices) {
                board[i][j] = next[i][j]
            }
        }
    }
    
    val DIR = arrayOf(intArrayOf(-1, -1), intArrayOf(0, -1), intArrayOf(1, -1), 
                            intArrayOf(-1, 0), intArrayOf(1, 0),
                           intArrayOf(-1, 1), intArrayOf(0, 1), intArrayOf(1, 1))
    fun getLive(board: Array<IntArray>, row: Int, col: Int): Int {
        var count = 0
        for (dir in DIR) {
            val nextC = col + dir[0];
            val nextR = row + dir[1];
            if (nextC < 0 || nextC >= board[row].size || nextR < 0 || nextR >= board.size) {
                continue
            }
            if (board[nextR][nextC] == 1) {
                count++
            }
        }
        return if (board[row][col] == 1) {
            if (count < 2) 
                0 
            else if (count == 2 || count == 3) 
                1 
            else
                0
        } else {
            if (count == 3) 1 else 0
        }
    }
}
