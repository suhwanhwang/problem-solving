class Solution {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val counts = IntArray(mat.size) { mat[it].count { it == 1 } }
        return List(mat.size) { it }
            .sortedBy { counts[it] }
            .dropLast(mat.size - k)
            .toIntArray()
    }
}
