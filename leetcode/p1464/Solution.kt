class Solution {
    fun maxProduct(nums: IntArray): Int {
        nums.sort()
        return (nums[nums.size - 1] - 1) * (nums[nums.size - 2] - 1)
    }
}
