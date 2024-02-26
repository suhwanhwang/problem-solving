class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null || q == null) return p == q
        
        if (p.`val` != q.`val`) return false
        
        if (!isSameTree(p.left, q.left)) return false
        
        return isSameTree(p.right, q.right)
    }
}
