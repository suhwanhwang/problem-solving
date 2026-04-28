class Solution {
    /* Wrong solution
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val mn = m * n

        var sum = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                sum += grid[i][j]
            }
        }
        
        val avg = sum / mn
        println("avg = $avg")
        var minOp = Int.MAX_VALUE

        for (k in 0 until x) {
            val target = avg + k
            var op = 0
            for (i in grid.indices) {
                for (j in grid[0].indices) {
                    if (abs(target - grid[i][j]) % x != 0) {
                        op = Int.MAX_VALUE
                        break
                    }
                    op += abs(target - grid[i][j]) / x
                }
                if (op == Int.MAX_VALUE) {
                    break
                }
            }
            minOp = min(minOp, op)
        }

        return if (minOp == Int.MAX_VALUE) -1 else minOp
    }
    */

    fun minOperations(grid: Array<IntArray>, x: Int): Int {


        val list = mutableListOf<Int>()
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                list.add(grid[i][j])
            }
        }
        list.sort()

        val remainder = list[0] % x
        for (num in list) {
            if (num % x != remainder) {
                return -1
            }
        }

        val mid = list[list.size / 2]
        var op = 0
        for (num in list) {
            op += abs(mid - num) / x
        }
        return op
    }
}
