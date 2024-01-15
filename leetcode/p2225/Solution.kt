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
            if (map[m] == null) {
                list[0].add(m)
            } else if (map[m] == 1) {
                list[1].add(m)
            }
        }
        return list
    }
}
