class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val set = mutableSetOf<Int>()
        
        for (i in numbers.indices) {
            val t = target - numbers[i]
            val index = search(numbers, i + 1, numbers.size - 1, t)
            if (index > 0) {
                return intArrayOf(i + 1, index + 1)
            }
        }
        return IntArray(0)
    }
    
    private fun search(numbers: IntArray, left: Int, right: Int, t: Int): Int {
    
        var l = left
        var r = right
        while (l <= r) {
            val m = (l + r) ushr 1
            if (numbers[m] == t) {
                return m
            } else if (numbers[m] < t) {
                l = m + 1
            } else {
                r = m - 1
            }
        }
        return -1
    }
}
