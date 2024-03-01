class Solution {
    fun maximumOddBinaryNumber(s: String): String {
        var one = 0
        for (c in s) {
            if (c == '1') one++
        }
        var sb = StringBuilder()
        for (i in 0 until s.length - 1) {
            if (one > 1) {
                sb.append('1')
                one--
            } else {
                sb.append('0')
            }
        }
        if (one == 1)
            sb.append('1')
        return sb.toString()
    }
}
