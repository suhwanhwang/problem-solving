/*
https://leetcode.com/problems/max-points-on-a-line/
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
{
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
*/
class Solution {
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int hashCode() {
            return Objects.hash(x, y);
        }
        
        public boolean equals(Object o) {
            if (!(o instanceof Point)) {
                return false;
            }
            Point p = (Point)o;
            return x == p.x && y == p.y;
        }
    }
    
    int gcd(int a, int b) {
	    int r = a % b;
	    if (r == 0)
		    return b;
	    else
		    return gcd(b, r);
    }
    
    public int maxPoints(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        Map<Point, Integer> pointMap = new HashMap<>();
        for(int i = 0; i < points.length; ++i) {
            Point p = new Point(points[i][0], points[i][1]);
            pointMap.put(p,
            pointMap.getOrDefault(p,0) + 1);
        }

        int max = 0;
        Map<Point, Integer> map = new HashMap<>();
        for(int i = 0; i < points.length - 1; ++i) {
            map.clear();
            Point p = new Point(points[i][0], points[i][1]);
            int num = pointMap.get(p);
            
            for(int j = i + 1; j < points.length; ++j) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) continue;
                int dx = points[j][0]-points[i][0];
                int dy = points[j][1]-points[i][1];
                
                if (dx == 0) {
                    dy = 1;
                } else if (dy == 0) {
                    dx = 1;
                } else {
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;
                }
                Point pp = new Point(dx, dy);
                map.put(pp, map.getOrDefault(pp, num)+1);
            }
            max = Math.max(max, num);
            for(Integer count : map.values()) {
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
