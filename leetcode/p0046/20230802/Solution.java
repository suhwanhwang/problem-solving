class Solution {
    private final List<List<Integer>> total = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        total.clear();
        helper(nums, new LinkedHashSet<>());
        return total;
    }

    private void helper(int[] nums, Set<Integer> set) {
        if (set.size() == nums.length) {
            total.add(new ArrayList<>(set));
            return;
        }

        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            set.add(num);
            helper(nums, set);
            set.remove(num);
        }
    }
}
