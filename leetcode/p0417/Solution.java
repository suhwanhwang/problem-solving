class Solution {
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] fromPacific = new boolean[row][col];
        boolean[][] fromAtlantic = new boolean[row][col];
        
        int r = 0;
        int c = 0;
        for (c = 0; c < col; ++c) {
            if (fromPacific[r][c]) {
                continue;
            }
            dfs(heights, r, c, fromPacific);
        }
        
        
        c = 0;
        for (r = 0; r < row; ++r) {
            if (fromPacific[r][c]) {
                continue;
            }
            dfs(heights, r, c, fromPacific);
        }
        
        r = row - 1;
        for (c = 0; c < col; ++c) {
            if (fromAtlantic[r][c]) {
                continue;
            }
            dfs(heights, r, c, fromAtlantic);
        }
        
        
        c = col - 1;
        for (r = 0; r < row; ++r) {
            if (fromAtlantic[r][c]) {
                continue;
            }
            dfs(heights, r, c, fromAtlantic);
        }
        
        List<List<Integer>> flow = new ArrayList<>();
        for (r = 0; r < row; ++r) {
            for (c = 0; c < col; ++c) {
                if (fromPacific[r][c] && fromAtlantic[r][c]) {
                    flow.add(Arrays.asList(r, c));
                }
            }
        }
        return flow;
    }
    
    private void print(boolean[][] visited) {
        for (boolean[] row : visited) {
            for (boolean value : row) {
                System.out.print(value ? 1: 0);
            }
            System.out.println();
        }
    }
    
    private static final int[][] DIR = {
        {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    }; 
    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        int row = heights.length;
        int col = heights[0].length;
        
        visited[r][c] = true;
        
        for (int[] d : DIR) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (nextR < 0 || nextR >= row  || nextC < 0 || nextC >= col
               || visited[nextR][nextC]
               || heights[r][c] > heights[nextR][nextC]) {
                continue;
            }
            dfs(heights, nextR, nextC, visited);
        }
    }
}
