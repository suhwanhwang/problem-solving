class Solution {
    
    fun minOperations_tl(nums: IntArray, x: Int): Int {
        val ans = helper(nums, x, 0, nums.size - 1)
        return if (ans >= INF) -1 else ans
    }
    
    private val INF = 987654321
    private fun helper(n: IntArray, x: Int, left: Int, right: Int): Int {
        if(x == 0) return 0
        
        if (left > right || x < 0) return INF
        
        val l = if (left < n.size ) helper(n, x - n[left], left + 1, right) else INF
        val r = if (right >= 0) helper(n, x - n[right], left, right - 1) else INF
        val min = Math.min(l, r)
        return min + 1
    }
    
    
    
    /* nums = [1,1,4,2,3], x = 5 sum = 11
       left          ^
       right             ^
       curSum  5
       max     3
    */
    
    fun minOperations(nums: IntArray, x: Int): Int {
        val sum = nums.sum()
        
        var left = 0
        var right = 0
        var max = -1
        var curSum = 0
        while (right < nums.size) {
            curSum += nums[right++]
            while (curSum > sum - x && left < right ) {
                curSum -= nums[left++]
            }
            if (curSum == sum - x) {
                max = Math.max(max, right - left)
            }
        }
        
        return if (max == -1) -1 else nums.size - max
    }
}
