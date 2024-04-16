class Solution {
    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        return helper(root, `val`, depth, 1, true)
    }
    
    private fun helper(root: TreeNode?, value: Int, depth: Int, current: Int, isLeft: Boolean): TreeNode? {
        
        if (depth == current) {
            val temp = TreeNode(value)
            if (isLeft) {
                temp.left = root
            } else {
                temp.right = root
            }
            return temp
        } else {      
            if (root == null) return null
            
            root.left = helper(root.left, value, depth, current + 1, true)
            root.right = helper(root.right, value, depth, current + 1, false)
        return root
        }
    }
}
