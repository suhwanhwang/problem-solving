class Solution {
    fun sortList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head
        
        val mid = getMidAndSplit(head)
        val left = sortList(head)
        val right = sortList(mid)
        return mergeList(left, right)
    }
    private fun printList(head: ListNode?) {
        var cur = head
        while(cur != null) {
            print(cur.`val`)
            print("->")
            cur = cur.next
        }
        println()
    }
    private fun getMidAndSplit(head: ListNode?): ListNode? {
        if (head == null) return null
        
        //printList(head)
        var prev = head
        var slow = head
        var fast = head
        while (slow != null && fast != null && fast.next != null) {
            prev = slow
            slow = slow.next
            fast = fast.next.next
        }
        prev?.next = null
        return slow
    }
    
    private fun mergeList(left:ListNode?, right:ListNode?): ListNode? {
        val dummy = ListNode()
        var prev = dummy
        var l = left
        var r = right
        var cur:ListNode? = null
        while (l != null && r != null) {
            if (l.`val` < r.`val`) {
                cur = l
                l = l.next
            } else {
                cur = r
                r = r.next
            }
            prev.next = cur
            prev = cur
        }
        if (l != null) {
            prev.next = l
        } else if (r != null) {
            prev.next = r
        }
        return dummy.next
    }
}
