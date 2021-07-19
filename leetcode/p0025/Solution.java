/**
https://leetcode.com/problems/reverse-nodes-in-k-group/

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
    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        
        for (int i = 0; i < list.size(); i += k) {
            if (i + k > list.size()) {
                break;
            }
            for (int j = 0; j < k / 2; ++j) {
                Collections.swap(list, i + j, i + k - 1 - j);
            }
        }
        
        ListNode reversedHead = list.get(0);
        for (int i = 1; i < list.size(); ++i) {
            ListNode prev = list.get(i - 1);
            ListNode next = list.get(i);
            prev.next = next;
        }
        list.get(list.size() - 1).next = null;
        return reversedHead;
    }
}
