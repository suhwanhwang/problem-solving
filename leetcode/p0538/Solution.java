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
    /*
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; --i) {
            sum += list.get(i);
            map.put(list.get(i), sum);
        }
        inorderUpdate(root);
        
        return root;
    }
    
    private void inorder(TreeNode root) {
        if(root == null) return ;
        
        inorder(root.left);
        list.add(root.val);        
        inorder(root.right);
    }
    
    private void inorderUpdate(TreeNode root) {
        if(root == null) return ;
        
        inorderUpdate(root.left);
        root.val = map.get(root.val);        
        inorderUpdate(root.right);
    }
    */
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
