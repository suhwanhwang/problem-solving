class Solution {
    fun minSteps(s: String, t: String): Int {
        var count = 0
        val sMap = s.getMap()
        val tMap = t.getMap()
        
        for ((key, value) in sMap) {
            val tValue = tMap[key] ?: 0
            if (value > tValue) count += value - tValue
        }
        return count
    }
    
    private fun String.getMap(): Map<Char, Int> {
        val map = mutableMapOf<Char, Int>()
        for (c in this) {
            map[c] = (map[c] ?: 0) + 1
        }
        return map
    }
}
