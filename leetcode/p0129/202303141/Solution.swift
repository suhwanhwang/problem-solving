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
    private var sum: Int = 0

    func sumNumbers(_ root: TreeNode?) -> Int {
        sum = 0
        dfs(root, 0)
        return sum
    }

    private func dfs(_ root: TreeNode?, _ num: Int) {
        guard let root = root else {
            return
        }

        let nextNum = num * 10 + root.val
        if root.left == nil && root.right == nil {
            sum += nextNum
            return
        }

        dfs(root.left, nextNum)
        dfs(root.right, nextNum)
    }
}
