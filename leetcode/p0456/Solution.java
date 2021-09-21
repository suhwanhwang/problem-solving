// https://leetcode.com/problems/max-consecutive-ones/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int localMax = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            if(nums[i] == 1) {
                localMax++;
                max = Math.max(max, localMax);
            } else {
                localMax = 0;
            }
        }
        return max;
    }
}
