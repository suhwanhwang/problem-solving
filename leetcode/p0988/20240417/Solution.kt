class Solution {
    private val pq = PriorityQueue<String>()
    fun smallestFromLeaf(root: TreeNode?): String {
        dfs(root, "")
        return pq.poll()
    }
    
    fun dfs(root: TreeNode?, s:String) {
        if (root == null) return 
        
        val next = ('a' + root.`val`) + s
        if (root.left == null && root.right == null) {
            pq.add(next)
            return
        }
        dfs(root.left, next)
        dfs(root.right, next)
    }
}
