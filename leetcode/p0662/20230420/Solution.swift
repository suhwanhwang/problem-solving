/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init() { self.val = 0; self.left = nil; self.right = nil; }
 *     public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
 *     public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
 *         self.val = val
 *         self.left = left
 *         self.right = right
 *     }
 * }
0
0        1
0   1    2   3
0 1 2 3  4 5 6 7

 */
class Solution {
    func widthOfBinaryTree(_ root: TreeNode?) -> Int {
        guard let root = root else {
            return 0
        }
        var maxWidth = 0
        var queue = [(TreeNode, Int)]()
        
        queue.append((root, 0))
        while !queue.isEmpty {
            var len = queue.count
            var start = queue.first!.1
            var end = -1
            while len > 0 {
                let (node, index) = queue.removeFirst()
                
                end = (index - start)

                print(index)
                if let left = node.left {
                    queue.append((left, end * 2))
                }
                if let right = node.right {
                    queue.append((right, end * 2 + 1))
                }
                len -= 1
            }
            maxWidth = max(maxWidth, end + 1)
        }
        return maxWidth
    }
}
