/*
https://leetcode.com/problems/count-of-smaller-numbers-after-self/

You are given an integer array nums and you have to return a new counts array. 
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
 

Constraints:

0 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4

*/
class Solution {
    static class TreeNode {
        int val;
        int count = 1;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    private int addNode(TreeNode root, int val) {
        TreeNode node = root;
        int smallCount = 0;
        while(node != null) {
            if (node.val < val) {
                smallCount += node.count;
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            } else {
                node.count++;
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else {
                    node = node.left;
                }
            }
        }
        return smallCount;
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        
        TreeNode root = new TreeNode(nums[nums.length-1]);
        ans.add(0);
        
        for (int i = nums.length - 2; i >= 0; --i) {
            int smallCount = addNode(root, nums[i]);
            ans.add(smallCount);
        }
        Collections.reverse(ans);
        return ans;
    }
}
