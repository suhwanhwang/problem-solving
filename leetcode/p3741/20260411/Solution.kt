class Solution {
    /*
            0 1 2 3 4
    nums = [1,2,1,1,3]

    map  1 -> 0, 2, 3
         2 -> 1
         3 -> 4

    minDist -> Int.MAX_VALUE -> 6
    dist -> 6
     */
    fun minimumDistance(nums: IntArray): Int {
        val map = mutableMapOf<Int, MutableList<Int>>()

        for ((i, num) in nums.withIndex()) {
            map.getOrPut(num) { mutableListOf() }.add(i)
        }

        var minDist = Int.MAX_VALUE
        for ((key, list) in map) {
            if (list.size < 3) {
                continue
            }

            for (i in 0 until (list.size - 2)) {
                // i .. i + 1 .. i + 2
                val dist = (list[i + 2] - list[i]) * 2
                minDist = min(minDist, dist)
            }
        }

        return if (minDist == Int.MAX_VALUE) -1 else minDist
    }
}
