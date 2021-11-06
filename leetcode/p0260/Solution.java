class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums.length == 2) {
            return nums;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                continue;
            }
            set.add(num);
        }
        int[] ans = new int[set.size()];
        int index = 0;
        for (int num : set) {
            ans[index++] = num;
        }
        return ans;
    }
}
