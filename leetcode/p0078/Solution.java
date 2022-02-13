class Solution {
    List<List<Integer>> allSet;
    public List<List<Integer>> subsets(int[] nums) {
        allSet = new ArrayList<>();
        helper(nums, 0,new ArrayList<>());
        return allSet;
    }
    
    private void helper(int[] nums, int index, List<Integer> list) {
        if (index >= nums.length) {
            allSet.add(new ArrayList<>(list));
            return;
        }
        helper(nums, index + 1, list);
        list.add(nums[index]);
        helper(nums, index + 1, list);
        list.remove(list.size() - 1);
    }
}
