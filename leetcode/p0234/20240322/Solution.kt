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
    fun isPalindrome(head: ListNode?): Boolean {
        // find mid
        val mid = getMid(head)
        print(mid)
        
        // reverse
        var reversed = reverse(mid)
        print(reversed)
        
        // compare
        var cur1 = head
        var cur2 = reversed
        while (cur1 != null && cur2 != null) {
            if (cur1?.`val` != cur2?.`val`) {
                return false
            }
            cur1 = cur1?.next
            cur2 = cur2?.next
        }
        return true
    }
    
    private fun print(head: ListNode?) {
        var cur = head
        while (cur != null) {
            print("${cur.`val`}->")
            cur = cur.next
        }
        println()
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
        var prev:ListNode? = null
        var cur = head
        while (cur != null) {
            val next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }
        return prev
    }
    
}
