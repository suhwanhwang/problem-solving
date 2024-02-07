class Solution {
    fun frequencySort(s: String): String {
        val map = mutableMapOf<Char, Int>()
        for (c in s) {
            map[c] = (map[c] ?: 0) + 1
        }
        
        return s.toList()
            .sortedWith(
              compareByDescending<Char>{ map[it]!! }
                .thenBy {it})
            .joinToString("")
    }
}
