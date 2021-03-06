/*
https://leetcode.com/problems/longest-increasing-subsequence/

Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104

*/
class Solution {
    private int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length + 1];
        return solve(nums, 0, -1);
    }
    
    private int solve(int[] nums, int index, int prevIndex) {
        if (index >= nums.length) {
            return 0;
        }
        
        if (dp[index][prevIndex + 1] != 0) {
            return dp[index][prevIndex + 1];
        } 
        
        int maxLen = 0;
        
        if (prevIndex < 0 || nums[prevIndex] < nums[index]) {
            maxLen = 1 + solve(nums, index + 1, index);
        }
        maxLen = Math.max(maxLen, solve(nums, index + 1, prevIndex));
        dp[index][prevIndex + 1] = maxLen;
        return maxLen;
    }
}
