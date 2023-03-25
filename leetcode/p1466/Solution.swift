class Solution {
    private var adj = [[(Int, Bool)]]() // next, needReorder
    private var reorderCount = 0

    func minReorder(_ n: Int, _ connections: [[Int]]) -> Int {
        adj = Array(repeating: [(Int, Bool)](), count: n)
        reorderCount = 0
        for con in connections {
            adj[con[0]].append((con[1], true))
            adj[con[1]].append((con[0], false))
        }
        
        dfs(n, 0, -1)
        return reorderCount
    }
    
    private func dfs(_ n: Int, _ index: Int, _ prev: Int) {
        if index >= n {
            return
        }
        
        for (next, needReorder) in adj[index] {
            if next == prev {
                continue
            }
            if needReorder {
                reorderCount += 1
            }
            dfs(n, next, index)
        }
    }
}
