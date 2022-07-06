class Solution {
    /*
       1,2,3,4,100,200
i                  ^
len    1
maxLen 4 
    */
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Arrays.sort(nums);
        
        int maxLen = 1;
        int len = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] - nums[i - 1] > 1) {
                len = 1;
            } else if (nums[i] - nums[i - 1] == 1) {
                len++;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
