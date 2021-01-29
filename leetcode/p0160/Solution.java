/*
https://leetcode.com/problems/intersection-of-two-linked-lists/description/

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        
        while (curA != curB) {
            if (curA.next != null) {
                curA = curA.next;
            } else {
                curA = headB;
                headB = null;
            }
            if (curB.next != null) {
                curB = curB.next;
            } else {
                curB = headA;
                headA = null;
            }
        }
        return curA;
    }
}
