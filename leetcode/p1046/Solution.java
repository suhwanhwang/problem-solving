class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<Integer>((a, b) -> -Integer.compare(a, b));

        for (int s : stones) {
            queue.offer(s);
        }

        while(queue.size() > 1) {
            int s1 = queue.poll();
            int s2 = queue.poll();
            int diff = s1 - s2;
            if (diff != 0) {
                queue.offer(diff);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
