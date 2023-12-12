class Solution {
    fun maxProduct_(nums: IntArray): Int {
        nums.sort()
        return (nums[nums.size - 1] - 1) * (nums[nums.size - 2] - 1)
    }

    fun maxProduct(nums: IntArray): Int {
        return nums
            .toList()
            .sortedDescending()
            .take(2)
            .map { it - 1 }
            .fold(1) { prod, num -> prod * num }
        
    }
}
