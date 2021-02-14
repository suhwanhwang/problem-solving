/*
https://leetcode.com/problems/palindrome-linked-list/description/

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
*/
class Solution {
    public boolean isPalindrome_on(ListNode head) {
        List<Integer> list = new ArrayList<>();
        
        ListNode cur = head;
        
        while(cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        
        for(int i = 0; i < list.size()/2; ++i) {
            if (list.get(i) != list.get(list.size()-1-i)){
                return false
            }
        }
        return true;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode midReversed = reverse(mid);
        ListNode cur = head;
        ListNode curMid = midReversed;
        while (cur != null && curMid != null) {
            if (cur.val != curMid.val) {
                return false;
            }
            cur = cur.next;
            curMid = curMid.next;
        }
        return true;
    }
    
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // 1-2-3-n
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
