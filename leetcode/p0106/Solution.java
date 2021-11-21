/*
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int iL,int iR, int[] postorder, int pL,int pR) {
        if (iL > iR || pL > pR) return null;
        
        int rootVal = postorder[pR];
        int rootIndex = iL;
        for(int i = iL; i <= iR; ++i) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        
        TreeNode root = new TreeNode(rootVal);
        int leftNum = rootIndex - iL;
        root.left = helper(inorder, iL, rootIndex - 1, postorder, pL, pL + leftNum - 1);
        root.right = helper(inorder, rootIndex + 1, iR, postorder, pL + leftNum, pR - 1);
        return root;
    }
}
