// https://leetcode.com/problems/max-consecutive-ones/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int localMax = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            if(nums[i] == 1) {
                localMax++;
            } else {
                max = Math.max(max, localMax);
                localMax = 0;
            }
        }
        return Math.max(max, localMax);
    }
}
