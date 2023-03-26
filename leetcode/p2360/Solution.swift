class Solution {
    private var edges = [Int]()
    private var visited = [Bool]()
    private var recStack = [Int]()

    func longestCycle(_ edges: [Int]) -> Int {
        let n = edges.count
        self.edges = edges
        visited = Array(repeating:false, count: n)
        recStack = Array(repeating:-1, count: n)

        var maxCycle = -1
        
        for i in 0..<n {
            if visited[i] {
                continue
            }

            maxCycle = max(maxCycle, dfs(i, 1))
        }
        return maxCycle
    }

/*
           0  1  2  3  4  5
         [-1, 4,-1, 2, 0, 4]
visited    
recStack              
*/
    private func dfs(_ index: Int, _ dist: Int) -> Int {
        if index < 0 {
            return -1
        }

        if recStack[index] != -1 {
            return dist - recStack[index]
        }

        if visited[index] {
            return -1
        }

        visited[index] = true
        recStack[index] = dist
        //print(index)

        let cycleNum = dfs(edges[index], dist + 1)
        recStack[index] = -1

        return cycleNum
    }
    
}
