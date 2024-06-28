class Solution {
    fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
        val adj = List(n) { mutableSetOf<Int>() }
        
        for (r in roads) {
            adj[r[0]].add(r[1])
            adj[r[1]].add(r[0])
        }
        
        val cities = List(n) { it }.sortedBy { adj[it].size }
        val cityMap = mutableMapOf<Int, Int>()
        for ((i, city) in cities.withIndex()) {
            cityMap.put(city, i + 1)
        }
        //println(cityMap)
        
        var sum = 0L
        for (r in roads) {
            sum += cityMap[r[0]]!! + cityMap[r[1]]!!
        }
        return sum
    }
}
