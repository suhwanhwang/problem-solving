class Solution {
    private static final int[][] DIR = {
        //row, col
        {-1, 0}, 
        {1, 0},
        {0, -1},
        {0, 1}
    };
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        
        pq.offer(new int[]{0, 0, 0}); // row, col, weight
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            visited[cur[0]][cur[1]] = true;
            
            if (cur[0] == heights.length -1 && cur[1] == heights[0].length -1) {
                return cur[2];
            }
            
            for (int[] d : DIR) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                
                if (nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length) {
                    continue;
                }
                
                if (visited[nr][nc]) {
                    continue;
                }
                
                int w = Math.max(cur[2], Math.abs(heights[cur[0]][cur[1]] - heights[nr][nc]));
                //visited[nr][nc] = true;
                pq.offer(new int[] {nr, nc, w});
            }
        }
        return -1;
    }
}
