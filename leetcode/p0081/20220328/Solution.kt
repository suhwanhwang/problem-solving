class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        return helper(nums, target, 0, nums.size - 1)
    }
    
    private fun helper(nums: IntArray, target: Int, left: Int, right: Int): Boolean {
        if (left == right) {
            return nums[left] == target
        }
        
        if (nums[left] >= nums[right]) {
            val mid = (left + right) ushr 1
            return helper(nums, target, left, mid) || helper(nums, target, mid + 1, right)
        } else {
            var l = left
            var r = right
            while (l <= r) {
                val mid = (l + r) ushr 1
                if (nums[mid] == target) {
                    return true;
                } else if (nums[mid] < target) {
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            }
            return false
        }
    }
}
