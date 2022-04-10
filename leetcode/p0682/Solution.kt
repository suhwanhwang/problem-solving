class Solution {
    fun calPoints(ops: Array<String>): Int {
        val scores = mutableListOf<Int>()
        for (op in ops) {
            when (op) {
            "+" -> scores.add(scores[scores.size - 1] + scores[scores.size - 2])
            "D" -> scores.add(scores[scores.size - 1] * 2)
            "C" -> scores.removeAt(scores.size - 1)
            else -> scores.add(op.toInt())
            }
        }
        return scores.sum()
    }
}
