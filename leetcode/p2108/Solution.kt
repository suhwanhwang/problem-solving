class Solution {
    fun firstPalindrome(words: Array<String>): String {
        return words.filter { isPal(it) }.firstOrNull() ?: ""
    }
    
    private fun isPal(s: String): Boolean {
        
        for (i in 0 until (s.length / 2)) {
            if (s[i] != s[s.length - 1 - i]) return false
        }
        return true
    }
}
