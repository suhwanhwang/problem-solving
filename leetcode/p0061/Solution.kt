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
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        val length = getLength(head)  
        val rotateCount = if (length != 0) k % length else 0
        
        if (length <= 1 || rotateCount == 0) {
            return head
        }

        val reversed = reverse(head)
        
        // move to rotated node
        var prev:ListNode? = null
        var cur = reversed
        for (i in 0 until rotateCount) {
            prev = cur
            cur = cur?.next
        }
        prev?.next = null
        
        val rotatedLeft = reverse(reversed)
        val rotatedRight = reverse(cur)
        
        // connect rotated left and right
        cur = rotatedLeft
        while(cur != null) {
            prev = cur
            cur = cur.next
        }
        prev?.next = rotatedRight
        return rotatedLeft
    }
    
    private fun print(head: ListNode?) {
        var cur = head
        while (cur != null) {
            print("${cur.`val`} -> ")
            cur = cur.next
        }
        println()
    }
    
    private fun getLength(head: ListNode?): Int {
        var length = 0
        var cur = head
        while (cur != null) {
            length++
            cur = cur.next
        }
        return length
    }
    
    private fun reverse(head: ListNode?): ListNode? {
        if (head == null) return null
        
        var cur = head
        var prev:ListNode? = null
        while(cur != null) {
            val next = cur.next
            cur. next = prev
            prev = cur
            cur = next
        }
        //print(prev)
        return prev
    }
}
