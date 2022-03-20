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
        var values = map.filter { it.value == tops.size }.map { it.key }
        if (values.size == 0) return -1
        
        var countTop = tops.count { it != values[0] }
        var countBottom = bottoms.count { it != values[0] }
        return Math.min(countTop, countBottom)
    }
}
