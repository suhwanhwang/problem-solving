/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return null
        }
        val map = mutableMapOf<Int, Node>()
        val queue = ArrayDeque<Node>()
        val visitedSet = mutableSetOf<Node>()
        
        visitedSet.add(node)
        queue.add(node)
        while (!queue.isEmpty()) {
            val cur = queue.poll()
            //println(cur.`val`)
            
            val copied = map[cur.`val`] ?: Node(cur.`val`)
            map[cur.`val`] = copied
            
            for (neighbor in cur.neighbors) {
                if (neighbor == null) {
                    continue
                }
                
                val tmp = map[neighbor.`val`] ?: Node(neighbor.`val`)
                map[neighbor.`val`] = tmp
                
                //if (!copied.neighbors.contains(tmp)) {
                    copied.neighbors.add(tmp)
                //}
                
                if (visitedSet.contains(neighbor)) {
                    continue
                }
                
                visitedSet.add(neighbor)
                queue.offer(neighbor)
            }
            
        }
        return map[1]
    }
    
}
