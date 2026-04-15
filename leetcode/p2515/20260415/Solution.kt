class Solution {
    fun closestTarget(words: Array<String>, target: String, startIndex: Int): Int {
        for (i in 0 until words.size) {
            val forward = (startIndex + i) % words.size
            val backward = (startIndex - i + words.size) % words.size
            if (words[forward] == target || words[backward] == target) {
                return i
            }
        }
        return -1
    }
}
