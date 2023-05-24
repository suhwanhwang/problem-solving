class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        List<int[]> nums = new ArrayList<>();
        for (int i = 0; i < nums1.length; ++i) {
            nums.add(new int[] {nums1[i], nums2[i]});
        }
        Collections.sort(nums, (a, b) -> {
            if (a[0] == b[0]) {
                return -Integer.compare(a[1], b[1]);
            }
            return -Integer.compare(a[0], b[0]);
        });

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        int count = 0;
        long sum = 0;
        long max = 0;
        for (int[] num : nums) {
            if (count < k 
            || queue.peek()[1] < num[1]) {
                queue.offer(num);
                sum += num[0];
                count++;
            }
            if (count > k) {
                int[] top = queue.poll();
                sum -= top[0];
                count--;
            }
            if (count == k) {
                max = Math.max(max, sum * queue.peek()[1]);
            }
        }
        return max;
    }
}
