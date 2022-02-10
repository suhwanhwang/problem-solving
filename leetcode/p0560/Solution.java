class Solution {
    public int subarraySum_x(int[] nums, int k) {
        int start = 0;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum > k) {
                while(start < i && nums[start] >= 0 && sum > k) {
                    sum -= nums[start];
                    start++;
                }
            } else if (sum < k) {
                while(start < i && nums[start] < 0 && sum < k) {
                    sum -= nums[start];
                    start++;
                }
            }
            if (sum == k) {
                count++;
            }

        }
        return count;
    }
    
    public int subarraySum_x2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            Set<Integer> prevSet = new HashSet<>(map.keySet());
            for (int prev : prevSet) {
                map.put(prev + num, map.getOrDefault(prev + num, 0) + 1);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        return map.getOrDefault(k, 0);
    }
    
    public int subarraySum_bf(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i; j < nums.length; ++j) {
                if (sum[j] - (i > 0 ? sum[i - 1] : 0) == k) {
                    //System.out.println(i + " " + j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // sum, count
        int sum = 0;
        int kCount = 0;
        map.put(sum, 1);
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            kCount += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return kCount;
    }
}
