class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = getMap(nums1);
        Map<Integer,Integer> map2 = getMap(nums2);
        
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map1.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            int count = Math.min(map2.getOrDefault(key,0), val);
            for (int i = 0; i < count; ++i) {
                ans.add(key);
            }
        }
        int[] output = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i) {
            output[i] = ans.get(i);
        }
        return output;
    }
    private Map<Integer,Integer> getMap(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num,count+1);
        }
        return map;
    }
}
