class Solution {
    val perm = mutableSetOf<List<Int>>()
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        helper(nums, BooleanArray(nums.size), ArrayList<Int>())
        return ArrayList<List<Int>>(perm)
    }
    
    fun helper(nums: IntArray, used: BooleanArray, list: MutableList<Int>) {
        if (list.size == nums.size) {
            perm.add(ArrayList<Int>(list))
            return
        }
        for (i in nums.indices) {
            if (used[i]) continue
            
            list.add(nums[i])
            used[i] = true
            helper(nums, used, list)
            used[i] = false
            list.removeAt(list.size - 1)
        }
    }
}
