/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 10^5
*/
class Solution {
    private int[] dp;
    public int jump(int[] nums) {
        dp = new int[nums.length];
        return jumpHelper(nums, 0);
    }
    
    private static final int INF = 987654321;
    private int jumpHelper(int[] nums, int index) {
        if (index >= nums.length) {
            return INF;
        }
        
        if (index == nums.length - 1) {
            return 0;
        }
        
        if (nums[index] == 0) {
            return INF;
        }
        
        if (dp[index] != 0) {
            return dp[index];
        }
        
        int minJump = INF; 
        for (int i = 1; i <= nums[index]; ++i) {
            minJump = Math.min(minJump, 1 + jumpHelper(nums, index + i));
        }
        dp[index] = minJump;
        return minJump;
    }
}
