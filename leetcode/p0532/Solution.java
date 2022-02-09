class Solution {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            if (map.containsKey(num + k)) {
                if (k != 0 || map.get(num) > 1) {
                    count++;
                }
            }    
        }
        return count;
    }
}
