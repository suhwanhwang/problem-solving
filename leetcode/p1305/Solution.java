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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> merged = new ArrayList<>();
        infix(root1, list1);
        infix(root2, list2);
        
        int i = 0;
        int j = 0;
        while(i < list1.size() || j < list2.size()) {
            if (i >= list1.size()) {
                merged.add(list2.get(j));
                j++;
            } else if (j >= list2.size()) {
                merged.add(list1.get(i));
                i++;
            } else if (list1.get(i) < list2.get(j)) {
                merged.add(list1.get(i));
                i++;
            } else {
                merged.add(list2.get(j));
                j++;
            }
        }
        return merged;
    }
    
    private void infix(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        infix(root.left, list);
        list.add(root.val);
        infix(root.right, list);
    }
}
