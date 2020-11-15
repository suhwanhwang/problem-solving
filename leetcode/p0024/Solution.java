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
        if (head == null) {
            return null;
        }
        
        if (head.next == null) {
            return head;
        }
        
        ListNode ans = head.next;
        ListNode prev = null;
        ListNode cur = head;
        
        /*
                +--------->
        1 <- 2  3 <- 4   null
        |            ^
        +------------+     
        */
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            
            cur.next = cur.next.next;
            next.next = cur;
            
            if (prev != null) {
                prev.next = next;
            }
            prev = cur;
            cur = cur.next;
        }
        
        return ans;
    }
}
