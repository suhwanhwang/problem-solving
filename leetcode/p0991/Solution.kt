class Solution {
    fun brokenCalc(startValue: Int, target: Int): Int {
        if (startValue >= target) return startValue - target
        
        if (target % 2 == 0) {
            return 1 + brokenCalc(startValue, target / 2)
        } else {
            return 1 + brokenCalc(startValue, target + 1)
        }
    }
    fun brokenCalc_to(startValue: Int, target: Int): Int {
        val set = mutableSetOf<Int>()
         val q = ArrayDeque<Int>()
         
         q.offer(startValue)
         set.add(startValue)
         
         var d = 0
         while(!q.isEmpty()) {
            val len = q.size
            for (i in 1..len) {
                val num = q.poll()
                if (num == target) {
                    return d
                }
                
                val next1 = num * 2
                val next2 = num - 1
                if (next2 <= target && !set.contains(next1)) {
                    q.offer(next1)
                    set.add(next1)
                }
                if (!set.contains(next2)) {
                    q.offer(next2)
                    set.add(next2)
                }
            }
            d++
         }
         return -1
    }
}
