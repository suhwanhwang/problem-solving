class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var max = 0
        var left = 0;
        var right = 0;
        while (left <= right && right < s.length) {
            if (set.contains(s[right])) {
                set.remove(s[left])
                left++
            } else {
                set.add(s[right])
                right++
                max = Math.max(max, set.size)
            }
        }
        return max
    }
}
