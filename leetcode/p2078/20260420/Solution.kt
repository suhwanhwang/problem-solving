class Solution {
    /*
          0 1 2 3 4 5 6
colors = [1,1,1,6,1,1,1]

    1 -> 0
    6 -> 3
          0 1 2 3 4 
colors = [1,8,3,8,3]
    1 -> 0
    8 -> 1
    3 -> 2
     */
    fun maxDistance(colors: IntArray): Int {
        val map = mutableMapOf<Int, Int>() // color, index
        var maxDist = 0

        for ((i, color) in colors.withIndex()) {
            if (!map.contains(color)) {
                map[color] = i
            }

            for ((c, index) in map) {
                if (c == color) {
                    continue
                }

                maxDist = max(maxDist, i - index)
            }
        }

        return maxDist
    }
}
