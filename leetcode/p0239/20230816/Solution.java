class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> -Integer.compare(nums[a], nums[b]));
        
        int[] result = new int[nums.length - k + 1];
        
        for(int i = 0; i < nums.length; ++i) {
            pq.offer(i);
            if (i < k - 1) {
                 continue;
            }
            
            while (!pq.isEmpty()) {
                int index = pq.peek();
                if (index < i - k + 1) {
                    pq.poll();
                } else {
                    break;
                }
            }
            result[i - k + 1] = nums[pq.peek()];
                
            
        }
        return result;
    }
}
