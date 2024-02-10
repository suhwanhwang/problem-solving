class Solution {
    
    /*
    0123
    1234
i      ^
j     ^

g   0112
p   -001
    
    */
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        nums.sort()
        
        val groupSize = IntArray(nums.size)
        val prevIndex = IntArray(nums.size) {-1}
        var maxIndex = 0
        for (i in 0 until nums.size) {
            for (j in 0 until i) {
                if (nums[i] % nums[j] != 0) {
                    continue
                }
                
                if (groupSize[i] < groupSize[j] + 1) {
                    groupSize[i] = groupSize[j] + 1
                    prevIndex[i] = j
                }
                
                if (groupSize[i] > groupSize[maxIndex]) {
                    maxIndex = i
                }
            }
        }
        val list = mutableListOf<Int>()
        var cur = maxIndex
        while (cur != -1) {
            list.add(nums[cur])
            cur = prevIndex[cur]
        }
        return list
    }
}
