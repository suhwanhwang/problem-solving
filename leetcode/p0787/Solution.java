class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]}); // to, price
        }

        Queue<int[]> pq = new ArrayDeque<>();
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        
        pq.offer(new int[]{src, 0}); // dest, price
        prices[src] = 0;
        int stop = 0;

        while (!pq.isEmpty() && stop <= k) {
            int len = pq.size();
            while (len -- > 0) {
                int[] cur = pq.poll();

                for (int[] next : adj.get(cur[0])) {
                    int price = cur[1] + next[1];
                    if (price >= prices[next[0]]) {
                         continue;
                    }

                    pq.offer(new int[]{next[0], cur[1] + next[1]});
                    prices[next[0]] = price;
                }
            }
            stop++;
        }

        return prices[dst] != Integer.MAX_VALUE ? prices[dst] : -1;
    }
}
