class Solution {
    private val allSet = mutableListOf<List<Int>>()
    
    fun subsets(nums: IntArray): List<List<Int>> {
        allSet.clear()
        helper(nums, 0, mutableListOf<Int>())
        return allSet
    }
    
    private fun helper(nums: IntArray, index: Int, list: MutableList<Int>) {
        if (index >= nums.size) {
            allSet.add(ArrayList(list))
            return
        }
        
        helper(nums, index + 1, list)
        list.add(nums[index])
        helper(nums, index + 1, list)
        list.removeAt(list.size - 1)
    }
}
