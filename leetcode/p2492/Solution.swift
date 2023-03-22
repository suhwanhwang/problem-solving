
class Solution {
    func minScore(_ n: Int, _ roads: [[Int]]) -> Int {
        var adj = Array(repeating: [(Int, Int)](), count: n + 1)    
        for road in roads {
            adj[road[0]].append((road[1], road[2]))
            adj[road[1]].append((road[0], road[2]))
        }
        //print(adj)
        
        var queue = [1]
        var distances = Array(repeating: Int.max, count: n+1)

        var minScore = Int.max

        while !queue.isEmpty {
           let cur = queue.removeFirst()

           for (next, dist) in adj[cur] {
               if distances[next] <= dist {
                   continue
               }
               minScore = min(minScore, dist)
               queue.append(next)
               distances[next] = dist
           }
        }
        return minScore
    }
}
