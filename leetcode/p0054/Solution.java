class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length ==0) {
            return ans;
        }
        
        int h = matrix.length;
        int w = matrix[0].length;
        int[][] dir = { //x, y
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}   
        };
        
        int cur = 0;
        int r = 0;
        int c = -1;
        int curW = w;
        int curH = h-1;
        while (ans.size() < h * w) {
            int len = (dir[cur][0] == 0 ? curW-- : curH--);
            //System.out.println("len = " + len);
            for (int i = 0; i < len; ++i) {
                r += dir[cur][0];
                c += dir[cur][1];

                //System.out.println("(" + r + "," + c + ")");
                ans.add(matrix[r][c]);
            }
            
            cur = (cur + 1) % dir.length;
        }
        
        return ans;
    }
}
