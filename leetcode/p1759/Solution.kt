class Solution {
    companion object {
        private val MOD = (1e9 + 7).toInt()
    }
    fun countHomogenous(s: String): Int {
        var left = 0
        var right = 0
        var count = 0

        while (left <= right) {
            if (right >= s.length || s[left] != s[right]) {
                val len = right - left
                count += getCount(len)
                count %= MOD
                left = right
                
                if (right >= s.length) break
            } else {
                right++
            }
        }
        return count
    }
    // aaa
    // 3 + 2 + 1
    private fun getCount(len: Int): Int {
        var ans: Long = len.toLong() * (len + 1) / 2
        ans %= MOD
        return ans.toInt()
    }
}
