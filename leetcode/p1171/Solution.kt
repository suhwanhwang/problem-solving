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
    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        
        var start:ListNode? = dummy
        while (start != null) {
            var sum = 0
            var cur = start.next
            while (cur != null) {
                sum += (cur?.`val` ?: 0)
                if (sum == 0) {
                    start.next = cur.next
                }
                cur = cur?.next
            }
            start = start?.next
        }
        return dummy.next
    }
}
