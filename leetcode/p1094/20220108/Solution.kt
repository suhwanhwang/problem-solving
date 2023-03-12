class Solution {
    class Transaction(val num: Int, val start:Int, val end:Int)
    
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        var curCapacity = 0
        var maxCapacity = 0
        val pq = PriorityQueue<Transaction> { t1, t2 ->
            t1.end - t2.end 
        }
        trips
            .map { Transaction(it[0], it[1], it[2])}
            .sortedBy { it.start }
            .forEach {
                while(!pq.isEmpty() && pq.peek().end <= it.start) {
                    curCapacity -= pq.poll().num
                }
                pq.offer(it)
                curCapacity += it.num
                maxCapacity = Math.max(maxCapacity, curCapacity);
            }
        return maxCapacity <= capacity
    }
}
