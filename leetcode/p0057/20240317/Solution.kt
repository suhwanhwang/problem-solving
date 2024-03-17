class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val list = mutableListOf<IntArray>()
        
        var index = 0
        var added = false
        while (index < intervals.size || !added) {
            val cur = if (!added && (index >= intervals.size || intervals[index][0] >= newInterval[0])) {
                added = true
                newInterval
            } else {
                intervals[index++]
            }
            
            if (!list.isEmpty() && list.last()[1] >= cur[0]) {
                list.last()[1] = max(list.last()[1], cur[1])
            } else {
                list.add(cur)
            }
        }
        return list.toTypedArray()
    }
}
