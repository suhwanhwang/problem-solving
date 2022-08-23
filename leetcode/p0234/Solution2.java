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
    public boolean isPalindrome(ListNode head) {
        // find mid
        ListNode midNode = getMid(head);
        
        // reverse
        ListNode reversed = reverse(midNode);
        
        // compare
        ListNode first = head;
        ListNode second = reversed;
        
        while(first != null && second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }
    
    private void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
    
    /*
        1 -> 2 -> 1 -> null
slow         ^
fast              ^
fast.next               ^
    */
    private ListNode getMid(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(slow != null && fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (prev != null) {
            prev.next = null;
            if (fast != null) {
                slow = slow.next;
            }
        }
        return slow;
    }
    
    /*
        1 <- 2 <- 2 <- 1 -> null
prev                   ^
cur                           ^
next                          ^
    */
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
