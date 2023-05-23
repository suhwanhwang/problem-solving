class KthLargest(k: Int, nums: IntArray) {
    private val pq = PriorityQueue<Int>()
    private val k:Int
    
    init {
        this.k = k
        for (num in nums) {
            pq.offer(num)
        }
        while (pq.size > k) {
            pq.poll()
        }
    }

    fun add(`val`: Int): Int {
        pq.offer(`val`)
        while (pq.size > k) {
            pq.poll()
        }
        return pq.peek()
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */
