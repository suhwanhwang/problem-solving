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
    public boolean findTarget(TreeNode root, int k) {
        return inorder(root, root, k);
    }
    
    private boolean inorder(TreeNode root, TreeNode node, int k) {
        if (node == null) return false;
        
        if (inorder(root, node.left, k)) return true;
        
        TreeNode other = findBST(root, k - node.val);
        //System.out.println(node.val + " " + (other != null ? other.val : "null"));
        if (other != null && other != node) return true;

        if(inorder(root, node.right, k)) return true;
        
        return false;
    }
    
    private TreeNode findBST(TreeNode root, int k) {
        if (root == null) return null;
        
        if (root.val == k) {
            return root;
        } else if (root.val < k) {
            return findBST(root.right, k);
        } else {
            return findBST(root.left, k);
        }
    }
}
