// https://leetcode.com/problems/next-greater-element-i/
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for(int i = 0; i < nums2.length; ++i) {
            for(int j = i + 1; j < nums2.length; ++j) {
                if (nums2[i] < nums2[j]) {
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }
        for(int i = 0; i < nums1.length; ++i) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
