class Solution {
    fun isPowerOfTwo_(n: Int): Boolean {
        if (n < 1) return false
        
        var num = 1L
        while (num < n) {
            num *= 2
        }
        return num == n.toLong()
    }

    fun isPowerOfTwo(n: Int): Boolean {
        return n > 0 && (n and (n - 1) == 0)
    }
}
