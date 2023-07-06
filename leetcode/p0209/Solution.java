class Solution {
    // 2 3 1 2 4 3
    //     
    public int minSubArrayLen(int target, int[] nums) {
        
        int start = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum >= target) {
                min = Math.min(min, i - start + 1);
            }
            while (sum > target) {
                sum -= nums[start++];
                if (sum >= target) {
                    min = Math.min(min,  i - start +1);
                }
            }
        }
        return (min != Integer.MAX_VALUE ? min : 0);
    }
}
