class Solution {
    fun countSubstrings(s: String): Int {
        var count = 0
        
        for (i in s.indices) {
            count += getPalindrome(s, i)
        }
        return count
    }
    
    private fun getPalindrome(s: String, index: Int): Int {
        var count = 0
        // odd
        for (i in 0..Math.min(index, s.length - index - 1)) {
            if (s[index - i] == s[index + i]) {
                count++
            } else {
                break
            }
        }
        
        //even
        for (i in 0..Math.min(index, s.length - index - 2)) {
            if (s[index - i] == s[index + 1 + i]) {
                count++
            } else {
                break
            }
        }
        return count;
    }
}
