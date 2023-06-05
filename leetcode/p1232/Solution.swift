class Solution {
    func checkStraightLine(_ co: [[Int]]) -> Bool {
        if co.count <= 2 {
            return true
        }

        let y = Double(co[1][1] - co[0][1]) 
        let x = Double(co[1][0] - co[0][0])
        let slope = y / x

        for i in 2..<co.count {
            let nextY = Double(co[i][1] - co[i - 1][1]) 
            let nextX = Double(co[i][0] - co[i - 1][0])
            if (x != 0 && slope != nextY / nextX) || (x == 0 && nextX != 0)  {
                return false
            }
        }
        return true
    }
}
