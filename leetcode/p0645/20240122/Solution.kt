class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val currentSet = mutableSetOf<Int>()
        val remainSet = mutableSetOf<Int>()
        for (i in 1..nums.size) remainSet.add(i)
        
        var duplicated = 0
        for (num in nums) {
            if (currentSet.contains(num)) {
                duplicated = num
            }
            currentSet.add(num)
            remainSet.remove(num)
        }
        return intArrayOf(duplicated, remainSet.first())
    }
}
