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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        
        val dummy = ListNode(987654321)
        dummy.next = head
        var prev = dummy
        var cur = head
        while (cur != null && cur.next != null) {
            if (cur.`val` == cur.next.`val`) {
                var tmp = cur.next
                while (tmp != null && cur.`val` == tmp.`val`) {
                    tmp = tmp.next
                }
                prev.next = tmp
                cur = tmp
            } else {
                prev = cur
                cur = cur.next
            }
            
        }
        return dummy.next
    }
}
