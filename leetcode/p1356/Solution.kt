class Solution {
    fun sortByBits(arr: IntArray): IntArray {
        return arr.sortedWith(compareBy({ getBitCount(it) }, { it })).toIntArray()
    }

    private fun getBitCount(num: Int): Int {
        var count = 0
        var cur = num
        while (cur != 0) {
            if ((cur and 0x1) == 0x1) {
                count++
            }
            cur = (cur shr 1)
        }
        return count
    }
}
