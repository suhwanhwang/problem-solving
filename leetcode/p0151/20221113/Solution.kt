class Solution {
    fun reverseWords(s: String): String {
        return s.split(" ")
        .toList()
        .filter {
            it.length != 0
        }
        .reversed()
        .joinToString(" ")
    }
}
