class Solution {
    // O(n^3)
    fun minimumDistance1(nums: IntArray): Int {
        var minDist = -1        
        for (i in 0 until (nums.size - 2)) {
            val first = nums[i]
            val firstIndex = i

            for (j in (i + 1) until (nums.size - 1)) {
                val second = nums[j]
                val secondIndex = j
                if (first != second) {
                    continue
                }

                for (k in (j + 1) until nums.size) {
                    val third = nums[k]
                    val thirdIndex = k
                    if (second != third) {
                        continue
                    }

                    val dist = ((j - i) + (k - j)) * 2
                    if (minDist == -1) {
                        minDist = dist;
                    } else {
                        minDist = min(minDist, dist)
                    }
                    break
                }
            }
        }
        return minDist
    }

    fun minimumDistance(nums: IntArray): Int {
        val map = mutableMapOf<Int, MutableList<Int>>()

        for ((i, num) in nums.withIndex()) {
            map.getOrPut(num) { mutableListOf<Int>() }.add(i)
        }

        var minDist = Int.MAX_VALUE
        for ((key, list) in map) {
            if (list.size < 3) {
                continue
            }

            for (j in 0 until (list.size - 2)) {
                val dist = (list[j + 2] - list[j]) * 2
                minDist = min(minDist, dist)
            }
        }

        return if (minDist == Int.MAX_VALUE) -1 else minDist
    }
}
