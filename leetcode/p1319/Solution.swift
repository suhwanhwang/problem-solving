class Solution {
    class UnionFind {
        private var array:[Int]
        init(_ n:Int) {
            array = Array(0..<n)
        }

        func connect(_ a: Int, _ b:Int) {
            let aRoot = getRoot(a)
            let bRoot = getRoot(b)

            array[bRoot] = aRoot
        }

        func isConnected(_ a: Int, _ b: Int) -> Bool {
            return getRoot(a) == getRoot(b)
        }

        private func getRoot(_ a: Int) -> Int {
            var cur = a
            while cur != array[cur] {
                cur = array[cur]
            }
            return cur
        }
    }

    func makeConnected(_ n: Int, _ connections: [[Int]]) -> Int {
        let unionFind = UnionFind(n)
        
        var remainConnection = 0
        
        for connection in connections {
            if unionFind.isConnected(connection[0], connection[1]) {
                remainConnection += 1
            } else {
                unionFind.connect(connection[0], connection[1])
            }
        }
        
        var cableCount = 0
        for i in 1..<n {
            if unionFind.isConnected(0, i) {
                continue
            }
            cableCount += 1
            unionFind.connect(0, i)
        }
        
        if cableCount > remainConnection { 
            return -1
        }
        return cableCount
    }
}
