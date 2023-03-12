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
        
        ListNode[] nodes = new ListNode[lists.length];
        for (int i = 0; i < lists.length; ++i) {
            nodes[i] = lists[i];
        }

        while(!isEmpty(nodes)) {
            ListNode minNode = null;
            int minListNum = 0;
            for (int i = 0; i < nodes.length; ++i) {
                int val = nodes[i] != null ? nodes[i].val : Integer.MAX_VALUE;
                if (minNode == null || val < minNode.val) {
                    minNode = nodes[i];
                    minListNum = i;
                }
            }
            nodes[minListNum] = nodes[minListNum].next;

            prev.next = new ListNode(minNode.val);
            prev = prev.next;
        }
        return dummy.next;
    }

    private boolean isEmpty(ListNode[] lists) {
        for (ListNode list : lists) {
            if (list != null) {
                return false;
            }
        }
        return true;
    }
}
