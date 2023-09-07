/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode startPrev = null;
        ListNode start = null;
        ListNode end = null;
        for (int i = 1; i <= right; ++i) {
            if (i == left) {
                startPrev = prev;
                start = cur;
            }
            if (i == right) {
                end = cur;
            }
            if (i >= left && i <= right) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            } else {
                prev = cur;
                cur = cur.next;
            }
            
        }
        startPrev.next = end;
        start.next = cur;
        return dummy.next;
    }
}
