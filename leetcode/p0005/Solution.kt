class Solution {
    fun longestPalindrome_(s: String): String {
        var maxLen = 0
        var maxPal = ""
        for (i in 0 until s.length) {
            for (j in (i + 1)..s.length) {
                val sub = s.substring(i, j)
            
                if (isPal(sub)) {
                    if (sub.length > maxLen) {
                        maxLen = sub.length
                        maxPal = sub
                    }
                }
            }
        }
        return maxPal
    }
    
    private fun isPal(s: String): Boolean {
        for (i in 0 until s.length / 2) {
            if (s[i] != s[s.length - 1 - i]) {
                return false
            }
        }
        return true
    }
    
    fun longestPalindrome(s: String): String {
        var maxLen = 0
        var maxPal = ""
        for (i in 0 until s.length) {
            
            // odd
            var left = i
            var right = i
            while (left >= 0 && right < s.length) {
                if (s[left] != s[right]) {
                    break
                }
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1
                    maxPal = s.substring(left, right + 1)
                }
                left--
                right++
            }
            
            // even
            left = i
            right = i + 1
            while (left >= 0 && right < s.length) {
                if (s[left] != s[right]) {
                    break
                }
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1
                    maxPal = s.substring(left, right + 1)
                }
                left--
                right++
            }
        }
        return maxPal
    }
    
}
