class Solution {
    func minPathSum(_ grid: [[Int]]) -> Int {
        dp = Array(repeating: Array(repeating: -1, count: grid[0].count), count: grid.count)
        return dfs(grid, 0, 0)
    }

    private let DIR = [
        [0, 1],
        [1, 0]
    ]

    private var dp = [[Int]]()

    private func dfs(_ grid: [[Int]], _ row: Int, _ col: Int) -> Int {
        if row == grid.count - 1 && col == grid[0].count - 1 {
            return grid[row][col]
        }

        if dp[row][col] != -1 {
            return dp[row][col]
        }

        var minPath = Int.max

        for d in DIR {
            let nextRow = row + d[0]
            let nextCol = col + d[1]

            if nextRow < 0 || nextRow >= grid.count || nextCol < 0 || nextCol >= grid[0].count  {
                continue
            }
            
            minPath = min(minPath, grid[row][col] + dfs(grid, nextRow, nextCol))
        }
        dp[row][col] = minPath
        return minPath
    }
}
