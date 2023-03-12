/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connect(root: Node?): Node? {
        if (root == null) {
            return null
        }
        
        val queue = ArrayDeque<Node>()
        
        queue.offer(root)
        while(!queue.isEmpty()) {
            var len = queue.size
            var prev: Node? = null
            while (len-- > 0) {
                val node = queue.poll()
                if (prev == null) {
                    prev = node
                } else {
                    prev.next = node
                    prev = node
                }
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
            
        }
        return root
    }
}
