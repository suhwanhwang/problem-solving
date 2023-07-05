class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> items = new ArrayList<>();
        int count = 0;
        for (int i = 0; i <= nums.length; ++i) {
            if (i == nums.length || nums[i] == 0) {
                items.add(count);
                if (count > 0) {
                    count = 0;
                }
            } else {
                count++;
            }
        }
        System.out.println(items);

        if (items.size() == 1 && items.get(0) == nums.length) {
            return items.get(0) - 1;
        }

        int max = items.size() > 0 ? items.get(0) : 0;
        for (int i = 1; i < items.size(); ++i) {
            max = Math.max(max, items.get(i - 1) + items.get(i));
        }
        return max;
    }
    /*
    public int longestSubarray(int[] nums) {
        int totalMax = 0;
        for (int i = 0; i < nums.length; ++i) {
            int max = 0;
            int cur = 0;
            for (int j = 0; j < nums.length; ++j) {
                if (j == i) continue;
                max = Math.max(max, cur);
                if (nums[j] == 0) {
                    cur = 0;
                } else {
                    cur++;
                }
            }
            max = Math.max(max, cur);
            totalMax = Math.max(totalMax, max);
        }
        return totalMax;
    }
    */
}
