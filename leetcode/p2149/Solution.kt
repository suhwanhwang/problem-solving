class Solution {
    fun rearrangeArray(nums: IntArray): IntArray {
        val pos = nums.filter { it > 0 }
        val neg = nums.filter { it < 0 }
        val ans = IntArray(nums.size)
        
        for (i in 0 until nums.size step 2) {
            ans[i] = pos[i/2]
            ans[i+1] = neg[i/2]
        }
        
        return ans
    }
}
