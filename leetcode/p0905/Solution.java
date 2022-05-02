class Solution {
    public int[] sortArrayByParity_n2(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] % 2 == 0) {
                continue;
            }
            
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] % 2 == 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }    
            }
        }
        return nums;
    }
    
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        
        Collections.sort(list, (a, b) -> (a % 2) - (b % 2));
        for (int i = 0; i < list.size(); ++i) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
