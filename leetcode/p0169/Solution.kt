class Solution {
    fun majorityElement_nlogn(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size / 2]
    }
    
    fun majorityElement(nums: IntArray): Int {
        var major = 0
        var count = 0
        for (num in nums) {
            if (count == 0) {
                major = num
            }
            
            if (num == major) {
                count++
            } else {
                count--
            }
        }
        return major
    }
}
