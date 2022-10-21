class Solution {
    /*
    0 1 2 3
    1 2 3 1
    
map 1, 0
    2, 1
    3, 2
    
    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (map.containsKey(num)) {
                int prevIndex = map.get(num);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            map.put(num, i);
        }
        return false;
    }
}
