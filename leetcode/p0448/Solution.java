class Solution {
    public List<Integer> findDisappearedNumbers_n(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        for (int i = 1; i <= nums.length; ++i) {
            ans.add(i);
        }
        
        for (int num : nums) {
            ans.remove(num);
        }
        
        return new ArrayList<>(ans);
    }
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = Math.abs(nums[i]);
            
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            }
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }   
}
