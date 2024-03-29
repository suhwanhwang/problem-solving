class Solution {
    fun twoSum_nlogn(numbers: IntArray, target: Int): IntArray {
        
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
    
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.size - 1
        
        while (l < r) {
            val n = numbers[l] + numbers[r]
            if (n == target) {
                return intArrayOf(l+1, r+1)
            } else if (n < target) {
                l++
            } else {
                r--
            }
        }
        return intArrayOf(-1,-1)
    }
}
