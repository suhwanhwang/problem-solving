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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyFirst = new ListNode();
        ListNode first = dummyFirst;
        
        ListNode dummySecond = new ListNode();
        ListNode second = dummySecond;
        
        ListNode cur = head;
        
        while (cur != null) {
            ListNode next = cur.next;
            
            if (cur.val < x) {
                first.next = cur;
                first = cur;
            } else {
                second.next = cur;
                second = cur;
            }
            cur.next = null;
            cur = next;
        }
        first.next = dummySecond.next;
        return dummyFirst.next;
    }
}
