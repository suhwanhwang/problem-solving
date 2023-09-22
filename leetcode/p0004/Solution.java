class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        
        int i1 = 0;
        int i2 = 0;
        while (i1 < nums1.length || i2 < nums2.length) {
            int num1 = (i1 < nums1.length ? nums1[i1] : Integer.MAX_VALUE);
            int num2 = (i2 < nums2.length ? nums2[i2] : Integer.MAX_VALUE);
            
            if (num1 < num2) {
                merged[i1 + i2] = num1;
                i1++;
            } else {
                merged[i1 + i2] = num2;
                i2++;
            }
        }

        int mid = merged.length / 2;
        return (merged.length % 2 == 0 ? (merged[mid - 1] + merged[mid]) / 2.0 : merged[mid]);
    }
}
