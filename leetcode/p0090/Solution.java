// https://leetcode.com/problems/subsets-ii/
class Solution {
    private Set<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new HashSet<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return new ArrayList(ans);
    }
    private void helper(int[] nums, int index, List<Integer> list) {
        if (index >= nums.length) {
            ans.add(new ArrayList(list));
            return;
        }
        list.add(nums[index]);
        helper(nums, index+1, list);
        list.remove(list.size() - 1);
        helper(nums, index+1, list);
    }
}
