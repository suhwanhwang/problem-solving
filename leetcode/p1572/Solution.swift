class Solution {
    func diagonalSum(_ mat: [[Int]]) -> Int {
        var sum = 0

        for i in 0..<mat.count {
            let other = (mat.count - 1) - i
            sum += (mat[i][i] + (i != other ? mat[i][other] : 0))
        }
        return sum
    }
}
