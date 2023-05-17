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
    func pairSum(_ head: ListNode?) -> Int {
        var twin = half(head)
        twin = reverse(twin)
        var maxSum = 0
        var cur1 = head
        var cur2 = twin
        while cur1 != nil && cur2 != nil {
            maxSum = max(maxSum, cur1!.val + cur2!.val)
            cur1 = cur1!.next
            cur2 = cur2!.next
        }

        return maxSum
    }

    private func half(_ head: ListNode?) -> ListNode? {
        var slow = head
        var fast = head
        while let fastNext = fast?.next {
            slow = slow?.next
            fast = fastNext.next
        }
        return slow
    }

    private func reverse(_ head: ListNode?) -> ListNode? {
        // p - c - n
        var prev:ListNode? = nil
        var cur = head
        while cur != nil {
            var next = cur?.next
            cur?.next = prev
            prev = cur
            cur = next
        }
        return prev
    }
}
