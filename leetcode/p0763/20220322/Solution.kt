class Solution {
    fun partitionLabels(s: String): List<Int> {
        val lastPosition = mutableMapOf<Char, Int>()
        for ((i, c) in s.withIndex()) {
            lastPosition[c] = i
        }
        
        val ans = mutableListOf<Int>()
        var start = 0
        while(start < s.length) {
            var last = lastPosition[s[start]] ?: -1
            var i = start + 1
            while (i < last) {
                last = Math.max(last, lastPosition[s[i]] ?: -1)
                i++
            }
            ans.add(last - start + 1)
            start = last + 1
        }
        
        return ans
    }
}
