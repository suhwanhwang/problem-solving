class Solution {
    fun totalNQueens(n: Int): Int {
        helper(n, 0, mutableSetOf<Int>(), mutableSetOf<Int>(), mutableSetOf<Int>(), mutableListOf<String>())
        return ans.size
    }
    
    private val ans = mutableListOf<List<String>>()
    
    private fun helper(n: Int, row: Int, colSet:MutableSet<Int>, diffSet:MutableSet<Int>,sumSet:MutableSet<Int>, board: MutableList<String>) {
        if (row == n) {
            ans.add(ArrayList<String>(board))
            //println(board)
            return
        }
            
        for (c in 0 until n) {
            if (!isAvailable(row, c, colSet, diffSet, sumSet)) {
                continue
            }
            
            val charArray = CharArray(n) { '.' }
            charArray[c] = 'Q'
            board.add(String(charArray))
            diffSet.add(row - c)
            sumSet.add(row + c)
            colSet.add(c)
            helper(n, row + 1, colSet, diffSet, sumSet, board)
            colSet.remove(c)
            diffSet.remove(row - c)
            sumSet.remove(row + c)
            board.removeAt(board.size - 1)
        }   
    }
    
    private fun isAvailable(r: Int, c: Int, colSet:Set<Int>, diffSet:Set<Int>, sumSet:MutableSet<Int>): Boolean {
        if (colSet.contains(c)) {
            return false
        }
        
        return !diffSet.contains(r - c) and !sumSet.contains(r + c)
    }
}
