class Solution {
    func generateMatrix(_ n: Int) -> [[Int]] {
        var matrix = Array(repeating: Array(repeating: 0, count: n), count: n)

        let DIR = [[0,1], [1,0], [0,-1], [-1,0]]
        var row = 0
        var col = 0
        var num = 1
        var d = 0
        while num <= n * n {
            matrix[row][col] = num
            let nr = row + DIR[d][0]
            let nc = col + DIR[d][1]

            if nr < 0 || nr >= n || nc < 0 || nc >= n || matrix[nr][nc] > 0 {
                d = (d + 1) % DIR.count
            }
            row += DIR[d][0]
            col += DIR[d][1]
            num += 1
        }

        return matrix
    }
}
