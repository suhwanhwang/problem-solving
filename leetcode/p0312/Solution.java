class Solution_bt {
    public int maxCoins(int[] nums) {
        return helper(nums,new boolean[nums.length],nums.length);
    }
    private int helper(int[] nums, boolean[] used, int remain) {
        int max = 0;
        int prev = -1;
        int index = 0;
        int next = 1;
        while (index < nums.length) {
            while (index < nums.length && used[index]) {
                index++;
            }
            if (index >= nums.length){
                break;
            }
            
            next = index + 1;
            while (next < nums.length && used[next]) {
                next++;
            }
            
            int val = (prev < 0 ? 1 : nums[prev]) * nums[index] * (next >= nums.length ? 1 : nums[next]);
            
            used[index] = true;
            //System.out.println(prev + " " + index + " " + next + " " + val);
            max = Math.max(max, val + helper(nums, used, remain - 1));
            used[index] = false;
            prev = index;
            index = next;
        }
        
        return max;
    }
}
class Solution {
    private int[][] dp;
    public int maxCoins(int[] nums) {
        int[] temp = new int[nums.length + 2];
        temp[0] = temp[temp.length - 1] = 1;
        for(int i = 0; i < nums.length; ++i) {
            temp[i+1] = nums[i];
        }
        
        dp = new int[temp.length][temp.length];
        return helper(temp, 0, temp.length - 1);
    }
    private int helper(int[] nums, int left, int right) {
        if (left == right + 1) {
            return 0;
        }
        
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        
        int max = 0;
        for(int i = left+1; i < right; ++i) {
            int val = nums[left] * nums[i] * nums[right];
            max = Math.max(max, val + helper(nums, left, i) + helper(nums, i, right));
        }
        dp[left][right] = max;
        return max;
    }
}
