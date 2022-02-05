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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        ListNode cur[] = new ListNode[lists.length];
        for(int i = 0; i < lists.length; ++i) {
            cur[i] = lists[i];
        }

        while (true) {
            ListNode min = null;
            int minIndex = -1;
            for(int i = 0; i < cur.length; ++i) {
                if (cur[i] == null) {
                    continue;
                }
                if (min == null || cur[i].val < min.val) {
                    min = cur[i];
                    minIndex = i;
                }
            }
            if (min == null) {
                break;
            }
            cur[minIndex] = cur[minIndex].next;
            prev.next = min;
            prev = min;
        }
        return dummy.next;
    }
}
