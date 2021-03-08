/*
https://leetcode.com/problems/odd-even-linked-list/


Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
 

Constraints:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
The length of the linked list is between [0, 10^4].
*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode d1 = new ListNode();
        ListNode d2 = new ListNode();
        ListNode p1 = d1;
        ListNode p2 = d2;
        ListNode cur = head;
        ListNode l1 = head;
        while(cur != null) {
            p1.next = cur;
            p2.next = cur.next;

            p1 = p1.next;
            p2 = p2.next;
            l1 = p1;
            cur =(cur.next != null ? cur.next.next : null);
            
        }
        l1.next = d2.next;
        return d1.next;
    }
}
