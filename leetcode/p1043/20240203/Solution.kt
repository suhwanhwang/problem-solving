class Solution {
    /*
    0 1  2 3 4 5 6
    1,15,7,9,2,5,10
    
    */
    
    
    fun maxSumAfterPartitioning_(arr: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>(compareByDescending{ arr[it] })
        
        for (i in 0 until (k - 1)) {
            pq.offer(i)
        }
        
        var sum = 0
        
        for (i in 0 until arr.size) {
            if (i + k - 1 < arr.size) {
                pq.offer(i + k - 1)
            }
            
            var index = 0
            while(!pq.isEmpty()) {
                index = pq.poll()
                if (index >= i) {
                    break
                } 
            }
        
            println(arr[index])
            sum += arr[index]
            if (index >= i) {
                pq.offer(index)
            }
            
        }
        return sum
    }
    
    private val dp = Array<Int>(500 + 1) { - 1 }
    fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        dp.fill(-1)
        return helper(arr, k, 0)
    }
    
    private fun helper(arr: IntArray, k: Int, index: Int): Int {
        if (index >= arr.size) {
            return 0
        }
        
        if (dp[index] != -1) {
            return dp[index]
        }
        
        var maxNum = 0
        var maxSum = 0
        for (i in index until min(arr.size, index + k)) {
            maxNum = max(maxNum, arr[i])
            val sum = maxNum * (i - index + 1) + helper(arr, k, i + 1)
            maxSum = max(maxSum, sum)
        }
        dp[index] = maxSum
        return maxSum
    }
}
