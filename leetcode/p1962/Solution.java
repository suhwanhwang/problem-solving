class Solution {
    /*
    public int minStoneSum(int[] piles, int k) {
        Arrays.sort(piles);
        int count = 0;
        for (int i = piles.length - 1; i >= 0; --i) {
            if (count == k) {
                break;
            }

            int cur = i;
            while (count < k && (i == 0 || piles[cur] > piles[i - 1])) {
                piles[cur] = (piles[cur] / 2) + (piles[cur] % 2);
                count++;
            }
        }

        int sum = 0;
        for (int pile : piles) {
            sum += pile;
        }    
        return sum;
    }
    */
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> -(a - b));
        for (int pile : piles) {
            pq.offer(pile);
        }

        for (int i = 0; i < k; ++i) {
            int pile = pq.poll();
            pq.offer((pile / 2) + (pile % 2));
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}
