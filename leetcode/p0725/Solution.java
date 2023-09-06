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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = getSize(head);
        int[] nums = new int[k];
        int slot = 0;
        for (int i = 0; i < count; ++i) {
            nums[slot]++;
            slot = (slot + 1) % k;
        }
        
        ListNode[] nodes = new ListNode[k];
        ListNode cur = head;
        for (int i = 0; i < nodes.length; ++i) {
            int nodeNum = nums[i];
            if (cur == null || nodeNum == 0) {
                break;
            }
            
            nodes[i] = cur;
            ListNode prev = null;
            for (int j = 0; j < nodeNum; ++j) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = null;
        }
        return nodes;
    }
    
    private int getSize(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
