class Solution {
    fun firstUniqChar(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        
        for (c in s) {
            map[c] = (map[c] ?: 0) + 1
        }
        
        for ((index, c) in s.withIndex()) {
            if (map.getOrDefault(c, 0) == 1) {
                return index
            }
        }
        return -1
    }
}
