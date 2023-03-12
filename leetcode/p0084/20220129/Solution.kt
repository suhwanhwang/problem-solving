class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        return solve(heights, 0, heights.size - 1)
    }
    
    private fun solve(heights: IntArray, left: Int, right: Int): Int {
        if (left == right) {
            return heights[left]
        }
        
        val mid = left + (right - left)/2
        val leftMax = solve(heights, left, mid)
        val rightMax = solve(heights, mid + 1, right)
        
        var maxArea = heights[mid]
        var minHeight = heights[mid]
        var l = mid
        var r = mid
        while (l > left || r < right) {
            val lh = if (l > left) heights[l - 1] else -1
            val rh = if (r < right) heights[r + 1] else -1
            if (lh > rh) {
                l--
                minHeight = Math.min(minHeight, lh)
            } else {
                r++
                minHeight = Math.min(minHeight, rh)
            }
            maxArea = Math.max(maxArea, (r - l + 1) * minHeight)
        }
        return Math.max(Math.max(leftMax, rightMax), maxArea)
    }
}
