class Solution {
    fun lengthOfLastWord(s: String): Int {
        val arr = s.split(" ")
        return arr.filter { it.length > 0 }.last().length
    }
}
