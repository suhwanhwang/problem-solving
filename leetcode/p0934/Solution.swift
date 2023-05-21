class Solution {
    private let DIR = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    private let INF = 987654321

    func shortestBridge(_ grid: [[Int]]) -> Int {
        var gridCopy = grid
        var landNum = 2
        var isDone = false
        var startRow = -1
        var startCol = -1
        for r in 0..<gridCopy.count {
            for c in 0..<gridCopy[0].count {
                if (dfs(&gridCopy, r, c, landNum)) {
                    startRow = r
                    startCol = c
                    isDone = true
                    break;
                }
            }
            if isDone {
                break;
            }
        }

        print(gridCopy)
        print("\(startRow), \(startCol)")

        if startRow == -1 && startCol == -1 {
            return 0
        }

        var queue = [(Int, Int, Int)]() // row, col, depth
        var distance = Array(repeating: Array(repeating: INF, count: grid[0].count), count: grid.count)
        var minValue = INF

        queue.append((startRow, startCol, 0))
        distance[startRow][startCol] = 0
        
        while !queue.isEmpty {
            let (row, col, depth) = queue.removeFirst()
            if gridCopy[row][col] == 1 {
                minValue = min(minValue, depth - 1)
            }

            for d in DIR {
                let nr = row + d[0]
                let nc = col + d[1]

                if nr < 0 || nr >= gridCopy.count || nc < 0 || nc >= gridCopy[0].count {
                    continue
                }
                if distance[nr][nc] <= depth + 1  {
                    continue
                }

                queue.append((nr, nc, gridCopy[nr][nc] == landNum ? 0 : depth + 1))
                distance[nr][nc] = depth + 1
            }
        }
        return minValue
    }

    private func dfs(_ grid: inout [[Int]], _ row: Int, _ col: Int, _ num: Int) -> Bool {
        if row < 0 || row >= grid.count || col < 0 || col >= grid[0].count {
            return false
        }

        if grid[row][col] == 0 {
            return false
        }

        grid[row][col] = num

        for d in DIR {
            let nr = row + d[0]
            let nc = col + d[1]

            if nr < 0 || nr >= grid.count || nc < 0 || nc >= grid[0].count || grid[nr][nc] == 0  || grid[nr][nc] == num { 
                continue
            }

            dfs(&grid, nr, nc, num)    
        }
        return true
    }
}
