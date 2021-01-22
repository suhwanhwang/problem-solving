/**
https://leetcode.com/problems/sort-list/

Given the head of a linked list, return the list after sorting it in ascending order.

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

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
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        
        ListNode cur = head;
        while(cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        
        if (list.size() <= 1) {
            return head;
        }
        
        Collections.sort(list, (node0, node1) -> {
            return node0.val - node1.val;
        });
        
        ListNode sortedHead = list.get(0);
        for (int i = 0; i < list.size() - 1; ++i) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;
        return sortedHead;
    }
}
