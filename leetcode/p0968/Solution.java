/**
https://leetcode.com/problems/binary-tree-cameras/description/

Given a binary tree, we install cameras on the nodes of the tree. 

Each camera at a node can monitor its parent, itself, and its immediate children.

Calculate the minimum number of cameras needed to monitor all nodes of the tree.

 

Example 1:


Input: [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.
Example 2:


Input: [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.

Note:

The number of nodes in the given tree will be in the range [1, 1000].
Every node has value 0.


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
    private int ans;
    private Set<TreeNode> set;
    public int minCameraCover(TreeNode root) {
        ans = 0;
        set = new HashSet<>();
        
        set.add(null);
        dfs(root, null);
        return ans;
    }
    
    private void dfs(TreeNode r, TreeNode p) {
        if (r == null) return;
        dfs(r.left, r);
        dfs(r.right, r);
        if (p == null && !set.contains(r)
           || !set.contains(r.left)
           || !set.contains(r.right)) {
            ans++;
            set.add(r);
            set.add(r.left);
            set.add(r.right);
            set.add(p);
        }
    }
}
