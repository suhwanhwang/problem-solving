class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var index = 0
        for (c in t) {
            if (index == s.length) {
                return true
            }
            if (c != s[index]) {
                continue
            }
            index++
        }
        return index == s.length
    }
}
