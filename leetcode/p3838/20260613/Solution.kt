class Solution {
    fun mapWordWeights(words: Array<String>, weights: IntArray): String {
        return words.map {
            convert(it, weights)
        }.joinToString("")
    }

    private fun convert(word: String, weights: IntArray): Char {
        val sum = word.map {
            weights[it.code - 'a'.code]
        }.sum()
        return ('a' + (25 - (sum % 26)))
    }
}
