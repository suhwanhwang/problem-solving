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
    func buildTree(_ inorder: [Int], _ postorder: [Int]) -> TreeNode? {
        return buildTree(inorder, 0, inorder.count - 1, postorder, 0, postorder.count - 1)
    }

    private func buildTree(_ inorder:[Int], _ iL: Int, _ iR: Int, _ postorder: [Int], _ pL: Int, _ pR: Int) -> TreeNode? {
        if iL > iR {
            return nil
        }

        let val = postorder[pR]
        var rootIndex = iL
        for i in iL...iR {
            if (inorder[i] == val) {
                rootIndex = i
                break;
            }
        }
        let leftSize = rootIndex - iL
        let node = TreeNode(val)
        node.left = buildTree(inorder, iL, rootIndex - 1, postorder, pL, pL + leftSize - 1)
        node.right = buildTree(inorder, rootIndex + 1, iR, postorder, pL + leftSize, pR - 1)
        return node
    }
}
