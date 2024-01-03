class Solution {
    fun numberOfBeams(bank: Array<String>): Int {
        var count = 0
        
        val converted = bank
        .map { getLaserNum(it) }
        .filter { it > 0 }
        
        if (converted.isEmpty()) return 0
        
        var prev = converted[0]
        for (i in 1 until converted.size) {
            count += (prev * converted[i])
            prev = converted[i]
        }
        return count
    }

    private fun getLaserNum(s: String): Int {
        return s.map { it - '0' }.sum()
    }
}
