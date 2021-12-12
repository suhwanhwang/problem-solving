class Solution {
    int[][]dp = new int[201][20001];
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        
        return helper(nums, 0, sum/2);
    }
    
    private boolean helper(int[] nums, int index, int remain) {
        if (remain < 0) {
            return false;
        }
        if (remain == 0) {
            return true;
        }
        
        if (index >= nums.length) {
            return false;
        }
        if (dp[index][remain] != 0) {
            return dp[index][remain] == 1;
        }
        
        boolean result = helper(nums, index + 1, remain) || helper(nums, index + 1, remain - nums[index]);
        dp[index][remain] = (result ? 1 : -1);
        return result;
    }
}
