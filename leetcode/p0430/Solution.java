/*
https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        
        Node cur = head;
        while (cur != null) {
            //System.out.println(cur.val);
            
            if (cur.child != null) {
                Node next = cur.next;
                cur.next = flatten(cur.child);
                cur.next.prev = cur;
                cur.child = null;
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = next;
                if(next != null) {
                    next.prev = cur;
                }
            }
            cur = cur.next;
        }
        return head;
    }
}
