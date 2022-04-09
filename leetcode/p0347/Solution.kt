class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int,Int>()
        nums.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        return map.keys.sortedByDescending {
            map[it]
        }.filterIndexed {index, num ->
            index < k
        }.toIntArray()
    }
}
