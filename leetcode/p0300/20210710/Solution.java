class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
        
            max = Math.max(max, helper(dp, nums, i));
        }
        return max;
    }
    
    private int helper(int[] dp, int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != 0) {
            return dp[index];
        }
        int num = nums[index];
        int max = 1;
        for(int i = index + 1; i < nums.length; ++i) {
            if (nums[i] <= num) {
                continue;
            }
            max = Math.max(max, 1 + helper(dp, nums, i));
        }
        dp[index] = max;
        return max;
    }
}
