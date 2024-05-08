class Solution {
    fun findRelativeRanks(score: IntArray): Array<String> {
        val sorted = score.sortedDescending()
        val map = mutableMapOf<Int, Int>()
        for ((index, value) in sorted.withIndex()) {
            map[value] = index + 1
        }
        //println(map)
        return Array<String>(sorted.size) { 
            val num = map[score[it]]
            when(num) {
                1 -> "Gold Medal"
                2 -> "Silver Medal"  
                3 -> "Bronze Medal"
                else -> num.toString()
            }
        }
    }
}
