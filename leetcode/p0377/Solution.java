/*
https://leetcode.com/problems/combination-sum-iv/

Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The answer is guaranteed to fit in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000
 

Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need to add to the question to allow negative numbers?
*/
class Solution {
    private int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[1000 + 1];
        Arrays.fill(dp, -1);
        return helper(nums, target, 0);
    }
    
    private int helper(int[] nums, int target, int sum) {
        if (sum > target) {
            return 0;
        }
        
        if (sum == target) {
            return 1;
        }
        
        if (dp[sum] >= 0) {
            return dp[sum];
        }
        
        int count = 0;
        for (int num : nums) {
            count += helper(nums, target, sum + num);
        }
        dp[sum] = count;
        return count;
    }
}
