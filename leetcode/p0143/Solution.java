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
    public void reorderList(ListNode head) {
        ListNode midNode = getMid(head);
        if (midNode == null) {
            return;
        }
        ListNode reversed = reverse(midNode);
        
        ListNode prev = null;
        ListNode cur = head;
        ListNode reversedCur = reversed;
        
        while(cur != null && reversedCur != null) {
            
            ListNode next = cur.next;
            ListNode reversedNext = reversedCur.next;
            
            cur.next = reversedCur;
            cur.next.next = next;
            
            cur = next;
            prev = reversedCur;
            reversedCur = reversedNext;
        }
        if (reversedCur != null) {
            prev.next = reversedCur;
        }
    }
    
    private ListNode getMid(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }
    
    // 1-2-3-n
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
