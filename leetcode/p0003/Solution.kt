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
    fun getIntersectionNode_on(headA:ListNode?, headB:ListNode?):ListNode? {
        
        val set = mutableSetOf<ListNode>()
        var cur = headA
        while (cur != null) {
            set.add(cur)
            cur = cur.next
        }
        
        cur = headB
        while (cur != null) {
            if (set.contains(cur)) {
                return cur
            }
            cur = cur.next
        }
        return null
    }
    
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        var hA = headA
        var hB = headB
        var curA = hA
        var curB = hB
        
        while (curA != null && curB != null && curA != curB) {
           if (curA.next != null) {
               curA = curA.next
           } else {
               curA = hB
               hB = null
           }
           
           if (curB.next != null) {
               curB = curB.next
           } else {
               curB = hA
               hA = null
           }
        }
        return curA
    }
}
