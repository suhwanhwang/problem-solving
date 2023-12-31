class Solution {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
        val map = Array<IntArray>(26) { intArrayOf(-1, -1) }
        
        for ((i, c) in s.withIndex()) {
            if (map[c - 'a'][0] == -1) {
                map[c - 'a'][0] = i
            } else {
                map[c - 'a'][1] = i
            }
        }
        
        var max = -1
        for (p in map) {
            if (p[0] == -1 || p[1] == -1) {
                continue
            }
            max = max(max, p[1] - p[0] - 1)
        }
        return max
    }
}
