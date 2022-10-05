class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            return temp;
        }
        dfs(null, root, val, depth, 1);
        return root;
    }
    
    private void dfs(TreeNode parent, TreeNode node, int val, int depth, int cur) {
        if (cur > depth) {
            return;
        }
        
        if (cur == depth) {
            TreeNode temp = new TreeNode(val);
            if (parent.left == node) {
                parent.left = temp;
                temp.left = node;
            } else {
                parent.right = temp;
                temp.right = node;
            }
        } else {
            if (node == null) {
                return;
            }
            dfs(node, node.left, val, depth, cur+1);
            dfs(node, node.right, val, depth, cur+1);
        }
    }
}
