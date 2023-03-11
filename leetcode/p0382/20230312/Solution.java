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
    private final ListNode head; 
    private final Random random;
    private final int size;
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();

        ListNode node = head;
        int count = 0;
        while(node != null) {
            count++;
            node = node.next;
        }
        this.size = count;
    }
    
    public int getRandom() {
        int number = random.nextInt(this.size);
        int count = 0;
        ListNode node = this.head;
        while(count++ != number) {
            node = node.next;
        }
        return node.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
