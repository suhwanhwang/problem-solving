class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        
        if (hasOne(root)) {
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            return root;
        } else {
            return null;
        }
    }
    
    private boolean hasOne(TreeNode root) {
        if (root == null) return false;
        
        if (root.val == 1) {
            return true;
        } else {
            return hasOne(root.left) || hasOne(root.right);
        }  
    }
}
