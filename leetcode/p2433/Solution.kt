class Solution {
    /*
    0101
    0010
    0111
    
    */
    fun findArray(pref: IntArray): IntArray {
        val ans = IntArray(pref.size)
        ans[0] = pref[0]
        for (i in 1 until pref.size) {
            ans[i] = getXorNum(pref[i - 1], pref[i])
        }
        return ans
    }
    
    private fun getXorNum(from:Int, to: Int):Int {
        var num = 0
        for (i in 0..31) {
            val mask = (1 shl i)
            if ((to and mask) != 0) {
                num = (num or if ((from and mask) == 0) {
                    mask
                } else {
                    0
                })
            } else {
                num = (num or (from and mask))
            }
        }
        return num
    }
}
