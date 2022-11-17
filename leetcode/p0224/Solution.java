class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = Math.abs((ax2 - ax1) * (ay2 - ay1));
        int area2 = Math.abs((bx2 - bx1) * (by2 - by1));
        
        int commonW = getCommon(ax1, ax2, bx1, bx2);
        int commonH = getCommon(ay1, ay2, by1, by2);

        return area1 + area2 - Math.abs(commonW * commonH);
    }

    private int getCommon(int a1, int a2, int b1, int b2) {
        /*
           a     ---------
           b  ------
        */
        int common = 0;
        if (a1 <= b2 && b2 <= a2) {
            return b2 - Math.max(a1, b1);
        }
        /*
           a     ---------
           b            ------
        */
        if (b1 <= a2 && a2 <= b2) {
            return a2 - Math.max(a1, b1);
        }
        return common;
    }
}
