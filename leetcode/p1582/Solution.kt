class Solution {
    fun numSpecial(mat: Array<IntArray>): Int {
        val rowSets = Array<MutableSet<Int>>(mat.size) { mutableSetOf<Int>() }
        val colSets = Array<MutableSet<Int>>(mat[0].size) { mutableSetOf<Int>() }
        
        for (i in 0 until mat.size) {
            for (j in 0 until mat[i].size) {
                if (mat[i][j] == 1) {
                    rowSets[i].add(j)
                    colSets[j].add(i)
                }
            }
        }
        
        var count = 0
        for (i in 0 until rowSets.size) {
            if (rowSets[i].size != 1) continue;
            
            val col = rowSets[i].firstOrNull() ?: continue
            if (colSets[col].size != 1) continue
            count++
        }
        
        return count
    }
}
