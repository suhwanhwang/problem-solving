class Solution {
    fun largestOddNumber(num: String): String {
        for (i in (num.length-1) downTo 0) {
            if (num[i].toInt() % 2 != 0) {
                return num.substring(0, i + 1)
            }
        }
        return ""
    }
}
