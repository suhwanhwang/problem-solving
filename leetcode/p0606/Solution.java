class Solution {
    private StringBuilder sb;
    
    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        
        helper(root);
        return sb.toString();
    }
    
    private void helper(TreeNode root) {
        if (root == null) return;
        
        sb.append(root.val);
        
        if(root.left != null || root.right != null) {
            sb.append("(");
            helper(root.left);
            sb.append(")");
        }
        
        if(root.right != null) {
            sb.append("(");
            helper(root.right);
            sb.append(")");
        }
    }
}
