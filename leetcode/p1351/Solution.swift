class Solution {
    /*
    [
        [ 4, 3, 2,-1],
        [ 3, 2, 1,-1],
        [ 1, 1,-1,-2],
        [-1,-1,-2,-3]
    ]
    */
    func countNegatives_nm(_ grid: [[Int]]) -> Int {
        var count = 0
        for gr in grid {
            for g in gr {
                if g < 0 {
                    count += 1
                }
            }
        }
        return count
    }

    func countNegatives(_ grid: [[Int]]) -> Int {
        let n = grid.count
        let m = grid[0].count
        var count = 0
        var row = grid.count - 1
        var col = 0
        while row >= 0 && col < m {
            if grid[row][col] >= 0 {
                col += 1
            } else {
                count += (m - col)
                row -= 1
            }
        }
        return count
    }
}
