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
    fun reorderList(head: ListNode?): Unit {
        val mid = getMid(head)
        val reversed = reverse(mid)
        
        val dummy = ListNode(0)
        var prev = dummy
        var first = head
        var second = reversed
        
        while (first != null && second != null) {
            val firstNext = first.next
            val secondNext = second.next
            
            prev.next = first
            first.next = second
            prev = second
            second.next = null
            
            first = firstNext
            second = secondNext
        }
        if (second != null) {
            prev.next = second
        }
    }
    
    private fun getMid(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        return slow
    }
    
    private fun reverse(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var cur = head
        while(cur != null) {
            val next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }
        return prev
    }
}
