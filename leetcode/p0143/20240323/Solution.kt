/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

/*
     d -> 1 -> 2 -> 3 <- 4 <- 5
pre                      ^
first               ^
second              ^

     d -> 1 -> 5 -> 2 -> 4 -> 3 -> null
 */
class Solution {
    fun reorderList(head: ListNode?): Unit {
        // 1. mid
        val mid = getMid(head)

        // 2. reverse
        val reversed = reverse(mid)

        // 3. merge
        val dummy = ListNode(0)
        dummy.next = head

        var pre = dummy
        var first = head
        var second = reversed
        while (first != null && second != null) {
            val firstNext = first.next
            val secondNext = second.next

            pre.next = first
            first.next = second
            second.next = null

            pre = second
            first = firstNext
            second = secondNext
        }
    }

/*

      1 -> 2 -> 3 -> 4 -> 5 -> null
slow            ^
fast                      ^

 */
    private fun getMid(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        return slow
    }

/*

    <- 1 <- 2 <- 3 <- 4 -> null
pre                   ^
cur                        ^
*/
    private fun reverse(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var cur = head
        while (cur != null) {
            val next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        }
        return pre
    }
}
