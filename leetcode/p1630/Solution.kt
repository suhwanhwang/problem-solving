class Solution {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val ans = mutableListOf<Boolean>()
        
        for (i in 0 until l.size) {
            val left = l[i]
            val right = r[i]
            val sorted = nums.filterIndexed { index, _ ->
                left <= index && index <= right
            }.sorted()
            
            var isOk = true
            val diff = sorted[1] - sorted[0]
            for (j in 2 until sorted.size) {
                if (sorted[j] - sorted[j - 1] != diff) {
                    isOk = false
                    break
                }
            }
            ans.add(isOk)
        }
        return ans
    }
}
