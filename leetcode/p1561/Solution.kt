class Solution {
    fun maxCoins(piles: IntArray): Int {
        /*
        return piles
            .sorted()
            .filterIndexed { index, value ->
                index % 3 == 1
            }
            .sum()
            */
        
        return piles
            .sortedWith(Comparator.reverseOrder())
            .filterIndexed { index, value ->
                index % 2 == 1
            }
            .take(piles.size / 3)
            .sum()
    }
}
