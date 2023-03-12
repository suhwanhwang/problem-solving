/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq = PriorityQueue<ListNode> { a, b -> a.`val` - b.`val` }
        for (node in lists) {
            if (node != null) {
                pq.offer(node)
            }
        }
        val dummy = ListNode()
        var prev = dummy
        while (!pq.isEmpty()) {
            val min = pq.poll()
            prev.next = min
            prev = min
            if (min.next != null) {
                pq.offer(min.next)
            }
        }
        return dummy.next
    }
}
