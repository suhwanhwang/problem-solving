class Solution {
    private static final int[][] DIR = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    
    private static class Node {
        int row;
        int col;
        int weight;
        public Node(int row, int col, int weight) {
            this.row = row;
            this.col = col;
            this.weight = weight;
        }
    }
    
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        
        Queue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        int[][] dist = new int[r][c];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        pq.offer(new Node(0, 0, 0));
        dist[0][0] = 0;
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.row == r - 1 && cur.col == c - 1) {
                return cur.weight;
            }
            
            for (int[] d : DIR) {
                int nr = cur.row + d[0];
                int nc = cur.col + d[1];
                
                
                if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    continue;
                }
                
                int diff = Math.max(cur.weight, Math.abs(heights[cur.row][cur.col] - heights[nr][nc]));
                if (diff >= dist[nr][nc]) {
                    continue;
                }
                
                dist[nr][nc] = diff;
                pq.offer(new Node(nr, nc, diff));
            }
        }
        return -1;
    }
}
