class Solution {
    /*
    val INF = 987654321
    val dp = Array<IntArray>(100 + 1) { IntArray(50 + 1) { 0 } }
    
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        return helper(costs, 0, 0)
    }
    
    private fun helper(costs: Array<IntArray>, index: Int, countA: Int): Int {
        if (index >= costs.size) {
            return if (countA != costs.size/2) INF else 0
        }
        
        if (dp[index][countA] != 0) {
            return dp[index][countA]
        }
        
        var minCost = INF
        if (countA < costs.size / 2) {
            minCost = costs[index][0] + helper(costs, index + 1, countA + 1)
        }
        
        minCost = Math.min(minCost, costs[index][1] + helper(costs, index + 1, countA))
        dp[index][countA] = minCost
        return minCost
    }
    */
    
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        costs.sortBy { it[0] - it[1] }
        
        var sum = 0
        for (i in 0 until costs.size / 2) {
            sum += costs[i][0]
        }
        for (i in costs.size / 2 until costs.size) {
            sum += costs[i][1]
        }
        return sum
    }
}
