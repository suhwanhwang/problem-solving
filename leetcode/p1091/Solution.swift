class Solution {
    private let DIR = [
        [0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1], [-1, 0], [-1, 1]
    ]

    func shortestPathBinaryMatrix(_ grid: [[Int]]) -> Int {
        guard grid[0][0] == 0 else {
            return -1
        }
        let n = grid.count
        var visited = Array(repeating:Array(repeating:false, count: n), count: n)
        var queue = [(Int, Int, Int)]()

        queue.append((0, 0, 1))
        visited[0][0] = true
        while !queue.isEmpty {
            let (row, col, depth) = queue.removeFirst() 
            if row == n - 1 && col == n - 1 {
                return depth
            }
            for d in DIR {
                let nr = row + d[0]
                let nc = col + d[1]
                if nr < 0 || nr >= n || nc < 0 || nc >= n || grid[nr][nc] == 1 || visited[nr][nc]{
                    continue
                }
                queue.append((nr, nc, depth + 1))
                visited[nr][nc] = true
            }
        }
        return -1
    }
    
}
