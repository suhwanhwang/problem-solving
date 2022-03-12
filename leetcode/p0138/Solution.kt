/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    fun copyRandomList(node: Node?): Node? {
        val nodeMap = mutableMapOf<Node, Node?>()
        
        var cur = node
        while (cur != null) {
            nodeMap[cur] = Node(cur.`val`)            
            cur = cur.next
        }
        
        cur = node
        while (cur != null) {
            val copied = nodeMap[cur]
            copied?.next = nodeMap[cur.next]
            copied?.random = nodeMap[cur.random]
            cur = cur.next
        }
        return nodeMap[node]
    }
}
