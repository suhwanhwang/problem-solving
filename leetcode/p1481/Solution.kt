class Solution {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val map = mutableMapOf<Int, Int>()
        for (num in arr) {
            map[num] = (map[num] ?: 0) + 1
        }
        
        val countList = map.values.sorted()
        var index = 0
        var remain = k
        while (index < countList.size) {
            if (countList[index] > remain) {
                break
            }
            remain -= countList[index]
            index++
        }
        return countList.size - index
    }
}
