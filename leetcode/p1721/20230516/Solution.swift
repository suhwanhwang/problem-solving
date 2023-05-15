/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init() { self.val = 0; self.next = nil; }
 *     public init(_ val: Int) { self.val = val; self.next = nil; }
 *     public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }
 * }
 */
class Solution {
    func swapNodes(_ head: ListNode?, _ k: Int) -> ListNode? {
        var cur = head
        for i in 1..<k {
            cur = cur!.next
        }

        var cur2 = head
        var fast = cur
        while fast!.next != nil {
            cur2 = cur2!.next
            fast = fast!.next
        }
        let temp = cur!.val
        cur!.val = cur2!.val
        cur2!.val = temp
        return head
    }
}
