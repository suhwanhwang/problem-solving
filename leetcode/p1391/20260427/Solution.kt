class Solution {
    private val streets = arrayOf(
        arrayOf(Pair(0, 0), Pair(0, 0)),
        arrayOf(Pair(0, -1), Pair(0, 1)), // 1
        arrayOf(Pair(-1, 0), Pair(1, 0)), // 2
        arrayOf(Pair(0, -1), Pair(1, 0)), // 3
        arrayOf(Pair(0, 1), Pair(1, 0)), // 4
        arrayOf(Pair(0, -1), Pair(-1, 0)), // 5
        arrayOf(Pair(-1, 0), Pair(0, 1)) // 6
    )

    fun hasValidPath(grid: Array<IntArray>): Boolean {
        val endX = grid[0].size - 1
        val endY = grid.size - 1
        val visited = Array(grid.size) { BooleanArray(grid[0].size) { false } }
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(Pair(0, 0))
        visited[0][0] = true
        while (!queue.isEmpty()) {
            val (curY, curX) = queue.removeFirst()
            val curStreet = grid[curY][curX]
            val dir = streets[grid[curY][curX]]
            if (curY == endY && curX == endX) {
                return true
            }

            for ((dY, dX) in dir) {
                val nextY = curY + dY
                val nextX = curX + dX
                
                if (nextY < 0 || nextY > endY ||
                nextX < 0 || nextX > endX ||  
                visited[nextY][nextX]) {
                    continue
                }

                val nextStreet = grid[nextY][nextX]
                if (dX != 0) {
                    // x
                    if (dX > 0) {
                        if (!(nextStreet == 1 || nextStreet == 3 || nextStreet == 5)) {
                            continue
                        }
                    } else {
                        if (!(nextStreet == 1 || nextStreet == 4 || nextStreet == 6)) {
                            continue
                        }
                    }
                } else {
                    // y
                    if (dY > 0) {
                        if (!(nextStreet == 2 || nextStreet == 5 || nextStreet == 6)) {
                            continue
                        }
                    } else {
                        if (!(nextStreet == 2 || nextStreet == 3 || nextStreet == 4)) {
                            continue
                        }
                    }
                }

                queue.addLast(Pair(nextY, nextX))
                visited[nextY][nextX] = true
            }
        }
        return false
    }
}
