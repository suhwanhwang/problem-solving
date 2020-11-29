/*
https://leetcode.com/problems/merge-intervals/

Given an array of intervals where intervals[i] = [starti, endi], 
merge all overlapping intervals, and return an array of the non-overlapping intervals 
that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

*/
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> {
           if (a[0] == b[0]) {
               return a[1] - b[1];
           } else {
               return a[0] - b[0];
           }
        });
        
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; ++i) {
            int[] cur = intervals[i];
            int[] last = merged.get(merged.size() - 1);
            if (cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]);
            } else {
                merged.add(cur);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
