class Solution {
    static class Position {
        final int row;
        final int col;
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        @Override 
        public int hashCode() {
            return Objects.hash(row, col);
        }
        @Override
        public boolean equals(Object other) {
            if (other instanceof Position) {
                Position p = (Position)other;
                return row == p.row && col == p.col;
            }
            return false;
        }
        @Override
        public String toString() {
            return row + "," + col;
        }
    }
    private static final int[][] DIR = {
        {0,1}, {1,0}, {0,-1}, {-1,0}
    };
    public int nearestExit(char[][] maze, int[] entrance) {
        final int row = maze.length;
        final int col = maze[0].length;
        Set<Position> exit = new HashSet<>();
        for (int i = 0; i < row; ++i) {
            if (maze[i][0] == '.') {
                exit.add(new Position(i, 0));
            }
            if (maze[i][col-1] == '.') {
                exit.add(new Position(i, col-1));
            }
        }
        for (int i = 0; i < col; ++i) {
            if (maze[0][i] == '.') {
                exit.add(new Position(0,i));
            }
            if (maze[row-1][i] == '.') {
                exit.add(new Position(row-1, i));
            }
        }
        exit.remove(new Position(entrance[0], entrance[1]));

        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(entrance[0], entrance[1]));
        int depth = 0;
        boolean[][] visited = new boolean[row][col];
        visited[entrance[0]][entrance[1]] = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.println(len);
            while(len-- > 0) {
                Position cur = queue.poll();               System.out.println(cur);
                if (exit.contains(cur)) {
                    return depth;
                }
                for (int[]d : DIR) {
                    int nr = cur.row + d[0];
                    int nc = cur.col + d[1];
                    if (nr < 0 || nr >= row || nc < 0 || nc >= col || maze[nr][nc] =='+' || visited[nr][nc]) {
                        continue;
                    }
                    queue.offer(new Position(nr, nc));
                    visited[nr][nc] = true;
                }
            }
            depth++;
        }
        return -1;
    }
}
