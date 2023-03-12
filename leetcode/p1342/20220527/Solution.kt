class Solution {
    fun numberOfSteps(num: Int): Int {
        if (num == 0) {
            return 0
        }
        
        return 1 + numberOfSteps(if (num % 2 == 0) num/2 else num - 1)
    }
}
