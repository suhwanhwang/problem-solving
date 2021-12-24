class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (src, dest) -> {
            if (src[0] == dest[0]) {
                return src[1] - dest[1];
            }
            return src[0] - dest[0];
        });
        
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int[] prev = merged.get(merged.size() - 1);
            int[] cur = intervals[i];
            if (prev[1] >= cur[0]) {
                prev[1] = Math.max(prev[1], cur[1]);
            } else {
                merged.add(Arrays.copyOf(cur, cur.length));
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
