class Solution {
    fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        for (i in tops.indices) {
            map[tops[i]] = (map[tops[i]] ?: 0) + 1
            if (bottoms[i] != tops[i]) {
                map[bottoms[i]] = (map[bottoms[i]] ?: 0) + 1
            }
        }
        //println(map)
        var value = 0
        for ((k,v) in map) {
            if (v == tops.size) {
                value = k
                break
            }
        }
        if (value == 0) return -1
        
        var countTop = 0
        for (t in tops) {
            if (t != value) {
                countTop++
            }
        }
        var countBottom = 0
        for (b in bottoms) {
            if (b != value) {
                countBottom++
            }
        }
        return Math.min(countTop, countBottom)
    }
}
