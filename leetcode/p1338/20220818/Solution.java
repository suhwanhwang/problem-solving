class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Queue<Integer> queue = new PriorityQueue<Integer>((a, b) -> {
           return -(a - b); 
        });
        for (int value : map.values()) {
            queue.offer(value);
        }
        
        int half = arr.length / 2;
        int sum = 0;
        
        while(!queue.isEmpty()) {
            sum += queue.poll();
            if (sum >= half) {
                return map.size() - queue.size();
            }
        }
        return -1;
    }
}
