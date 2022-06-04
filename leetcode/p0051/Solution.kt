class Solution {
    private val ans = mutableListOf<List<String>>()
    
    fun solveNQueens(n: Int): List<List<String>> {
        helper(n, 0, mutableSetOf<Int>(), mutableListOf<Pair<Int, Int>>(), mutableListOf<String>())
        return ans
    }
    
    private fun helper(n: Int, row: Int, colSet:MutableSet<Int>, queens:MutableList<Pair<Int,Int>>, board: MutableList<String>) {
        if (row == n) {
            ans.add(ArrayList<String>(board))
            return
        }
        
        //println(board)
            
        for (c in 0 until n) {
            if (!isAvailable(row, c, colSet, queens)) {
                continue
            }
            
            val charArray = CharArray(n) { '.' }
            charArray[c] = 'Q'
            board.add(String(charArray))
            queens.add(Pair(row, c))
            colSet.add(c)
            helper(n, row + 1, colSet, queens, board)
            colSet.remove(c)
            queens.removeAt(queens.size - 1)
            board.removeAt(board.size - 1)
        }   
    }
    
    private fun isAvailable(r: Int, c: Int, colSet:Set<Int>, queens:List<Pair<Int,Int>>): Boolean {
        if (colSet.contains(c)) {
            return false
        }
        
        for (q in queens) {
            val delta = r - q.first
            if (c == q.second + delta || c == q.second - delta) {
                return false
            } 
        }
        return true
    }
}
