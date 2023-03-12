class Solution {
    fun titleToNumber(columnTitle: String): Int {
        var num = 0
        for (c in columnTitle) {
            num *= 26
            num += (c - 'A') + 1
        }
        return num
    }
}
