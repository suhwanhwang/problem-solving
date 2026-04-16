class Solution {
    fun solveQueries(nums: IntArray, queries: IntArray): List<Int> {
        val map = mutableMapOf<Int, TreeSet<Int>>()
        for ((i, num) in nums.withIndex()) {
            map.getOrPut(num) { TreeSet() }.add(i)
        }

        val dists = mutableListOf<Int>()
        for (i in queries) {
            val num = nums[i]
            val set = map[num]
            if (set == null || set.size < 2) {
                dists.add(-1)
                continue
            }

            val higher = set.higher(i) ?: set.first()
            val lower = set.lower(i) ?: set.last()
            val minDist = min(getDist(i, higher, nums.size), getDist(i, lower, nums.size))

            dists.add(minDist)
        }

        return dists
    }

    private fun getDist(i: Int, j: Int, n: Int): Int {
        return min(abs(j - i), n - abs(j - i))
    }

    /*
    fun solveQueries_bf(nums: IntArray, queries: IntArray): List<Int> {
        val dists = mutableListOf<Int>()

        for (i in queries) {
            dists.add(getMinDist(i, nums))
        }
        return dists
    }
    
    private fun getMinDist(index: Int, nums: IntArray): Int {
        val num = nums[index]
        for (i in 1 until nums.size) {
            val forward = nums[(index + i) % nums.size]
            val backward = nums[(index - i + nums.size) % nums.size]
            if (num == forward || num == backward) {
                return i
            }
        }
        return -1
    }
    */
}
