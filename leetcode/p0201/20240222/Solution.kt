class Solution {
    /*
    101
    110
    111
    
    101 + 1 = 110
    101 + 100 = 
    */
    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        var result = 0L
        val l = left.toLong()
        val r = right.toLong()
        for (i in 0..31) {
            val mask = (1L shl i)
            if (l and mask != 0L) {
                val nextNum = (l and (mask - 1).inv()) + mask
                if (r < nextNum) {
                    result = (result or mask)
                }
            }
        }
        return result.toInt()
    }
}
