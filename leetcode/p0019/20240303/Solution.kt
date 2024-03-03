class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var dummy = ListNode(0)
        dummy.next = head
        
        var prev:ListNode? = dummy        
        var cur = head
        var next = head
        for (i in 0 until n) {
            next = next?.next
        }
        
        while (next != null) {
            prev = cur
            cur = cur?.next
            next = next?.next
        }
        prev?.next = cur?.next
        return dummy.next
    }
}
