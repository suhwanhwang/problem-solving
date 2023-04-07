class Solution {

    func numEnclaves(_ grid: [[Int]]) -> Int {
        var visited = Array(repeating: Array(repeating: false, count: grid[0].count), count: grid.count)
        var visited2 = Array(repeating: Array(repeating: false, count: grid[0].count), count: grid.count)
        
        var totalLand = 0
        for r in 0..<grid.count {
            for c in 0..<grid[0].count {
                if grid[r][c] == 0  || visited[r][c] {
                    continue
                }

                let land = dfs(grid, &visited, r, c)
                if isBoundary(grid, &visited2, r, c) {
                    continue
                }
                totalLand += land
                print(land)
            }
        }
        return totalLand   
    }

    private let DIR = [[0, 1], [1, 0], [0, -1], [-1, 0]]

    private func dfs(_ grid: [[Int]], _ visited: inout [[Bool]],  _ row: Int, _ col: Int) -> Int {
        visited[row][col] = true

        var land = 1
        for d in DIR {
            let nr = row + d[0]
            let nc = col + d[1]

            if nr < 0 || nr >= grid.count || nc < 0 || nc >= grid[0].count || grid[nr][nc] == 0 || visited[nr][nc] {
                continue
            }

            land += dfs(grid, &visited, nr, nc)
        }
        return land
    }

    private func isBoundary(_ grid: [[Int]], _ visited: inout [[Bool]],  _ row: Int, _ col: Int) -> Bool {
        if row == 0 || row == grid.count - 1 || col == 0 || col == grid[0].count - 1 {
            return true
        }
        visited[row][col] = true

        for d in DIR {
            let nr = row + d[0]
            let nc = col + d[1]

            if nr < 0 || nr >= grid.count || nc < 0 || nc >= grid[0].count || grid[nr][nc] == 0 || visited[nr][nc] {
                continue
            }

            if isBoundary(grid, &visited, nr, nc) {
                return true
            }
        }
        return false
    }
}
