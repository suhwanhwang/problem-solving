class Solution {
    private var adj = [[Int]]()
    func countPairs(_ n: Int, _ edges: [[Int]]) -> Int {
        adj = Array(repeating: [Int](), count: n)
        for edge in edges {
            adj[edge[0]].append(edge[1])
            adj[edge[1]].append(edge[0])
        }

        var visited = Array(repeating: false, count: n)
        var groupNums = [Int]()
        for i in 0..<n {
            if visited[i] {
                continue
            }
            groupNums.append(dfs(i, &visited))
        }
        print(groupNums)
        var remain = n
        var count = 0
        for num in groupNums {
            remain -= num
            count += num * remain
        }
        return count
    }

    private func dfs(_ index:Int, _ visited: inout [Bool]) -> Int {

        var count = 1
        visited[index] = true

        for next in adj[index] {
            if visited[next] {
                continue
            }
            
            count += dfs(next, &visited)
        }
        return count;
    }
}
