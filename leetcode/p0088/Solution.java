/*
https://leetcode.com/problems/merge-sorted-array/

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/
class Solution {
    public void merge_(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        
        int index = 0;
        int mIndex = 0;
        int nIndex = 0;
        
        while (mIndex < m || nIndex < n) {
            if (nIndex >= n || mIndex < m && nums1[mIndex] < nums2[nIndex]) {
                merged[index] = nums1[mIndex];
                mIndex++;
            } else {
                merged[index] = nums2[nIndex];
                nIndex++;
            }
            index++;
        }
        
        for (int i = 0; i < m + n; ++i) {
            nums1[i] = merged[i];
        }
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m - 1;
        int nIndex = n - 1;
        
        for (int i = m + n - 1; i >= 0; --i) {
            if (nIndex < 0 || mIndex >= 0 && nums1[mIndex] > nums2[nIndex]) {
                nums1[i] = nums1[mIndex--];
            } else {
                nums1[i] = nums2[nIndex--];
            }
        }
    }
}
