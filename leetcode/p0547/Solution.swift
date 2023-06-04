class Solution {
    func findCircleNum(_ isConnected: [[Int]]) -> Int {
        let n = isConnected.count
        var count = 0
        var visited = Array(repeating: false, count: n)
        for i in 0..<n {
            if visited[i] {
                continue
            }
            dfs(isConnected, i, &visited)
            count+=1
        }
        return count
    }

    private func dfs(_ isConnected: [[Int]], _ index: Int, _ visited: inout [Bool]) {
        visited[index] = true
        for next in 0..<isConnected.count {
            if isConnected[index][next] == 0 || visited[next] {
                continue
            }
            dfs(isConnected, next, &visited)
        }
    }
}
