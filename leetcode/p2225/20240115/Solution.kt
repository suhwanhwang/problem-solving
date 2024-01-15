class Solution {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val map = mutableMapOf<Int, Int>()
        val set = TreeSet<Int>()
        
        for (m in matches) {
            map[m[1]] = (map[m[1]] ?: 0) + 1
            set.add(m[0])
            set.add(m[1])
        }
        
        val list = listOf<MutableList<Int>>(mutableListOf<Int>(), mutableListOf<Int>())
        for (m in set) {
            val count = (map[m] ?: 0) 
            if (count <= 1) {
                list[count].add(m)
            }
        }
        return list
    }
}
