class Solution {
    private int[]dp;
    
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length + 1];
        return helper(nums, -1);
    }
    
    private int helper(int[] nums, int prev) {
        if (prev != -1 && dp[prev] != 0) return dp[prev];
        
        int max = 0;
        for (int i = prev+1; i < nums.length; ++i) {
            if (prev != -1 && nums[prev] >= nums[i]) {
                continue;
            }
            max = Math.max(max, 1+helper(nums, i));
        }
        if (prev != -1)
            dp[prev] = max;
        return max;
    }
}
