/**
 * Definition for a Node.
 * public class Node {
 *     public var val: Int
 *     public var neighbors: [Node?]
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.neighbors = []
 *     }
 * }
 */

class Solution {
    func cloneGraph(_ node: Node?) -> Node? {
        var map = [Int:Node]()
        return helper(node, &map)
    }
    private func helper(_ node: Node?, _ map: inout [Int:Node]) -> Node? {
        //print("helper \(node?.val ?? nil)")
        if let node = node {
            if let cached = map[node.val] {
                return cached
            }
            var copy = Node(node.val)
            map[node.val] = copy
            for neighbor in node.neighbors {
                copy.neighbors.append(helper(neighbor, &map))
            }
            return copy
        } else {
            return nil
        }
    }
}
