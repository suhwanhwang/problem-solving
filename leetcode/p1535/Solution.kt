class Solution {
    fun getWinner(arr: IntArray, k: Int): Int {
        if (k > arr.size) {
            return arr.max()
        }
        
        val list = arr.toMutableList()
        var winner = 0
        var count = 0
        while (count < k) {
            val curWinner = if (list[0] > list[1]) list[0] else list[1]
            val smallIndex = if (list[0] > list[1]) 1 else 0
            
            if (winner == curWinner) {
                count++
                
            } else {
                count = 1
                winner = curWinner
            }
            if (count == k) {
                return curWinner
            }
            
            val smallNum = list[smallIndex]
            list.removeAt(smallIndex)
            list.add(smallNum)
        }
        return 0
    }
}
