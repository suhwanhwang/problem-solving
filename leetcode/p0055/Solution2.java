class Solution {
    private int[] dp;
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0);
    }

    private boolean helper(int[] nums, int index) {
        if (index == nums.length - 1) {
            return true;
        }

        if (dp[index] != -1) {
            return dp[index] == 1;
        }

        if (nums[index] == 0) {
            return false;
        }

        for (int i = 1; i <= nums[index]; ++i) {
            if (helper(nums, index + i)) {
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = 0;
        return false;
    }
}
