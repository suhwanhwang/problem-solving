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
    func swapPairs(_ head: ListNode?) -> ListNode? {
        guard let head = head else {
            return nil
        }

        let dummy = ListNode()
        dummy.next = head

        var prev = dummy
        var cur = head
        while let next = cur.next {
            // p - c - n
            var temp = next.next

            prev.next = next
            next.next = cur
            prev = cur
            if let temp = temp {
                cur.next = temp
                cur = temp
            } else {
                cur.next = nil
                break
            }
        }
        return dummy.next
    }
}
