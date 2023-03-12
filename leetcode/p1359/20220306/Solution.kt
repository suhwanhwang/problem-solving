class Solution {
    val mod = (1e9 +7).toInt()
    fun countOrders(n: Int): Int {
        //if (n == 1) return 1
        
        //return n * (2 * n - 1) * countOrders(n-1)
        var ans:Long = 1
        for (i in 1..n) {
            ans *= i
            ans %= mod
            ans *= (2 * i - 1)
            ans %= mod
        }
        return ans.toInt()
    }
}
