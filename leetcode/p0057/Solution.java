class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean isAdd = false;
        for (int i = 0; i < intervals.length; ++i) {
            if (!isAdd && intervals[i][0] >= newInterval[0]) {
                list.add(newInterval);
                isAdd = true;
            }
            list.add(intervals[i]);
        }
        if (!isAdd) {
            list.add(newInterval);
        }

        List<int[]> merged = new ArrayList<>();
        merged.add(list.get(0));
        for (int i = 1; i < list.size(); ++i) {
            int[] prev = merged.get(merged.size() - 1);
            int[] cur = list.get(i);

            if (prev[1] >= cur[0]) {
                prev[1] = Math.max(prev[1],cur[1]);
            } else {
                merged.add(cur);

            }
        }

        int[][] ans = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); ++i) {
            ans[i][0] = merged.get(i)[0];
            ans[i][1] = merged.get(i)[1];
        }
        return ans;
    }
}
