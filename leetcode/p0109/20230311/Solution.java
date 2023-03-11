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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }
    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        if (head.next == tail) {
            return new TreeNode(head.val);
        }

        ListNode mid = splitNode(head, tail);
        ListNode midNext = mid.next;

        TreeNode tree = new TreeNode(mid.val);
        tree.left = sortedListToBST(head, mid);
        tree.right = sortedListToBST(midNext, tail);
        return tree;
    }

    private ListNode splitNode(ListNode node, ListNode tail) {
        if (node == null) {
            return null;
        }

        ListNode slow = node;
        ListNode fast = node;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
