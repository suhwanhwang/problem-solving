class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        
        for (int i = 0; i < mat.length; ++i) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; ++j) {
                sum += mat[i][j];
            }
            pq.offer(new int[]{sum, i});
        }

        
        int[] ans = new int[k];
        
        for (int i = 0; i < k; ++i) {
            int[] cur = pq.poll();
            ans[i] = cur[1];
        }
        return ans;
    }
}
