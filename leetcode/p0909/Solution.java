/*
[     0  1  2  3  4  5
   0 [-1,-1,-1,-1,-1,-1],
   1 [-1,-1,-1,-1,-1,-1],
   2 [-1,-1,-1,-1,-1,-1],
   3 [-1,35,-1,-1,13,-1],
   4 [-1,-1,-1,-1,-1,-1],
   5 [-1,15,-1,-1,-1,-1]
]

[
    [-1,-1],
    [-1, 3]
]

[
    [-1,-1,-1,46,47,-1,-1,-1],
    [51,-1,-1,63,-1,31,21,-1],
    [-1,-1,26,-1,-1,38,-1,-1],
    [-1,-1,11,-1,14,23,56,57],
    [11,-1,-1,-1,49,36,-1,48],
    [-1,-1,-1,33,56,-1,57,21],
    [-1,-1,-1,-1,-1,-1,2,-1],
    [-1,-1,-1,8,3,-1,6,56]
]

[
    [-1,-1,-1,46,47,-1,-1,-1],
    [51,-1,-1,63,-1,31,21,-1],
    [-1,-1,26,-1,-1,38,-1,-1],
    [-1,-1,11,-1,14,23,56,57],
    [11,-1,-1,-1,49,36,-1,48],
    [-1,-1,-1,33,56,-1,57,21],
    [-1,-1,-1,-1,-1,-1,2,-1],
    [-1,-1,-1,8,3,-1,6,56]]
      1  2  3 4 5  6 7  8 
 1, 1,-1
 1, 1, 1
-1, 1, 1

 1 2 3 4 5 6 7 8  9
-1 1 1 1 1 1 1 1 -1
 ^
*/
class Solution {
    public int snakesAndLadders(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[] lines = new int[row * col + 1];

        int dir = -1; // 1 or -1
        int index = 1;
        for (int i = row - 1; i >= 0; --i) {
            dir *= -1;
            if (dir > 0) {
                for (int j = 0; j < col; ++j) {
                    lines[index] = board[i][j];
                    index++;
                }
            } else {
                for (int j = col - 1; j >= 0;  --j) {
                    lines[index] = board[i][j];
                    index++;
                }
            }
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[row * col + 1];
        queue.offer(1);
        visited[1] = true;
        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while(len-- > 0) {
                int cur = queue.poll();
                System.out.println(depth + " " + cur);
                if (cur == lines.length - 1) {
                    return depth;
                }
                for (int i = 1; i <= 6; ++i) {
                    int next = cur + i;
                    if (next >= lines.length) break;

                    if (lines[next] != -1) {
                        next = lines[next];
                    }

                    if (visited[next]) continue;

                    visited[next] = true;
                    queue.offer(next);
                }
            }
            depth++;
        }
        return -1;
    }

}
