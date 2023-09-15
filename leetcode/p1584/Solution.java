class Solution {
    private int[] roots;
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<Integer>> distances = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            int[] p1 = points[i];
            for (int j = i + 1; j < n; ++j) {
                int[] p2 = points[j];
                int distance = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                distances.add(Arrays.asList(distance, i, j));
            }
        }
        Collections.sort(distances, (a, b) -> { return Integer.compare(a.get(0), b.get(0)); });
        //System.out.println(distances);
                              
        // init union find
        roots = new int[n];
        for (int i = 0; i < n; ++i) {
            roots[i] = i;
        }
        
        int sum = 0;
        for (List<Integer> distance : distances) {
            if (find(distance.get(1), distance.get(2))) {
                continue;
            }
            connect(distance.get(1), distance.get(2));
            sum += distance.get(0);
        }
        return sum;
    }
    
    private int getRoot(int u) {
        int cur = u;
        while(roots[cur] != cur) {
            cur = roots[cur];
        }
        return cur;
    }
    
    private boolean find(int u, int v) {
        return getRoot(u) == getRoot(v);    
    }
    
    private void connect(int u, int v) {
        int rootU = getRoot(u);
        int rootV = getRoot(v);
        roots[rootU] = rootV;
    }
    
}
