class Solution {
    private val dp = Array<IntArray>(1001) { IntArray(1001) { -1 }}
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        var sum = 0
        for (i in 0 until (nums.size - 2)) {
            val first = nums[i]
            for (j in (i + 1) until (nums.size - 1)) {
                val second = nums[j]
                val diff = second - first
                sum += helper(nums, i, j)
            }
        }
        return sum
    }
    
    private fun helper(nums: IntArray, pIndex: Int, index: Int): Int {
        if (index >= nums.size - 1) return 0
        
        if (dp[pIndex][index] != -1) {
            return dp[pIndex][index]
        }
        
        var count = 0
        val diff:Long = nums[index].toLong() - nums[pIndex].toLong()
        val prev = nums[index]
        for (i in (index + 1) until nums.size) {
            val cur = nums[i]
            val curDiff:Long = cur.toLong() - prev.toLong()
            if (curDiff < diff) {
                continue
            } else if (curDiff == diff) {
                count += 1 + helper(nums, index, i)
            }
        }
        dp[pIndex][index] = count
        return count
    }
}
