class Solution {
    public boolean checkSubarraySum_bt(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            sum[i] = sum[i - 1] + nums[i];
        }
        
        
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if ((sum[j] - (i > 0 ? sum[i - 1] : 0)) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            // (sum[a] - sum[b]) % k = 0
            //  sum[a] % k = sum[b] % k
            sum += nums[i];
            if (map.containsKey(sum % k)) {
                int index = map.get(sum%k);
                if (i+1 - index >= 2) return true;
            } else {
                map.put(sum%k, i + 1);
            }
        }
        return false;
    }
}
