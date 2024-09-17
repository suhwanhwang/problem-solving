class Solution {
    fun uncommonFromSentences(s1: String, s2: String): Array<String> {
        val word1 = s1.split(" ")
        val word2 = s2.split(" ")
        
        val map = mutableMapOf<String, Int>()
        for (word in word1) {
            map[word] = (map[word] ?: 0) + 1
        }
        
        for (word in word2) {
            map[word] = (map[word] ?: 0) + 1
        }

        return map.filterValues { it == 1 }.keys.toTypedArray()
    }
}
