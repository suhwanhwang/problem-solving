class Solution {
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        if (adjacentPairs.size < 2) {
            return adjacentPairs[0]
        }

        val map = mutableMapOf<Int, List<Int>>()
        for ((i, pair) in adjacentPairs.withIndex()) {
            map[pair[0]] = ((map[pair[0]] ?: emptyList()) + listOf(i))
            map[pair[1]] = ((map[pair[1]] ?: emptyList()) + listOf(i))
        }

        val startEntry = map.filterValues { it.size == 1 }.entries.first()
        val startIndex = startEntry.value[0]
        val startValue = startEntry.key

        val usedSet = mutableSetOf<Int>()
        val ans = mutableListOf<Int>()
        ans.add(startValue)
        ans.add(adjacentPairs[startIndex][if (adjacentPairs[startIndex][0] == startValue) 1 else 0])
        usedSet.add(startIndex)

        while (usedSet.size < adjacentPairs.size) {
            val last = ans.last()
            val index = map[ans.last()]!!.filter {
                !usedSet.contains(it)
            }[0]
            usedSet.add(index)
            ans.add(adjacentPairs[index][if (adjacentPairs[index][0] == last) 1 else 0])
        }

        return ans.toIntArray()
    }
}
