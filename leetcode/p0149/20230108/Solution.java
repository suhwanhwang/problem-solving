class Solution {
    public int maxPoints(int[][] points) {
        Map<Double, Integer> map = new HashMap<>();

        int maxCount = 0;
        for (int i = 0; i < points.length - 1; ++i) {
            map.clear();

            int[] p1 = points[i];
            for (int j = 0; j < points.length; ++j) {
                if (i == j) continue;
                
                int[] p2 = points[j];
                double degree = (double)(p2[1] - p1[1]) / (p2[0] - p1[0]);

                map.put(degree, map.getOrDefault(degree, 0) + 1);
            }
            System.out.println(map);

            for (int count : map.values()) {
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount + 1;
    }
}
