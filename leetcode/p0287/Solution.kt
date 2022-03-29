class Solution {
    fun findDuplicate_sort(nums: IntArray): Int {
        val sorted = nums.sorted()
        for (i in 1 until sorted.size) {
            if (sorted[i - 1] == sorted[i]) {
                return sorted[i]
            }
        }
        return -1
    }
    
    fun findDuplicate(nums: IntArray): Int {
        var duplicatedNum = -1
        for (i in nums.indices) {
            val cur = Math.abs(nums[i])
            if (nums[cur] < 0) {
                duplicatedNum = cur
                break
            } else {
                nums[cur] *= -1
            }
        }
        for (i in nums.indices) {
            nums[i] = Math.abs(nums[i])
        }
        return duplicatedNum
    }
}
