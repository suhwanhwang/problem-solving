/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 0 1 2 3 4 5 6 7 8 9 10
 3 2 0 4 2 0 4 2 0 4 2

 0 2  3 0
 1 4  2 2 x
 2 6  0 4
 3 8  4 0
 4 10 2 2 x

 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public ListNode detectCycle_(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);

            cur = cur.next;
        }
        return null;
    }
}
