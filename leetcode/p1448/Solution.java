class Solution {
    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }
    
    private int helper(TreeNode root, int maxVal) {
        if (root == null) return 0;
        
        int count = 0;
        if (root.val >= maxVal) {
            count++;
            maxVal = root.val;
        }
        return count + helper(root.left, maxVal) + helper(root.right, maxVal);
    }
}
