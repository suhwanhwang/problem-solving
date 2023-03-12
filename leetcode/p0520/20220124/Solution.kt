class Solution {
    fun detectCapitalUse(word: String): Boolean {
        return word.matches("([A-Z]+|[A-Z][a-z]+|[a-z]+)".toRegex())
    }
}
