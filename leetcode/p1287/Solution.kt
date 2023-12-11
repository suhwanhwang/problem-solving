class Solution {
    fun findSpecialInteger(arr: IntArray): Int {
        if (arr.size == 1) return arr[0]
        val quater = arr.size / 4
        var count = 1
        var prev = arr[0]
        for(i in 1 until arr.size) {
            if (prev == arr[i]) {
                count++
                if (count > quater) return prev
            } else {
                prev = arr[i]
                count = 1
            }
        }
        return -1
    }
}
