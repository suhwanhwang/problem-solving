class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode()
        dummy.next = head
        
        var prev = dummy
        var cur = head
        while (cur != null && cur.next != null) {
            val next = cur.next
            
            cur.next = next.next
            next.next = cur
            prev.next = next
            
            prev = cur
            cur = cur.next
        }
        return dummy.next
    }
}
