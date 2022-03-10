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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var cur1 = l1
        var cur2 = l2
        var carry = 0
        var prev = dummy
        while(cur1 != null || cur2 != null || carry > 0) {
            val sum = (cur1?.`val` ?: 0) + (cur2?.`val` ?: 0) + carry
            val num = sum % 10
            carry = sum / 10
            
            val node = ListNode(num)
            prev.next = node
            prev = node
            
            if (cur1 != null) {
                cur1 = cur1.next
            }
            
            if (cur2 != null) {
                cur2 = cur2.next
            }
        }
        
        return dummy.next
    }
}
