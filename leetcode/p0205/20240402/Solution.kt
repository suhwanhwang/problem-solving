class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        //println(s.convert())
        return s.convert() == t.convert()
    }
    
    private fun String.convert(): List<Int> {
        var lastIndex = 0
        val map = mutableMapOf<Char, Int>()
        return this.map {
            if (!map.contains(it)) {
                map[it] = lastIndex++
            }
            map[it]!!
        }
    }
}
