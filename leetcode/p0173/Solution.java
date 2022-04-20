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
class BSTIterator {
    /*
    private List<TreeNode> list = new ArrayList<>();
    private int index = -1;

    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
    
    public int next() {
        index++;
        return list.get(index).val;
    }
    
    public boolean hasNext() {
        return (index + 1) < list.size();
    }
*/
    
    private Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        updateStack(root);
    }
    
    private void updateStack(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
    
    public int next() {
        TreeNode node = st.pop();
        updateStack(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
*/
