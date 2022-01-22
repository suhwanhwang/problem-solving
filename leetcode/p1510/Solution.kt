class Solution {
    val map = mutableMapOf<Int, Boolean>()
    fun winnerSquareGame(n: Int): Boolean {
        if (n == 0) return false
        val result = map[n]
        if (result != null) {
            return result
        }
        
        for (i in 1..Math.sqrt(n.toDouble()).toInt()) {
            if (!winnerSquareGame(n - i*i)) {
                map[n] = true
                return true
            }
        }
        map[n] = false
        return false
    }
}
