class Solution {
    /*
    0 1 2 3 4 5 6 7 8
    7 4 3 9 1 8 5 2 6
i         ^
i+k             ^    
s   35
avg * * * * * * * * *      
    */
    public int[] getAverages(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k && i < nums.length; ++i) {
            sum += nums[i];
        }

        int[] avg = new int[nums.length];
        Arrays.fill(avg, -1);
        for (int i = 0; i + k < nums.length; ++i) {
            sum += nums[i + k];
            if (k <= i) {
                if (i - k - 1 >= 0) {
                    sum -= nums[i - k - 1];
                }
                avg[i] = (int)(sum / (2 * k + 1));
            }
        }
        return avg;
    }
}
