class Solution {
    func maximumDetonation(_ bombs: [[Int]]) -> Int {
        var maxBomb = 0
        
        for i in 0..<bombs.count {
            maxBomb = max(maxBomb, getBombNum(bombs, i))
        }
        return maxBomb
    }

    private func getBombNum(_ bombs: [[Int]], _ index: Int) -> Int {
        var num = 0
        var queue = [Int]()
        var visited = Array(repeating: false, count: bombs.count)

        queue.append(index)
        visited[index] = true
        num += 1
        while !queue.isEmpty {
            let cur = queue.removeFirst()

            for i in 0..<bombs.count {
                if visited[i] {
                    continue
                }

                let x = bombs[i][0] - bombs[cur][0]
                let y = bombs[i][1] - bombs[cur][1]
                let r = bombs[cur][2]
                if x*x + y*y <= r*r {
                    queue.append(i)
                    visited[i] = true
                    num += 1
                }
            }
        }
        return num
    }
}
