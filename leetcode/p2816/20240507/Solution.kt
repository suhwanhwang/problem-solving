class Solution {
    fun doubleIt(head: ListNode?): ListNode? {
        val reversed = reverse(head)
        
        var prev:ListNode? = null
        var cur = reversed
        var carry = 0
        while (cur != null) {
            val num = (cur?.`val` ?: 0) * 2 + carry
            carry = num / 10
            cur?.`val` = num % 10
            prev = cur
            cur = cur?.next
        }
        if (carry != 0) {
            prev?.next = ListNode(carry)
        }
        
        return reverse(reversed)
    }
    
    /*
    1 -> 2 -> 3 -> null
*/
    
    private fun reverse(head: ListNode?): ListNode? {
        var prev:ListNode? = null
        var cur = head
        while (cur != null) {
            val next = cur?.next
            cur?.next = prev
            prev = cur
            cur = next
        }
        return prev
    }
}
