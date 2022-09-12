class Solution {
    /*
    private static final int INF = 987654321;
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        return helper(speed, efficiency, k, 0, 0, INF);
    }
    
    private int helper(int[] speed, int[] efficiency, int k, int index, int sum, int minEfficiency) {
        if (k == 0) {
            return sum * minEfficiency;
        }
        
        if (index >= speed.length) {
            return sum * minEfficiency;
        }
        
        int included = helper(speed, efficiency, k - 1, index + 1, sum + speed[index], Math.min(efficiency[index], minEfficiency));
        
        int excluded = helper(speed, efficiency, k, index + 1, sum, minEfficiency);
        return Math.max(sum * minEfficiency, Math.max(included, excluded));
    }
    */
    static class Engineer {
        private final int speed;
        private final int efficiency;
        public Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
        public int getSpeed() {
            return this.speed;
        }
        public int getEfficiency() {
            return this.efficiency;
        }
        
        @Override
        public String toString() {
            return "[" + speed + " " + efficiency + "]";
        }
    }
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer> engineers = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            engineers.add(new Engineer(speed[i], efficiency[i]));
        }
        
        Collections.sort(engineers, (a, b) -> {
            return -(a.getEfficiency() - b.getEfficiency());
        });
        System.out.println(engineers);
        
        long sum = 0;
        long maxPerformance = 0;
        Queue<Engineer> queue = new PriorityQueue<>((a, b) -> {
            return a.getSpeed() - b.getSpeed();
        });
        for (Engineer e : engineers) {
            if (queue.size() == k) {
                Engineer temp = queue.poll();
                sum -= temp.getSpeed();
            }
            queue.offer(e);
            sum += e.getSpeed();
            maxPerformance = Math.max(maxPerformance, sum * e.getEfficiency());
        }
        return (int)(maxPerformance % ((int)1e9 + 7));
    }
}
