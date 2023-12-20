class Solution {
    fun buyChoco(prices: IntArray, money: Int): Int {
        val sum = prices
            .sorted()
            .take(2)
            .sum()
        return if (sum <= money) money - sum else money
    }
}
