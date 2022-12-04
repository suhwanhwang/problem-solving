class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long min = Integer.MAX_VALUE;
        int minIndex = 0;
        long curSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            curSum += nums[i];
            long rightSum = sum - curSum;
            long averageDifference = Math.abs(curSum / (i + 1) - ((i < nums.length - 1) ? rightSum / (nums.length - i - 1) : 0));
            if (min > averageDifference) {
                min = averageDifference;
                minIndex = i;
            }
        }
        return minIndex;
    }
}
