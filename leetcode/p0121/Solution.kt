class Solution {
    fun maxProfit(prices: IntArray): Int {
        var max = 0
        var minPrice = prices[0]
        for (p in prices) {
            max = Math.max(max, p - minPrice)
            minPrice = Math.min(p, minPrice)
        }
        return max
    }
}
