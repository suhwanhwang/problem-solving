class Solution {
    public int singleNonDuplicate_n(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
    
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i - 1] != nums[i]) {
                return nums[i - 1];
            }
        }
        
        return (nums[nums.length - 2] != nums[nums.length - 1]) ? nums[nums.length - 1] : -1;
    }

    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length;
        
        while(lo < hi) {
            int mid = (lo + hi) >>> 1;
            mid -= (mid%2);
            int cur = nums[mid];
            //System.out.println(lo + " " + mid + " " + hi);
            int next = (mid + 1 >= nums.length) ? -1 : nums[mid+1];
            if (cur != next) {
                int prev =  (mid - 1 >= 0) ? nums[mid-1] : -1;
                if (prev == cur) {
                    hi = mid;
                } else {
                    return cur;
                }
            } else {
                lo = mid+1;
            }
        }
        return -1;
    }
}
