class Solution {
    fun majorityElement(nums: IntArray): Int {
        return nums.sorted()[nums.size / 2]
    }

    fun majorityElement_n(nums: IntArray): Int {
        var count = 0
        var major = 0
        
        for (num in nums) {
            if(count == 0) {
                major = num
            }
            
            if (num == major) count++
            else count--
        }
        return major
    }
}
