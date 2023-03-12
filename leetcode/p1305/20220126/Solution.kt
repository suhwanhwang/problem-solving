/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        val merged = mutableListOf<Int>()
        
        infix(root1, list1)
        infix(root2, list2)
        
        var i = 0;
        var j = 0;
        while(i < list1.size && j < list2.size) {
            if (list1[i] < list2[j]) {
                merged.add(list1[i++])
            } else {
                merged.add(list2[j++])
            }
        }
        while (i < list1.size) {
            merged.add(list1[i++]);
        }
        while (j < list2.size) {
            merged.add(list2[j++]);
        }
        return merged;
    }
    
    private fun infix(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) {
            return;
        }
        
        infix(root.left, list)
        list.add(root.`val`)
        infix(root.right, list)
    }
}
