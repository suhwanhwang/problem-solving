/*
        [1,2,3,2,1]
            [3,2,1,4,7]

*/
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int maxLen = 0;
        
        for (int i = 0; i < nums1.length - 1; ++i) {
            int len = 0;
            for (int j = 0; j < Math.min(nums1.length - i, nums2.length); ++j) {
                if (nums1[i + j] == nums2[j]) {
                    len++;
                    maxLen = Math.max(maxLen, len);
                } else {
                    len = 0;
                }
            }
        }
        
        for (int i = 0; i < nums2.length - 1; ++i) {
            int len = 0;
            for (int j = 0; j < Math.min(nums2.length - i, nums1.length); ++j) {
                if (nums2[i + j] == nums1[j]) {
                    len++;
                    maxLen = Math.max(maxLen, len);
                } else {
                    len = 0;
                }
            }
        }
        return maxLen;
    }
}
