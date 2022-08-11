class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, int left, int right) {
        if (root == null) {
            return true;
        }
        
        if (!(left <= root.val && root.val <= right)) {
            return false;
        }
        if (!(root.left == null || root.left.val < root.val) || !(root.right == null || root.val < root.right.val)) {
            return false;
        }
        
        return isValidBST(root.left, left, root.val - 1) && isValidBST(root.right, root.val+1, right);
    }
}
