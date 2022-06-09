class Solution {
    fun removePalindromeSub(s: String): Int {
        return if (isPal(s)) 1 else 2
        
    }
    private fun isPal(s: String): Boolean {
        for (i in 0 until s.length/2) {
            if (s[i] != s[s.length -1 - i]) {
                return false
            }
        }
        return true
    }
}
