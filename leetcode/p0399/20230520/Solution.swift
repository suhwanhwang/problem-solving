class Solution {
    func calcEquation(_ equations: [[String]], _ values: [Double], _ queries: [[String]]) -> [Double] {
        var adj = [String: [String: Double]]()

        for (i, eq) in equations.enumerated() {
            var left = adj[eq[0], default: [String: Double]()]
            left[eq[1]] = values[i]
            adj[eq[0]] = left

            var right = adj[eq[1], default: [String: Double]()]
            right[eq[0]] = 1.0 / values[i] 
            adj[eq[1]] = right
        }
        var ans = [Double]()
        for query in queries {
            if let _ = adj[query[0]], let _ = adj[query[1]] {
                ans.append(calc(adj, query[0], query[1]))
            } else {
                ans.append(-1.0)
            }
        }
        
        return ans
    }

    private func calc(_ adj: [String: [String: Double]], _ from: String, _ to: String) -> Double {
        if from == to {
            return 1.0
        }

        var queue = [(String, Double)]()
        var visited = [String: Bool]()

        queue.append((from, 1.0))
        visited[from] = true

        while !queue.isEmpty {
            var (cur, value) = queue.removeFirst()
            if cur == to {
                return value
            }

            for (next, weight) in adj[cur, default: [String:Double]()] {
                if visited[next, default: false] {
                    continue
                }
                queue.append((next, value * weight))
                visited[next] = true
            }
        }

        return -1.0
    }
}
