class Solution {
    fun largestPerimeter(nums: IntArray): Int {
        nums.sort()

        var i = nums.size - 1
        while (i >= 2) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i]
            }
            i--
        }
        return 0
    }
}
