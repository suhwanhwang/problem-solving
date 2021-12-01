class Solution {
    private int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0);
    }
    
    private int helper(int[] nums, int index) {
        if (index >= nums.length) return 0;
        
        if (dp[index] != -1) return dp[index];
        
        dp[index] = Math.max(helper(nums, index + 1), nums[index] + helper(nums, index + 2));
        
        return dp[index];
    }
}
