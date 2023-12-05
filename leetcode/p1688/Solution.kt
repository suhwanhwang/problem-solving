class Solution {
    fun numberOfMatches(n: Int): Int {
        if (n <= 1) return 0
        
        return n / 2 + numberOfMatches(n / 2 + (n % 2))
    }
}
