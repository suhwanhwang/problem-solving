class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        return helper(dp, nums, 0);
    }

    private int helper(int[] dp, int[] nums, int index) {
        if (index >= nums.length - 1) {
            return 0;
        }

        if (dp[index] != 0) {
            return dp[index];
        }

        int minJump = nums.length;
        for (int i = 1; i <= nums[index]; ++i) {
            minJump = Math.min(minJump, 1 + helper(dp, nums, index + i));
        }
        dp[index] = minJump;

        return minJump;
    }
}
