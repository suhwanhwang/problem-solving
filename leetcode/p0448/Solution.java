class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        for (int i = 1; i <= nums.length; ++i) {
            ans.add(i);
        }
        
        for (int num : nums) {
            ans.remove(num);
        }
        
        return new ArrayList<>(ans);
    }
}
