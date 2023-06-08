class Solution {
    func countNegatives(_ grid: [[Int]]) -> Int {
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
}
