/**
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
    private int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int left, int right) {
        if (index < 0 || left > right) {
            return null;
        }
        if (left == right) {
            index--;
            return new TreeNode(inorder[left]);
        }

        int val = postorder[index--];
        int rootIndex = -1;
        for (int i = left; i <= right; ++i) {
            if (inorder[i] == val) {
                rootIndex = i;
                break;
            }
        }
        TreeNode node = new TreeNode(val);
        node.right = helper(inorder, postorder, rootIndex + 1, right);
        node.left = helper(inorder, postorder, left, rootIndex - 1);

        return node;
    }
}
