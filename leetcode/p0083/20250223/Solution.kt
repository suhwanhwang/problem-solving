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
        val dummy = ListNode(-987654321)
        dummy.next = head

        var prev = dummy
        var cur = head

        while (cur != null) {
            val prevNum = prev?.`val`
            val curNum = cur.`val`
            if (prevNum == curNum) {
                prev?.next = cur.next
            } else {
                prev = cur
            }
            cur = cur.next
        }
        return dummy?.next
    }
}
