class Solution {
    fun closestTarget(words: Array<String>, target: String, startIndex: Int): Int {
        var minDist = Int.MAX_VALUE

        for (i in 0 until words.size) {
            val foward = (startIndex + i) % words.size
            val backward = (startIndex - i + words.size) % words.size
            if (words[foward] == target || words[backward] == target) {
                minDist = min(minDist, i)
            }
        }
        return if (minDist == Int.MAX_VALUE) -1 else minDist
    }
}
