class Solution {
    Map<TreeNode, Integer> mapParentRobTrue = new HashMap<>();
    Map<TreeNode, Integer> mapParentRobFalse = new HashMap<>();
    
    public int rob(TreeNode root) {
        return helper(root, 0, false);
    }
    
    private int helper(TreeNode node, int d, boolean parentRob) {
        if (node == null) return 0;
        
        Map<TreeNode, Integer> map = (parentRob ? mapParentRobTrue : mapParentRobFalse);
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        int max = helper(node.left, d+1, false) + helper(node.right, d+1, false);
        
        if (!parentRob) {
            max = Math.max(max, node.val + helper(node.left, d+1, true) + helper(node.right, d+1, true));
        }
        map.put(node, max);
        return max;
    }
}
