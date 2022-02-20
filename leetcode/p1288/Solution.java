class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> { return a[0] == b[0] ? -(a[1] - b[1]) : a[0] - b[0]; });
        
        int prev = 0;
        int count = 0;
        for(int i = 1; i < intervals.length; ++i) {
            if (intervals[prev][1] >= intervals[i][1]) {
                count++;
            } else {
                prev = i;
            }
        }
        return intervals.length - count;
    }
}
