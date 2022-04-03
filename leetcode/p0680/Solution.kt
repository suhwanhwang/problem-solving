class Solution {
    fun validPalindrome(s: String): Boolean {
        return helper(s, 0, s.length-1, false)
    }
    
    private fun helper(s: String, left: Int, right: Int, isDel: Boolean): Boolean {
        if (left >= right) return true
        
        if (s[left] == s[right]) {
            return helper(s, left+1, right-1, isDel)
        } else if (!isDel) {
            return helper(s, left+1, right, true) || helper(s, left, right-1, true)
        } else {
            return false
        }
    }
}
