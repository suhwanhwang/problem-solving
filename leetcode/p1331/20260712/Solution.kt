class Solution {
    fun arrayRankTransform(arr: IntArray): IntArray {
        /* 
        val map = TreeMap<Int, MutableList<Int>>()
        for (i in arr.indices) {
            map.getOrPut(arr[i]) { mutableListOf() }.add(i)
        }

        val ans = IntArray(arr.size)
        var rank = 0
        for ((k, v) in map) {
            rank++
            for (i in v) {
                ans[i] = rank
            }
        }
        return ans
        */

        val map = mutableMapOf<Int, Int>()
        for (num in arr.toSortedSet()) {
            map[num] = map.size + 1
        }
        return IntArray(arr.size) {
            map[arr[it]]!!
        }
    }
}
