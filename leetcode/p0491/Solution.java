class Solution {
    private final Set<List<Integer>> sequences = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        sequences.clear();
        dfs(nums, 0, new ArrayList<>());
        return new ArrayList<>(sequences);
    }

    private void dfs(int[] nums, int index, List<Integer> seq) {
        if (index >= nums.length) {
            if (seq.size() > 1) {
                sequences.add(new ArrayList<>(seq));
            }
            return;
        }

        if (seq.size() == 0 || seq.get(seq.size() - 1) <= nums[index]) {
            seq.add(nums[index]);
            dfs(nums, index + 1, seq);
            seq.remove(seq.size() - 1);
        }

        dfs(nums, index + 1, seq);
    }
}
