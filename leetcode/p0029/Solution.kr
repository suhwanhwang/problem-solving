class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        val result = dividend.toLong() / divisor.toLong()
        
        return if (result > Int.MAX_VALUE) Int.MAX_VALUE else if (result < Int.MIN_VALUE) Int.MIN_VALUE else result.toInt()
    }
}
