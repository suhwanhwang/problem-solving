class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val list = mutableListOf<String>()
        if (nums.size == 0) {
            return list
        }
        var left = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] <= nums[i - 1] + 1) {
                continue
            }
            
            list.add("${left}" + if (left != nums[i - 1]) "->${nums[i - 1]}" else "")
            left = nums[i]
        }
        list.add("${left}"+ if (left != nums[nums.size - 1]) "->${nums[nums.size - 1]}" else "")
        
        return list
    }
}
