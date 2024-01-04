class Solution {
    fun minOperations(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            map[num] = (map[num] ?: 0) + 1
        }
        var count = 0
        for ((key, value) in map) {
            if (value < 2) {
                return -1
            }
            
            if (value % 3 == 0) {
                count += (value/3)
            } else if (value % 3 == 2) {
                count += (value/3) + 1
            } else {
                //3 + 3 + 1
                if (value > 4) {
                    count += (value-4)/3 + 2
                } else {
                    count += (value/2)
                }
            }
        }
        return count
    }
}
