/**
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int index;
    private TreeNode makeTree(int[] preorder, int s, int e, Map<Integer,Integer> inorderMap) {
        if (s > e) {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[index++]);
        
        int inorderIndex = inorderMap.get(node.val);
        node.left = makeTree(preorder, s, inorderIndex - 1, inorderMap);
        node.right = makeTree(preorder, inorderIndex + 1, e, inorderMap);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; ++i) {
            inorderMap.put(inorder[i], i);
        }
        index = 0;
        return makeTree(preorder, 0, inorder.length-1, inorderMap);
    }
}
