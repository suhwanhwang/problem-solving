class Solution {
    fun commonChars(words: Array<String>): List<String> {
        val map = getMap(words[0])
        
        for (i in 1 until words.size) {
            val cur = getMap(words[i])
            for (j in 0..25) {
                map[j] = min(map[j], cur[j])
            }
        }
        val ans = mutableListOf<String>()
        
        for (i in 0..25) {
            for (j in 0 until map[i]) {
                ans.add(('a' + i).toString())
            }
        }

        return ans
    }

    private fun getMap(s: String): IntArray {
        val map = IntArray(26) { 0 }
        
        for (c in s) {
            map[c - 'a']++
        }
        return map
    }
}
