class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = people.length - 1; i >= 0; --i) {
            int p = people[i];
            if (pq.isEmpty()) {
                pq.offer(p);
            } else {
                int min = pq.peek();
                if (p + min <= limit) {
                    pq.poll();
                    pq.offer(limit); // limit 2 people
                } else {
                    pq.offer(p);
                }
            }
        }
        return pq.size();
    }
}
