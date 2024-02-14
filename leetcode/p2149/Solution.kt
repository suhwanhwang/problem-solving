class Solution {
    fun rearrangeArray_(nums: IntArray): IntArray {
        val pos = nums.filter { it > 0 }
        val neg = nums.filter { it < 0 }
        val ans = IntArray(nums.size)
        
        for (i in 0 until nums.size step 2) {
            ans[i] = pos[i/2]
            ans[i+1] = neg[i/2]
        }
        
        return ans
    }

    fun rearrangeArray(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)
        var pos = 0
        var neg = 0
        for (i in 0 until nums.size step 2) {
            while(nums[pos] < 0) pos++
            ans[i] = nums[pos++]
            
            while(nums[neg] > 0) neg++
            ans[i+1] = nums[neg++]
        }
        
        return ans
    }
}
