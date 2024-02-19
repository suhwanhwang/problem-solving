class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n < 1) return false
        
        var num = 1L
        while (num < n) {
            num *= 2
        }
        return num == n.toLong()
    }
}
