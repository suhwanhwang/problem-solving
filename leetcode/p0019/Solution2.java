class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i < n; ++i) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        return dummy.next;
    }
}
