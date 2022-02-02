class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val pMap = IntArray(26) {0}
        for (c in p) {
            pMap[c - 'a']++
        }
        //println(pMap.toList())
        val sMap = IntArray(26) {0}
        var start = 0
        val ans = mutableListOf<Int>()
        for(i in 0 until s.length) {
            if (p.length < (i - start + 1)) {
                sMap[s[start] - 'a']--
                start++
            }
            sMap[s[i] - 'a']++
            //println(sMap.toList())
            if (p.length == (i - start + 1) && pMap contentEquals sMap) {
                ans.add(start)
            }
        }
        return ans
    }
}
