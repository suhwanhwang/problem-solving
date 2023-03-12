class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return hasOne(root) ? root : null;
    }
    
    private boolean hasOne(TreeNode root) {
        if (root == null) return false;
        
        boolean left = hasOne(root.left);
        if (!left) root.left = null;
        
        boolean right = hasOne(root.right);
        if (!right) root.right = null;
        
        return root.val == 1 || left || right;
    }
}
