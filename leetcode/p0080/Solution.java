class Solution {
    public int removeDuplicates(int[] nums) {
        int prevIndex = 0;
        int count = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[prevIndex] != nums[i]) {
                count = 0;
                prevIndex++;
                nums[prevIndex] = nums[i];
            } else {
                if (count == 0) {
                    count++;
                    prevIndex++;
                    nums[prevIndex] = nums[i];
                }
            }
            
        }
        return prevIndex + 1;
    }
}
