class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        int[] ans = new int[2];
        for (int num : nums) {
            if (set.contains(num)) {
                ans[0] = num;
            }
            set.add(num);
        }
        for (int i = 1; i <= nums.length; ++i) {
            if (!set.contains(i)) {
                ans[1] = i;
                break;
            }
        }
        
        return ans;
    }
}
