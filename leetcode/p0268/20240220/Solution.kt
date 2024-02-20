class Solution {
    fun missingNumber_(nums: IntArray): Int {
        nums.sort()
        
        for (i in 0 until nums.size) {
            if (nums[i] != i) {
                return i
            }
        }
        return nums.size
    }
    
    fun missingNumber(nums: IntArray): Int {
        return nums.size * (nums.size + 1) / 2 - nums.sum()
    }
}
