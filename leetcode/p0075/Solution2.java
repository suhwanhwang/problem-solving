// https://leetcode.com/problems/sort-colors/description/
class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int color : nums) {
            count[color]++;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (i < count[0]) {
                nums[i] = 0;
            } else if (i < count[0] + count[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
