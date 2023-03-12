class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val len = k % nums.size
        nums.reverse()
        nums.reverse(0, len)
        nums.reverse(len, nums.size)
    }
    fun IntArray.reverse(from:Int, to:Int) {
        for (i in 0 until (to - from) / 2) {
            val temp = this[from + i]
            this[from + i] = this[to - 1 - i]
            this[to - 1 - i] = temp
        }
    }
}
