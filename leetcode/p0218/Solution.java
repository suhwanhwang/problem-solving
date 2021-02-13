/*
https://leetcode.com/problems/the-skyline-problem/

A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.

The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:

lefti is the x coordinate of the left edge of the ith building.
righti is the x coordinate of the right edge of the ith building.
heighti is the height of the ith building.
You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.

Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]

Example 1:


Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
Explanation:
Figure A shows the buildings of the input.
Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the output list.
Example 2:

Input: buildings = [[0,2,3],[2,5,3]]
Output: [[0,3],[5,0]]
 

Constraints:

1 <= buildings.length <= 104
0 <= lefti < righti <= 231 - 1
1 <= heighti <= 231 - 1
buildings is sorted by lefti in non-decreasing order.

*/
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        return getSkyline(buildings, 0, buildings.length - 1);
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings, int left, int right) {
        if (left == right) {
            List<List<Integer>> ans = new ArrayList<>();
            int l = buildings[left][0];
            int r = buildings[left][1];
            int h = buildings[left][2];
            ans.add(Arrays.asList(l, h));
            ans.add(Arrays.asList(r, 0));
            return ans;
        }
        int mid = (left + right) >>> 1;
        List<List<Integer>> leftSkyline = getSkyline(buildings, left, mid);
        List<List<Integer>> rightSkyline = getSkyline(buildings, mid + 1, right);
        
        return merge(leftSkyline, rightSkyline);   
    }
    
    public List<List<Integer>> merge(List<List<Integer>> leftSkyline, List<List<Integer>> rightSkyline) {
        List<List<Integer>> merged = new ArrayList<>();
        int left = 0;
        int right = 0;
        int leftH = 0;
        int rightH = 0;
        int maxH = 0;
        int curH = 0;
        int x = 0;
        while (left < leftSkyline.size() && right < rightSkyline.size()) {
            List<Integer> l = leftSkyline.get(left);
            List<Integer> r = rightSkyline.get(right);
            
            if (l.get(0) < r.get(0)) {
                x = l.get(0);
                leftH = l.get(1);
                left++;
            } else {
                x = r.get(0);
                rightH = r.get(1);
                right++;
            }
            maxH = Math.max(leftH, rightH);
            
            if (curH != maxH) {
                addSkyline(merged, x, maxH);
                curH = maxH;
            }
        }
        
        appendSkyline(merged, leftSkyline, left, curH);
        appendSkyline(merged, rightSkyline, right, curH);
        
        return merged;
    }
    
    private void addSkyline(List<List<Integer>> merged, int x, int h) {
        if (merged.isEmpty() || merged.get(merged.size() - 1).get(0) != x) {
            merged.add(Arrays.asList(x, h));
        } else {
            merged.get(merged.size() - 1).set(1, h);
        }
    }
    
    private void appendSkyline(List<List<Integer>> merged, List<List<Integer>> skylines, int index, int curH) {
        int x = 0;
        int h = 0;
        while(index < skylines.size()) {
            List<Integer> skyline = skylines.get(index);
            x = skyline.get(0);
            h = skyline.get(1);
            index++;
            
            if (curH != h) {
                addSkyline(merged, x, h);
                curH = h;
            }
        }
    }
}
