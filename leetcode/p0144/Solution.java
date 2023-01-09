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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();

        traverse(root, preorderList);
        return preorderList;
    }

    private void traverse(TreeNode root, List<Integer> preorderList) {
        if (root == null) {
            return;
        }
        preorderList.add(root.val);
        traverse(root.left, preorderList);
        traverse(root.right, preorderList);
    }
}
