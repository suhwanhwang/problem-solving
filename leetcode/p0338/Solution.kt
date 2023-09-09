class Solution {
    fun countBits(n: Int): IntArray {
        val arr = IntArray(n + 1)
        
        for (i in 0..n) {
            arr[i] = getCountBit(i)
        }
        return arr
    }
    
    private fun getCountBit(n: Int): Int {
        var count = 0
        var num = n
        while (num > 0) {
            if (num and 1 == 1) {
                count++
            }
            num = num shr 1
        }
        return count
    }
}
