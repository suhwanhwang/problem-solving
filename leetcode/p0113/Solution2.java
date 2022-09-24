class Solution {
    private final List<List<Integer>> paths = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        paths.clear();
        dfs(root, targetSum, new ArrayList<>());
        return paths;
    }
    
    private void dfs(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) {
            
            return;
        }
        
        path.add(root.val);
        targetSum -= root.val;
        
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                paths.add(new ArrayList<>(path));
            }
        } else {
            dfs(root.left, targetSum, path);
            dfs(root.right, targetSum, path);
        }
        
        path.remove(path.size() - 1);
    }
}
