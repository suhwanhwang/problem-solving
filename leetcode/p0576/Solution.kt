class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val s1Map = IntArray(26) { 0 }
        val s2Map = IntArray(26) { 0 }

        s1.forEach {
            s1Map[it - 'a']++
        }

        var start = 0
        for (i in 0 until s2.length) {
            s2Map[s2[i] - 'a']++
            val len = i - start + 1
            if (len < s1.length) {
                continue
            }

            if (len > s1.length) {
                s2Map[s2[start] - 'a']--
                start++
            }
            if (s1Map contentEquals  s2Map) {
                return true
            }
        }
        return false
    }
}
