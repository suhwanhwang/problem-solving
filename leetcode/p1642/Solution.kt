class Solution {
    fun furthestBuilding_tle(heights: IntArray, bricks: Int, ladders: Int): Int {
        return helper(heights, bricks, ladders, 0)
    }
    
    private fun helper(heights: IntArray, bricks: Int, ladders: Int, index: Int): Int {
        if (bricks < 0 || ladders < 0) return index - 1
        
        if (index >= heights.size - 1) return heights.size - 1
        
        val diff = heights[index + 1] - heights[index]

        var max = 0
        if (diff <= 0) {
            max = helper(heights, bricks, ladders, index + 1)
        } else {
            max = max(helper(heights, bricks - diff, ladders, index + 1), helper(heights, bricks, ladders - 1, index + 1))
        }
        return max
    }
    
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        val pq = PriorityQueue<Int>({a, b-> -(a - b)})
        
        var index = 0
        var b = bricks
        var l = ladders
        while (index < heights.size - 1) {
            val diff = heights[index + 1] - heights[index]
            if (diff > 0) {
                if (b >= diff) {
                    b -= diff
                    pq.offer(diff)
                } else {
                    if (l > 0) {
                        if (!pq.isEmpty() && pq.peek() > diff) {
                            val max = pq.poll()
                            b += (max - diff)
                            pq.offer(diff)
                        }
                        l--
                    } else {
                        break
                    }
                }
            }
            index++
        }
        
        return index
    }
}
