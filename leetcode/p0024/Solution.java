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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode cur = head;
        
        /*
                 |--------->
        1 <- 2  3 <- 4   null
        |       ^    ^
        +------------+     
        */
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
