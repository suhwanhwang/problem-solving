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
    public int pathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, false, new ArrayList<>());
    }
    private int helper(TreeNode root, int targetSum, boolean isStarted, List<Integer> list) {
        
        if (root == null){
            return 0;
        }
        
        int count = 0;
        
        // skip
        if (!isStarted) {
            count += helper(root.left, targetSum, false,list) + helper(root.right, targetSum, false,list);
        }
        
        // include
        int remain = targetSum - root.val;
        list.add(root.val);
        if (remain == 0) {
            count++;
            //System.out.println(list);
        }
        count += helper(root.left, remain, true,list) + helper(root.right, remain, true,list);
        
        list.remove(list.size() - 1);
        return count;
    }
}
