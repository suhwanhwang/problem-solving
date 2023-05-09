class Solution {
    private let DIR = [[0, 1], [1, 0], [0, -1], [-1, 0]]

    func spiralOrder(_ matrix: [[Int]]) -> [Int] {
        let row = matrix.count
        let col = matrix[0].count
        var output = [Int]()
        var visited = Array(repeating: Array(repeating: false, count: col), count: row)

        var r = 0
        var c = 0
        var d = 0
        while output.count < row * col {
            print("\(r), \(c)")
            output.append(matrix[r][c])
            visited[r][c] = true

            let nr = r + DIR[d][0]
            let nc = c + DIR[d][1]
            if nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc] {
                d = (d + 1) % DIR.count
            }
            r += DIR[d][0]
            c += DIR[d][1]
        }
        return output
    }
}
