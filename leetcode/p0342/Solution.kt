class Solution {
    private val powerOfFour = mutableSetOf<Int>()
    
    init {
        var num = 1L
        while (num < Int.MAX_VALUE) {
            powerOfFour.add(num.toInt())
            num *= 4L
        }
    }
    fun isPowerOfFour(n: Int): Boolean {
        return powerOfFour.contains(n)
        
    }
}
