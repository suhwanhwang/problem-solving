class Solution {
    fun minMirrorPairDistance_nlogn(nums: IntArray): Int {
        
        val map = mutableMapOf<Int, TreeSet<Int>>()

        for ((i, num) in nums.withIndex()) {
            map.getOrPut(num) { TreeSet() }.add(i)
        }

        var minDist = Int.MAX_VALUE

        for ((i, num) in nums.withIndex()) {
            val set = map[getReverse(num)] ?: continue

            val higher = set.higher(i)
            if (higher == null) {
                continue
            }
            minDist = min(minDist, higher - i)
        }

        return if (minDist == Int.MAX_VALUE) -1 else minDist
    }

    private fun getReverse(num: Int): Int {
        return num.toString().reversed().toInt()
    }

    fun minMirrorPairDistance(nums: IntArray): Int {
        val lastSeen = mutableMapOf<Int, Int>()
        var minDist = Int.MAX_VALUE
        
        for ((i, num) in nums.withIndex()) {
            val prev = lastSeen[num]
            if (prev != null) {
                minDist = min(minDist, i - prev)
            }
            val reverse = getReverse(num)
            lastSeen[reverse] = i
        }

        return if (minDist == Int.MAX_VALUE) -1 else minDist
    }
}
