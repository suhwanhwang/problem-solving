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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reversed1 = reverse(l1);
        ListNode reversed2 = reverse(l2);

        ListNode cur1 = reversed1;
        ListNode cur2 = reversed2;
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode prev = dummy;

        while (cur1 != null || cur2 != null || carry == 1) {
            int num1 = (cur1 != null ? cur1.val : 0);
            int num2 = (cur2 != null ? cur2.val : 0);

            int sum = num1 + num2 + carry;
            carry = sum / 10;
            int num = sum % 10;

            ListNode cur = new ListNode(num);
            prev.next = cur;
            prev = cur;

            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
