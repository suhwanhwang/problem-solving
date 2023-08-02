class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isAdded = new boolean[nums.length];
        
        permuteSub(ans, nums, isAdded, new ArrayList<Integer>());
        return ans;
    }
    
    private void permuteSub(List<List<Integer>> ans, int[] nums, boolean[] isAdded, List<Integer> current) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<Integer>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (isAdded[i]) {
                continue;
            }
            Integer num = nums[i];
            isAdded[i] = true;
            current.add(num);
            permuteSub(ans, nums, isAdded, current);
            current.remove(num);
            isAdded[i] = false;
        }
    }
}
