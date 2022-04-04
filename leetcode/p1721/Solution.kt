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
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        
        var cur = dummy.next
        var index = 1;
        while (cur != null && index < k) {
            cur = cur.next
            index++
        }
        
        
        var curTail = dummy.next
        var fast = curTail
        var indexTail = 1
        while(fast != null && indexTail < k) {
            fast = fast.next
            indexTail++
        }
        
        while (fast.next != null) {
            curTail = curTail.next
            fast = fast.next
        }
        
        val temp = cur.`val`
        cur.`val` = curTail.`val`
        curTail.`val`= temp
        return dummy.next
    }
