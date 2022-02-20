class Solution {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith(Comparator {a, b ->
            if (a[0] == b[0]) -(a[1] -b[1]) else a[0] - b[0]
        })
        
        var prev = 0
        var count = 0
        for (i in 1 until intervals.size) {
            if (intervals[prev][1] >= intervals[i][1]) {
                count++
            } else {
                prev = i
            }
        }
        return intervals.size - count
    }
}
