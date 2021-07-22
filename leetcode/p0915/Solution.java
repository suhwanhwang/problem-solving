class Solution {
    /*
    0 1 2 3 4
    5,0,3,8,6
max 5 5 5 8 8
min 0 0 3 6 6
    */
    
    public int partitionDisjoint(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int currentMax = nums[0];
        for(int i = 0; i < nums.length; ++i) {
            if (nums[i] > currentMax) {
                currentMax = nums[i];
            }
            max[i] = currentMax;
        }
        int currentMin = nums[nums.length-1];
        for(int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] < currentMin) {
                currentMin = nums[i];
            }
            min[i] = currentMin;
        }
        
        
        for(int i = 1; i < nums.length; ++i) {
            if (min[i] >= max[i - 1]) {
                return i;
            }
        }
        
        return -1;
    
    }
}
