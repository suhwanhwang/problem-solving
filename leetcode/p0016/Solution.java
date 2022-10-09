class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                int sum = nums[i] + nums[j];
                
                int index = lowerBound(nums, j+1, nums.length-1, target - sum);
                sum += nums[index];
                //System.out.println(sum + "=" + nums[i] +"+"+ nums[j] +"+"+ nums[index]);
                //System.out.println(target - sum);
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
            }
        }
        return target - diff;
    }
    
    private int lowerBound(int[] nums, int left, int right, int target) {
        while(left < right) {
            int m = (left + right) >>> 1;
            if (nums[m] < target) {
                left = m + 1;
            } else {
                right = m;
            }
        }
        return left;
    }
}
