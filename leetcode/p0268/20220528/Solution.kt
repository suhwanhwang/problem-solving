class Solution {
    fun missingNumber(nums: IntArray): Int {
        val n = nums.size
        val sum = nums.sum()
        return n * (n + 1) / 2 - sum
    }
}
