class Solution {
    fun majorityElement(nums: IntArray): Int {
        return nums.sorted()[nums.size / 2]
    }
}
