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
/*
          1 4 3 2 5 2
head      ^
cur                   ^
        d 1 2 2 4 3 5
newNode             ^ 
x       3
*/
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode();
        
        ListNode newNode = dummy;
        ListNode cur = head;
        while(cur != null) {
            if (cur.val < x) {
                newNode.next = new ListNode(cur.val);
                newNode = newNode.next;
            }
            cur = cur.next;
        }
        
        cur = head;
        while(cur != null) {
            if (cur.val >= x) {
                newNode.next = new ListNode(cur.val);
                newNode = newNode.next;
            }
            cur = cur.next;
        }
        
        return dummy.next;
    }
}
