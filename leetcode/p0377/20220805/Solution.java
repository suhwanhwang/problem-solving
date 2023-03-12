class Solution {
    private int[] dp = new int[1001];
    public int combinationSum4(int[] nums, int target) {
        Arrays.fill(dp, -1);
        return helper(nums, target);
    }
    
    private int helper(int[] nums, int target) {
        if (target == 0) return 1;
        if (dp[target] != -1) return dp[target];
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            int t = target - nums[i];
            if (t < 0) continue;
            
            sum += helper(nums, t);
        }
        dp[target] = sum;
        return dp[target];
    }
}
