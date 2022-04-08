class KthLargest(k: Int, nums: IntArray) {
    val k:Int
    val pqMin = PriorityQueue<Int>()
    val pqMax = PriorityQueue<Int>(Collections.reverseOrder())
    init {
        this.k = k
        for (num in nums) {
            pqMax.offer(num)
        }
        for (i in 1 until k) {
            pqMin.offer(pqMax.poll())
        }
    }
    
    fun add(`val`: Int): Int {
        pqMin.offer(`val`)
        pqMax.offer(pqMin.poll())
        return pqMax.peek()
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */
