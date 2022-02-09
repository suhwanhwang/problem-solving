class Solution {
    fun findPairs(nums: IntArray, k: Int): Int {
        val map = TreeMap<Int, Int>()
        for (num in nums) {
            map[num] = (map[num] ?: 0) + 1
        }

        var count = 0
        for (num in map.keys) {
            if (map.containsKey(num + k)) {
                if (k != 0 || (map[num] ?: 0) > 1) {
                    count++
                }
            }
        }
        return count
    }
}
