class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
        
            cur.next = cur.next.next;
            next.next = cur;
            prev.next = next;
              
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
