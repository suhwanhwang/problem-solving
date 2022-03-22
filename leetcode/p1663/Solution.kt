class Solution {
    fun getSmallestString(n: Int, k: Int): String {
        val sb = StringBuilder()
        var remain = k
        for (i in (n - 1) downTo 0) {
            val value = Math.min(remain - i, 26)
            sb.append('a' + value - 1)
            remain -= value
        }
        return sb.reverse().toString()
    }
}
