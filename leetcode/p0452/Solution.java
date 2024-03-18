class Solution {
    public int findMinArrowShots_(int[][] points) {
        Arrays.sort(points, (a,b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int count = 0;
        int left = points[0][0];
        int right = points[0][1];
        for (int i = 1; i < points.length; ++i) {
            if (right < points[i][0]) {
                count++;
                right = points[i][1];
            } else {
                right = Math.min(right, points[i][1]);
            }
        }
        return count +1;
    }

    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[0] }
        var right = points[0][1]
        var count = 0
        for (i in 1 until points.size) {
            if (points[i][0] <= right) {
                right = min(right, points[i][1])
            } else {
                right = points[i][1]
                count++
            }
        }
        return count + 1
    }
}
