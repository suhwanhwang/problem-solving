class Solution {
    List<List<Integer>> allList;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        allList = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        
        return allList;
    }
    
    private void helper(int[] candidates, int target, int index, List<Integer> list) {
        if (0 == target) {
            allList.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = index; i < candidates.length; ++i) {
            int remain = target - candidates[i];
            if (remain < 0) {
                continue;
            }
            list.add(candidates[i]);
            helper(candidates, remain, i, list);
            list.remove(list.size() - 1);
        }
    }
}
