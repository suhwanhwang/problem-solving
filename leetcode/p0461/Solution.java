class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; ++i) {
            int curX = (1 << i) & x;
            int curY = (1 << i) & y;
            if (curX != curY) {
                count++;
            }
        }
        return count;
    }
}
