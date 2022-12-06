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
    public ListNode oddEvenList(ListNode head) {
        ListNode prev = new ListNode();
        prev.next = head;
        
        ListNode dummy = new ListNode();
        ListNode cur = head;
        ListNode even = dummy;
        while (cur != null) {
            ListNode next = cur.next;
            even.next = next;
            even = even.next;

            cur.next = (next == null ? null : next.next);
            prev = cur;
            cur = cur.next;
        }
        prev.next = dummy.next;
        return head;
    }
}
