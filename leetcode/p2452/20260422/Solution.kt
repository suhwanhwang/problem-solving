class Solution {
    fun twoEditWords(queries: Array<String>, dictionary: Array<String>): List<String> {
        val result = mutableListOf<String>()

        for (q in queries) {
            if (isMatched(q, dictionary)) {
                result.add(q)
            }
        }

        return result
    }

    private fun isMatched(q: String, dictionary: Array<String>): Boolean {
        for (word in dictionary) {
            if (q.length != word.length) {
                continue
            }

            var count = 0
            for (i in q.indices) {
                if (q[i] != word[i]) {
                    count++
                    if (count > 2) {
                        break
                    }
                }
            }
            if (count <= 2) {
                return true
            }
        }
        return false
    }
}
