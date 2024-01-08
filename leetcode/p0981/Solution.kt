class Solution {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) return 0
        
        val value = (if (low <= root.`val` && root.`val` <= high) root.`val` else 0)
        return value + rangeSumBST(root.left, low, high)+rangeSumBST(root.right, low, high)
    }
}
