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
 */
class Solution {
    func longestZigZag(_ root: TreeNode?) -> Int {
        guard let root = root else {
            return 0
        }
        return max(helper(root.left, true, 0), helper(root.right, false, 0))
    }

    func helper(_ root: TreeNode?, _ prevLeft: Bool) -> Int {
        guard let root = root else {
            return 0
        }

        var len = 0
        if prevLeft {
            len = max(helper(root.left, true), 1 + helper(root.right, false))
        } else {
            len = max(helper(root.right, false), 1 + helper(root.left, true))
        }
        
        return len
    }

    func helper(_ root: TreeNode?, _ prevLeft: Bool, _ depth: Int) -> Int {
        guard let root = root else {
            return depth
        }

        var maxDepth = 0
        if prevLeft {
            maxDepth = max(helper(root.left, true, 0), helper(root.right, false, depth + 1))
        } else {
            maxDepth = max(helper(root.right, false, 0), helper(root.left, true, depth + 1))
        }
        
        return maxDepth
    }
}
