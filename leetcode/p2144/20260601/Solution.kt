class Solution {
    fun minimumCost(cost: IntArray): Int {
        val sortedCost = cost.sortedByDescending { it }
        
        var minCost = 0
        for ((i, c) in sortedCost.withIndex()) {
            if (i % 3 == 2) {
                continue
            }
            minCost += c
        }
        return minCost
    }
}
