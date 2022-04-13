class Solution {
    /*
    1  2  3  4
   12 13 14  5
   11 16 15  6
   10  9  8  7
   
    1  2  3  4  5
   16 17 18 19  6
   15 24 25 20  7
   14 23 22 21  8
   13 12 11 10  9
    
    */
    private static final int[][] DIR = {
        //r, c
        {1, 0},  // V
        {0, -1}, // <-
        {-1, 0},  // ^
        {0, 1}  // ->
    };
    
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int r = 0;
        int c = 0;
        while (num <= n) {
            matrix[0][c] = num;
            num++;
            c++;
        }
        c--;
        
        int d = 0;
        int count = n - 1;
        while (num <= n * n) {
            for (int j = 0; j < 2; ++j) {
                for (int i = 0; i < count; ++i) {
                    r += DIR[d][0];
                    c += DIR[d][1];
                    matrix[r][c] = num++;
                }
                d = (d + 1) % 4;
            }
            count--;
        }
        return matrix;
    }
}
