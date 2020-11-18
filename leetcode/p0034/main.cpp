/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Given an array of integers nums sorted 
in ascending order, find the starting 
and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm 
with O(log n) runtime complexity?

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

*/
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        auto lo = lower_bound(nums.begin(),nums.end(), target);
        auto up = upper_bound(nums.begin(),nums.end(), target);
        vector<int> ans;
        if (lo == up) {
            return {-1,-1};
        }
        
        ans.push_back(distance(nums.begin(), lo));
        ans.push_back(distance(nums.begin(), up) - 1);
        return ans;
    }
};
