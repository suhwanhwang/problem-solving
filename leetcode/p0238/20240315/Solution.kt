class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val pre = IntArray(nums.size)
        val post = IntArray(nums.size)
        
        pre[0] = 1
        for (i in 1 until pre.size) {
            pre[i] = pre[i - 1] * nums[i - 1]
        }
        
        post[post.size - 1] = 1
        for (i in (post.size - 2) downTo 0) {
            post[i] = post[i + 1] * nums[i + 1]
        }
        
        val ans = IntArray(nums.size)
        for (i in 0 until ans.size) {
            ans[i] = pre[i] * post[i]
        }
        
        return ans
    }
}
