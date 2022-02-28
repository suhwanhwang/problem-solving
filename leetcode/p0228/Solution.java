class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) {
            return ranges;
        }
        
        int left = nums[0];
        for (int i = 1; i <= nums.length; ++i) {
            if (i != nums.length && nums[i] <= nums[i - 1] + 1) {
                continue;
            }
            
            ranges.add(left + (left == nums[i - 1] ? "" : "->" + nums[i - 1]));
            if (i != nums.length) {
                left = nums[i];
            }
        }
        
        return ranges;
    }
}
