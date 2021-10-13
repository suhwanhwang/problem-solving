/*
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/

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

Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }
    private TreeNode helper(int[] p, int s, int e) {
        if (s > e) {
            return null;
        }
        TreeNode node = new TreeNode(p[s]);
        
        int index;
        for(index = s+1; index <= e; ++index) {
            if (p[s] < p[index]) {
                break;
            }
        }
        node.left = helper(p, s+1, index-1);
        node.right= helper(p, index,e);
        return node;
    }
}
