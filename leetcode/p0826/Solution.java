class Solution {
    public boolean isMonotonic(int[] nums) {
        int prevDiff = 0;
        for (int i = 1; i < nums.length; ++i) {
            int diff = nums[i - 1] - nums[i];
            if (diff == 0) {
                continue;
            }
            
            if (prevDiff * diff < 0) {
                return false;
            }
            prevDiff = diff;
        }
        return true;
    }
}
