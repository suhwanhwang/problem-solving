class Solution {
    fun findMaxLength(nums: IntArray): Int {
        val map = mutableMapOf<Int, MutableList<Int>>()
        var delta = 0
        map[0] = mutableListOf<Int>(-1)
        for ((i, num) in nums.withIndex()) {
            delta += if (num == 0) -1 else 1
            val list = map.getOrDefault(delta, mutableListOf<Int>())
            list.add(i)
            map[delta] = list
        }
        
        var max = 0
        for (entry in map) {
            if (entry.value.size >= 2) {
                max = Math.max(max, entry.value.last() - entry.value.first())
            }
        }
        return max
    }
}
