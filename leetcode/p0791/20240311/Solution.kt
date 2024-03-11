class Solution {
    fun customSortString(order: String, s: String): String {
        val map = IntArray(26) {0}
        
        for(c in s) {
            map[c - 'a']++
        }
        
        val sb = StringBuilder()
        for (c in order) {
            for(i in 0 until map[c - 'a']) sb.append(c)
            map[c - 'a'] = 0
        }
        for (i in 0 until map.size) {
            for(j in 0 until map[i]) sb.append('a' + i)
        }
        return sb.toString()
    }
}
