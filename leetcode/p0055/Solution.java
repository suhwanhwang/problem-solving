/*
https://leetcode.com/problems/jump-game/

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
*/

class Solution {
    boolean[] dp;
    boolean[] ready;
    private boolean solve(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return true;
        }
        
        if (nums[index] == 0) {
            return false;
        }
        
        if (ready[index]) {
            return dp[index];
        }
        
        for (int i = 1; i <= nums[index]; ++i) {
            if (solve(nums, index + i)) {
                ready[index] = true;
                dp[index] = true;
                return true;
            }
        }
        ready[index] = true;
        dp[index] = false;
        return false;
    }
    
    public boolean canJump(int[] nums) {
        dp = new boolean[nums.length+1];
        ready = new boolean[nums.length+1];
        return solve(nums, 0);
    }
}
