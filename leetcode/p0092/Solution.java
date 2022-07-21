class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        int pos = 1;
        while (cur != null) {
            if (pos == left) {
                break;
            }
            prev = cur;
            cur = cur.next;
            pos++;

        }
        
        ListNode prevHead = prev;
        ListNode curTail = cur;
        ListNode next = cur.next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            if (pos == right) {
                break;
            }
            prev = cur;
            cur = next;
            pos++;
        }
        if (prevHead != null)
            prevHead.next = cur;
        if (curTail != null)
            curTail.next = next;
        return dummy.next;
    }
}
