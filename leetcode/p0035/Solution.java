class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo <= hi) {
            int m = (lo+hi) >>> 1;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }
        return lo;
    }
}
