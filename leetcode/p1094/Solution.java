class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (t0, t1) -> {
            if (t0[1] == t1[1]) {
                return t0[2] - t1[2];
            }
            return t0[1] - t1[1];
        });
        
        Queue<Integer> pq = new PriorityQueue<>();
        int max = 0;
        for (int[] t : trips) {
            while(!pq.isEmpty() && pq.peek() <= t[1]) {
                pq.poll();
            }
            for (int i = 0; i < t[0]; ++i) {
                pq.offer(t[2]);
            }
            max = Math.max(max, pq.size());
        }
        return max <= capacity;
    }
}
