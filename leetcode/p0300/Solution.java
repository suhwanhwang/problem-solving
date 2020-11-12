
/* https://leetcode.com/problems/longest-increasing-subsequence/
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
*/
class Solution {
    private int sub(int[] nums, int index, int prevIndex, int[][] dp) {
        if (index >= nums.length) {
            return 0;
        }
        
        if (dp[index][prevIndex + 1] != 0) {
            return dp[index][prevIndex + 1];
        }
        
        int prev = prevIndex >= 0 ? nums[prevIndex] : Integer.MIN_VALUE;
        
        int maxLen = 0;
        
        for (int i = index; i < nums.length; ++i) {
            if (nums[i] <= prev) {
                continue;
            }

            maxLen = Math.max(maxLen,sub(nums, i + 1, i,dp) + 1);
        }
        dp[index][prevIndex + 1] = maxLen;
        return maxLen;
    }
    
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[nums.length][nums.length +1];
        return sub(nums,0,-1, dp);
    }
}
