class Solution {
    func findSmallestSetOfVertices(_ n: Int, _ edges: [[Int]]) -> [Int] {
        var adj = Array(repeating: Array<Int>(), count: n)

        for e in edges {
            adj[e[1]].append(e[0])
        }

        var ans = [Int]()
        for (i, nexts) in adj.enumerated() {
            if nexts.count == 0 {
                ans.append(i)
            }
        }
        return ans
        /*
        var visited = Array(repeating: false, count: n)

        var ans = Set<Int>()
        for i in 0..<n {
            var queue = [Int]()
            queue.append(i)
            while !queue.isEmpty {
                let num = queue.removeFirst() 
                visited[num] = true
                for next in adj[num] {
                    if visited[next] {
                        continue
                    }

                    queue.append(next)
                }
                if adj[num].count == 0 {
                    ans.insert(num)
                }
            }
        }
        
        return Array(ans)
        */
    }
}
