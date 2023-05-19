class Solution {
    func isBipartite(_ graph: [[Int]]) -> Bool {
        let n = graph.count
        var color = Array(repeating: -1, count: n)
        var queue = [Int]()

        for i in 0..<n {
            if color[i] != -1 {
                continue
            }
            queue.append(i)
            color[i] = i
            while !queue.isEmpty {
                var len = queue.count
                let node = queue.removeFirst()
                let curColor = color[node]
                let nextColor = curColor ^ 0x1
                for next in graph[node] {
                    if color[next] != -1 {
                        if color[next] != nextColor {
                            return false
                        }
                        continue
                    }

                    queue.append(next)
                    color[next] = nextColor
                }
            }
        }

        return true
    }
}
