class Solution {
    fun tribonacci(n: Int): Int {
        
        val prev = intArrayOf(0, 1, 1)
        if (n < 3) return prev[n]
        
        for (i in 3..n) {
            val temp = prev[0]
            prev[0] = prev[1]
            prev[1] = prev[2]
            prev[2] = temp + prev[0] + prev[1]
        }
        return prev[2]
    }
}
