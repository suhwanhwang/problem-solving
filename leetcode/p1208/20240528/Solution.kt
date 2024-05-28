class Solution {
    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        
        var max = 0
        
        for (i in 0 until s.length) {
            var cost = 0
            for (j in i until s.length) {
                cost += abs(s[j] - t[j])
                if (maxCost < cost) break
                max = max(max, j - i + 1)
            }
        }
        return max
    }
}
