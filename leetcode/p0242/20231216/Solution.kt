class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        return getMap(s) == getMap(t)
    }
    
    private fun getMap(s:String): Map<Char, Int> {
        val map = mutableMapOf<Char, Int>()
        for (c in s) {
            map[c] = (map[c] ?: 0) + 1
        }
        return map
    }
}
