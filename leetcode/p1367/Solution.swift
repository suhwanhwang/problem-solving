class Solution {
    func numOfMinutes(_ n: Int, _ headID: Int, _ manager: [Int], _ informTime: [Int]) -> Int {
        var adj = Array(repeating:[Int](), count:n)

        for (i, m) in manager.enumerated() {
            if m == -1 {
                continue
            }
            adj[m].append(i)
        }

        var queue = [(Int, Int)]()
        var visited = Array(repeating: false, count: n)
        queue.append((headID, 0))
        visited[headID] = true
        var maxTime = 0
        while !queue.isEmpty {
            let (curId, time) = queue.removeFirst()
            maxTime = max(maxTime, time)

            for nextId in adj[curId] {
                if visited[nextId] {
                    continue
                }
                queue.append((nextId, time + informTime[curId]))
                visited[nextId] = true
            }
        }
        return maxTime
    }
}
