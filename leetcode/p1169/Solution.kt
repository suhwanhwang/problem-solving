class Solution {
    fun countCharacters(words: Array<String>, chars: String): Int {
        val map = getMap(chars)
        var sum = 0
        for (w in words) {
            if (isGood(map, w)) {
                sum += w.length
            }
        }
        return sum
    }
    
    private fun getMap(s: String): IntArray {
        val map = IntArray(26)
        for (c in s) {
            map[c - 'a']++
        }
        return map
    }
    
    private fun isGood(map:IntArray, s: String): Boolean {
        val sMap = getMap(s)
        for (i in 0 until map.size) {
            if (sMap[i] > map[i]) return false
        }
        return true
    }
}
