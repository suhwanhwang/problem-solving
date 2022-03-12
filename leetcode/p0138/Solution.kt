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
        
        var dummy = Node(0)
        var copied: Node? = dummy
        var cur = node
        while (cur != null) {
            val copiedNode = Node(cur.`val`)
            
            copied?.next = copiedNode
            nodeMap[cur] = copiedNode
            
            copied = copied?.next
            cur = cur.next
        }
        
        cur = node
        while (cur != null) {
            val random = cur.random
            if (random != null) {
                val copiedNode = nodeMap[cur]
                copiedNode?.random = nodeMap[random]
            }
            
            cur = cur.next
        }
        return dummy.next
    }
}
