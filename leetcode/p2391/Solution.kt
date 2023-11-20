class Solution {
    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        val map = mutableMapOf<Char, Pair<Int,Int>>(
            'G' to Pair(0, -1),
            'M' to Pair(0, -1),
            'P' to Pair(0, -1)
        )
        
        for ((i, curGarbage) in garbage.withIndex()) {
            for (g in curGarbage) {
                for ((key, value) in map) {
                    if (g == key) {
                        map[key] = Pair(value.first +1, i)
                    }
                }
            }
        }
        for ((i, t) in travel.withIndex()) {
            for ((key, value) in map) {
                if (value.second > i) {
                    map[key] = Pair(value.first + t, value.second)
                }
            }
        }
        
        return map.values
            .map { it.first }
            .filter { it > 0 }
            .sum()
    }
}
