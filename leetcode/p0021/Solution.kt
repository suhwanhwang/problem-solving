class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode()
        var prev = dummy
        var l1 = list1
        var l2 = list2
        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                prev.next = l1
                l1 = l1.next
            } else {
                prev.next = l2
                l2 = l2.next
            }
            prev = prev.next
        }
        prev.next = if (l1 != null) l1 else l2
        
        return dummy.next;
    }
}
