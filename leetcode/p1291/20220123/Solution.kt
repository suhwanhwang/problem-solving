class Solution {
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val queue = ArrayDeque<Int>()
        for (i in 1..9) {
            queue.offer(i)
        }
        
        val ans = mutableListOf<Int>()
        
        while(!queue.isEmpty()) {
            val num = queue.poll()
            if (num >= low && num <= high) {
                ans.add(num)
            } else if (num > high) {
                break
            }
            
            val last = num % 10
            if (last != 9) {
                queue.offer(num * 10 + last + 1)
            }
        }
        
        return ans;
    }
}
