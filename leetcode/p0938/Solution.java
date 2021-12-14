/*
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
    List<Integer> list;
    public int rangeSumBST(TreeNode root, int low, int high) {
        list = new ArrayList<>();
        dfs(root);
        //System.out.println(list);
        int lowIndex = binarySearch(list, low);
        int highIndex = binarySearch(list, high);
        if (lowIndex == -1 || highIndex == -1) return -1;
        
        int sum = 0;
        for (int i = lowIndex; i <= highIndex; ++i) {
            sum += list.get(i);
        }
        return sum;
    }
    private void dfs(TreeNode node) {
        if (node == null) return;
        
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
    private int binarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        
        while(low <= high) {
            int mid = (low + high) >>> 1;
            int val = list.get(mid);
            if(val == target) {
                return mid;
            } else if (val < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
