class KthLargest {
    private Queue<Integer> pq = new PriorityQueue<>();
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            pq.offer(num);
        }
        while (pq.size() > k) {
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        while (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
