class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val map = mutableMapOf<Char, Char>()
        var index = 0
        val normalizedPattern = pattern
            .map {
                if (map[it] == null) {
                    map[it] = 'a' + index++
                }
                map[it]
            }
            .joinToString("")

        index = 0
        val tokenMap = mutableMapOf<String, Char>()

        return s.split(" ")
            .map {
                if (tokenMap[it] == null) {
                    tokenMap[it] = 'a' + index++
                }
                tokenMap[it]
            }
            .joinToString("")
            .equals(normalizedPattern)
    }
}
