class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map12 = getSumMap(nums1, nums2);
        Map<Integer, Integer> map34 = getSumMap(nums3, nums4);
        
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map12.entrySet()) {
            count += map34.getOrDefault(-entry.getKey(), 0) * entry.getValue();
        }
        return count;
    }
    
    private Map<Integer, Integer> getSumMap(int[] n1, int[] n2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n1.length; ++i) {
            for (int j = 0; j < n2.length; ++j) {
                int sum = n1[i] + n2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return map;
    }
}
