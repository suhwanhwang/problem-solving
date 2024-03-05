class Solution {
    fun minimumLength(s: String): Int {
        var left = 0
        var right = s.length - 1
        
        while (left < right) {
            if (s[left] != s[right]) {
                break
            }
            val prefix = s[left]
            while(left < right && s[left] == prefix) {
                left++
            }
            
            while(left <= right && s[right] == prefix) {
                right--
            }
        }
        
        return right - left + 1
    }
}
